package keno.SnsChats.repository;

import keno.SnsChats.domain.ChatsMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatsMessageRepository extends CrudRepository<ChatsMessage, Long> {
}
