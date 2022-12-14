package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// AppConfig는 애플리케이션의 실제동작에 필요한 구현 객체를 생성한다.
// AppConfig는 생성한 객체인스턴스의 참조를 생성자를통해서 주입(연결)시켜준다.

 // @Bean memberService -> new MemoryMemberRepository()
 // @Bean orderService -> new MemoryMemberRepository()


    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository
    // 이렇게 호출되어야함

//근데 실제로는
//call AppConfig.memberService
//call AppConfig.memberRepository
//call AppConfig.orderService
//로 나옴  일단 이건 정상 싱글톤이 적용된상태이기때문에 이렇게나오는게 정상이다.

@Configuration
public class AppConfig {
   @Bean
    public MemberService memberService(){
       System.out.println(" call AppConfig.memberService");
        return  new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println(" call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    //여기 오류날지도모르니까 주의
    @Bean
    public OrderService orderService() {
        System.out.println(" call AppConfig.orderService");
       return  new OrderServiceImpl(memberRepository(), discountPolicy());
    }
     //emoryMemberRepository, FixDiscountPolicy들이 parameter로 들어간다.
    // 이걸 주입(injection)해준다고 표현한다.
    //OrderServiceImpl()내용을 memberRepository(), discountPolicy()로 대체함
     @Bean
     public DiscountPolicy discountPolicy() {
       // return  new FixDiscountPolicy(); //고정 할인
        return  new RateDiscountPolicy();  // 변동 할인
    }


}
