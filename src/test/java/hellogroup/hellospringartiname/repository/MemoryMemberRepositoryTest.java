package hellogroup.hellospringartiname.repository;

import hellogroup.hellospringartiname.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        repository.clearStore();
    }

    @Test
    void save_findById() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        assertThat(member).isEqualTo(repository.findById(member.getId()).get());
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        assertThat(repository.findByName("spring1").get()).isEqualTo(member1);
        assertThat(repository.findByName("spring2").get()).isEqualTo(member2);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        assertThat(repository.findAll().size()).isEqualTo(2);
    }
}