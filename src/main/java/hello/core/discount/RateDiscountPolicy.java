package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy  implements  DiscountPolicy{
    private  int discountPercent = 10;

    //ctrl + shift + T   원하는부분에 단축키누르면 관련된 test class생성
    @Override
    public int discount(Member member, int price) {
       if (member.getGrade() == Grade.VIP){
           return  price * discountPercent /100;
       }else {
           return  0;
       }
    }
}
