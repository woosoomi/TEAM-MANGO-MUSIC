
//order_history 최신순, 오래된순


$(document).ready(function() {
	var initialData = $('#orderHistory').html(); //페이지 시작할때 타임리프로 구현한 데이터 저장
	var sortSelect = $('#sortSelect');
	var orderHistory = $('#orderHistory');

	function sortOrder(ascending) { //정렬
		var itemList = orderHistory.find('.movie-item-style-2').toArray();
		itemList.sort(function(a, b) {
			var dateA = new Date($(a).find('p').eq(0).text());
			var dateB = new Date($(b).find('p').eq(0).text());
			return ascending ? dateA - dateB : dateB - dateA;
		});
		orderHistory.empty();
		$.each(itemList, function(index, item) {
			orderHistory.append(item);
		});
	}

	sortSelect.on('change', function() {
	var selectedOption = sortSelect.val();
		if (selectedOption === 'newest') {
			sortOrder(false); // 최신순으로 정렬
		} else if (selectedOption === 'oldest') {
			sortOrder(true); // 오래된순으로 정렬
		}
	});

});
			   	 