package hello.core.member;

public class MemberServiceImpl implements  MemberService{

  //  private  final  MemberRepository memberRepository = new MemoryMemberRepository();
    //  AppConfig 에서 내용 추가할것이기때문에 필요없다



    private  final  MemberRepository memberRepository;

    //AppConfig의 코드를 받아올 생성자가필요
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
}
