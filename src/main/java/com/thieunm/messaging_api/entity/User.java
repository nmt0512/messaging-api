package com.thieunm.messaging_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends JpaAuditable<String> {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Nationalized
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column
    private Boolean gender;

    @Column
    private LocalDate birthday;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @Column(name = "is_online", nullable = false)
    private boolean isOnline;

    @Column(name = "is_locked", nullable = false)
    private boolean isLocked;

    @Column(name = "last_online_time", nullable = false)
    private Timestamp lastOnlineTime;

    @OneToMany(mappedBy = "user")
    private List<UserGroup> userGroupList;

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessageList;

    @OneToMany(mappedBy = "receivedUser")
    private List<MessageReceiver> receivedMessageList;

    @OneToMany(mappedBy = "user")
    private List<Contact> contactList;

    @OneToMany(mappedBy = "friend")
    private List<Contact> addedToFriendContactList;
}
