package keno.SnsChats.service;

import keno.SnsChats.domain.Chats;
import keno.SnsChats.domain.Member;
import keno.SnsChats.repository.ChatsRepository;
import keno.SnsChats.repository.MemberRepository;
import keno.SnsChats.web.ChatsCreateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatsService {
    private final ChatsRepository chatsRepository;
    private final MemberService memberService;

    public Chats findChatsById(Long chatsId) {
        return chatsRepository.findById(chatsId).orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));
    }
    @Transactional
    public Long create(String title, Integer maxNumMembers, Long memberId) {
        Member member = memberService.findMemberById(memberId);
        Chats chats = Chats.createChats(member, title, maxNumMembers, LocalDateTime.now());
        chatsRepository.save(chats);
        return chats.getId();
    }

}
