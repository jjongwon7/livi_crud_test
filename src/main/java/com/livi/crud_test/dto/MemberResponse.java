package com.livi.crud_test.dto;

import com.livi.crud_test.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private Long id;
    private String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
