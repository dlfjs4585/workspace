import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const BoardList = () => {
  
  const navigate = useNavigate();

  //route 의 url로 전달되는 데이터 받기
  const params = useParams();

  // 게시글 목록 데이터를 저장할 state 변수
  const [boardList, setBoardList] = useState([]);

  // 게시글 목록 조회
  useEffect(() => {
    axios
    .get('/boardList')
    .then((res) => {
    setBoardList(res.data);
    console.log(res.data)
  })
  .catch((error) => {
    alert('오류 발생!!\n 개발자 모드로 콘솔 확인!!');
    console.log(error);
  });
  }, []);

  

  return(
    <>
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제 목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.map((board, i) => {
              return(
                <tr key={i}>
                  <td>{board.boardNum}</td>
                  <td><span onClick={() => {navigate(`/detail/${board.boardNum}`)}}>{board.boardTitle}</span></td>
                  <td>{board.boardWriter}</td>
                  <td>{board.createDate}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
      <button type="button" onClick={(e) => {navigate('/writeForm')}}>글쓰기</button>
    </>
  );
}

export default BoardList;