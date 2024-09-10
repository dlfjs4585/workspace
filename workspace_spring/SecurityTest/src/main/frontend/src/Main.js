import axios from 'axios';
import React from 'react'
import { useNavigate } from 'react-router-dom'
import { securityApi } from './securityAxios';

const Main = () => {

  const navigate = useNavigate();

  const test = () => {
    axios.get('/')
    .then((res) => {})
    .catch((error) => {console.log(error)})
  }

  const test1 = () => {
    securityApi.get('/test1')
    .then((res) => {console.log('성공')})
    .catch((error) => {console.log(error)})
  }
  const test2 = () => {
    securityApi.get('/test2')
    .then((res) => {console.log('성공')})
    .catch((error) => {
      console.log(error);
    })
  }
  const test3 = () => {}
  const test4 = () => {
    axios.get('/test4', {
      headers : {
        'Authorization' : localStorage.getItem('Authorization')
      }
    })
    .then((res) => {console.log('성공')})
    .catch((error) => {
      console.log(error)
    })
  }
  const test5 = () => {}

  return (
    <div>
      <h1>Main Page</h1>
      <h3><span onClick={() => {navigate('/loginForm')}}>로그인 페이지 이동</span></h3>
      <h3><span onClick={() => {navigate('/joinForm')}}>회원가입 페이지 이동</span></h3>
      <h3><span onClick={() => {test()}}>서버에 토큰 가져가기</span></h3>
      <h3>관리자 페이지 이동</h3>
      <h3>일반회원 페이지 이동</h3>

      <h3 onClick={() => {test1()}}>MainController-test1 메서드 : 누구나 접근</h3>
      <h3 onClick={() => {test2()}}>MainController-test2 메서드 : 인증된 사람만 접근</h3>
      <h3 onClick={() => {test3()}}>MainController-test3 메서드 : 인증된 일반 회원만 접근</h3>
      <h3 onClick={() => {test4()}}>MainController-test4 메서드 : 인증된 관리자만 접근</h3>
      <h3 onClick={() => {test5()}}>MainController-test5 메서드 : 인증된 매니저 or 관리자만 접근</h3>
    </div>
  )
}

export default Main