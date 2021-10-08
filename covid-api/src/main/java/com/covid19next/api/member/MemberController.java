package com.covid19next.api.member;

import com.covid19next.domain.member.MemberRequestDto;
import com.covid19next.domain.member.MemberResponseDto;
import com.covid19next.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        return ResponseEntity.ok(memberService.getMyInfo());
    }

    @PostMapping("/change")
    public ResponseEntity<MemberResponseDto> changeMember(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.changeMember(memberRequestDto));
    }


    @GetMapping("/{email}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String email) {
        return ResponseEntity.ok(memberService.getMemberInfo(email));
    }
}
