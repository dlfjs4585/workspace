import { useNavigate } from "react-router-dom";
import Board from "./Board";

const BoardList = ({board_list}) => {
  const navigate = useNavigate();
  return(
    <div className="table">
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            board_list.map((board, i) => {
              return(
                <Board key={i} board={board} />
              );
            })
          }
        </tbody>
      </table>
      <button type="button" onClick={(e) => {navigate('/writeForm')}}>글 쓰기</button>
    </div>
  );
};

export default BoardList;