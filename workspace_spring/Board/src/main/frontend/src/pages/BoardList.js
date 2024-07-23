import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import * as boardApi from '../apis/boardApi';

const BoardList = () => {

  const[boardList, setBoardList] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    boardApi.getBoardList()
    .then((res) => {
      setBoardList(res.data);
    })
    .catch((error) => {
      console.log(error);
    })
  }, []);

  return (
    <div>
      <div>
        <select>
          <option>제목</option>
          {
            boardList.map((board, i) => {
              return(
                <option key={i}>{board.title}</option>
              );
            })
          }
        </select>
        <input type='text' />
        <button type='button'>검색</button>
      </div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.map((board, i) => {
              return(
                <tr key={i}>
                  <td>{boardList.length - i}</td>
                  <td>{board.title}</td>
                  <td>{board.memId}</td>
                  <td>{board.createDate}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
      <button type='button' onClick={(e) => {navigate('/regBoard')}}>글쓰기</button>
    </div>
  )
}

export default BoardList;