
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import * as boardApi from '../apis/boardApi';
import { useNavigate } from 'react-router-dom';

const BoardList = ({loginInfo}) => {
  //조회된 게시글 목록을 저장할 변수
  const [boardList, setBoardList] = useState([]);
  const navigate = useNavigate();
  // const [cnt , setCnt] = useState([]);

  // 검색 조건 저장할 변수 생성
  const [searchData, setSearchData] = useState({
    searchType : 'TITLE',
    searchValue : ''
  }); 

  function changeSearchData(e){
    setSearchData({
      ...searchData,
      [e.target.name] : e.target.value
    })
  }

  //게시글 목록 조회
  useEffect(() => {
    boardApi.getBoardList(searchData)
    .then((res) => {
      setBoardList(res.data);
    })
    .catch((error) => {
      alert('게시글 목록 조회 오류!');
      console.log(error);
    });
  }, []);

  //제목, 작성자로 게시글 조회
  function selectSameData(){
    boardApi.getBoardList(searchData)
    .then((res) => {
      // setCnt(cnt + 1)
      setBoardList(res.data)
    })
    .catch((error) => {})
  }

  return (
    <div className='board-list-container'>
      <div className='search-div'>
        <select name='searchType' onChange={(e) => {changeSearchData(e)}} >
          <option value={'TITLE'}>제목</option>
          <option value={'MEM_ID'}>작성자</option>
        </select>
        <input type='text' name='searchValue' onChange={(e) => {changeSearchData(e)}} />
        <button className='btn' onClick={() => {selectSameData()}} >검색</button>
      </div>
      <div className='board-list-div'>
        <table>
          <colgroup>
            <col width='10%'/>
            <col width='*'/>
            <col width='20%'/>
            <col width='20%'/>
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>제 목</td>
              <td>작성자</td>
              <td>작성일</td>
            </tr>
          </thead>
          <tbody>
            {
              boardList.map((board, i) => {
                return (
                  <tr key={i}>
                    <td>{boardList.length - i}</td>
                    <td><span onClick={(e) => {navigate(`/detailForm/${board.boardNum}`)}}>{board.title}</span></td>
                    <td>{board.memId}</td>
                    <td>{board.createDate}</td>
                  </tr>
                );
              })
            }
          </tbody>
        </table>
      </div>
      <div className='btn-div'>
        {
          loginInfo.memId != null 
          ?
          <button className='btn' onClick={(e) => {navigate('/writeForm')}} >글쓰기</button>
          :
          null
        }
      </div>
    </div>
  )
}

export default BoardList