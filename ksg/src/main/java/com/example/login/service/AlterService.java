package com.example.login.service;


import com.example.login.dto.AlterDTO;
import com.example.login.entitiy.AlterEntity;
import com.example.login.repository.AlterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlterService {

    private final AlterRepository alterRepository;

    @Transactional
    public AlterDTO save(AlterDTO alterDTO) {
        /*1.신호 감지
        2.감지한 신호로 시간, 방 번호 저장
        3.이미 그 방 번호가 등록 되어 있으면, 등록 시간만 업데이트
             AlterEntity alterEntity = new AlterEntity();
    */
        Optional<AlterEntity> byRoom = alterRepository.findByAlterRoom(alterDTO.getRoom());
        if (byRoom.isPresent()) {
            AlterEntity existingAlterEntity = byRoom.get();
            // 기존 데이터가 있을 경우 업데이트
            existingAlterEntity.modifyAlterTime(alterDTO.getLocalDateTime());
            AlterDTO a_dto = AlterDTO.toAlterDTO(existingAlterEntity);
            return a_dto;
        } else {
            // 새로운 데이터 등록
            AlterEntity newAlterEntity = AlterEntity.builder()
                    .alterTime(alterDTO.getLocalDateTime())
                    .alterRoom(alterDTO.getRoom())
                    .build();
            alterRepository.save(newAlterEntity);
            AlterDTO a_dto = AlterDTO.toAlterDTO(newAlterEntity);
            return a_dto;
        }

    }

    @Transactional
    public void remove(){
        alterRepository.deleteAll();
    }

}

