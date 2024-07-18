import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const Score = () => {

  const [stuList, setStuList] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
    .get('/stuList')
    .then((res) => {
      setStuList(res.data);
    })
    .catch((error) => {
      alert('오류 발생!!\n 개발자 모드로 콘솔 확인!!');
      console.log(error);
    })
  }, []);

  function setScore(stuNum){
    navigate(`/SetScore/${stuNum}`);
  }

  return(
    <table>
      <thead>
        <tr>
          <td>No</td>
          <td>학생명</td>
          <td>성적입력</td>
        </tr>
      </thead>
      <tbody>
        {
          stuList.map((stu, i) => {
            return(
              <tr key={i}>
                <td>{i + 1}</td>
                <td>{stu.stuName}</td>
                <td><button type="button" onClick={(e) => {setScore(stu.stuNum)}}>입력</button></td>
              </tr>
            );
          })
        }
      </tbody>
    </table>
  );
}

export default Score;