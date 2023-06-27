package com.livi.crud_test.controller;

import com.livi.crud_test.dto.MemberRequest;
import com.livi.crud_test.dto.MemberResponse;
import com.livi.crud_test.entity.Member;
import com.livi.crud_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class MemberController {

    private final MemberService memberService;
    
    @PostMapping("")
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberRequest memberRequest) {
        Member member = memberService.createMember(memberRequest);
        return ResponseEntity.ok(new MemberResponse(member));
    }

    @GetMapping("")
    public ResponseEntity<String> selectMember(@RequestParam(name = "id") Long id) {
        String memberName = memberService.selectMember(id);
        return ResponseEntity.ok(memberName);
    }

    @PutMapping("")
    public ResponseEntity<String> updateMember(@RequestBody MemberRequest memberRequest) {
        String memberName = memberService.updateMember(memberRequest);
        return ResponseEntity.ok(memberName);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteMember(@RequestParam(name = "id") Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("삭제 성공");
    }

}
