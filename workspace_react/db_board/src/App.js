import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';

function App() {
  return (
    <div className="App">
      
      <Routes>
        {/* 게시글 목록 페이지 */}
        <Route path='/' element={<BoardList />} />
        <Route path='/Detail' elemen={<BoardList />}/>
      </Routes>
      
    </div>
  );
}

export default App;
