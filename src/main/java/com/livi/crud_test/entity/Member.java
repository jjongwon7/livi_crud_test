package com.livi.crud_test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*******************************************************************************
     * 수정내용: Entity Member(String name) 생성자 추가
     * 수정이유: Id 생성을 DB에 위임하여 자동으로 넣어주기떼문에, name field 사용 생성자 필요
     ******************************************************************************/
    public Member(String name) {
        this.name = name;
    }
}
