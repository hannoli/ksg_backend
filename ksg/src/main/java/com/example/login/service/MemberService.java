package com.example.login.service;

import com.example.login.dto.MemberDTO;
import com.example.login.entitiy.MemberEntity;
import com.example.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {

    }

    public MemberDTO login(MemberDTO memberDTO) {
/*1.id으로 db에서 조회
2.db에서  조회한 비번이랑 사용자가 입력한 비번이랑 일치하는지 확인
 */
        Optional<MemberEntity> byName = memberRepository.findByMemberName(memberDTO.getName());
        if (byName.isPresent()) {
            //조회 결과가 있다
            MemberEntity memberEntity = byName.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getPwd())) {
                //비밀번호 일치
                //entity->dto변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                //불일치
                return null;
            }
        } else {
            return null;
        }

    }

}
