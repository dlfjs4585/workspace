
import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import * as boardApi from '../apis/boardApi'

const BoardWrite = ({loginInfo}) => {

  const navigate = useNavigate();
  // 글 등록시 가져갈 데이터
  const [insertData, setInsertData] = useState({
    title : '',
    content : '',
    memId : ''
  });

  function changeInsertData(e){
    setInsertData({
      ...insertData,
      [e.target.name] : e.target.value,
      memId : loginInfo.memId
    });
  }

  function regBoard(){
    boardApi.insertBoard(insertData)
    .then((res) => {
      navigate('/')
    })
    .catch((error) => {
      console.log(error)
    })
  }


  return (
    <div>
      <div>제목 : <input type='text' name='title' onChange={(e) => {changeInsertData(e)}} /> </div>
      <div>내용 : <textarea name='content' onChange={(e) => {changeInsertData(e)}} ></textarea></div>
      <button type='button' onClick={(e) => {
        regBoard()
      }}> 글등록 </button>
    </div>
  )
}

export default BoardWrite