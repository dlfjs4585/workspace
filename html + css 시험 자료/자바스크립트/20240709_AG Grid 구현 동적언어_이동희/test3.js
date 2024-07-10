function setTable(){
  const row = document.querySelector('#rowInput').value;

  const col = document.querySelector('#colInput').value;

  let div = '';
  for(let i = 1; i <= row; i++){
    div += `<tr>`;
    for(let j = 1; j <= col; j++){
      div += (`<td>${i}행${j}열</td>`)
    }
    div += `</tr>`;
  }
  const colRow = `
    <table>
      ${div}
	  </table>
  `;

  const table = document.querySelector('.table-div');
  table.innerHTML ='';
  table.insertAdjacentHTML('beforeend', colRow);

}