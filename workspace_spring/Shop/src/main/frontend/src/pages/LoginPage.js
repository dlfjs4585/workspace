
import React from 'react'

const LoginPage = () => {
  return (
    <div>
      <div>
        아이디 <input type='text' /> <button type='button'>중복확인</button>
      </div>
      <div>
        비밀번호 <input type='password' />
      </div>
      <div>
        비밀번호 확인 <input type='password' />
      </div>
      <div>
        이름 <input type='text' />
      </div>
      <div>
        연락처 <input type='text' />
      </div>
      <div>
        <div>
          주소 <input type='text' /> <button type='button'>검색</button>
        </div>
        <input type='text' />
      </div>
      <div>
        이메일 <input type='text' /> 
        <select>
          <option>naver.com</option>
        </select> 
      </div>
    </div>
  )
}

export default LoginPage