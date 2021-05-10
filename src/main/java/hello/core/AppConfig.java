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

@Configuration
public class AppConfig {
    //memberService()를 쓸때 emeberService구현체 객체(MemberServiceImpl)가 생성되는데,
    // 생성자로 MemoryMemberRepository가 할당이 된다.

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
       return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }

}

//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository() );
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }
