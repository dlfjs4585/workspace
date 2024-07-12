import logo from './logo.svg';
import './App.css';
import data from './data';
import BoardList from './BoardList';
import { Route, Routes } from 'react-router-dom';
import Detail from './Detail';
import Write from './Write';
import { useState } from 'react';
import InputTest from './InputTest';

function App() {
  
  const [boardList, setBoard] = useState(data);

  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<BoardList board_list={boardList} />}></Route>
        <Route path='/detail/:id' element={<Detail board_list={boardList} setBoard={setBoard}/>}></Route>
        <Route path='/writeForm' element={<Write board_list={boardList}/>}></Route>
        <Route path='/test' element={<InputTest />}/>
      </Routes>

      
    </div>
  );
}

export default App;
