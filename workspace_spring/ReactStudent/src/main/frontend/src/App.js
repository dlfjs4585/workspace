import logo from './logo.svg';
import './reset.css';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import StuList from './StuList';
import { useState } from 'react';
import RegStu from './RegStu';
import Delstu from './DelStu';
import Score from './Score';
import Detail from './Detail';
import SetScore from './SetScore';

function App() {

  const [stuList, setStuList] = useState();
  const navigate = useNavigate();

  return (
    <div className="container">
      {/* 헤더 영역 */}
      <div className="header">
        <ul>
          <li><span onClick={(e) => {navigate('/')}}>학생정보조회</span></li>
          <li><span onClick={(e) => {navigate('/regStu')}}>학생등록</span></li>
          <li><span onClick={(e) => {navigate('/delStu')}}>학생삭제</span></li>
          <li><span onClick={(e) => {navigate('/score')}}>성적관리</span></li>
        </ul>
      </div>
      {/* 컨텐츠 영역 */}
      <div className="content">
        <Routes>
          {/* 학생정보조회 페이지 */}
          <Route path='/' element={<StuList />}/>
          {/* 학생 등록 페이지 */}
          <Route path='/regStu' element={<RegStu />} />
          {/* 학생 상세보기 페이지 */}
          <Route path='/detail/:stuNum' element={<Detail />} />
          {/* 학생 삭제 페이지 */}
          <Route path='/delStu' element={<Delstu />} />
          {/* 학생 성적 관리 페이지 */}
          <Route path='/score' element={<Score />} />
          {/* 학생 성적 입력 페이지 */}
          <Route path='/setScore/:stuNum' element={<SetScore />} />
        </Routes>
      </div>

    </div>
  );
}


export default App;
