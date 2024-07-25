
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import * as boardApi from '../apis/boardApi'
import axios from 'axios';

const BoardUpdate = () => {

  const navigate = useNavigate();
  const [detail, setDetail] = useState({});
  
  const {boardNum} = useParams();

  useEffect(() => {
    boardApi.detailBoard(boardNum)
    .then((res) => {
      setDetail(res.data);
      console.log(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, []);

  function boardUpdate(){
    axios.put(`/board/update/${boardNum}`, detail)
    .then((res) => {
      navigate('/')
      console.log(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }

  function changeBoard(e){
    setDetail({
      ...detail,
      [e.target.name] : e.target.value
    })
  }

  return (
    <div>
        <table>
          <tbody>
            <tr>
              <td>작성일</td>
              <td>{detail.createDate}</td>
              <td>작성자</td>
              <td>{detail.memId}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td><input type='text' name='title' value={detail.title} onChange={(e) => {changeBoard(e)}} /></td>
            </tr>
            <tr>
              <td>내용</td>
              <td><textarea name='content' value={detail.content} onChange={(e) => {changeBoard(e)}} ></textarea></td>
            </tr>
          </tbody>
        </table>
        <div>
          <button type='button' onClick={(e) => {navigate(`/detailForm/${boardNum}`)}}>뒤로가기</button>
          <button type='button' onClick={(e) => {boardUpdate()}} >수정</button>
        </div>
      </div>
  )
}

export default BoardUpdate