import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';
import AxiosTest from './AxiosTest';
import Detail from './Detail';
import WriteForm from './WriteForm';

function App() {

  // 가장 나중에 실행
  // 컴포넌트의 생애주기에 따라 기능을 구현
  // 생애주기
  // mount(컴포넌트 생성)
  // update(컴포넌트 재랜더링)
  // unmount(컴포넌트 제거)
  // useEffect(() => {}); 마운트 + 업데이트
  // useEffect(() => {}, []); 마운트
  // useEffect(() => {}, [age]); 마운트 + age라는 state변수의 값이 update 될때

  return (
    <div className="App">
      
      <Routes>
        {/* axios 예제 페이지 */}
        <Route path='/axios' element={<AxiosTest />} />
        {/* 게시글 목록 페이지 */}
        <Route path='/' element={<BoardList />} />
        {/* 상세 정보 페이지 */}
        <Route path='/detail/:boardNum' element={<Detail />}/>
        {/* 글 등록 페이지 이동 */}
        <Route path='/writeForm' element={<WriteForm />} />
      </Routes>
      
    </div>
  );
}

export default App;
