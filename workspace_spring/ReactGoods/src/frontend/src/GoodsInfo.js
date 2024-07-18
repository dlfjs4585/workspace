
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const GoodsInfo = () => {

  const [goodsList, setGoodsList] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
    .get('/goodsInfo')
    .then((res) => {
      setGoodsList(res.data);
    })
    .catch((error) => {
      alert('오류 발생!!\n 개발자 모드로 콘솔 확인!!');
      console.log(error);
    })
  }, []);

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>상품명</td>
            <td>상품가격</td>
            <td>판매자</td>
          </tr>
        </thead>
        <tbody>
          {
            goodsList.length == 0 ?
            <tr>
              <td colSpan={4}> 조회된 상품이 없습니다. </td>
            </tr>
            :
            goodsList.map((goods, i) => {
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
                  <td><span onClick={() => {navigate(`/detail${goods.itemNum}`)}}>{goods.itemName}</span></td>
                  <td>{goods.itemPrice}</td>
                  <td>{goods.seller}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default GoodsInfo;