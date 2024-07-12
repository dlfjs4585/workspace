import { useState } from "react";

const InputTest = () => {

  // input 태그에 입력한 내용을 저장하는 변수
  const [inputData, setInputData] = useState(''); // useState 안의 값은 inputData의 초기값
  const [inputData2, setInputData2] = useState('');
  // setInputData('java'); // 그림이 제 랜더링됨.


  const [stu, setStu] = useState({
    stuName : '',
    age : 0,
    score : 0,
    addr : ''
  });

  function changeStu(e){
    setStu({
      ...stu,
      [e.target.name] : e.target.value
    });
  }

  return(
    <>
      <div>
        이름 : <input type='text' onChange={(e) => {
          setInputData(e.target.value);
        }}/> <br />
        나이 : <input type='text' onChange={(e) => {
          setInputData2(e.target.value);
        }}/>
      </div> <br />
      
      <div>
        학생명 : <input type='text' name="stuName" onChange={(e) => {
          setStu({
            ...stu,
            [e.target.name] : e.target.value
          });
        }}/> <br />
        나이 : <input type='text' name="age" onChange={(e) => {
          setStu({
            ...stu,
            [e.target.name] : e.target.value
          }
          );
        }} /> <br />
        점수 : <input type='text' name="score" onChange={(e) => {
          changeStu(e);
        }}/> <br />
        주소 : <input type='text' name="addr" onChange={(e) => {
          changeStu(e);
        }} /> <br />

        <div>
          이름 : {stu.stuName}; <br />
          나이 : {stu.age}; <br />
          점수 : {stu.score}; <br />
          주소 : {stu.addr}; <br />
        </div>

      </div>
    </>
  );

}

export default InputTest;