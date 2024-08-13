
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';

const CartList = () => {

  const [cart, setCart] = useState([]);
  const{memId} = useParams();

  useEffect(() => {
    axios.get(`/api_item/getCartList`)
    .then((res) => {
      setCart(res.data)
      console.log(res.data)
    })
    .catch((error) => {console.log(error)})
  }, []);


  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td></td>
            <td>상품정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>구매가격</td>
            <td>구매일시</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          
        </tbody>
      </table>
    </div>
  )
}

export default CartList