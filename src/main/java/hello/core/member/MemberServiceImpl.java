package hello.core.member;

//구현체가 하나만 있을때 인터페이스명 뒤에 Impl 붙이는게 관례!
public class MemberServiceImpl implements MemberService{

    //가입하고 찾으려면 MemberRepository 구현객체가 필요
    //이제 추상화에만 의존 DIP지킴
    private final MemberRepository memberRepository;

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

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
