package keno.SnsChats.utils;

import keno.SnsChats.domain.Member;
import keno.SnsChats.repository.ChatsRepository;
import keno.SnsChats.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
@Profile("!test")
@Transactional
@RequiredArgsConstructor
public class TestDataGenerator implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final ChatsRepository chatsRepository;

    @Override
    public void run(String... args) throws Exception {
        createMember();
    }

    private void createMember() {
        Optional<Member> findMember = memberRepository.findById(1L);
        if (findMember.isPresent()) return;
        Member member = Member.createMember("키노");
        memberRepository.save(member);
    }

    private void createChats() {

    }

}
