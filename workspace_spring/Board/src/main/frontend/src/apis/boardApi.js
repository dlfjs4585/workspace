
//=== 게시판 테이블에서 사용하는 axios 모음 ===//

import axios from "axios"

//게시글 목록 조회
export const getBoardList = (pageNo) => {
  const response = axios.post('/board/list', {'pageNo' : pageNo});
  return response;
}

//게시글 등록
export const insertBoard = (insertData) => {
  const response = axios.post('/board/insert', insertData);
  return response;
}

//게시글 상세조회
export const detailBoard = (boardNum) => {
  const response = axios.get(`/board/detail/${boardNum}`);
  return response;
}