import java.util.List;
import java.util.Optional;

public class BoardController {

    private BoardServiceImpl boardService;

    public BoardController(){
        this.boardService = new BoardServiceImpl();
    }

    // 게시글 목록 데이터 조회
    public List<BoardVO> boardList(){
        Optional<List<BoardVO>> optionalList = boardService.getBoardList();
        //optionalList.(() -> {});


        return optionalList.get();
    }

    // 게시글 상세 조회
    public BoardVO boardDetail(){
        Optional<BoardVO> op = boardService.getBoardDetail(1);
        op.ifPresentOrElse(
                board -> System.out.println("게시글 제목 : " + board.getTitle()),
                () -> System.out.println("조회된 게시글이 없습니다.")
        );

        return op.get();
    }

}
