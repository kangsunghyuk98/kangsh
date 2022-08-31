package springSecurityTest.kangsh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import springSecurityTest.kangsh.dto.MemberDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId; // 게시글 번호

    private String title; //게시글 제목
    private String content; // 게시글 내용
    private String writer; // 게시글 작성자

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime; // 작성시간

    @UpdateTimestamp
    private LocalDateTime updateTime; // 수정시간


}
