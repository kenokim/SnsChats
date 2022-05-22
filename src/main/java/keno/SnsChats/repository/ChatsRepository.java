package keno.SnsChats.repository;

import keno.SnsChats.domain.Chats;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatsRepository extends CrudRepository<Chats, Long> {
    List<Chats> findAll();
}
