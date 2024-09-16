package basic.spring.discount;

import basic.spring.member.Grade;
import basic.spring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int price = 20000;

        int discount = rateDiscountPolicy.discount(member, price);
        Assertions.assertThat(discount).isEqualTo(price * 10 / 100);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        Member member = new Member(1L, "memberBasic", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }


}