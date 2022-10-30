package hellogroup.hellospringartiname;

import hellogroup.hellospringartiname.repository.MemberRepository;
import hellogroup.hellospringartiname.repository.MemoryMemberRepository;
import hellogroup.hellospringartiname.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /**
     * 컨트롤러-서비스-리포지토리로 정형화된 프로젝트는 컴포넌트 스캔 사용
     *
     * 정형화되지 않은 경우, (지금처럼) 구현클래스의 변경여지가 있는경우 config 작성
     */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
