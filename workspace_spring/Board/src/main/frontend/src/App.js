import logo from './logo.svg';
import './reset.css';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import BoardList from './pages/BoardList';
import Login from './pages/Login';
import Join from './pages/Join';

function App() {

  const navigate = useNavigate();

  return (
    <div className="container">
      <div className='header'>
        <div className='login'>
          <span onClick={(e) => {navigate('/login')}}>Login</span>
          <span onClick={(e) => {navigate('/join')}}>Join</span>
        </div>
        <h2>자유게시판</h2>
      </div>
      <div className='content'>
        <Routes>
          <Route path='/' element={<BoardList />}/>
          <Route path='/join' element={<Join />} />
          <Route path='/login' element={<Login />} />
        </Routes>
      </div>

    </div>
  );
}

export default App;
