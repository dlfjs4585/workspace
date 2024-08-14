
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import './CartList.css'

const CartList = () => {

  const [cart, setCart] = useState([]);
  const{memId} = useParams();
  
  const [totalPrice, setTotalPrice] = useState(0); 

  useEffect(() => {
    axios.get(`/api_item/getCartList/${memId}`)
    .then((res) => {
      setCart(res.data)
      console.log(res.data)
    })
    .catch((error) => {console.log(error)})
  }, []);

  const handleQuantityChange = (index, newQuantity) => {
    // 새로운 배열을 복사해서 수정
    const updatedCart = cart.map((cartItem, i) => 
      i === index ? { ...cartItem, cartCnt: newQuantity } : cartItem
    );
    setCart(updatedCart); // 상태 업데이트
  };

  return (
    <div className='cart-contain'>
      <table className='cart-info-table'>
        <thead>
          <tr>
            <td>No</td>
            <td><input type='checkbox'/></td>
            <td>상품정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>구매가격</td>
            <td>구매일시</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          {
            cart.map((cartItem, i)=> {
              return(
                <tr key={i}>
                  <td>{i}</td>
                  <td><input type='checkbox'/></td>
                  <td>
                    <div className='item-info'>
                      <img src={`http://localhost:8080/upload/${cartItem.imgList[0].attachedFileName}`}/>
                    {cartItem.itemList[0].itemName}
                    </div>
                  </td>
                  <td>{cartItem.itemList[0].itemPrice}</td>
                  <td>
                    <input type='number'
                            min={1}
                            value={cartItem.cartCnt}
                            onChange={(e) => handleQuantityChange(i, parseInt(e.target.value))}/>
                  </td>
                  <td>{cartItem.cartCnt*cartItem.itemList[0].itemPrice}</td>
                  <td>{cartItem.cartDate}</td>
                  <td>
                    <button type='button' className='btn btn-primary'>
                      삭제
                    </button>
                  </td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div className='total-price'>
        <p>총 구매금액 </p>
      </div>
      <div className='select-button'>
        <button type='button' className='btn btn-primary' >선택삭제</button>
        <button type='button' className='btn btn-primary' >선택구매</button>
      </div>
    </div>
  )
}

export default CartList