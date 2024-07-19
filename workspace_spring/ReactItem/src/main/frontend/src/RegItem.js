
import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './RegItem.css';

const RegItem = () => {

  const navigate = useNavigate();

  const[item, setItem] = useState({
    itemName : "",
    itemPrice : 0,
    seller : "",
    itemIntro : ""
  });

  function regItem(){
    let arr1 = document.querySelectorAll('.input');

    for(let i = 0; i < arr1.length; i++){
      if(arr1[i].value == ""){
        alert('상품명, 상품가격, 판매자는 필수 입력입니다.')
        return ;
      }
    }
    
    axios
    .post('/insertItem', item)
    .then((res) => {
      alert('상품이 등록되었습니다.')
      navigate('/')
    })
    .catch((error) => {
      alert('오류 발생!!');
      console.log(error)
    })
  }

  function changeItem(e){
    setItem({
      ...item,
      [e.target.name] : e.target.value
    });
  }


  return (
    <div className='regItem'>
      <table>
        <tr>
          <td>상품명</td>
          <td><input type='text' name='itemName' className='input' onChange={(e) => {changeItem(e)}} /></td>
        </tr>
        <tr>
          <td>상품가격</td>
          <td><input type='text' name='itemPrice' className='input' onChange={(e) => {changeItem(e)}}  /></td>
        </tr>
        <tr>
          <td>판매자</td>
          <td><input type='text' name='seller' className='input' onChange={(e) => {changeItem(e)}}  /></td>
        </tr>
        <tr>
          <td>상품 설명</td>
          <td><textarea name='itemIntro' onChange={(e) => {changeItem(e)}} ></textarea></td>
        </tr>
      </table>
      <button type='button' onClick={() => {regItem()}}>등록</button>
    </div>
  )
}

export default RegItem;