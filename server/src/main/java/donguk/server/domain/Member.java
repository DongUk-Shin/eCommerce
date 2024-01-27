package donguk.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    public static Member toMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setEmail(memberDTO.getEmail());
        member.setName(memberDTO.getName());
        member.setPassword(memberDTO.getPassword());
        return member;
    }
}
