import { useNavigate, useParams } from "react-router-dom";

const Detail = ({board_list}) => {
  const {id} = useParams();
  const navigate = useNavigate();
  // let findBoard = null;
  // board_list.forEach((board, i) => {
  //   if(board.boardNum == id){
  //     findBoard = item;
  //   }
  // });

  return(
    <>
      <table>
        <tr>
          <td>글번호</td>
          <td>{board_list[id-1].boardNum}</td>
          <td>작성자</td>
          <td>{board_list[id-1].writer}</td>
          <td>작성일</td>
          <td>{board_list[id-1].createDate}</td>
        </tr>
        <tr>
          <td>제목</td>
          <td>{board_list[id-1].title}</td>
        </tr>
        <tr>
          <td>내용</td>
          <td>{board_list[id-1].content}</td>
        </tr>
      </table>
      <button type="button" onClick={(e) => {
        navigate(`/`)
      }}>뒤로가기</button>
      <button type="button">삭제</button>
    </>
  );
};

export default Detail;

