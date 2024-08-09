
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import './ItemDetail.css'

const ItemDetail = () => {

  const[item, setItem] = useState({
    itemIntro : '',
    itemPrice : 0,
    itemName : '',
    imgList : []
  });
  const [cnt, setCnt] = useState(1);
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
  
  const totalPrice = item.itemPrice * cnt

  function img(index){
    return(
      item.imgList[index] ? `http://localhost:8080/upload/${item.imgList[index].attachedFileName}` : ''
    )
  }
  
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
                <td><input type='number' value={cnt} onChange={(e) => {setCnt(Number(e.target.value))}} /></td>
              </tr>
              <tr>
                <td>총 가격</td>
                <td>{totalPrice.toLocaleString()}원</td>
              </tr>
            </tbody>
          </table>
          <button type='button' className='btn btn-primary' >구매하기</button>
          <button type='button' className='btn btn-primary' >장바구니에 담기</button>
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