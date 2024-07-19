import logo from './logo.svg';
import './reset.css';
import './App.css';
import './table.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import Detail from './Detail';
import RegItem from './RegItem';
import OrderItem from './OrderItem';
import OrderList from './OrderList';
import ItemList from './ItemList';

function App() {

  const navigate = useNavigate();

  return (
    <div className="container">
      <div className="header">
        <ul>
          <li><span onClick={(e) => {navigate('/')}}>상품정보</span></li>
          <li><span onClick={(e) => {navigate('/regItem')}}>상품등록</span></li>
          <li><span onClick={(e) => {navigate('/orderItem')}}>주문하기</span></li>
          <li><span onClick={(e) => {navigate('/orderList')}}>주문목록</span></li>
        </ul>
      </div>
      <div className="content">
        <Routes>
          {/* 상품정보  */}
          <Route path='/' element={<ItemList />} />
          {/* 상품 상세 보기 */}
          <Route path='/detail/:itemNum' element={<Detail />} />
          {/* 상품 등록 */}
          <Route path='/regItem' element={<RegItem />} />
          {/* 주문 하기 */}
          <Route path='/orderItem' element={<OrderItem />} />
          {/* 주문 목록 */}
          <Route path='/orderList' element={<OrderList />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
