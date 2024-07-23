import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import * as memberApi from '../apis/memberApi'

const Login = () => {

  const navigate = useNavigate()
  const[loginData, setLoginData] = useState({
    memId : '',
    memPw : ''
  });

  function changeLoginData(e){
    setLoginData({
      ...loginData,
      [e.target.name] : e.target.value
    });
  }

  function login(){
    // 아이디, 비밀번호 입력했는지 유효성 검사 필요(안만들었음)
    memberApi.login(loginData)
    .then((res) => {
      console.log(loginData)
      navigate('/')
    })
    .catch((error) => {
      console.log(error)
    })
  }

  return (
    <div>
      <span>아이디</span>
      <div><input type='text' name='memId' placeholder='input ID' onChange={(e) => {changeLoginData(e)}}/></div>
      <span>비밀번호</span>
      <div><input type='password' name='memPw' placeholder='input PW' onChange={(e) => {changeLoginData(e)}} /></div>
      <button type='button' onClick={(e) => {login()}}>로그인</button>
      <button type='button' onClick={(e) => {navigate('/')}}>목록가기</button>
    </div>
  )
}

export default Login