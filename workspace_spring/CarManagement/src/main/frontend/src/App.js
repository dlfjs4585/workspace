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
    <div className="App">
      <table>
        <tbody>
          <tr>
            <td><span onClick={(e) => {navigate('/')}}>홈</span></td>
            <td><span onClick={(e) => {navigate('/management')}}>차량 관리</span></td>
            <td><span onClick={(e) => {navigate('/regSaleInfo')}}>판매 정보 등록</span></td>
            <td><span onClick={(e) => {navigate('/salesInfoList')}}>판매 목록</span></td>
          </tr>
        </tbody>
      </table>
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
  );
}

export default App;
