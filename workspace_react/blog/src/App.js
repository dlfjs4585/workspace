import logo from './logo.svg';
import './App.css';
import { Component, useState } from 'react';


// App() 함수의 리턴문 안에 작성하는 코드가 화면에 나타남
// html 코드처럼 보이는 것은 실은 jsx라는 문법이다.
// 그렇기 때문에 html과 조금 다른 부분이 있다.
function App() {

  // 제목 정보를 저장하고 있는 변수
  const [titles, setTitles] = useState(['울산 맛집', 'React 공부', '집가고 싶다']);
  // 좋아요 갯수
  // 대괄호의 첫번째 : 변수
  // 대괄호의 두번째 : 변수의 값을 변경시켜주는 함수
  // ex) setLikeCnt(5); -> likeCnt 변수의 값을 5로 변경
  // useState로 만들어진 변수는 값을 변경하면 html화면을 재랜더링한다.
  let [likeCnt, setLikeCnt] = useState([0,0,0]);

  // Detail 컴포넌트가 보일지 안보일지 결정하는 변수
  let [isShow, setIsShow] = useState(false);
  
  return (
    <div className="App">
      <div className="blog-nav">
        <h3>My blog</h3>
      </div>

      {/* {
        [1,2,3].map((e, i) => {
          return (
            <div>{e}</div>
          );
        })
      } */}

      
      
      <button type='button' onClick={() => {
        const copyTitles = [...titles]; //['울산 맛집', 'React 공부', '집가고 싶다']
        copyTitles[0] = '대구 맛집';
        setTitles(copyTitles);
      }} >제목변경</button>

      {/* 블로그 글 목록 */}
      {
        titles.map((title, i) => {
          return(
            <Board 
            title={title}  
            key={i} 

            />
          );
        })
      }
      
      {/* 상세보기 */}
      {/* 자바스크립트 문법을 사용할때는 {}를 사용 */}
      {
        isShow ? <Detail board={titles}/> : null
      }
    </div>
  );
}

// 상세보기 컴포넌트
// 컴포넌트 만들때는 앞글자를 대문자로 시작
// 컴포넌트의 리턴문에 html 작성
// 모든 html 태그는 반드시 하나의 태그 안에 포함되게 작성
// 태그가 여러개 필요할 때는 빈태그(<></>)를 이용한다
function Detail (props){
  return(
    <div className='detail'>
      <h4>제목 : {props.Board}</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}

// 블로그 글 하나에 대한 컴포넌트 생성
// 전달되는 데이터는 매개변수에 props 를 사용해서 전달 받음
function Board(props){
  return(
    <div className='list'>
      <h4>
        {props.title}
        <span>👍</span>
        
      </h4>
      <p>2024-07-10</p>
    </div>
  );
};

export default App;
