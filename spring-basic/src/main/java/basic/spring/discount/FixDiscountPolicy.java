package basic.spring.discount;

import basic.spring.member.Grade;
import basic.spring.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }

        return 0;
    }
}
