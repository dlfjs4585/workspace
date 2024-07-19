
// 서버와 통신하는 기능을 모아놓은 js

import axios from "axios";


// 상품 목록 조회 api
export const getItemInfo = axios.get('/itemInfo');

export const getItemInfo1 = () => {
  const response = axios.get('/itemInfo');
  return response;
}

export const  getItemDetail = (itemNum) => {
  const response = axios.get(`/getItemDetail/${itemNum}`)
  return response;
}

//export const getItemDetail = axios.get(`/getItemDetail/${itemNum}`)