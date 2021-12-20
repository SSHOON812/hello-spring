package hello.hellospring.Service;

import hello.hellospring.domain.Member;

import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    // 테스트 코드는 한글 가능. 직관적

    MemberService memberService ;

    MemoryMemberRepository memoryMemberRepository ;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }


    @AfterEach
    public void aterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {

        //given 뭐가 주어지면
        Member member = new Member();
        member.setName("hello");


        //when  이게 실행 되서

        Long saveId = memberService.join(member);


        //then  결과가 나와야 됨
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복회원_예외(){

        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존대하는 회원 입니다");

/*
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){

            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존대하는 회원 입니다");

        }
*/



        //than

    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}