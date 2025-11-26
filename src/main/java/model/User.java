package model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")   // 실제 테이블명이 다르면 수정하세요 (예: users)
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;
}
