package springSecurityTest.kangsh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "board")
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId; // 게시글 번호

    @Column(length = 50, nullable = false)
    private String title; //게시글 제목

    @Lob
    private String content; // 게시글 내용

    @Column(length = 30, nullable = false)
    private String writer; // 게시글 작성자

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime; // 작성시간

    @UpdateTimestamp
    private LocalDateTime updateTime; // 수정시간

    @Builder
    public BoardEntity(Long boardId, String title, String content, String writer, LocalDateTime createdTime, LocalDateTime updateTime) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }

}
