import axios from "axios"

// 게시글 목록 조회
export const getBoardList = () => {
  const response = axios.get('/board/list');
  return response;
}