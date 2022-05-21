package keno.SnsChats.domain;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity @Getter
public class Chats {
    @Id @GeneratedValue
    @Column(name = "chats_id")
    private Long id;

    @NotNull
    private String title;

    private Integer numMembers;

    private LocalDateTime createAt;

    private LocalDateTime lastModified;

}
