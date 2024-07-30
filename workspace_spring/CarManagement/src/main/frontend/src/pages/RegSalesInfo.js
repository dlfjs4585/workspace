import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import '../regSalesInfo.css';

const RegSalesInfo = () => {

  const navigate = useNavigate();

  const[carName, setCarName] = useState([]);
  const[regSale, setRegSale] = useState({
    buyerName : '',
    color : '블랙',
    carNum : 1,
    buyerTel : ''
  });

  function onChangeRegSale(e){
    setRegSale({
      ...regSale,
      [e.target.name] : e.target.value
    })
  }

  console.log(regSale)
  

  function insertRegSale(){

    // 값이 들어 가지 않았을때 해야함.
    if(document.querySelector('.buyer').value == ''){
      alert('전화 번호를 제외한 모든 정보는 필수 입력입니다.')
      return;
    }
    else{
      axios.post('/sales/insertSaleInfo', regSale)
      .then((res) => {
        alert('등록을 완료하였습니다.')
        navigate('/salesInfoList')
      })
      .catch((error) => {
        console.log(error)
      })
    }

  }

  useEffect(() => {
    axios.get('/carInfo/getCarNameList')
    .then((res) => {
      setCarName(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, []);

  return (
    <div className='contain'>
      <table>
        <tbody>
          <tr>
            <td>구매자명</td>
            <td colSpan={3}><input type='text' className='buyer' name='buyerName' onChange={(e) => {onChangeRegSale(e)}} /></td>
          </tr>
          <tr>
            <td>색상</td>
            <td>
              <select name='color' className='color' onChange={(e) => {onChangeRegSale(e)}}>
                <option>블랙</option>
                <option>화이트</option>
                <option>실버</option>
                <option>레드</option>
              </select>
            </td>
            <td>모델</td>
            <td>
              {/* 모델 종류 들어올것 list사용 */}
              <select name='carNum' className='carNum' onChange={(e) => {onChangeRegSale(e)}}>
                {
                  carName.map((car, i) => {
                    return(
                        <option key={i} value={car.carNum}>{car.carName}</option>
                      )
                    })
                }
              </select> 
            </td>
          </tr>
          <tr>
            <td>연락처</td>
            <td colSpan={2}><input type='text' className='tel' name='buyerTel' onChange={(e) => {onChangeRegSale(e)}} /></td>
          </tr>
        </tbody>
      </table>
      <button type='button' onClick={() => {insertRegSale()}}>등록</button>
    </div>
  )
}

export default RegSalesInfo