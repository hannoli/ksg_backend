package com.example.login.repository;

import com.example.login.entitiy.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*@NoRepositoryBean*/
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


    //이름으로 회원 정보 조회
    Optional<MemberEntity> findByMemberName(String memberName);

}
