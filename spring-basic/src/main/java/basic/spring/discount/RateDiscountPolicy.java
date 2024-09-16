package basic.spring.discount;

import basic.spring.member.Grade;
import basic.spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private static final int DISCOUNT = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * DISCOUNT / 100;
        }

        return 0;
    }
}
