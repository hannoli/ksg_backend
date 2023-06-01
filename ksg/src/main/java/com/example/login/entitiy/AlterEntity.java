package com.example.login.entitiy;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "alter_table")
public class AlterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alter_id")
    private Long id;

    @Column(unique = true)
    private String alterRoom;

    @Column
    private LocalDateTime alterTime;


    @Builder
    public AlterEntity(String alterRoom, LocalDateTime alterTime) {
        this.alterRoom = alterRoom;
        this.alterTime = alterTime;
    }

    public void modifyAlterTime(LocalDateTime time) {
        this.alterTime = time;
    }
}
