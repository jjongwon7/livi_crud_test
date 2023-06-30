package com.livi.crud_test.service;

import com.livi.crud_test.dto.MemberRequest;
import com.livi.crud_test.dto.MemberResponse;
import com.livi.crud_test.entity.Member;
import com.livi.crud_test.exception.InvalidMemberRequestException;
import com.livi.crud_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


    public MemberResponse createMember(MemberRequest memberRequest) {

        Member newMember = new Member(memberRequest.getName());
        Member savedMember = memberRepository.save(newMember);

        return new MemberResponse(savedMember.getName());
    }


    /**
     * @param id
     * @return 조회한 멤버 이름
     */
    public MemberResponse selectMember(Long id) {

        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);

        return new MemberResponse(member.getName());
    }

    /**
     * @param id,memberRequest
     * @return 갱신한 멤버 이름
     */
    public MemberResponse updateMember(Long id, MemberRequest memberRequest) {

        Member member = new Member(id, memberRequest.getName());

        memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);

        //이게 @Transactional 역할하여 commit
        Member updateMember = memberRepository.save(member);

        return new MemberResponse(updateMember.getName());
    }

    /**
     * @param id
     */
    public void deleteMember(Long id) {

        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberRequestException::new);

        memberRepository.delete(member);

    }
}
