
$(document).ready(function() {
  // 정렬 함수
  function sortItems(order) {
    var orderHistory = $('#orderHistory');
    var items = orderHistory.find('.movie-item-style-2').get();
    items.sort(function(a, b) {
      var dateA = new Date($(a).find('.rate span').text().split(': ')[1]);
      var dateB = new Date($(b).find('.rate span').text().split(': ')[1]);
      console.log(dateA)
      console.log(dateB)
      // 날짜 객체를 사용하여 비교
      if (order === 'newest') {
        return dateB - dateA;
      } else {
        return dateA - dateB;
      }
    });
    orderHistory.empty();
    $.each(items, function(i, item) {
      orderHistory.append(item);
    });
  }

  // 선택 요소의 변경 이벤트를 감지
  $('#sortSelect').change(function() {
    var selectedOption = $(this).val();
    sortItems(selectedOption);
  });

  // 페이지 로드 시 최신순으로 정렬
  sortItems('newest');
});


/////////삭제버튼/////////////

document.addEventListener("DOMContentLoaded", function() {
    // 삭제 버튼을 클릭할 때
    var deleteButton = document.getElementById("deleteItem");
    deleteButton.addEventListener("click", function() {
        var oiId = deleteButton.getAttribute("data-order-id");
        
        // AJAX 요청을 보냅니다.
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost/2023-05-JAVA-DEVELOPER-final-project-team1-mango/order_history/delete/" + oiId, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                if (response.status === "success") {
                    // 삭제 성공 시 실행할 코드
                    alert("주문내역이 삭제되었습니다.");
                    // 페이지 새로고침 또는 다른 업데이트 작업 수행
                } else {
                    // 삭제 실패 시 실행할 코드
                    alert("주문내역 삭제 중 오류가 발생했습니다.");
                }
            }
        };
        xhr.send("orderitemId=" + oiId);
    });
});