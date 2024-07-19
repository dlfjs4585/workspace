
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const SetScore = () => {

  const[stuScore, setStuScore] = useState([]);
  const navigate = useNavigate();
  const {stuNum} = useParams();

  function changeScore(e){
    setStuScore({
      ...stuScore,
      [e.target.name] : e.target.value
    });
  }
  
  useEffect(() => {
    axios
    .get(`/getStuDetail/${stuNum}`)
    .then((res) => {
      setStuScore(res.data);
    })
    .catch((error) => {
      console.log(stuNum)
    })
  }, []);

  function updateScore(){

    axios
    .put('/updateScore', stuScore)
    .then((res) => {
      alert('점수를 등록하였습니다.')
      navigate('/');
    })
    .catch((error) => {
      alert('오류 발생!!');
      console.log(error);
    });
  }
  

  return (
    <div>
      <div></div>
      <div>
        <table>
          <tr>
            <td>국어</td>
            <td><input type='text' name='korScore' value={stuScore.korScore} onChange={(e) => {changeScore(e)}} /></td>
          </tr>
          <tr>
            <td>영어</td>
            <td><input type='text' name='engScore' value={stuScore.engScore} onChange={(e) => {changeScore(e)}} /></td>
          </tr>
          <tr>
            <td>수학</td>
            <td><input type='text' name='mathScore' value={stuScore.mathScore} onChange={(e) => {changeScore(e)}} /></td>
          </tr>
        </table>
      </div>
      <button type='button' onClick={() => {updateScore()}}>점수등록</button>
    </div>
  )
}

export default SetScore;