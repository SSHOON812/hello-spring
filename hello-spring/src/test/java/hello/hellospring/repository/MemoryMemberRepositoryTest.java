package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트가 많으면 자동으로 돌려주는 방법이 있음
    //테스트 코드 관련 공부 할것.

    // 테스트 코드를 짤때는 순서에 상관없게 해야됨 의존관계 없이 설계해야됨
    @AfterEach  // 하나의 테스트 케이스가 끝나면 값을 지움 저장소, 공용데이터를 지워야 함
    public void afterEach(){

        repository.clearStore(); // 테스트 후 삭제

    }


    @Test
    public void save(){

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);

    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

       Member result = repository.findByName("spring1").get();

       assertThat(result).isEqualTo(member1);


    }


    @Test
    public void findAll(){

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result =repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }



}
