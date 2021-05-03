package hello.core.member;

//구현체가 하나만 있을때 인터페이스명 뒤에 Impl 붙이는게 관례!
public class MemberServiceImpl implements MemberService{

    //가입하고 찾으려면 MemberRepository 구현객체가 필요
    private  final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
