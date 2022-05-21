package keno.SnsChats.domain;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull
    private String name;

    public static Member createMember(String name) {
        Member member = new Member();
        member.name = name;
        return member;
    }
}
