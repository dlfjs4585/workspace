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

console.log('\n');

for(let i = 0; i < item_list.length; i++){
  if(item_list[i].brand == 'java마켓'){
    console.log(item_list[i].item_name, item_list[i].price);
  }
}

console.log('\n');

for(const e of item_list){
  if(e.brand == 'java마켓'){
    console.log(e.item_name, e.price);
  }
}

console.log('\n');

//2. 95사이즈를 구매할 수 있는 상품들의 상품명을 콘솔창에 출력하시오.
item_list.forEach(function(java, i){
  for(let i = 0; i < java.size.length; i++){
    if(java.size[i] == 95){
      console.log(java.item_name)
    }
  }
});

console.log('\n');

//3. '등록 및 출력' 버튼을 클릭하면 입력 내용 저장 후 콘솔창에 데이터를 출력하시오.
function addItem(){
  const arr = [];

  //체크박스
  const chks = document.querySelectorAll('.size:checked');
  chks.forEach((chk, i) => {
    arr.push(chk.value);
  });

  // 추가할 객체
  const add_data = {
    item_name : document.querySelector('#itemName').value,
    price : document.querySelector('#price').value,
    brand : document.querySelector('#brand').value,
    size : arr
  }
  item_list.push(add_data);

  console.log(item_list);



}
