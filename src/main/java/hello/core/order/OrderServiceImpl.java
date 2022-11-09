package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//OrderServiceImpl 은  DiscountPolicy 뿐만아니라  RateDiscountPolicy도 의존하고있기때문에 OCP를 위반한상태이다.
//  OCP를 위반하지않으면 OrderServiceImpl은 변경하지않고 안의 내용만바꿔도 정상적으로 작동하게 변경시킬수있다.
// final은 무좋건 값이 할당되어야한다.


@Component
public class OrderServiceImpl implements  OrderService{

 //   private  final MemberRepository memberRepository = new MemoryMemberRepository();
 // AppConfig 와 연결될예정이기때문에 필요없다

    // private  final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인정책
   // private  final DiscountPolicy discountPolicy = new RateDiscountPolicy();// 변동 할인정책
    // 위의 둘은 FixDiscountPolicy나 RateDiscountPolicy를 의존하게되기때문에 OCP위반이다.

    private  final MemberRepository memberRepository;
    //AppConfig와 연결될예정
    private  final DiscountPolicy discountPolicy;
    //이렇게하면 OrderService에만의존하게됨. 다만이렇게하면 정상작동이안됨.
    // 이걸 고치면서  정상작동해야함
    // AppConfig와 연결하면 된다.

    @Autowired //의존관계주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memberId);
       int discountPrice = discountPolicy.discount(member,itemPrice);

        return  new Order(memberId, itemName, itemPrice,discountPrice);
    }

    //테스트용도
    public  MemberRepository getMemberRepository(){
        return  memberRepository;
    }
}
