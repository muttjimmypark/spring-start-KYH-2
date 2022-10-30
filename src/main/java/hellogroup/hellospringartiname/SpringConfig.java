package hellogroup.hellospringartiname;

import hellogroup.hellospringartiname.repository.MemberRepository;
import hellogroup.hellospringartiname.repository.MemoryMemberRepository;
import hellogroup.hellospringartiname.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
