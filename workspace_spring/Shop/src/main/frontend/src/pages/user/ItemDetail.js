
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import './ItemDetail.css'

const ItemDetail = () => {
  const navigate = useNavigate()

  const[item, setItem] = useState({
    itemIntro : '',
    itemPrice : 0,
    itemName : '',
    carCnt : 1,
    imgList : []
  });
  // const [cnt, setCnt] = useState(1);
  const{itemCode} = useParams();
  

  useEffect(() => {
    axios.get(`/api_item/getItemDetail/${itemCode}`)
    .then((res) => {
      console.log(res.data)
      setItem({
        ...item,
        ...res.data
      })
    })
    .catch((error) => {
      console.log(error)
    })
  }, [])
  
  const totalPrice = item.itemPrice * item.carCnt

  function img(index){
    return(
      item.imgList[index] ? `http://localhost:8080/upload/${item.imgList[index].attachedFileName}` : ''
    )
  }

  const [cartItem, setCartItem] = useState({
    cartCnt : 1,
    itemCode : itemCode,
    memId : JSON.parse(window.sessionStorage.getItem('loginInfo')).memId,
  });

  function goCart(){
    axios.post('/api_item/insertCart', cartItem)
    .then((res) => {
      navigate(`/cartList`);
    })
    .catch((error) => {console.log(error)})
  }

  function onChangeCartData(e){
    setCartItem({
      ...cartItem,
      [e.target.name] : e.target.value
    });
  }

  console.log(cartItem)

  return (
    <div className='item-container'>
      <div className='item-info'>
        <div className='img'>
          <img src={img(0)} />
        </div>
        <div>
          <table>
            <tbody>
              <tr>
                <td>상품명</td>
                <td>{item.itemName}</td>
              </tr>
              <tr>
                <td>가격</td>
                <td>{item.itemPrice.toLocaleString()}원</td>
              </tr>
              <tr>
                <td>수량</td>
                <td><input type='number' name='cartCnt' value={item.carCnt} min={1} onChange={(e) => {
                                                                                                        const newCarCnt = Number(e.target.value); // 입력된 값을 숫자로 변환
                                                                                                        setItem({
                                                                                                          ...item,
                                                                                                          carCnt: newCarCnt // item의 carCnt를 업데이트
                                                                                                        });
                                                                                                        onChangeCartData(e); // cartItem의 cartCnt도 업데이트
                }} /></td>
              </tr>
              <tr>
                <td>총 가격</td>
                <td>{totalPrice.toLocaleString()}원</td>
              </tr>
            </tbody>
          </table>
          <button type='button' className='btn btn-primary' >구매하기</button>
          <button type='button' className='btn btn-primary' onClick={() => {goCart()}} >장바구니에 담기</button>
        </div>
      </div>
      <div className='intro'>
        {item.itemIntro}
      </div>
      <div className='detail-img'>
        <img src={img(1)} />
      </div>
    </div>
  )
}

export default ItemDetail