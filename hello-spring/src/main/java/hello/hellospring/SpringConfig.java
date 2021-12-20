package hello.hellospring;

import hello.hellospring.Service.MemberService;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return  new MemoryMemberRepository();
    }

    //주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔 @어노테이션 을 사용
    //정형와 되지 않거나, 상황에 따라 변경되어야 하면 설정을 통해 스프링 빈으로 등록한다.

    //스프링 컨테이너에 올라가는 @Sevice @Reposittory @Component 것들만 @Autowired를 붙혀 사용할 수 있다.

}
