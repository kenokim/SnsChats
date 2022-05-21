package keno.SnsChats.repository;

import keno.SnsChats.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
