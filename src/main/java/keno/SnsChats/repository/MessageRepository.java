package keno.SnsChats.repository;

import keno.SnsChats.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
