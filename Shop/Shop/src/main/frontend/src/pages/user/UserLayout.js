
import React from 'react'
import { Outlet } from 'react-router-dom'
import './UserLayout.css'

const UserLayout = () => {
  return (
    <div>
      <div className='category-div'>
        <div onClick={() => {}}>전체 상품</div>
        <div onClick={() => {}}>인터넷 / IT</div>
        <div onClick={() => {}}>소설 / 에세이</div>
        <div onClick={() => {}}>자기계발</div>
      </div>
      <Outlet />
    </div>
  )
}

export default UserLayout