package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //memberService()를 쓸때 emeberService구현체 객체(MemberServiceImpl)가 생성되는데,
    // 생성자로 MemoryMemberRepository가 할당이 된다.
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository() );
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
