import logo from './logo.svg';
import './App.css';
import data from './data';
import ItemList from './ItemList';
import Item from './Item';
import axios, { Axios } from 'axios';
import { Link, Route, Router, Routes } from 'react-router-dom';
import Detail from './Detail';

function App() {
  const item_list = data;

  return (
    <div className="App">
      <div className="header">
        <Link to={'/'}>Book shop</Link>
        <Link to={'/list'}>상품 목록</Link>
        <Link to={'/detail'}>상품 상세</Link>
      </div>
      <div className="banner">
        <img src={process.env.PUBLIC_URL + '/header.jpg'} />
      </div>

      {/* 이동할 수 있는 페이지의 url들 */}
      <Routes>
        <Route path='/' element={<div>메인 페이지</div>} />
        <Route path='/list' element={<div><ItemList item_list={item_list} /></div>} />
        <Route path='/detail/:id' element={<Detail item_list={item_list} />} />
        <Route path='*' element={<div>잘못된 페이지입니다.</div>} />
      </Routes>

      {/* <ItemList item_list={item_list} /> */}
      
    </div>
  );
}

export default App;
