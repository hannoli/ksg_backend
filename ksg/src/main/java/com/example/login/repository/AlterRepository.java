package com.example.login.repository;

import com.example.login.entitiy.AlterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlterRepository extends JpaRepository<AlterEntity,Long> {


    //방이름으로 회원 정보 조회
    Optional<AlterEntity> findByAlterRoom(String AlterRoom);
}
