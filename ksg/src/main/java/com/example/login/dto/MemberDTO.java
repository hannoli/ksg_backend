package com.example.login.dto;

import com.example.login.entitiy.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {

    private Long id;
    private String name;
    private String pwd;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(memberEntity.getMemberName());
        memberDTO.setId(memberEntity.getId());
        memberDTO.setPwd(memberEntity.getMemberPassword());
        return memberDTO;
    }
}
