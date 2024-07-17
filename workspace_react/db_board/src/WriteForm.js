import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const WriteForm = () => {

  const navigate = useNavigate();
  
  // 입력한 내용을 저장하는 state 변수
  const [board, setboard] = useState({
    boardTitle : '',
    boardWriter : '',
    boardContent : ''
  });

  function insertBoard (){
    // 제목이 비었으면?
    const title_input = document.querySelector('input[name="boardTitle"]');
    const writer_input = document.querySelector('input[name="boardWriter"]');

    // 함수 안에서 return에 아무것도 넣지 않으면 함수가 종료된다.
    if(title_input.value == ''){
      alert('제목 작성은 필수 입니다.');
      title_input.focus();
      return ;
    }
    if(writer_input.value == ''){
      alert('작성자 작성은 필수 입니다.');
      writer_input.focus();
      return ;
    }

    axios
    .post('/regBoard', board)
    .then((res) => {
      alert('게시글이 등록되었습니다.')
      navigate('/');
    })
    .catch((error) => {
      alert('오류 발생!!')
      console.log(error);
    });
  }

  // 입력 값 세팅
  function changeBoard(e){
    setboard({
      ...board,
      // key가 변수로 사용하게 되면 [] <- 대괄호를 사용하면 된다.
      [e.target.name] : e.target.value
    });
  }
  
  
  return(
    <div>
      <table>
        <tr>
          <td>제 목</td>
          <td><input type="text" name='boardTitle' onChange={(e) => {
            changeBoard(e);
          }}/></td>
        </tr>
        <tr>
          <td>작성자</td>
          <td><input type="text" name='boardWriter' onChange={(e) => {
            changeBoard(e);
          }}/></td>
        </tr>
        <tr>
          <td>내 용</td>
          <td><textarea name="boardContent" onChange={(e) => {
            changeBoard(e);
          }}></textarea></td>
        </tr>
      </table>
      <button type="button" onClick={(e) => {insertBoard()}} >글등록</button>
    </div>
  );
}


export default WriteForm;