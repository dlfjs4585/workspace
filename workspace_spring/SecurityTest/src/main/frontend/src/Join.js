import axios from 'axios';
import React, { useState } from 'react'

const Join = () => {

  // 입력한 회원정보를 저장 할 state변수
  const [joinData, setJoinData] = useState({
    memName : '',
    memId : '',
    memPw : ''
  });

  // input 태그에 값 입력할때마다 실행되는 함수
  const changeJoinData = (e) => {
    setJoinData({
      ...joinData,
      [e.target.name] : e.target.value
    })
  }

  // 회원가입 버튼 클릭 시 실행되는 함수
  const join = () => {
    axios.post('/member/join', joinData)
    .then((res) => {
      console.log('회원가입이 완료되었습니다.')
    })
    .catch((error) => {console.log(error)})
  }

  return (
    <div>
      <h1>회원가입 페이지</h1>
      <div>
        이름 : <input type='text' name='memName' onChange={(e) => {changeJoinData(e)}}/>
      </div>
      <div>
        아이디 : <input type='text' name='memId' onChange={(e) => {changeJoinData(e)}}/>
      </div>
      <div>
        비밀번호 : <input type='password' name='memPw' onChange={(e) => {changeJoinData(e)}}/>
      </div>
      <div>
        <button type='button' onClick={() => {join()}}>회원가입</button>
      </div>
    </div>
  )
}

export default Join