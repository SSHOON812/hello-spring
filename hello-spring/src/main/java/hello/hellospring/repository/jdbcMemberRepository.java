package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class jdbcMemberRepository implements MemberRepository{


    private final DataSource dataSource;

    public jdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
