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
    private LocalDateTime localDateTime= LocalDateTime.now();

    public static AlterDTO toAlterDTO(AlterEntity alterEntity) {
        AlterDTO alterDTO = new AlterDTO();
        alterDTO.setRoom(alterEntity.getAlterRoom());
        alterDTO.setLocalDateTime(alterEntity.getAlterTime());
        return alterDTO;
    }


}
