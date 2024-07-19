
import axios from 'axios';
import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

const OrderItem = () => {

  const navigate = useNavigate();

  useEffect(() => {
    axios
    .get('/itemInfo')
    .then((res) => {
      setItemList(res.data);
    })
    .catch((error) => {
      alert('오류 발생!!\n 개발자 모드로 콘솔 확인!!');
      console.log(error);
    })
  }, []);

  function orderItem(){
    axios
    .post()
    .then((res) => {})
    .catch((error) => {})
  }


  return (
    <div>
      <table>
        <tr>
          <td>주문상품</td>
          <td>
            <select>
              <option>

              </option>
            </select>
          </td>
        </tr>
        <tr>
          <td>상품단가</td>
          <td><input type='text' readOnly /></td>
        </tr>
        <tr>
          <td>주문자</td>
          <td><input type='text' /></td>
        </tr>
        <tr>
          <td>주문 수량</td>
          <td><input type='text'/></td>
        </tr>
      </table>
      <button type='button'>주문하기</button>
    </div>
  )
}

export default OrderItem