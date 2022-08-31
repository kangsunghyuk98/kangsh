package springSecurityTest.kangsh.dto;


import lombok.*;
import springSecurityTest.kangsh.domain.MemberEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String email;
    private String password;
    private String goon;
    private String nick;
    private LocalDateTime createdDate;
    private LocalDateTime modifyDate;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .goon(goon)
                .nick(nick)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String goon, String nick) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.goon = goon;
        this.nick = nick;
    }
}
