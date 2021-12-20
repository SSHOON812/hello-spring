package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    //서비스와 관련된 코드는 비즈니스와 관련된 네이밍을 해야함
    private final MemberRepository memberRepository;


    public MemberService( MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join (Member member){

        //같은 이름이 있는 죽복회원 안된
        // optional 로 바로 꺼내는것을 권장 하지 않음
        validateDuplicateMember(member); //  중복회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    public void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
             throw  new IllegalStateException("이미 존대하는 회원 입니다");
         });
    }


    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
