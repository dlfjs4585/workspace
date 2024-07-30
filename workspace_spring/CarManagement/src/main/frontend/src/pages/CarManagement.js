import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../carManagement.css';

const CarManagement = () => {

  const [cnt, setCnt] = useState([]);
  const [carList, setCarList] = useState([]);
  const [regCar, setRegCar] = useState({
    carName : '',
    carMoney : 0,
    carManufacturer : '현대'
  });

  function onchangeCar(e){
    setRegCar({
      ...regCar,
      [e.target.name] : e.target.value
    })
  }

  function insertCar(){
    axios.post('/carInfo/insert', regCar)
    .then((res) => {
      alert('차량이 등록되었습니다.')
      setCnt(cnt + 1)
    })
    .catch((error) => {
      console.log(error)
    })
  }

  useEffect(() => {
    axios.get('/carInfo/get')
    .then((res) => {
      setCarList(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [cnt]);

  return (
    <div className='contain'>
      <div className='intro'>- 차량 등록</div>
      <div className='main'>
        <table>
          <tbody>
            <tr>
              <td>제조사</td>
              <td>
                <select name='carManufacturer' onChange={(e) => {onchangeCar(e)}}>
                  <option>현대</option>
                  <option>기아</option>
                  <option>쌍용</option>
                </select>
              </td>
              <td>모델명</td>
              <td><input type='text' name='carName' onChange={(e) => {onchangeCar(e)}} /></td>
              <td>차량가격</td>
              <td><input type='text' name='carMoney' onChange={(e) => {onchangeCar(e)}} /></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className='btn-div'>
        <button type='button' onClick={(e) => {insertCar()}}>등록</button>
      </div>
      <div>
        <div className='intro'>-차량 목록</div>
        <div className='car-list'>
          <table>
            <thead>
              <tr>
                <td>모델번호</td>
                <td>모델명</td>
                <td>제조사</td>
              </tr>
            </thead>
            <tbody>
                {
                  carList.map((car, i) => {
                    return(
                      <tr key={i}>
                        <td>{i+1}</td>
                        <td>{car.carName}</td>
                        <td>{car.carManufacturer}</td>
                      </tr>
                    )
                  })
                }
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

export default CarManagement