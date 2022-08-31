package springSecurityTest.kangsh.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springSecurityTest.kangsh.domain.BoardEntity;
import springSecurityTest.kangsh.service.BoardService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board") //url board로 1차 분류
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public String Boardlist(Model model) {
        model.addAttribute("board", boardService.list());
        return "list";
    } //작성글 조회 뷰 매핑

    @GetMapping("/detail/{boardId}")
    public String boardDetail(@PathVariable Integer boardId, Model model) {
        model.addAttribute("board", boardService.boardDetail(boardId));
        return "detail";
    } // 작성글 세부정보 조회 뷰 매핑

    @GetMapping("/register")
    public String boardregistView() {
        return "register";
    } // 글쓰기 페이지 뷰만 GET 매핑

    @PostMapping("/register")
    public String boardregistPost(BoardEntity boardEntity) {
        boardService.boardRegist(boardEntity);
        return "redirect:/board/list";
    } // 글쓰기 페이지 매핑

    @GetMapping("/update/{boardId}")
    public String boardupdateView(@PathVariable Integer boardId, Model model) {
        model.addAttribute("board", boardService.boardDetail(boardId));
        return "update";
    } // 게시판 글 수정 뷰 GET 매핑

    @PostMapping("/update")
    public String boardupdatePost(BoardEntity boardEntity) {
        boardService.boardUpdate(boardEntity);
        return "redirect:/board/list";
    } // 게시판 글 수정 매핑



}
