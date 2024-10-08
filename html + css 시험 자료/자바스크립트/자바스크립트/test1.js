//item_list는 현재 쇼핑몰에서 판매하고 있는 상품들의 목록 정보이다.
//아래 데이터를 참고하여 요구사항을 해결하시오.
const item_list = [
  {
    item_name : '여름 셔츠',
    price : 25000,
    brand : 'java마켓',
    size : [90, 100, 110]
  },
  {
    item_name : '라운드 티',
    price : 20000,
    brand : 'java마켓',
    size : [90, 95, 100, 105, 110]
  },
  {
    item_name : '데님 청바지',
    price : 30000,
    brand : 'python마켓',
    size : [90, 100, 110, 120]
  },
  {
    item_name : '슬림 면바지',
    price : 35000,
    brand : 'python마켓',
    size : [90, 95, 100]
  }
];

//1. 'java마켓'에서 팔고 있는 상품들의 상품명과 가격을 각각 콘솔창에 출력하여라.
item_list.forEach(function(java, i){
  if(java.brand == 'java마켓'){
    console.log(java.item_name, java.price);
  }
});

//2. 95사이즈를 구매할 수 있는 상품들의 상품명을 콘솔창에 출력하시오.
item_list.forEach(function(java, i){
  for(let i = 0; i < java.size.length; i++){
    if(java.size[i] == 95){
      console.log(java.item_name)
    }
  }
});

//3. '등록 및 출력' 버튼을 클릭하면 입력 내용 저장 후 콘솔창에 데이터를 출력하시오.
function addItem(){
  const item_name1 = document.querySelector('#itemName');
  const price1 = document.querySelector('#price');
  const brand1 = document.querySelector('#brand');
  const size1 = document.querySelectorAll('.size');

  const input1 = item_name1.value;
  const input2 = price1.value;
  const input3 = brand1.value;

  

  item_list.push({item_name : input1, price : input2, brand : input3, });

  console.log(item_list);
}
