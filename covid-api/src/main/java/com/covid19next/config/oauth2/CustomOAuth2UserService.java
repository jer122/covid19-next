package com.covid19next.config.oauth2;

import com.covid19next.domain.auth.AuthProvider;
import com.covid19next.domain.auth.oauth2.OAuth2UserInfo;
import com.covid19next.domain.auth.oauth2.OAuth2UserInfoFactory;
import com.covid19next.domain.auth.oauth2.UserPrincipal;
import com.covid19next.domain.member.Member;
import com.covid19next.domain.member.MemberRequestDto;
import com.covid19next.domain.member.MemberRole;
import com.covid19next.exception.OAuth2AuthenticationProcessingException;
import com.covid19next.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {


    private final MemberRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("이메일을 찾을 수 없습니다.");
        }

        Optional<Member> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        Member user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            System.out.println(oAuth2UserRequest.getClientRegistration().getRegistrationId());
            if(!user.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                        user.getProvider() + " account. Please use your " + user.getProvider() +
                        " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private Member registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        Member user = new Member(oAuth2UserInfo.getName(),
                oAuth2UserInfo.getEmail(),
                oAuth2UserInfo.getId(),
                false,
                AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()),
                MemberRole.ROLE_USER
        );


        return userRepository.save(user);
    }

    private Member updateExistingUser(Member existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.changeMemberOauth(existingUser.getMemberId(),
                oAuth2UserInfo.getName(),
                existingUser.getEmail(),
                existingUser.getAuthId(),
                existingUser.getProvider()
                );
        return existingUser;
    }

}