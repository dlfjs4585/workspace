import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Detail = () => {
  const [board, setBoardList] = useState({});
  const params = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    axios
    .get(`/boardDetail/${params.boardNum}`)
    .then((res) => {
      setBoardList(res.data)
      console.log(res.data)
    })
    .catch((error) => {
      alert('오류발생!!');
      console.log(error);
    });
  }, []);

  function deleteBoard(){
    if(window.confirm('삭제하시겠습니까?')){
      axios
      .delete(`/deleteBoard/${params.boardNum}`)
      .then((res) => {
        navigate('/');
      })
      .catch((error) => {
        alert('오류 발생!!')
        console.log(error);
      });
    }
  }

  return(
    <div>
      <table>
        <tr>
          <td>글번호</td>
          <td>{board.boardNum}</td>
          <td>작성자</td>
          <td>{board.boardWriter}</td>
          <td>작성일</td>
          <td>{board.createDate}</td>
        </tr>
        <tr>
          <td>제목</td>
          <td colSpan={5}>{board.boardTitle}</td>
        </tr>
        <tr>
          <td>내용</td>
          <td colSpan={5}>{board.boardContent}</td>
        </tr>
      </table>
      <button type="button" onClick={() => {navigate('/')}}>뒤로가기</button>
      <button type="button" onClick={() => {deleteBoard()}}>삭제</button>
    </div>
  );
}


export default Detail;