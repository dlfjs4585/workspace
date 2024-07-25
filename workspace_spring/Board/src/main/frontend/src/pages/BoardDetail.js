
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as boardApi from '../apis/boardApi'

const BoardDetail = () => {

  const navigate = useNavigate();
  const {boardNum} = useParams();

  const [detail, setDetail] = useState({});

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

  console.log(detail)

  return (
    <div>
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
              <td>{detail.title}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td>{detail.content}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div>
        <button type='button' onClick={(e) => {navigate('/')}} >목록가기</button>
        <button type='button' onClick={(e) => {navigate(`/updateForm/${boardNum}`)}} >수정</button>
        <button type='button'>삭제</button>
      </div>
      <div>
        <div>1</div>
        <div>2</div>
        <div>3</div>
      </div>
    </div>
  )
}

export default BoardDetail