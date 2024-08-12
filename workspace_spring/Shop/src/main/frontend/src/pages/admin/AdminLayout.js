
import React, { useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'

const AdminLayout = () => {
  const navigate = useNavigate();

  // 사이드 메뉴 정보를 관리하는 state변수 생성
  const[sideMenu, setSideMenu] = useState('itemManage');

  // 사이드 메뉴를 화면에 그리는 함수 생성
  function drawSideMenu(){

    // 상단 메뉴에서 상품관리 클릭시
    if(sideMenu == 'itemManage'){
      return(
        <ul className='side-menu-ul'>
          <li onClick={() => {navigate('/admin/itemManage')}}>
            <span>
              상품관리
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li onClick={() => {navigate('/admin/regItem')}}>
            <span>
              상품등록
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li onClick={() => {navigate('/admin/categoryManage')}}>
            <span>
              카테고리관리
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
        </ul>
      );
    }
    // 상단 메뉴에서 구매관리 클릭시
    else if(sideMenu == 'saleManage'){
      return(
        <ul className='side-menu-ul'>
          <li onClick={() => {navigate('/admin/saleHistoryOfMonth')}}>
            <span>
              이달의 구매내역
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li>
            <span>
              구매정보 검색
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
        </ul>
      );
    }
    // 상단 메뉴에서 유저관리 클릭시
    else if(sideMenu == 'userManage'){
      return(
        <ul className='side-menu-ul'>
          <li onClick={() => {navigate('/admin/searchUser')}}>
            <span>
              유저검색
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li>
            <span>
              유저정보 변경
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li>
            <span>
              탈퇴유저 관리
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
        </ul>
      );
    }
    // 상단 메뉴에서 매출관리 클릭시
    else if(sideMenu == 'recordManage'){
      return(
        <ul className='side-menu-ul'>
          <li onClick={() => {navigate('/admin/recordOfMonth')}}>
            <span>
              이달의 매출
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li>
            <span>
              월별 매출
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
          <li>
            <span>
              카테고리별 매출
            </span>
            <span>
              <i className="bi bi-chevron-right"></i>
            </span>
          </li>
        </ul>
      );
    }
  }

  return (
    <div>
      <div className='menu-div'>
        <ul className='menu-ul'>
          <li><span onClick={() => {setSideMenu('itemManage'); navigate('/admin/itemManage')}}>상품관리</span></li>
          <li><span onClick={() => {setSideMenu('saleManage'); navigate('/admin/saleHistoryOfMonth')}}>구매관리</span></li>
          <li><span onClick={() => {setSideMenu('userManage'); navigate('/admin/searchUser')}}>유저관리</span></li>
          <li><span onClick={() => {setSideMenu('recordManage'); navigate('/admin/recordOfMonth')}}>매출관리</span></li>
        </ul>
      </div>
      <div className='side-menu-div'>
        {drawSideMenu()}
        <Outlet />
      </div>
    </div>
  )
}

export default AdminLayout