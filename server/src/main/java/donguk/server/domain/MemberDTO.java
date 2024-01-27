package donguk.server.domain;

import jakarta.persistence.*;
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
        memberDTO.setId(memberDTO.getId());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setName(member.getName());
        memberDTO.setPassword(member.getPassword());
        return memberDTO;
    }

}
