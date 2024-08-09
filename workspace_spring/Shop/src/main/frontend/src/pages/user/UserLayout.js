
import React from 'react'
import { Outlet } from 'react-router-dom'

const UserLayout = () => {
  return (
    <div>
      <div className='user-menu-div'>
        <ul className='menu-ul'>
          <li>전체상품</li>
          <li>인터넷/IT</li>
          <li>소설</li>
          <li>자기개발</li>
        </ul>
      </div>
      <Outlet />
    </div>
  )
}

export default UserLayout