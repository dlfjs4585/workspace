
const WriteForm = () => {
  
  
  return(
    <div>
      <table>
        <tr>
          <td>제 목</td>
          <td><input type="text" /></td>
        </tr>
        <tr>
          <td>작성자</td>
          <td><input type="text" /></td>
        </tr>
        <tr>
          <td>내 용</td>
          <td><input type="text" /></td>
        </tr>
      </table>
      <button type="button" onClick={() => {}} >글등록</button>
    </div>
  );
}


export default WriteForm;