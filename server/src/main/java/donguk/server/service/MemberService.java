package donguk.server.service;

import donguk.server.domain.Member;
import donguk.server.domain.MemberDTO;
import donguk.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        Member member = Member.toMember(memberDTO);

        memberRepository.save(member);
    }

}
