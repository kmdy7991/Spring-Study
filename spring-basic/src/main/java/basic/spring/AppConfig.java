package basic.spring;

import basic.spring.discount.DiscountPolicy;
import basic.spring.discount.FixDiscountPolicy;
import basic.spring.discount.RateDiscountPolicy;
import basic.spring.member.MemberRepository;
import basic.spring.member.MemberService;
import basic.spring.member.MemberServiceImpl;
import basic.spring.member.MemoryMemberRepository;
import basic.spring.order.OrderService;
import basic.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
