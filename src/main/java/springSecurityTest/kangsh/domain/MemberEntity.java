package springSecurityTest.kangsh.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Member;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String goon;

    @Column(length = 50, nullable = false)
    private String nick;

    @Builder
    public MemberEntity(Long id, String email, String password, String goon, String nick) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.goon = goon;
        this.nick = nick;
    }

}
