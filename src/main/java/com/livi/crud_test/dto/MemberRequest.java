package com.livi.crud_test.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

/**********************************************************************************************
 * 수정내용: Field: (Long id , String name) -> (String name)
 * 수정이유: Controller단에서 @Pathvaiable을 통한 id값 전달로, 중복데이터 방지, 필요한 데이터만 계층간 이동
 **********************************************************************************************/
public class MemberRequest {

    @NotNull
    private String name;

}
