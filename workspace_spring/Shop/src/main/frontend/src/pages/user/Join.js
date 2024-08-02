import React, { useEffect, useRef, useState } from 'react'
import './Join.css'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import { useDaumPostcodePopup } from 'react-daum-postcode';

const Join = () => {

  // 아이디 중복 눌러서 아이디 사용 문구가 나오면 회원가입 버튼 가능하게 만들기

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

  const navigate = useNavigate();
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
  const [memberId, setMemberId] = useState([]);


  // 필수입력 및 회원등록
  function joinMember(){

    for(let i = 0; i < document.querySelectorAll('.input').length; i++){
      if(document.querySelectorAll('.input')[i].value == ''){
        alert('아이디, 비밀번호, 이름은 필수입력입니다.')
        return;
      }
    } 

    // 비밀번호 확인
    if(memberInfo.memPw != memberInfo.confirmPw){
      alert('비밀번호를 다시 확인하십시오.')
      return;
    }

    axios.post('/member/insertMember', memberInfo)
    .then((res) => {
      alert('회원가입이 완료되었습니다.')
    })
    .catch((error) => {
      console.log(error)
    })
  }

  function onchangeMember(e){

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

  // 아이디 받아오기
  useEffect(() => {
    axios.get('/member/getId')
    .then((res) => {
      setMemberId(res.data)
      console.log(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, []);

  // 아이디 중복 확인
  function selectGetId(e){
    const inputId = memberInfo.memId;
    let isDuplicate = false;

    memberId.forEach((id) => {
      if (id.memId == inputId) {
        isDuplicate = true;
      }
    });

    if(isDuplicate){
      alert('아이디가 중복입니다.');
    } else {
      alert('사용 가능한 아이디입니다.');
    }
  }

  console.log(memberInfo)

  return (
    <div className='contain'>
      <table>
        <colgroup>
          <col width='30%'/>
          <col width='40%'/>
          <col width='*'/>
        </colgroup>
        <tbody>
          <tr>
            <td>아이디</td>
            <td><input type='text' name='memId' className='input' onChange={(e) => {onchangeMember(e)}} /></td>
            <td><button type='button' onClick={(e) => {selectGetId(e)}}  >중복확인</button></td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td colSpan={2}><input type='password' name='memPw' className='input' onChange={(e) => {onchangeMember(e)}} /></td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td colSpan={2}>
              <input type='password' name='confirmPw' onChange={(e) => {onchangeMember(e)}}/>
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td colSpan={2}><input type='text' name='memName' className='input' onChange={(e) => {onchangeMember(e)}} /></td>
          </tr>
          <tr>
            <td>연락처</td>
            <td colSpan={2}><input type='text' name='memTel'  placeholder='숫자만 입력하세요.' onChange={(e) => {onchangeMember(e)}} /></td>
          </tr>
          <tr>
            <td>주소</td>
            <td><input type='text' name='post'  placeholder='우편번호' readOnly value={memberInfo.post}
            onClick={handleClick} onChange={(e) => {onchangeMember(e)}} /></td>
            <td><button type='button' onClick={() => {handleClick()}} >주소 검색</button></td>
          </tr>
          <tr>
            <td></td>
            <td><input type='text' name='memAddr' className='form-control' readOnly value={memberInfo.memAddr} placeholder='주소' onChange={(e) => {onchangeMember(e)}}/></td>
          </tr>
          <tr>
            <td></td>
            <td><input type='text' name='addrDetail' placeholder='상세주소' onChange={(e) => {onchangeMember(e)}} /></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td><input type='text' name='memEmail' ref={email_1} onChange={(e) => {onchangeMember(e)}} /> </td>
            <td>
              <select name='memEmail' ref={email_2} onChange={(e) => {onchangeMember(e)}}>
                <option value={'@naver.com'} >naver.com</option>
                <option value={'@gmail.com'} >gamil.com</option>
              </select>
            </td>
          </tr>
        </tbody>
      </table>
      <div id='join'>
        <button type='button' onClick={(e) => {joinMember()}}>회원가입</button>
      </div>
    </div>
  )
}

export default Join