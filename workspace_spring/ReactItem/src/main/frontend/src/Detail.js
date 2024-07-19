
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import * as api from './apis'
import ItemList from './ItemList';
import './Detail.css';

const Detail = () => {

  const[item, setItem] = useState({});
  const{itemNum} = useParams();
  const navigate = useNavigate();
  
  
  useEffect(() => {
    api.getItemDetail(itemNum)
    .then((res) => {
      setItem(res.data);
    })
    .catch((error) => {
      alert('오류발생!!');
      console.log(error);
    })
  }, [itemNum]);

  function changeItem(e){
    setItem({
      ...item,
      [e.target.name] : e.target.value
    });
  }

  console.log(item)

  function updateItem(){
    axios
    .put(`/updateItem/${itemNum}`, item)
    .then((res) => {
      alert('상품정보를 수정하였습니다.')
      navigate('/');
    })
    .catch((error) => {
      alert('오류 발생!!');
      console.log(error);
    })
  }


  return (
    <div className="detail">
      <div className="itemList">
        <ItemList />
      </div>
      <div>
        <table>
          <tr>
            <td>상품번호</td>
            <td><input type='text' name='itemNum' readOnly value={item.itemNum} onChange={(e) => {changeItem(e)}} /></td>
          </tr>
          <tr>
            <td>상품명</td>
            <td><input type='text' name='itemName' value={item.itemName} onChange={(e) => {changeItem(e)}} /></td>
          </tr>
          <tr>
            <td>상품가격</td>
            <td><input type='text' name='itemPrice' value={item.itemPrice} onChange={(e) => {changeItem(e)}} /></td>
          </tr>
          <tr>
            <td>판매자</td>
            <td><input type='text' name='seller' readOnly value={item.seller} onChange={(e) => {changeItem(e)}} /></td>
          </tr>
          <tr>
            <td>판매시작일</td>
            <td><input type='text' name='regDate' readOnly value={item.regDate} onChange={(e) => {changeItem(e)}} /></td>
          </tr>
          <tr>
            <td>상품 설명</td>
            <td><textarea name='itemIntro' value={item.itemIntro} onChange={(e) => {changeItem(e)}}></textarea></td>
          </tr>
        </table>
        <button type='button' onClick={() => {updateItem()}} >수정</button>
      </div>
    </div>
  )
}

export default Detail;