package com.livi.crud_test.controller;

import com.livi.crud_test.dto.MemberRequest;
import com.livi.crud_test.dto.MemberResponse;
import com.livi.crud_test.entity.Member;
import com.livi.crud_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
/*******************************************************************************
 * 수정내용: Value of @RequestMapping: "/test" -> "/members"
 * 수정이유: REST API 설계 규칙, URI는 Resource를 표현해야한다. 에 따라 적합한 URI로 변경
 ******************************************************************************/
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<?> createMember(@RequestBody MemberRequest memberRequest) {
        Member member = memberService.createMember(memberRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(member.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*******************************************************************************
     * 수정내용: @RequestParam -> @PathVariable로 변경 & return String->MemberResponse
     * 수정이유: id를 Resource Path로 받기 위함, DTO 객체를 계층간 데이터 이동 일관성.
     ******************************************************************************/
    @GetMapping("/{id}")
    public ResponseEntity<?> selectMember(@PathVariable Long id) {
        return ResponseEntity.ok(new MemberResponse(memberService.selectMember(id)));
    }


    /*******************************************************************************
     * 수정내용: PutMapping @RequestBody->@@PathVariable + @RequestBody
     * 수정이유: Resource의 정보를 URI 입력값과, Http Body값으로 구분하여 받기 위함.
     ******************************************************************************/
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id, @RequestBody MemberRequest memberRequest) {
        memberService.updateMember(id, memberRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }

}
