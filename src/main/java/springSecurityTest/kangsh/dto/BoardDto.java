package springSecurityTest.kangsh.dto;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import springSecurityTest.kangsh.domain.BoardEntity;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long boardId;
    private String title; //게시글 제목
    private String content; // 게시글 내용
    private String writer; // 게시글 작성자
    private LocalDateTime createdTime; // 작성시간
    private LocalDateTime updateTime; // 수정시간

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .boardId(boardId)
                .title(title)
                .content(content)
                .writer(writer)
                .createdTime(createdTime)
                .updateTime(updateTime)
                .build();
    }

        @Builder
        public BoardDto(Long boardId, String title, String content, String writer, LocalDateTime createdTime, LocalDateTime updateTime) {
            this.boardId = boardId;
            this.title = title;
            this.content = content;
            this.writer = writer;
            this.createdTime = createdTime;
            this.updateTime = updateTime;
        }

}
