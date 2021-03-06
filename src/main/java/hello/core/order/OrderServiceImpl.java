package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //fianl이 붙은것을 가지고 생성자를 만들어준다. ctrl f12로 확인가능
public class OrderServiceImpl implements OrderService{

   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;
    //누군가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현객체를 대신산성하고 주입해줘야한다.
    //    private DiscountPolicy discountPolicy;

    @Autowired
    public  OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);    //고객 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인금액 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
