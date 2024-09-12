package intro.spring.repository;

import intro.spring.config.TimeLogging;
import intro.spring.domain.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@TimeLogging
// MemoryMemberRepository에 @Repository Annotion으로 MemoryMemberRepository가 bean으로 주입되는 것을
// 방지하기 위해 해당 Annotation설정
@Primary
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
