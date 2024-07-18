import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import './reset.css';
import './studentList.css';

const StuList = () => {
  const navigate = useNavigate();

  const [stuList, setStuList] = useState([]);
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

  return(
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>국어점수</td>
            <td>영어점수</td>
            <td>수학점수</td>
            <td>평균</td>
          </tr>
        </thead>
        <tbody>
          {
            stuList.length == 0 ?
            <tr>
              <td colSpan='6'>조회된 데이터가 없습니다.</td>
            </tr>
            :
            stuList.map((stu, i) => {
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
                  <td><span onClick={() => {navigate(`/detail/${stu.stuNum}`)}}>{stu.stuName}</span></td>
                  <td>{stu.korScore}</td>
                  <td>{stu.engScore}</td>
                  <td>{stu.mathScore}</td>
                  <td>{Math.round((stu.korScore + stu.engScore + stu.mathScore) / 3 * 10 )/ 10}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  );
}

export default StuList;