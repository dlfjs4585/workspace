import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegStu = () => {

  const navigate = useNavigate();

  const [stu, setStuList] = useState({
    stuName : '',
    stuAge : 0,
    stuTel : '',
    stuAddr : ''
  });


  // 학생 등록
  function insertStu(){
    const stuName_input = document.querySelector('input[name="stuName"]');

    if(stuName_input.value == ''){
      alert('이름 입력은 필수 입니다.')
      stuName_input.focus();
      return ;
    }

    axios
    .post('/insertStu', stu)
    .then((res) => {
      alert('학생이 등록되었습니다.');
      navigate('/');
    })
    .catch((error) => {
      alert('오류 발생!!');
      console.log(error);
    })
  }

  // 입력 값 세팅
  function changeStu(e){
    setStuList({
      ...stu,
      [e.target.name] : e.target.value
    });
  }

  return(
    <div>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" name='stuName' onChange={(e) => {changeStu(e)}}/></td>
        </tr>
        <tr>
          <td>나이</td>
          <td><input type="text" name='stuAge' onChange={(e) => {changeStu(e)}} /></td>
        </tr>
        <tr>
          <td>연락처</td>
          <td><input type="text" name='stuTel' onChange={(e) => {changeStu(e)}} /></td>
        </tr>
        <tr>
          <td>주소</td>
          <td><input type="text" name='stuAddr' onChange={(e) => {changeStu(e)}} /></td>
        </tr>
      </table>
      <button type="button" onClick={(e) => {insertStu()}}>글 쓰기</button>
    </div>
  );
}

export default RegStu;