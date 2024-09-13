package basic.spring.discount;

import basic.spring.member.Member;

public interface DiscountPolicy {
    /*
     * @Return 할인 정책
     */
    int discount(Member member, int price);
}
