
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../salesInfoList.css';

const SalesInfoList = () => {

  const [carList, setCarList] = useState([]);

  console.log(carList)

  useEffect(() => {
    axios.get('/sales/getCarList')
    .then((res) => {
      setCarList(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [])


  return (
    <div className='contain'>
      <table className='sellInfo-table'>
        <thead>
          <tr>
            <td rowSpan={2}>No</td>
            <td colSpan={4}>구매자정보</td>
            <td colSpan={2}>차량정보</td>
          </tr>
          <tr>
            <td>구매자명</td>
            <td>연락처</td>
            <td>구매일</td>
            <td>색상</td>
            <td>모델명</td>
            <td>금액</td>
          </tr>
        </thead>
        <tbody>
          {
            carList.map((car, i) => {
              return(
                <tr key={i}>
                  <td>{i+1}</td>
                  <td>{car.buyerName}</td>
                  <td>{car.buyerTel}</td>
                  <td>{car.saleDate}</td>
                  <td>{car.color}</td>
                  <td>{car.carVO.carName}</td>
                  <td>{car.carVO.carMoney}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default SalesInfoList