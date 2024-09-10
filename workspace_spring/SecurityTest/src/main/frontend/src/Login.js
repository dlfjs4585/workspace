import axios from 'axios';
import React, { useState } from 'react'

const Login = () => {

  // 로그인 데이터를 저장할 변수
  const [loginData, setLoginData] = useState({
    memId : '',
    memPw : ''
  });

  // 입력한 정보로 로그인데이터 변경 함수
  const changeLoginData = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name] : e.target.value
    });
  }

  // 로그인 버튼 클릭 시 실행 함수
  const login = () => {
    axios.post('member/login', loginData)
    .then((res) => {
      console.log('로그인 성공')
      console.log(res)

      localStorage.setItem("Authorization", res.headers.authorization)
    })
    .catch((error) => {
      console.log(error)
      // 오류코드가 401이면 다시 로그인
      // 오류코드가 401이 아닐때
      if(error.response.status == 401){
        alert('아이디 혹은 비밀번호를 확인하십시오.')
      }
      else{
        alert('알수없는 오류 발생')
      }
    })
  }

  // 아이디와 비밀번호 input 태그의 name 속성은 반드시 
  // 자바의 LoginFitter 클래스 생성자 안에서 설정한 parameter 이름으로 지정
  return (
    <div>
      <div>
        아이디 : <input type='text' name='memId' onChange={(e) => {changeLoginData(e)}}/>
      </div>
      <div>
        비밀번호 : <input type='password' name='memPw' onChange={(e) => {changeLoginData(e)}}/>
      </div>
      <div>
        <button type='button' onClick={() => {login()}} >로그인</button>
      </div>
    </div>
  )
}

export default Login