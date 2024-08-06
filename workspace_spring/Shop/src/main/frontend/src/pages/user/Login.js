
import React, { useState } from 'react'
import './Login.css'
import Modal from '../../common/Modal';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const navigate = useNavigate();

  // Login버튼을 클릭 시 화면에 보여지는 모달 창의 상태
  const [beforeLoginModal, setBeforeLoginModal] = useState(false);

  // login 쿼리가 실행된 후, 보여지는 모달 창의 상태
  const [afterLoginModal, setAfterLoginModal] = useState(false);

  // login 성공, 실패 여부를 저장하는 변수
  const [isLoginSuccess, setIsLoginSuccess] = useState(false);

  //입력한 id, pw를 저장할 함수
  const [loginData, setLoginData] = useState({
    memId : '',
    memPw : ''
  });

  // 입력한 아이디의 정보를 담아오는 변수
  const [loginMemberInfo, setLoginMemberInfo] = useState({
    memId : '',
    memName : '',
    memRole : ''
  });

  // 입력한 id, pw를 loginData에 저장하는 함수(입력할 떄마다 실행)
  function changeLoginData(e){
    setLoginData({
      ...loginData,
      [e.target.name] : e.target.value
    });
  }

  // 로그인 버튼 클릭시 실행
  function login(){
    // id, pw 입력 여부 확인
    if(loginData.memId =='' || loginData.memPw == ''){
      // 모달 창 상태를 보이게 변경
      setBeforeLoginModal(true)
      return;
    }

    axios.post('/api_member/login', loginData)
    .then((res) => {
      setLoginMemberInfo({
        memId : res.data.memId,
        memName : res.data.memName,
        memRole : res.data.memRole
      })
      // 자바에서 null 데이터가 전달되면 res.data 빈문자('') 데이터로 변환된다.
      // 로그인 성공시
      if(res.data != ''){
        setAfterLoginModal(true)
        setIsLoginSuccess(true)
      }
      // 로그인 실패시
      else{
        setAfterLoginModal(true)
        setIsLoginSuccess(false)
      }
      // 객체 -> 문자열로 변환한 데이터를 JSON 데이터로 부른다.
      const loginInfo = {
        memId : res.data.memId,
        memName : res.data.memName,
        memRole : res.data.memRole
      };
      // 로그인 정보를 가진 변수를 문자열 형태로 변환(sessionStorage에는 문자열 밖에 들어가지 못하기 때문)
      window.sessionStorage.setItem('loginInfo',JSON.stringify(loginInfo))
    })
    .catch((error) => {
      console.log(error)
    })
  }

  // login 쿼리 실행 후 띄는 모달 안의 내용
  function drawModalContent(){
    return(
      <>
        {
          isLoginSuccess
          ?
          <div>{loginData.memId}님 환영합니다.</div>
          :
          <div>아이디 혹은 비밀번호를 잘못입력하셨습니다.</div>
        }
      </>
    )
  }

  // login 쿼리 실행 후 띄는 모달 안의 확인 버튼 클릭 시 실행되는 내용
  function handleBtn(){
    if(isLoginSuccess){
      // 로그인 성공 시 상품 목록 페이지로 이동
      if(loginMemberInfo.memRole == 'USER'){
        navigate('/')
      }
      else{
        navigate('/admin')
      }
    } 
    else{
      navigate('/loginForm')
    }
  }

  return (
    <div className='login-page-div'>
      <div>
        <input type='text' name='memId' className='form-control' placeholder='Input your ID' onChange={(e) => {changeLoginData(e)}}/>
      </div>
      <div>
        <input type='password' name='memPw' className='form-control' placeholder='Input your Password' onChange={(e) => {changeLoginData(e)}} />
      </div>
      <div>
        <button type='button' className='btn btn-primary' onClick={() => {login()}}>L O G I N</button>
      </div>
      {/*  login 중 id, pw입력 여부 확인 모달 창 */}
      {
        beforeLoginModal
        ?
        <Modal 
          content={() => {
            return(
              <div>Id, Pw를 확인하십시오.</div>
            );
          }} 
          setIsShow={
            setBeforeLoginModal
          }
          clickCloseBtn={() => {
            alert(1);
          }}/>
        :
        null
      }
      {/* login 쿼리 실행 후 실행되는 모달 창 */}
      {
        afterLoginModal
        ?
        <Modal content={drawModalContent} 
        setIsShow={setAfterLoginModal} 
        clickCloseBtn={handleBtn} />
        :
        null
      }
    </div>
  )
}

export default Login