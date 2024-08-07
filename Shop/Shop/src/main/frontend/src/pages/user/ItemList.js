
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import './ItemList.css'

const ItemList = () => {

  const [itemList, setItemList] = useState([]);

  useEffect(() => {
    axios.get('/api_admin/getItemList')
    .then((res) => {
      setItemList(res.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, []);

  return (
    <div>
      <table className='item-table'>
        <tbody>
          {
            itemList.map((item, i) => {
              return(
                <tr key={i}>
                  <td>{item.itemName}</td>
                  <td>{item.itemPrice}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default ItemList