
let resultArr = [
  false, // id
  false, // pw
  false, // name
  false // tel
];

let result_pw1 = false;
let result_pw2 = false;

export const joinValidate = (newData, valid_tag, tagName) => {
  console.log(resultArr)
  // id 값을 변경했으면 id관련 validation을 띄우고
  // pw 값을 변경했으면 pw관련 validation을 띄우고
  // name 값을 변경했으면 name관련 validation만 띄우기
  // tel 값을 변경했으면 tel관련 validation을 띄우고
  // validation 처리 : 모든 데이터가 유요한 데이터라면 리턴 true
  switch (tagName) {
    case 'memId':
      // id가 영문만 포함 + 4~12자리인지 검사하는 정규식
      const regex_memId = /^[a-z|A-Z|0-9]{4,12}$/;
      
      // id 유효성 검사
      // test() : 매개변수로 들어온 데이터가 조건에 부합하면 리턴 true
      if(regex_memId.test(newData.memId)){
        // div에 error 클래스 추가
        // div 태그 안에 글자 변경 : 4자리 이상 가능
        // memId_valid_tag.current.className = 'feedback error';
        // memId_valid_tag.current.textContent = '사용 불가능한 아이디 입니다.';
        sendFeedbackMsg(valid_tag[0], 'good', '사용 가능한 아이디 입니다.');
        resultArr[0] = true;
      }
      else{
        // div에 good 클래스 추가
        // div 태그 안에 글자 변경 : 사용 가능한 아이디
        // memId_valid_tag.current.className = 'feedback good';
        // memId_valid_tag.current.textContent = '사용 가능한 아이디 입니다.';
        sendFeedbackMsg(valid_tag[0], 'error', '사용 불가능한 아이디 입니다.');
        resultArr[0] = false;
      }
      break;
    case 'memPw':
    case 'confirmPw':
      const regex_memPw = /^(?=.*[a-z])(?=.*[0-9]).{4,12}$/;

      if(regex_memPw.test(newData.memPw)){
        sendFeedbackMsg(valid_tag[1], 'good', '');
        result_pw1 = true;
      }
      else{
        sendFeedbackMsg(valid_tag[1], 'error', '비밀번호는 4~12글자 영문 소문자,숫자를 조합하십시오.');
        result_pw1 = false;
      }

      if(newData.memPw!=newData.confirmPw){
        sendFeedbackMsg(valid_tag[2], 'error', '입력한 비밀번호가 다릅니다.');
        result_pw2 = false;
      }
      else{
        sendFeedbackMsg(valid_tag[2], 'good', '');
        result_pw2 = true;
      }

      resultArr[1] = result_pw1 && result_pw2 ? true : false;

      break;
    case 'memName':
      // 이름 값 유효성 검사
      // 정규식 : 2~10글자 + 한글만
      const regex_memName = /^[가-힣]{2,10}$/;

      if(regex_memName.test(newData.memName)){
        // memName_valid_tag.current.className = 'feedback error';
        // memName_valid_tag.current.textContent = '이름은 2~10글자, 한글만 가능합니다.';
        sendFeedbackMsg(valid_tag[3], 'good', '');
        resultArr[2] = true;
      }
      else{
        // memName_valid_tag.current.className = 'feedback good';
        // memName_valid_tag.current.textContent = '';
        sendFeedbackMsg(valid_tag[3], 'error', '이름은 2~10글자, 한글만 가능합니다.');
        resultArr[2] = false;
      }
      break;
    case 'memTel':
      const regex_memTel = /^\d{2,3}-\d{3,4}-\d{4}$/;

      if(regex_memTel.test(newData.memTel)){
        sendFeedbackMsg(valid_tag[4], 'good', '유효한 연락처입니다.');
        resultArr[3] = true;
      }
      else{
        sendFeedbackMsg(valid_tag[4], 'error', '연락처를 확인하십시오');
        resultArr[3] = false;
      }

      break;
  }

  // resultArr의 모든 데이터가 true일때만, 리턴 true

  // 배열에 매개변수로 전달된 데이터가 존재하면 리턴 true
  // return !resultArr.includes(false);

  for(const e of resultArr){
    if(!e){
      return false;
    }
  }
  return true;
};

// 유효성 결과 메세지를 띄우는 함수
function sendFeedbackMsg( feedbackTag, type, msg){
  feedbackTag.current.className = `feedback ${type}`;
  feedbackTag.current.textContent = msg;
}



