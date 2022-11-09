package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements  MemberService{
  //  private  final  MemberRepository memberRepository = new MemoryMemberRepository();
    //  AppConfig 에서 내용 추가할것이기때문에 필요없다

    private  final  MemberRepository memberRepository;

    //AppConfig의 코드를 받아올 생성자가필요
    @Autowired  //@Autowired 의존관계 주입 (ac.getBean(MemberRepository.class) 랑 비슷한기능을한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


   //테스트용도 singleton 관련 근데 제대로 작동안함 이유알아내기
  public  MemberRepository getMemberRepository() {
        return  memberRepository;
    }



}
