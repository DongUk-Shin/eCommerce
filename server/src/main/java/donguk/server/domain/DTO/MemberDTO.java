package donguk.server.domain.DTO;

import donguk.server.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

    private Long id;
    private String email;
    private String name;
    private String password;

    public static MemberDTO toMember(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(member.getEmail());
        memberDTO.setName(member.getName());
        memberDTO.setPassword(member.getPassword());
        return memberDTO;
    }

}
