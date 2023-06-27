package com.livi.crud_test.repository;

import com.livi.crud_test.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
