
function setAvgAge(){
  const age_Tag = document.querySelectorAll('.ageTd');
  let sum = 0;
  let avg = 0;
  age_Tag.forEach(function(tag, i){
    sum += Number(tag.textContent);
  });
  avg = sum/3;

  const result =document.querySelector('#resultTd');

  result.innerHTML = '';
  result.insertAdjacentHTML('beforeend', avg)
}

