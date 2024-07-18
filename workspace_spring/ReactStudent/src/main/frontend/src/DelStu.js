import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Delstu = () => {

  const [studentList, setStudentList] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
    .get('/stuList')
    .then((res) => {
      setStudentList(res.data);
    })
    .catch((error) => {
      alert('오류 발생!!\n 개발자 모드로 콘솔 확인!!');
      console.log(error);
    })
  }, []);

  function deleteStu(stuNum){
    if(window.confirm('삭제하시겠습니까?')){
      axios
      .delete(`/delStu/${stuNum}`)
      .then((res) => {
        window.location.reload();
      })
      .catch((error) => {
        console.log(error);
      })
    }
  }
  

  return(
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>삭제</td>
          </tr>
        </thead>
        <tbody>
          {
            studentList.map((stu, i) => {
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
                  <td>{stu.stuName}</td>
                  <td><button type="button" onClick={(e) => {deleteStu(stu.stuNum)}}>삭제</button></td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  );
}

export default Delstu;