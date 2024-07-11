import { useParams } from 'react-router-dom';
import './Detail.css'

const Detail = ({item_list}) => {

  // url로 전달되는 데이터 받기
  // params 는 변수!!
  // 1번 방식
  // const params = useParams();
  // console.log(params.id);

  const {id} = useParams();
  console.log(id);

  // 이런 방식으로도 가능.
  // let findItem = null;
  // item_list.forEach((item, i) => {
  //   if(item.itemNum == id){
  //     findItem = item;
  //   }
  // });
  // 이 방식으로 하면 findItem.~ 으로 값을 넣어주면 됨.

  return(
    <div className="detail-all">
      <div className="detail">
        <img src={process.env.PUBLIC_URL + '/' +  item_list[id-1].imgName} />
        <div>
          <h3>{item_list[id-1].itemName}</h3>
          <h3>{item_list[id-1].price}</h3>
          <button type="button">주문하기</button>
        </div>
      </div>
      <div className="intro">{item_list[id-1].intro}</div>
    </div>
  );
}

export default Detail;