import axios from "axios"

// 회원 아이디 불러오기
export const getId = () => {
  const response = axios.get('/member/getId')
  return response;
}

// 회원 가입 
export const insertMember = (member) => {
  const response = axios.post('/member/insertMember', member)
  return response;
}

// 로그인
// 데이터 여러개 넘길때는 select여도 post를 사용해도 된다.
export const login = (data) => {
  const response = axios.post('/member/login', data);
  return response;
}