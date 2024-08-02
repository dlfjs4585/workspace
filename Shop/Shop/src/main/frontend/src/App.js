import './App.css';
import './reset.css'
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';

function App() {

  const navigate = useNavigate()


  return (
    <div className="container">
      <div className='login-div'>
        <ul className='header-menu'>
          <li><span  onClick={() => {navigate('loginForm')}}>Login</span></li>
          <li><span  onClick={() => {navigate('joinForm')}}>Join</span></li>
        </ul>
        <div className='banner'>
          <div>
            <img className='banner-img' src='http://localhost:8080/images/book_banner.PNG' />
          </div>
          <div className='title-div'>BOOK SHOP</div>
        </div>
      </div>
      <div className='layout-div'>
        <Routes>
          {/* 일반 유저용 */}
          <Route path='/' element={ <UserLayout /> }>
            {/* 상품 목록 화면 */}
            <Route path='' element={ <div>상품목록화면</div> }/>

            <Route path='test1' element={<div>1번화면</div>} />
            <Route path='test2' element={<div>2번화면</div>} />
            <Route path='joinForm' element={<Join />} />
            <Route path='loginForm' element={<Login />} />
          </Route>
          {/* 관리자용 */}
          <Route path='/admin' element={ <AdminLayout /> }>
            <Route path='test1' element={ <div>상품등록페이지</div> }/>
          </Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
