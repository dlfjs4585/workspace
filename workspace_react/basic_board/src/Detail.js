import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Detail = ({board_list, setBoard}) => {
  const {id} = useParams();
  const navigate = useNavigate();

  const deleteBoard = (boardNum) => {
    const newBoard = [...board_list];
    for(let i = 0; i < newBoard.length; i++){
      if(newBoard[i].boardNum == boardNum){
        newBoard.splice(i , 1);
      }
    }
    setBoard(newBoard);
    navigate('/');
  }

  let findBoard = null;
  board_list.forEach((board, i) => {
    if(board.boardNum == id){
      findBoard = board;
    }
  });

  return(
    <>
      <table>
        <tr>
          <td>글번호</td>
          <td>{findBoard.boardNum}</td>
          <td>작성자</td>
          <td>{findBoard.writer}</td>
          <td>작성일</td>
          <td>{findBoard.createDate}</td>
        </tr>
        <tr>
          <td>제목</td>
          <td>{findBoard.title}</td>
        </tr>
        <tr>
          <td>내용</td>
          <td>{findBoard.content}</td>
        </tr>
      </table>
      <button type="button" onClick={(e) => {
        navigate(`/`);
      }}>뒤로가기</button>
      <button type="button" onClick={() => {
        deleteBoard(findBoard.boardNum);
      }}>삭제</button>
    </>
  );
};

export default Detail;

