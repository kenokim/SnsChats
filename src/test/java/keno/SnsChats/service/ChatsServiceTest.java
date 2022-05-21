package keno.SnsChats.service;

import keno.SnsChats.domain.Chats;
import keno.SnsChats.domain.Member;
import keno.SnsChats.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ChatsServiceTest {

    @Autowired private ChatsService chatsService;

    @Autowired private MemberRepository memberRepository;

    private Long testMemberId;
    private String testMemberName;

    @BeforeEach
    void setup() {
        testMemberName = "keno";
        Member testMember = Member.createMember(testMemberName);
        memberRepository.save(testMember);
        testMemberId = testMember.getId();
    }

    @Test
    void saveAndFindChats() {
        // given
        Long chatsId = chatsService.create("hello", 10, testMemberId);
        // when
        Chats findChats = chatsService.findChatsById(chatsId);
        // then
        assertThat(findChats.getId()).isEqualTo(chatsId);
    }

}