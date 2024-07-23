import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import * as memberApi from '../apis/memberApi'

const Join = () => {

  const navigate = useNavigate();

  // 버튼 활성화 여부 state변수
  const[isDisabled, setIsDisabled] = useState(true);

  const[mem, setMem] = useState({
    memId : ""
  });

  // 회원 아이디 불러오기
  useEffect(() => {
    memberApi.getId()
    .then((res) => {
      setMem(res.data);
    })
    .catch((error) => {
      console.log(error)
    })
  },[]);


  // 아이디 중복확인
  function memIdDuplicate(){
    mem.forEach((mem, i) => {
      if(mem.memId == member.memId){
        alert('아이디가 중복입니다.');
        return;
      }
    });
  }

  
  const[member, setMember] = useState({
    memId : "",
    memPw : "",
    memName : "",
    gender : ""
  });

  function changeMember(e){
    setMember({
      ...member,
      [e.target.name] : e.target.value
    });
  }

  // 회원가입 버튼
  function memberJoin(){
    let memArr = document.querySelectorAll('.input');
    
    // 유효성 검사
    // 비밀번호 확인 
    const result = document.querySelector('#pw').value
    if(member.memPw != result){
      alert('비밀번호를 확인하세요')
      return;
    }

    //아이디 4~8글자
    if(member.memId.length < 3 || member.memId.length > 10){
      alert('아이디는 3~10글자 이여야 합니다.')
      return;
    }

    // 내용 입력
    for(let i = 0; i < memArr.length; i++){
      if(memArr[i].value == ""){
        alert('모든 내용은 필수 입력입니다.')
        return;
      }
    }

    memberApi.insertMember(member)
    .then((res) => {
      alert('회원가입이 완료 되었습니다.')
      navigate('/login')
    })
    .catch((error) => {
      console.log(error)
    })
  }
  console.log(member)

  return (
    <div>
      <span>아이디</span>
      <div>
        <input type='text' name='memId' className='input' onChange={(e) => {changeMember(e)}} />
        <button type='button' onClick={(e) => {memIdDuplicate()}} >중복확인</button>
      </div>
      <span>비밀번호</span>
      <div>
        <input type='password' name='memPw' className='input' onChange={(e) => {changeMember(e)}} />
      </div>
      <span>비밀번호 확인</span>
      <div>
        <input type='password' id='pw'/>
      </div>
      <span>이름</span>
      <div>
        <input type='text' name='memName' className='input' onChange={(e) => {changeMember(e)}} />
      </div>
      <div>
        성별 
        <input type="radio" name='gender' value='male' checked={member.gender == 'male'} onChange={(e) => changeMember(e) } /> 남
        <input type="radio" name='gender' value='female' checked={member.gender == 'female'} onChange={(e) => changeMember(e)} /> 여
      </div>
      <button type='button' onClick={() => {memberJoin()}}>회원가입</button>
      <button type='button' disabled={isDisabled} >연습용 버튼</button>
    </div>
  )
}

export default Join;