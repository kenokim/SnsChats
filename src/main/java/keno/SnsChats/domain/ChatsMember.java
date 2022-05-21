package keno.SnsChats.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity @Getter
public class ChatsMember {
    @Id @GeneratedValue
    @Column(name = "chats_member_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chats_id")
    private Chats chats;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public static ChatsMember createChatsMember(Chats chats, Member member) {
        ChatsMember chatsMember = new ChatsMember();
        chatsMember.chats = chats;
        chatsMember.member = member;
        return chatsMember;
    }
}
