package com.covid19next.api.member;

import com.covid19next.domain.auth.TokenDto;
import com.covid19next.domain.auth.TokenRequestDto;
import com.covid19next.domain.member.MemberRequestDto;
import com.covid19next.domain.member.MemberResponseDto;
import com.covid19next.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/logout")
    public void logout(@Valid @RequestBody TokenRequestDto tokenRequestDto) {
        authService.logout(tokenRequestDto);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@Valid @RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}
