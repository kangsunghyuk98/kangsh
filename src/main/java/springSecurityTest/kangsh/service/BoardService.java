package springSecurityTest.kangsh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springSecurityTest.kangsh.domain.BoardEntity;
import springSecurityTest.kangsh.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void boardRegist(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    } // 글 등록

    public List<BoardEntity> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    } // 글 조회(게시글 번호 순서대로 내림차순 정렬함)

    public BoardEntity boardDetail(Integer boardId) {
        return boardRepository.findById(boardId).orElse(null);
    } // 글 상세 정보 조회 (orElse사용해서 optional로 감싸져있는 findById를 엔티티로 바로 쓰려고)

    public void boardUpdate(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    } // 글 수정(save랑 로직 같음 데이터 있으면 수정한다)\

    public void boardDelete(Integer boardId) {
        boardRepository.deleteById(boardId);
    } // 글 삭제

}
