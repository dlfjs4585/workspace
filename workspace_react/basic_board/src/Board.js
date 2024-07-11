import { useNavigate } from "react-router-dom";

const Board = ({board}) => {

  const navigate = useNavigate();

  return(
    <tr>
      <td>{board.boardNum}</td>
      <td onClick={(e) => {
        navigate(`/detail/${board.boardNum}`)
      }}>{board.title}</td>
      <td>{board.writer}</td>
      <td>{board.createDate}</td>
    </tr>
  );
};

export default Board;