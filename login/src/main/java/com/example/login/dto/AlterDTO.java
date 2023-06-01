package com.example.login.dto;

import com.example.login.entitiy.AlterEntity;
import com.example.login.entitiy.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlterDTO {

private String Room;
private LocalDateTime localDateTime;

    public static AlterDTO toAlterDTO(AlterEntity alterEntity){
        AlterDTO alterDTO = new AlterDTO();
        alterDTO.setRoom(alterEntity.getMemberRoom());
        alterDTO.setLocalDateTime(alterEntity.getMemberTime());
        return alterDTO;
    }
}
