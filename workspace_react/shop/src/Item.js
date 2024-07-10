const Item = ({item}) => {
  return(
    <div className="item">
      <img src={process.env.PUBLIC_URL + '/' + item.imgName } />
      <h3>{item.itemName}</h3>
      <p>{item.price}</p>
    </div>
  );
};



export default Item;