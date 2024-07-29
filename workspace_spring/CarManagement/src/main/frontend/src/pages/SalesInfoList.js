
import axios from 'axios';
import React, { useEffect, useState } from 'react'

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
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>구매자정보</td>
            <td>차량정보</td>
          </tr>
          <tr>
            <td></td>
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
                  <td>{car.carNum}</td>
                  <td>{car.buyerName}</td>
                  <td>{car.buyerTel}</td>
                  <td>{car.saleDate}</td>
                  <td>{car.color}</td>
                  <td>{car.carName}</td>
                  <td>{car.carMoney}</td>
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