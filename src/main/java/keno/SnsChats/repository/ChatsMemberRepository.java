package keno.SnsChats.repository;

import keno.SnsChats.domain.ChatsMember;
import org.springframework.data.repository.CrudRepository;

public interface ChatsMemberRepository extends CrudRepository<ChatsMember, Long> {
}
