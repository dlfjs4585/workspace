import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Detail = () => {
  const navigate = useNavigate();
  const [stu, setStu] = useState({});
  const params = useParams();

  useEffect(() => {
    axios
    .get(`/getStuDetail/${params.stuNum}`)
    .then((res) => {
      setStu(res.data);
      console.log(res.data);
    })
    .catch((error) => {
      alert('오류발생!!');
      console.log(error);
      console.log(params.stuNum);
    })
  }, []);
  

  return(
    <>
      <table>
        <tr>
          <td>이름</td>
          <td>{stu.stuName}</td>
          <td>나이</td>
          <td>{stu.stuAge}</td>
        </tr>
        <tr>
          <td>연락처</td>
          <td>{stu.stuTel}</td>
          <td>주소</td>
          <td>{stu.stuAddr}</td>
        </tr>
        <tr>
          <td>국어점수</td>
          <td>{stu.korScore}</td>
          <td>영어점수</td>
          <td>{stu.engScore}</td>
        </tr>
        <tr>
          <td>수학점수</td>
          <td>{stu.mathScore}</td>
          <td>평균</td>
          <td>{(stu.korScore + stu.engScore + stu.mathScore)/3}</td>
        </tr>
      </table>
      <button type="button" onClick={() => {navigate('/')}}>뒤로가기</button>
    </>
  );
}

export default Detail;