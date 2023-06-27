package com.livi.crud_test.service;

import com.livi.crud_test.dto.MemberRequest;
import com.livi.crud_test.entity.Member;
import com.livi.crud_test.exception.InvalidMemberRequestException;
import com.livi.crud_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * @param memberRequest
     * @return 생성한 멤버 id, name
     */
    public Member createMember(MemberRequest memberRequest) {

        Member newMember = new Member(memberRequest.getId(), memberRequest.getName());

        Member savedMember = memberRepository.save(newMember);

        return savedMember;
    }


    /**
     * @param id
     * @return 조회한 멤버 이름
     */
    public String selectMember(Long id) {

        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);

        return member.getName();
    }

    /**
     * @param memberRequest
     * @return 갱신한 멤버 이름
     */
    public String updateMember(MemberRequest memberRequest) {

        Member member = new Member(memberRequest.getId(), memberRequest.getName());

        memberRepository.findById(memberRequest.getId()).orElseThrow(InvalidMemberRequestException::new);

        Member updateMember = memberRepository.save(member);

        return updateMember.getName();
    }

    /**
     * @param id
     */
    public void deleteMember(Long id) {

        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);

        memberRepository.delete(member);
    }
}
