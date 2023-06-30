package com.livi.crud_test.dto;

import com.livi.crud_test.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


/**********************************************************************
 * 수정내용: Field: (Long id , String name) -> (String name)
 * 수정이유: Controller단에서 @Pathvaiable을 통한 id값 전달로, 중복데이터 방지.
 **********************************************************************/
public class MemberResponse {
    private String name;

    public MemberResponse(Member member) {
        this.name = member.getName();
    }
}
