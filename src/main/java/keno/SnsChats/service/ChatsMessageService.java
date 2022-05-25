package keno.SnsChats.service;

import keno.SnsChats.repository.ChatsMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatsMessageService {
    private final ChatsMessageRepository chatsMessageRepository;

}
