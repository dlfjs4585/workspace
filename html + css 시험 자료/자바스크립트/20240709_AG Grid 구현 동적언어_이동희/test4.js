function checkAllMenu(){
  const chk_all = document.querySelector('#chk_all');
  const input = document.querySelectorAll('input');
  if(chk_all.checked){
    for(const checks of input){
      checks.checked = true;
    }
  }else{
    for(const checks of input){
      checks.checked = false;
    }
  }
}

function checkAllOption(e){

  // 다음 형제 노드 찾아감
  const ul = e.nextElementSibling;

  const input = ul.querySelectorAll('input')

  if(e.checked){
    for(const checks of input){
      checks.checked = true;
    }
  }else{
    for(const checks of input){
      checks.checked = false;
    }
  }

}