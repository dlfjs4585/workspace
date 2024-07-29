
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as boardApi from '../apis/boardApi'

const BoardDetail = ({loginInfo}) => {

  const navigate = useNavigate();
  const {boardNum} = useParams();

  const [detail, setDetail] = useState({});
  const [reply, setReply] = useState([]);

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

  useEffect(() => {
    axios.get(`/reply/list/${boardNum}`)
    .then((res) => {
      setReply(res.data);
      console.log(res.data)
    })
    .catch((error) => {
      console.log(error);
    })
  }, []);

  
  function boardDelete(boardNum){
    axios.all([
      axios.delete(`/reply/delete/${boardNum}`),
      axios.delete(`/board/delete/${boardNum}`)
    ])
    .then((res) => {
      navigate('/')
    })
    .catch((error) => {
      console.log(error)
    })
  }

  const [boardReply, setBoardReply] = useState({
    memId : '',
    boardNum : 0,
    replyContent : ''
  });

  function replyOnchange(e){
    setBoardReply({
      ...boardReply,
      memId : loginInfo.memId,
      boardNum : boardNum,
      [e.target.name] : e.target.value,
    })
  }

  console.log(boardReply)

  function insertReply(boardNum){
    axios.post(`/reply/insertReply/${boardNum}`, boardReply)
    .then((res) => {
      window.location.reload();
    })
    .catch((error) => {
      console.log(error)
    })
  }

  function replyDelete(replyNum){
    axios.delete(`/reply/deleteReply/${replyNum}`)
    .then((res) => {
      alert('삭제되었습니다.')
      window.location.reload();
    })
    .catch((error) => {
      console.log(error)
      console.log(replyNum)
    })
  }

  //db에서 데이터 조회 여러개 동시에 실행하기
  // useEffect(() => {
  //   axios.all([boardApi.detailBoard(boardNum), axios.get(`/reply/list/${boardNum}`)])
  //   .then(axios.spread((res1, res2) => {
  //     setDetail(res1.data); 
  //     setReply(res2.data);
  //   }))
  //   .catch()
  // }, []);
  console.log(detail.memId)
  console.log(loginInfo.memRole)

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
        {
          loginInfo.memId != detail.memId && loginInfo.memRole != 'ADMIN'
          ?
          <button type='button' onClick={(e) => {navigate('/')}} >목록가기</button>
          :
          <>
            <button type='button' onClick={(e) => {navigate('/')}} >목록가기</button>
            <button type='button' onClick={(e) => {navigate(`/updateForm/${boardNum}`)}} >수정</button>
            <button type='button' onClick={() => {boardDelete(boardNum)}}>삭제</button>
          </>
        }
      </div>
      <div>
        {
          loginInfo.memId != null
          ?
          <>
          <input type='text' name='replyContent' onChange={(e) => {replyOnchange(e)}} /> 
          <button type='button' onClick={(e) => {insertReply(boardNum)}}>댓글 등록</button>
          </>
          :
          <input type='text' placeholder='댓글을 등록하기 위해서는 로그인을 하셔야합니다.' />
        }
      </div>
      <div>
        <table>
          <tbody>
            {
              reply.map((reply, i) => {
                return(
                  <tr key={i}>
                    <td>{reply.replyDate}</td>
                    <td>{reply.memId}</td>
                    <td>{reply.replyContent}</td>
                    <td>
                      {
                        reply.memId != loginInfo.memId && loginInfo.memRole != 'ADMIN'
                        ?
                        <></>
                        :
                        <button type='button' onClick={() => {replyDelete(reply.replyNum)}} >댓글 삭제</button>
                      }
                    </td>
                  </tr>
                );
              })
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default BoardDetail