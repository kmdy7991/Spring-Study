package basic.spring;

import basic.spring.member.Grade;
import basic.spring.member.Member;
import basic.spring.member.MemberService;
import basic.spring.member.MemberServiceImpl;
import basic.spring.order.Order;
import basic.spring.order.OrderService;
import basic.spring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println(order);
    }
}
