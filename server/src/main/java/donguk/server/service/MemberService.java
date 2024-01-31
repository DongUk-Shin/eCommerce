package donguk.server.service;

import donguk.server.domain.Member;
import donguk.server.domain.DTO.MemberDTO;
import donguk.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        Member member = Member.toMember(memberDTO);

        memberRepository.save(member);
    }

    public MemberDTO signin(MemberDTO memberDTO) {

        Optional<Member> memberOptional = memberRepository.findByEmail(memberDTO.getEmail());

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();

            if (member.getPassword().equals(memberDTO.getPassword())) {
                return MemberDTO.toMember(member);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }
}
