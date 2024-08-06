
import React from 'react'

const RegItem = () => {
  return (
    <div>
      <div>
        <div>상품 카테고리</div>
        <select>
          <option>A</option>
          <option>B</option>
          <option>C</option>
        </select>
      </div>
      <div>
        <div>상품명</div>
        <input type='text' />
      </div>
      <div>
        <div>상품 가격</div>
        <input type='text' />
      </div>
      <div>
        <div>상품 소개</div>
        <textarea></textarea>
      </div>
      <div>
        <button type='button'></button>
      </div>
    </div>
  )
}

export default RegItem