package keno.SnsChats.security;

import keno.SnsChats.domain.Chats;
import keno.SnsChats.domain.Member;
import keno.SnsChats.service.ChatsService;
import keno.SnsChats.service.MemberService;
import keno.SnsChats.web.ChatsDetailsDto;
import keno.SnsChats.web.WeatherDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {
    @Autowired TestRestTemplate template;

    @Autowired TokenProvider tokenProvider;

    @MockBean MemberService memberService;
    @MockBean ChatsService chatsService;

    private final Long memberId = 1L;
    private final Long chatsId = 1L;
    private final String memberName = "keno";

    @BeforeEach
    public void createMockData() {
        Member member = Member.createMember(memberName);
        when(memberService.findMemberById(memberId)).thenReturn(member);

        Chats chats = Chats.createChats(member, "Hello", 10, LocalDateTime.now());
        when(chatsService.findChatsById(chatsId)).thenReturn(chats);
    }

    public String createValidToken () {
        return tokenProvider.token();
    }
    public String createInvalidToken () {
        return "access-token";
    }

    @Test
    public void 인증된_유저_OK() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(createValidToken());
        HttpEntity req = new HttpEntity(headers);
        ResponseEntity res = template.exchange("/chats/1", HttpMethod.GET, req, ChatsDetailsDto.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void 인증안된_유저_UNAUTHORIZED() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(createInvalidToken());
        HttpEntity req = new HttpEntity(headers);
        ResponseEntity res = template.exchange("/chats/1", HttpMethod.GET, req, ChatsDetailsDto.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void Weather는_누구나_조회가능() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity req = new HttpEntity(headers);
        ResponseEntity res = template.exchange("/weather", HttpMethod.GET, req, WeatherDto.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
