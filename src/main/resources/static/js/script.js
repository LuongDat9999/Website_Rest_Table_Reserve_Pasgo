// dropdown.js
document.addEventListener('DOMContentLoaded', function() {
    const dropdowns = document.querySelectorAll('.dropdown');
  
    dropdowns.forEach(dropdown => {
      const select = dropdown.querySelector('.select');
      const caret = dropdown.querySelector('.caret');
      const option = dropdown.querySelector('.option');
      const options = dropdown.querySelectorAll('.option li');
      const selected = dropdown.querySelector('.selected');
  
      select.addEventListener('click', () => {
        select.classList.toggle('select-clicked');
        caret.classList.toggle('caret-rotate');
        option.classList.toggle('option-open');
      });
  
      options.forEach(chooseoption => {
        chooseoption.addEventListener('click', () => {
          selected.innerText = chooseoption.innerText;
          select.classList.remove('select-clicked');
          caret.classList.remove('caret-rotate');
          option.classList.remove('option-open');
  
          options.forEach(option => {
            option.classList.remove('active');
          });
  
          chooseoption.classList.add('active');
        });
      });
    });
  });
  

  //------ Save key word ------
  function saveKeyword() {
    const queryInput = document.getElementById('query-input');
    const keyword = queryInput.value.trim();
  
    if (keyword) {
      let keywords = JSON.parse(sessionStorage.getItem('keywords')) || [];
      keywords = keywords.filter(k => k !== keyword);
      
      keywords.unshift(keyword);
  
      if (keywords.length > 4) {
        keywords.pop();
      }
  
      sessionStorage.setItem('keywords', JSON.stringify(keywords));
      displayKeywords();
    }
  }
  
  
  function displayKeywords() {
    const keywords = JSON.parse(sessionStorage.getItem('keywords')) || [];
    const keywordList = document.getElementById('recent-keywords-list');
    keywordList.innerHTML = '';
  
    keywords.forEach(function (keyword) {
      const listItem = document.createElement('li');
      listItem.className = 'fm-key';
      listItem.textContent = keyword;
      listItem.onclick = function () {
        document.getElementById('query-input').value = keyword;
        document.getElementById('search-form').submit(); 
      };
      keywordList.appendChild(listItem);
    });
  }
  
  function openPropose() {
    document.getElementById("propose-box").style.display = "block";
    document.getElementById("brg-propose-box").style.display = "block";
    displayKeywords();
  }
  
  function closePropose() {
    document.getElementById("propose-box").style.display = "none";
    document.getElementById("brg-propose-box").style.display = "none";
  }
  window.onload = displayKeywords;

  function removeDiacritics(str) {
    // Chuyển đổi các ký tự có dấu thành ký tự không dấu
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}

function wordSuggess() {
    var input, filter, ul, li, a, i, hasResults = false;
    input = document.getElementById("query-input");
    filter = removeDiacritics(input.value.toUpperCase().trim());  // Loại bỏ khoảng trắng và dấu
    ul = document.getElementById("myMenu");
    li = ul.getElementsByTagName("li");
  
    // Lặp qua tất cả các phần tử li
    for (i = 0; i < li.length; i++) {
      a = li[i].getElementsByTagName("a")[0];
      var content = removeDiacritics(a.innerHTML.toUpperCase());
      console.log("Filter:", filter, "Content:", content);
      if (content.indexOf(filter) > -1) {
        li[i].style.display = ""; // Hiển thị các từ khóa khớp với tìm kiếm
        hasResults = true;
      } else {
        li[i].style.display = "none"; // Ẩn các từ khóa không khớp
      }
    }
  
    // Hiển thị hoặc ẩn danh sách tùy thuộc vào kết quả tìm kiếm
    if (hasResults && filter) {
      ul.classList.add("show");
    } else {
      ul.classList.remove("show");
    }
}
