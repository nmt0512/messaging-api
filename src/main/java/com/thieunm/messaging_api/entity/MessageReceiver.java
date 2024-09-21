package com.thieunm.messaging_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "message_receiver")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageReceiver extends JpaAuditable<String> {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receivedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_group_id")
    private Group receivedGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message message;

    @Column(name = "is_read")
    private boolean isRead;
}
