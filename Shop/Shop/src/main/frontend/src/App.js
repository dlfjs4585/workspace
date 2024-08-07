import './App.css';
import './reset.css'
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';
import ItemList from './pages/user/ItemList';
import { useEffect, useState } from 'react';
import RegItem from './pages/admin/RegItem';

function App() {

  const navigate = useNavigate()

  const [loginInfo, setLoginInfo] = useState({});

  useEffect(() => {
    const loginDataString = window.sessionStorage.getItem('loginInfo');

    if(loginDataString != null){
      const loginData = JSON.parse(loginDataString);
      setLoginInfo(loginData);
    }
  }, []);

  return (
    <div className="container">
      <div className='login-div'>
        <ul className='header-menu'>
          {
            loginInfo.memId == null
            ?
            <>
              <li><span  onClick={() => {navigate('/loginForm')}}>Login</span></li>
              <li><span  onClick={() => {navigate('/joinForm')}}>Join</span></li>
            </>
            :
            <div>
              {loginInfo.memName}님 반갑습니다.
              <span onClick={(e) => {
                window.sessionStorage.removeItem('loginInfo');
                setLoginInfo({});
                // 모달 로그아웃 만들어야함
                alert('로그아웃');
                navigate('/');
              }}>Logout</span>
            </div>
          }
          
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
            {/* 상품 리스트 페이지 */}
            <Route path='itemList' element={<ItemList/>} />
            {/* 회원 가입 화면 */}
            <Route path='joinForm' element={<Join />} />

            {/* 로그인 페이지 */}
            <Route path='loginForm' element={<Login setLoginInfo={setLoginInfo} />} />

          </Route>

          {/* 관리자용 */}
          <Route path='/admin' element={ <AdminLayout /> }>
            <Route path='regItem' element={ <RegItem />} />
          </Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
