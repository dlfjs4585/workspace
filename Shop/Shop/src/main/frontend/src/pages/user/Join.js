import React, { useEffect, useRef, useState } from 'react'
import './Join.css'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import Modal from '../../common/Modal';
import { joinValidate } from '../../validate/joinValidate';


const Join = () => {

  // id 중복 체크 여부를 저장할 변수
  const [isCheckId, setIsCheckId] = useState(false);

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
    // 유효성 검사 결과가 false이면 회원가입 로직 중지
    if(!valid_result){
      alert('입력 데이터를 확인하세요.');
      return ;
    }

    // id 중복 검사를 했는지 확인
    if(!isCheckId){
      alert('ID 중복 검사 후 가입 하세요.');
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
  
  const memId_valid_tag = useRef();
  const memName_valid_tag = useRef();
  const memPw_valid_tag = useRef();
  const confirmPw_valid_tag = useRef();
  const memTel_valid_tag = useRef();
  const valid_tag = [memId_valid_tag
                    , memPw_valid_tag
                    , confirmPw_valid_tag
                    , memName_valid_tag
                    , memTel_valid_tag];

  // 유효성 검사 결과를 저장하는 변수
  const [valid_result, setValid_result] = useState(false);

  function onchangeJoinData(e){

    // useRef 콘솔에서 사용시 current필수
    // console.log(email_1.current.value);
    // console.log(email_2.current.value);
    // 이메일을 변경했으면.

    // 입력한 데이터
    const newData = {
      ...memberInfo,
      [e.target.name] : e.target.name != 'memEmail' ? 
                                                    e.target.value 
                                                    :
                                                    email_1.current.value + email_2.current.value
    };

    // validation 처리
    const result = joinValidate(newData, valid_tag, e.target.name);
    setValid_result(result);
    // 유효성 검사 끝난 데이터를 memberInfo에 저장
    setMemberInfo(newData);

  }
  
  // 아이디 중복
  function isEnableId(){
    axios.get(`/api_member/isEnableId/${memberInfo.memId}`)
    .then((res) => {
      alert(res.data ? '사용 가능한 아이디입니다.' : '중복된 아이디입니다.');
      setIsCheckId(res.data);
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
  function onclickModalBtn(){
    navigate('/loginForm');
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
              <input type='text' name='memId' className='form-control input' onChange={(e) => 
                {
                  setIsCheckId(false);
                  onchangeJoinData(e);
                }} />
              <div className='feedback' ref={memId_valid_tag}></div>
            </td>
            <td><button type='button' className='btn btn-primary' onClick={() => {isEnableId()}}>중복 확인</button></td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td>
              <input type='password' name='memPw' className='form-control input' onChange={(e) => 
              {
                onchangeJoinData(e);
              }} />
              <div className='feedback' ref={memPw_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td>
              <input type='password' name='confirmPw' className='form-control' onChange={(e) => {onchangeJoinData(e)}} />
              <div className='feedback' ref={confirmPw_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td>
              <input type='text' name='memName' className='form-control input'onChange={(e) => {onchangeJoinData(e)}} />
              <div className='feedback' ref={memName_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>연락처</td>
            <td><input type='text' name='memTel' className='form-control'  placeholder='숫자만 입력하세요.' onChange={(e) => {onchangeJoinData(e)}} />
            <div className='feedback' ref={memTel_valid_tag}></div>
            </td>
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
        isShow ? <Modal clickCloseBtn={onclickModalBtn} content={setModalContent} setIsShow={setIsShow} /> : null
        }
      </div>
    </div>
  )
}

export default Join