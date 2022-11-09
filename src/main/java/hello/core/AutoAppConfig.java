package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//shift + shift  원하는 파일 search
//  excludeFilters는  ComponentScan중에 제한하는것을 의미한다.
@Configuration
@ComponentScan(
    //   basePackages = "hello.core.member", //이렇게하면 hello.core.member안의 내용물만 ComponentScan한다.
    //   basePackageClasses = AutoAppConfig.class, // package는 hello.core 이므로 hello.core이후 부터 scan한다
    //   DeFalut 설정으로는 @ComponentScan 이 붙은 설정정보 클래스의 패키지가 시작위치가된다.
    //   DeFalut @ComponentScan 를 이용할려면 설정정보 클래스의 위치를 프로젝트 최상단에 두는방식으로 이용하면 좋다

    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {

    //오류내기위해서 만든내용 성공하기는하나 내용보면 조금 다름  return new MemoryMemberRepository()는 component하면 소문자로 바뀌기때문에 memoryMemberRepository로 읽힘
    @Bean(name ="memoryMemberRepository")
    MemberRepository memberRepository(){
     return new MemoryMemberRepository();
    }
}


