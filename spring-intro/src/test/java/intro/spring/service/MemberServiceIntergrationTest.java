package intro.spring.service;

import intro.spring.domain.Member;
import intro.spring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class MemberServiceIntergrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello4");
        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("spring2");

        Member member2 = new Member();
        member2.setName("spring2");

        memberService.join(member1);
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }

    @Test
    void findOne() {
        Member member = memberService.findOne(1L).get();

        Assertions.assertThat(member.getName()).isNotNull();
    }
}