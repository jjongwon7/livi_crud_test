package com.livi.crud_test.service;

import com.livi.crud_test.dto.MemberRequest;
import com.livi.crud_test.entity.Member;
import com.livi.crud_test.exception.InvalidMemberRequestException;
import com.livi.crud_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**********************************************************************************************
     * 수정내용: selectMember, updateMember return Type: String->MemberResponse
     * 수정이유: 계층간 데이터 이동에 DTO 활용하기 위함
     **********************************************************************************************/

    /**
     * @param memberRequest
     * @return 생성한 멤버 id, name
     */


    public Member createMember(MemberRequest memberRequest) {
        // TODO : 연습삼아 Builder 를 사용해서 해볼 것
        Member member = memberRepository.save(new Member(memberRequest.getName()));

        return member;
    }


    /**
     * @param id
     * @return 조회한 멤버 이름
     */
    public Member selectMember(Long id) {

        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);

        return member;
    }

    /**
     * @param id,memberRequest
     * @return 갱신한 멤버 이름
     */
    @Transactional
    public void updateMember(Long id, MemberRequest memberRequest) throws InvalidMemberRequestException {
        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);
        member.setName(memberRequest.getName());
        memberRepository.save(member);
    }

    /**
     * @param id
     */
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);
        memberRepository.delete(member);
    }
}
