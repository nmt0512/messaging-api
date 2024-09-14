package com.thieunm.messaging_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends JpaAuditable<Integer> {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Nationalized
    @Column(nullable = false)
    private String fullName;

    @Column
    private Boolean gender;

    @Column
    private LocalDate birthday;

    @Column
    private int role;

    @Column
    private int status;
}
