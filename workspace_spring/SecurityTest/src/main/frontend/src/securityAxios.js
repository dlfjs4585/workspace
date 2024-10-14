import axios from "axios";

// 모든 요청에서 사용할 axios 객체 생성
export const securityApi = axios.create({
  //baseURL : 'http://localhost:8080'
});

// interceptor 적용
// axios로 요청을 보내기 전 실행 내용 작성 가능
// 첫번째 매개변수 : 요청이 서버로 전달되기 전 실행할 내용
// 두번째 매개변수 : 서버로 요청 시 오류가 발생되면, 그 오류가 실행되기 전 진행할 내용
securityApi.interceptors.request.use(
  (config) => {
    // 작업 내용(헤더에 토큰 추가)
    const token = localStorage.getItem('Authorization');

    // 토큰이 존재 할 때 실행
    if(token){
      config.headers.Authorization = token; 
    }
    return config
  },
  (error) => {
    // 요청 오류 발생 시 사전 작업 내용
    return Promise.reject(error)
  }
);

// axios로 응답을 받기 전 실행 내용 작성 가능
// 첫번째 매개변수 : 응답 성공 전에 작업 내용
// 두번째 매개변수 : 응답에서 오류가 발생하기 전에 작업 내용
securityApi.interceptors.response.use(
  (res) => {
    // 응답 성공 직전 실행 내용
    return res;
  },
  (error) => {
    alert('응답 오류 시 실행하는 인터셉터')

    if(error.response.status == 403){
      alert('인증, 인가 실패');
    }

    return Promise.reject(error);
  }
);


