import logo from './logo.svg';
import './App.css';
import data from './data';
import BoardList from './BoardList';
import { Route, Routes } from 'react-router-dom';
import Detail from './Detail';

function App() {
  const board_list = data;
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<BoardList board_list={board_list} />}></Route>
        <Route path='/detail/:id' element={<Detail board_list={board_list} />}></Route>
      </Routes>
      
    </div>
  );
}

export default App;
