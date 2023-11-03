
/*$(document).ready(function() {
  // 정렬 함수
  function sortItems(order) {
    var orderHistory = $('#orderHistory');
    var items = orderHistory.find('.movie-item-style-2').get();
    items.sort(function(a, b) {
      var dateA = new Date($(a).find('.rate span').text().split(': ')[1]);
      var dateB = new Date($(b).find('.rate span').text().split(': ')[1]);
      
      // 날짜를 타임스탬프로 변환하여 비교
      var timestampA = dateA.getTime();
      var timestampB = dateB.getTime();
      

      return order === 'newest' ? timestampB - timestampA : timestampA - timestampB;
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
});*/