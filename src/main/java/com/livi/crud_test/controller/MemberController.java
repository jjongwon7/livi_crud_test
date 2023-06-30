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

    /*******************************************************************************
     * 수정내용: Post method에만 Response Header에 Location값으로 URI 추가
     * 수정이유: id값으로 식별 불가능한 Post에서 추가된 Resource를 식별하기 위함.
     ******************************************************************************/
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
     * 수정내용: @RequestParam -> @PathVariable로 변경 & return String->?
     * 수정이유: id를 Resource Path로 받기 위함, 와일드카드 사용으로 유연성 확보
     ******************************************************************************/
    @GetMapping("/{id}")
    public ResponseEntity<?> selectMember(@PathVariable Long id) {
        return ResponseEntity.ok(MemberResponse
                .builder()
                .name(memberService.selectMember(id).getName())
                .build());
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
