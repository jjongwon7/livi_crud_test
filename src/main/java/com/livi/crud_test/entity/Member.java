package com.livi.crud_test.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter //이거 나중에 쓸지도?
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    public Member(String name) {
        this.name = name;
    }
}
