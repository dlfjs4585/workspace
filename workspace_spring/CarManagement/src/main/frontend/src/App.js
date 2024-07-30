import logo from './logo.svg';
import './reset.css';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import CarHome from './pages/CarHome';
import CarManagement from './pages/CarManagement';
import RegSalesInfo from './pages/RegSalesInfo';
import SalesInfoList from './pages/SalesInfoList';

function App() {
  const navigate = useNavigate();

  return (
    <div className="container">
      <div className='head'>
        <ul>
          <li onClick={(e) => {navigate('/')}} >홈</li>
          <li onClick={(e) => {navigate('/management')}} >차량 관리</li>
          <li onClick={(e) => {navigate('/regSaleInfo')}} >판매 정보 등록</li>
          <li onClick={(e) => {navigate('/salesInfoList')}}>판매 목록</li>
        </ul>
      </div>
      <div className='content'>
        <Routes>
          {/* 홈 화면 */}
          <Route path='/' element={ <CarHome/> } />
          {/* 차량 관리 화면 */}
          <Route path='/management' element={<CarManagement />} />
          {/* 판매 정보 등록 화면 */}
          <Route path='/regSaleInfo' element={<RegSalesInfo />} />
          {/* 판매 목록 화면 */}
          <Route path='/salesInfoList' element={<SalesInfoList />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
