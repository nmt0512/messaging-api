package com.thieunm.messaging_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message extends JpaAuditable<String> {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToMany(mappedBy = "message")
    private List<MessageReceiver> messageReceiverList;

    @Column(name = "message_body", nullable = false)
    private String messageBody;
}
