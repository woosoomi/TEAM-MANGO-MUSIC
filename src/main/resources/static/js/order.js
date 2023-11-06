
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
    document.querySelectorAll(".deleteButton").forEach(function(button) {
        button.addEventListener("click", function() {
            var oiId = button.getAttribute("data-order-id");
            
            console.log(oiId)
            // AJAX 요청을 보냅니다.
            var xhr = new XMLHttpRequest();
            // 주문 ID를 동적으로 대체
       		var url = '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/orderItem/delete/'+ oiId; // 결제 처리를 수행하는 서버 엔드포인트 URL
            xhr.open("DELETE", url, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
			    if (xhr.readyState === 4) {
			        if (xhr.status === 200) {
			            alert("주문내역이 삭제되었습니다.");
			            // 페이지 새로고침 또는 다른 업데이트 작업 수행
			               window.location.reload();
			        } else {
			            alert("주문내역 삭제 중 오류가 발생했습니다.");
			        }
			    }
			};
            // 요청 데이터를 동적으로 설정
			xhr.send(JSON.stringify({ oiId: oiId }));
        });
    });
});