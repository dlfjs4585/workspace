import React, { useEffect, useRef, useState } from 'react'
import './Join.css'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import Modal from '../../common/Modal';


const Join = () => {

  const navigate = useNavigate();

  // daum 주소 api 팝업창을 띄우기 위한 함수 선언
  const open = useDaumPostcodePopup();

  // 주소 검색 팝업창이 닫힐 때 실행되는 함수
  function handleComplete(data){
    // input 태그에 검색한 내용 넣어주기!
    setMemberInfo({
      ...memberInfo,
      post : data.zonecode,
      memAddr : data.roadAddress
    })
  }

  // 검색 버튼 클릭 시 실행되는 함수
  function handleClick(){
    open({onComplete : handleComplete})
  }


  // input 태그를 참조하는 변수
  const email_1 = useRef();
  const email_2 = useRef();

  // 회원가입 쿼리 실행했을 때, 가져갈 데이터
  const [memberInfo, setMemberInfo] = useState({
    memId : '',
    memPw : '',
    confirmPw : '',
    memName : '',
    memTel : '',
    post : '',
    memAddr : '',
    addrDetail : '',
    memEmail : ''
  });

  function joinMember(){

    for(let i = 0; i < document.querySelectorAll('.input').length; i++){
      if(document.querySelectorAll('.input')[i].value == ''){
        alert('아이디, 비밀번호, 이름은 필수입력입니다.')
        return;
      }
    } 

    if(memberInfo.memPw != memberInfo.confirmPw){
      alert('비밀번호가 일치하지 않습니다.')
      return;
    }

    axios.post('/api_member/join', memberInfo)
    .then((res) => {
      setIsShow(true)
    })
    .catch((error) => {
      console.log(error)
    })
  }

  function onchangeJoinData(e){

    // useRef 콘솔에서 사용시 current필수
    // console.log(email_1.current.value);
    // console.log(email_2.current.value);

    // 이메일을 변경했으면.
    setMemberInfo({
      ...memberInfo,
      [e.target.name] : e.target.name != 'memEmail' ? 
                                                    e.target.value 
                                                    :
                                                    email_1.current.value + email_2.current.value
    })
  }


  // 아이디 중복
  function getId(){
    axios.get(`/api_member/getId/${memberInfo.memId}`)
    .then((res) => {
      let result = res.data;
      alert(result ? '아이디가 중복입니다.' : '사용 가능한 아이디입니다.')  
    })
    .catch((error) => {
      console.log(error)
    })
  }
  

  // modal 랜더링 여부
  const[isShow, setIsShow] = useState(false); 
  
  // modal 안의 내용 생성하는 함수
  function setModalContent(){
    return(
      <div>회원 가입을 축하합니다.</div>
    )
  }

  // modal 확인 버튼 클릭시 로그인 화면으로 넘어가는 함수
  function goNavigate(){
    navigate('loginForm')
  }

  return (
    <div className='join-div'>
      <table className='join-table'>
        <colgroup>
          <col width='30%'/>
          <col width='40%'/>
          <col width='*'/>
        </colgroup>
        <tbody>
          <tr>
            <td>아이디</td>
            <td>
              <input type='text' name='memId' className='form-control input' onChange={(e) => {onchangeJoinData(e)}} />
            </td>
            <td><button type='button' className='btn btn-primary' onClick={() => {getId()}}>중복 확인</button></td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type='password' name='memPw' className='form-control input' onChange={(e) => {onchangeJoinData(e)}} /></td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td><input type='password' name='confirmPw' className='form-control' onChange={(e) => {onchangeJoinData(e)}} /></td>
          </tr>
          <tr>
            <td>이름</td>
            <td><input type='text' name='memName' className='form-control input'onChange={(e) => {onchangeJoinData(e)}} /></td>
          </tr>
          <tr>
            <td>연락처</td>
            <td><input type='text' name='memTel' className='form-control'  placeholder='숫자만 입력하세요.' onChange={(e) => {onchangeJoinData(e)}} /></td>
          </tr>
          <tr>
            <td rowSpan={3}>주소</td>
            <td><input type='text' name='post' className='form-control' readOnly value={memberInfo.post}  placeholder='우편번호' onClick={handleClick} onChange={(e) => {onchangeJoinData(e)}} /></td>
            <td><button type='button' className='btn btn-primary' onClick={handleClick} >주소 검색</button></td>
          </tr>
          <tr>
            <td><input type='text' name='memAddr' className='form-control' readOnly value={memberInfo.memAddr} placeholder='주소' onChange={(e) => {onchangeJoinData(e)}}/></td>
          </tr>
          <tr>
            <td><input type='text' name='addrDetail' className='form-control'placeholder='상세주소' onChange={(e) => {onchangeJoinData(e)}} /></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td><input type='text' className='form-control' name='memEmail' ref={email_1} onChange={(e) => {onchangeJoinData(e)}} /> </td>
            <td>
              <select name='memEmail' className='form-control select-form'ref={email_2} onChange={(e) => {onchangeJoinData(e)}}>
                <option value={'@naver.com'}>naver.com</option>
                <option value={'@gmail.com'}>gamil.com</option>
              </select>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={(e) => {joinMember()}}>회원가입</button>
        {
        isShow ? <Modal goNavigate={goNavigate} content={setModalContent} setIsShow={setIsShow} /> : null
        }
      </div>
    </div>
  )
}

export default Join