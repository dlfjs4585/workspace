import logo from './logo.svg';
import './reset.css';
import './App.css';
import './table.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import GoodsInfo from './GoodsInfo';
import RegGoods from './RegGoods';
import OrderGoods from './OrderGoods';
import OrderList from './OrderList';

function App() {

  const navigate = useNavigate();

  return (
    <div className="container">
      <div className="header">
        <ul>
          <li><span onClick={(e) => {navigate('/')}}>상품정보</span></li>
          <li><span onClick={(e) => {navigate('/regGoods')}}>상품등록</span></li>
          <li><span onClick={(e) => {navigate('/orderGoods')}}>주문하기</span></li>
          <li><span onClick={(e) => {navigate('/orderList')}}>주문목록</span></li>
        </ul>
      </div>
      <div className="content">
        <Routes>
          {/* 상품정보  */}
          <Route path='/' element={<GoodsInfo />} />
          {/* 상품 상세 보기 */}
          <Route path='/detail/:itemNum' element={<GoodsInfo />} />
          {/* 상품 등록 */}
          <Route path='/regGoods' element={<RegGoods />} />
          {/* 주문 하기 */}
          <Route path='/orderGoods' element={<OrderGoods />} />
          {/* 주문 목록 */}
          <Route path='/orderList' element={<OrderList />} />
        </Routes>
      </div>
    </div>
  );
}



export default App;
