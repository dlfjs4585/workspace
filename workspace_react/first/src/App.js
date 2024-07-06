import logo from './logo.svg';
import './App.css';

function App() {
  return (
    // jsx , html 아님!!
    <div className="App">
      <MyTable></MyTable>
      <MyTable></MyTable>
    </div>
  );
}

// 컴포넌트
function MyTable() {
  return (
    <table border={1}>
        <tr>
          <td>이름</td>
          <td>나이</td>
        </tr>
      </table>
  );
}

export default App;
