package keno.SnsChats.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TokenTest {
    @Autowired TokenProvider tokenProvider;

    @Test
    void basicTokenTest() {
        String token = tokenProvider.token(1L);
        assertThat(token).isNotNull();
    }
}
