
import React, { useEffect, useState } from 'react'
import './ItemList.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ItemList = () => {

  // const num = 10000;
  // num.toLocaleString();
  const [itemList, setItemList] = useState([]);
  const navigate = useNavigate();
  
  useEffect(() => {
    axios.get('/api_item/getItemList')
    .then((res) => {
      setItemList(res.data)
      console.log(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [])

  return (
    <div className='item-list-div'>
      {
        itemList.map((item, i) => {
          return(
            <div className='item-div' key={i}>
              <img src={`http://localhost:8080/upload/${item.imgList[0].attachedFileName}`} onClick={() => {navigate(`/detail/${item.itemCode}`)}} />
              <h4>{item.itemName}</h4>
              <p>{item.itemPrice.toLocaleString()}원</p>
            </div>
          )
        })
      }
    </div>
  )
}

export default ItemList