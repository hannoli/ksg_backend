package com.example.login.service;


import com.example.login.dto.AlterDTO;
import com.example.login.repository.AlterReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlterService {

    private final AlterReposiotry alterReposiotry;

    public void save(AlterDTO alterDTO) {
        /*1.신호 감지
        2.감지한 신호로 시간, 방 번호 저장
        3.이미 그 방 번호가 등록 되어 있으면, 등록 시간만 업데이트
    */
        return null;
    }

    public AlterDTO find(AlterDTO alterDTO) {
        /*1.신호 감지
        2.감지한 신호로 시간, 방 번호 저장
    */
        return null;
    }
}
