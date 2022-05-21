package keno.SnsChats.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity @Getter
public class Message {
    @Id @GeneratedValue
    @Column(name = "message_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chats_id")
    private Chats chats;

}
