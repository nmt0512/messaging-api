package com.thieunm.messaging_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "group_chat") // Can not name "group", it's a reserved keyword in MySQL, so changed to "group_chat"
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group extends JpaAuditable<String> {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "group")
    private List<UserGroup> userGroupList;

    @OneToMany(mappedBy = "receivedGroup")
    private List<MessageReceiver> receivedMessageList;
}
