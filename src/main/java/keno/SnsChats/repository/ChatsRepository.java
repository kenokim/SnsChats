package keno.SnsChats.repository;

import keno.SnsChats.domain.Chats;
import org.springframework.data.repository.CrudRepository;

public interface ChatsRepository extends CrudRepository<Chats, Long> {
}
