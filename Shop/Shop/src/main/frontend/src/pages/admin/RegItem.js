
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Modal from '../../common/Modal';

const RegItem = () => {

  const [categoryList, setCategoryList] = useState([]);

  const [itemInfo, setItemInfo] = useState({
    cateCode : 2 ,
    itemName : '',
    itemPrice : 0,
    itemIntro : ''
  });

  useEffect(() => {
    axios.get('/api_admin/getCategoryList')
    .then((res) =>{
      setCategoryList(res.data);
    })
    .catch((error) => {
      console.log(error)
    })
  }, []);

  function insertItem(){
    axios.post('/api_admin/insertItem', itemInfo)
    .then((res) => {
      setIsShow(true);
    })
    .catch((error) => {
      console.log(error)
    })
  }

  function changeItemInfo(e){
    setItemInfo({
      ...itemInfo,
      [e.target.name] : e.target.value
    });
  }

  const[isShow, setIsShow] = useState(false);

  function setModalContent(){
    return(
      <div>상품 등록이 완료되었습니다.</div>
    )
  }



  console.log(itemInfo)

  return (
    <div className='reg-item-div'>
      <div className='input-element'>
        <div>상품 카테고리</div>
        <div>
          <select name='cateCode' onChange={(e) => {changeItemInfo(e)}} className='form-control'>
            {
              categoryList.map((category, i) => {
                return(
                  <option value={category.cateCode} key={i}>{category.cateName}</option>
                );
              })
            }
          </select>
        </div>
      </div>
      <div className='input-element'>
        <div>상품명</div>
        <div><input type='text' name='itemName' className='form-control' onChange={(e) => {changeItemInfo(e)}} /></div>
      </div>
      <div className='input-element'>
        <div>상품 가격</div>
        <div><input type='text' name='itemPrice' className='form-control' onChange={(e) => {changeItemInfo(e)}} /></div>
      </div>
      <div className='input-element'>
        <div>상품 소개</div>
        <div>
          <textarea className='form-control' name='itemIntro' rows={7} onChange={(e) => {changeItemInfo(e)}} ></textarea>
        </div>
      </div>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={() => {insertItem()}}>상품등록</button>
        {
          isShow
          ?
          <Modal content={setModalContent} setIsShow={setIsShow} clickCloseBtn={() => {}}/>
          :
          null
        }
      </div>
    </div>
  )
}

export default RegItem