import './App.css';
import './reset.css'
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';
import { useEffect, useState } from 'react';
import ItemList from './pages/user/ItemList';
import RegItem from './pages/admin/RegItem';
import ItemDetail from './pages/user/ItemDetail';
import ItemManage from './pages/admin/ItemManage';
import CategoryManage from './pages/admin/CategoryManage';
import SaleHistoryOfMonth from './pages/admin/SaleHistoryOfMonth';
import SearchUser from './pages/admin/SearchUser';
import RecordOfMonth from './pages/admin/RecordOfMonth';

function App() {

  const navigate = useNavigate()

  // 로그인 정보를 저장할 수 있는 state변수 생성
  // 로그인 성공 시 loginInfo에 로그인 정보를 저장하지만
  // 새로고침하면 App.js가 다시 시작하면서 loginInfo의 값이 초기화된다.
  // 새로고침과 재랜더링은 다르다
  // 새로고침하면 state변수의 값이 전부 초기화 된다.
  // 재랜더링하면 state변수의 값이 보존된다.
  const [loginInfo, setLoginInfo] = useState({});

  // 새로고침을 하더라도 sessionStorage에 로그인 정보는 존재하나,
  // 새로고침 할때 만약 로그인 정보가 sessionStorage에 남아있다면
  // loginInfo state변수에 로그인 정보를 저장시켜야 함.
  
  // App.js가 mount(새로고침) 된다면 실행
  useEffect(() => {
    // 세션에 저장된 로그인 정보 가져옴
    const sessionLoginInfo = window.sessionStorage.getItem('loginInfo');
    // 로그인 정보가 있으면..
    if(sessionLoginInfo != null){
      // 로그인 정보를 loginInfo에 저장
      const obj_loginInfo = JSON.parse(sessionLoginInfo);

      // 세션에서 가져온 데이터를 객체로 변환
      setLoginInfo(obj_loginInfo);
    }
  }, []);

  // 빈 객체인지 확인하는 코드
  // Object.keys() -> 객체 안의 모든 키 값을 가져옴
  // console.log(Object.keys(loginInfo).length);


  return (
    <div className="container">
      <div className='login-div'>
        <ul className='header-menu'>
          {
            // Object.keys(loginInfo).length == 0
            loginInfo.memId == null
            ?
            <>
              <li><span  onClick={() => {navigate('/loginForm')}}>Login</span></li>
              <li><span  onClick={() => {navigate('/joinForm')}}>Join</span></li>
            </>
            :
            <div>
              {loginInfo.memId}님 반갑습니다.
              <span onClick={(e) => {
                // 세션에 저장된 로그인 정보 삭제
                window.sessionStorage.removeItem('loginInfo')
                setLoginInfo({});

                //상품 목록 페이지 이동
                navigate('/')
              }}>L O G O U T</span>
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

            {/* 상품 목록 화면 */}
            <Route path='' element={ <ItemList/> }/>

            {/* 회원 가입 화면 */}
            <Route path='joinForm' element={<Join />} />

            {/* 로그인 페이지 */}
            {/* loginInfo 넘겨서 다시 memRole 다시 만들기 */}
            <Route path='loginForm' element={<Login setLoginInfo={setLoginInfo} />} />

            {/* 상품 상세 화면 */}
            <Route path='detail/:itemCode' element={<ItemDetail />} />

          </Route>
          {/* 관리자용 */}
          <Route path='/admin' element={ <AdminLayout /> }>
            <Route path='itemManage' element={<ItemManage />} />
            <Route path='regItem' element={ <RegItem /> }/>
            <Route path='categoryManage' element={<CategoryManage />} />
            <Route path='saleHistoryOfMonth' element={<SaleHistoryOfMonth />} />
            <Route path='searchUser' element={<SearchUser />} />
            <Route path='recordOfMonth' element={<RecordOfMonth />} />
          </Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
