package hello.core.member;

import java.util.HashMap;
import java.util.Map;
//메모리에서 저장, 찾기 - 테스트용
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
