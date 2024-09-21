package com.thieunm.messaging_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "user_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroup extends JpaAuditable<String> {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "is_joining", nullable = false)
    private boolean isJoining;

    @Column(name = "user_nick_name")
    private String userNickName;
}
