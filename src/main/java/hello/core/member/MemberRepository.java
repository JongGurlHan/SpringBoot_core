package hello.core.member;

public interface MemberRepository {

    //member 저장
    void save (Member member);

    //memberId로 member 찾기
    Member findById(Long memberId);

}
