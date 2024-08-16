
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import './CartList.css'

const CartList = () => {

  const [cart, setCart] = useState([]);
  const{memId} = useParams();
  const[totalPrice, setTotalPrice] =useState(0);
  const [isAllSelected, setIsAllSelected] = useState(false); // 전체 선택 상태

  useEffect(() => {
    axios.get(`/api_item/getCartList/${memId}`)
    .then((res) => {
      setCart(res.data)
      console.log(res.data)
      calculateTotalPrice()
    })
    .catch((error) => {console.log(error)})
  }, []);

  const handleQuantityChange = (index, newQuantity) => {
    // 새로운 배열을 복사해서 수정
    const updatedCart = cart.map((cartItem, i) => 
      i === index ? { ...cartItem, cartCnt: newQuantity } : cartItem
    );
    setCart(updatedCart); // 상태 업데이트
    updateCartCnt(updatedCart[index]); // 
  };

  // 아이템 수량 번경시 변경된 수량이 저장되는 함수
  function updateCartCnt(cartItem){
    axios.put(`/api_item/updateCartCnt`, cartItem)
    .then((res) => {

    })
    .catch((error) => {
      console.log(error)
    })
  }

  // 삭제 버튼 클릭시 아이템 삭제
  function deleteItem(cartCode){
    axios.delete(`/api_item/deleteItem/${cartCode}`)
    .then((res) => {
      alert('상품이 삭제 되었습니다.')
    })
    .catch((error) => {console.log(error)})
  }

  // 체크된 품목의 총 가격을 계산
  const calculateTotalPrice = () => {
    let total = 0;
    cart.forEach((cartItem, i) => {
      if(cartItem.isChecked){
        total += cartItem.cartCnt * cartItem.itemList[0].itemPrice
      }
    });
    setTotalPrice(total)
  }

  // 전체 체크박스 선택/해제 기능
  const checkedAll = (e) => {
    const checked = e.target.checked;
    setIsAllSelected(checked);
    
    // 직접 배열을 수정하지 않고, 새로운 배열 생성
    const updateCart = [...cart];
    updateCart.forEach((item, i) => {item.isChecked = checked});
    setCart(updateCart);
  }

  const singleCheck = (index) => {
    const updateCart = [...cart]; // 기존 장바구니 배열 복사

    // 선택된 아이템의 isChecked 상태 반전
    updateCart.forEach((item, i) => {
      if(i == index){
        item.isChecked = !item.isChecked;
      }
    });
    setCart(updateCart);

    // 전체 선택 상태 업데이트
    const allSelected = updateCart.some(item => !item.isChecked);
    setIsAllSelected(!allSelected);
  }

  console.log(cart)

  return (
    <div className='cart-contain'>
      <table className='cart-info-table'>
        <thead>
          <tr>
            <td>No</td>
            <td><input type='checkbox' checked={isAllSelected} onChange={(e) => {checkedAll(e)}} /></td>
            <td>상품정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>구매가격</td>
            <td>구매일시</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          {
            cart.map((cartItem, i)=> {
              return(
                <tr key={i}>
                  <td>{i}</td>
                  <td><input type='checkbox' checked={cartItem.isChecked || false}  onChange={() => {singleCheck(i)}}/></td>
                  <td>
                    <div className='item-info'>
                      <img src={`http://localhost:8080/upload/${cartItem.imgList[0].attachedFileName}`}/>
                    {cartItem.itemList[0].itemName}
                    </div>
                  </td>
                  <td>{cartItem.itemList[0].itemPrice}</td>
                  <td>
                    <input type='number'
                            min={1}
                            value={cartItem.cartCnt}
                            onChange={(e) => {handleQuantityChange(i, parseInt(e.target.value))}}/>
                  </td>
                  <td>{cartItem.cartCnt*cartItem.itemList[0].itemPrice}</td>
                  <td>{cartItem.cartDate}</td>
                  <td>
                    <button type='button' className='btn btn-primary' onClick={() => {deleteItem(cartItem.cartCode)}}>
                      삭제
                    </button>
                  </td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div className='total-price'>
        <p>￦ {totalPrice.toLocaleString()} 총 구매금액 </p>
      </div>
      <div className='select-button'>
        <button type='button' className='btn btn-primary' >선택삭제</button>
        <button type='button' className='btn btn-primary' >선택구매</button>
      </div>
    </div>
  )
}

export default CartList