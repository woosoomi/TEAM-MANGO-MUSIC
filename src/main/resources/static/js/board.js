$(document).ready(function() {
	// 이벤트 핸들러 추가
	$('#sortSelect').on('change', function() {
		var selectedOption = this.value;
		var url = selectedOption === 'oldest' ? "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/inquiries/reverseSort?categoryId=4&userId=why3795" : "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/inquiries/sort?categoryId=4&userId=why3795";


		$.get(url, function(data) {
			// 데이터를 가져왔으므로 페이지 업데이트를 수행
			displayData(data);
			console.log(data);

		});
	});
});



function displayData(data) {
	var container = $('.ceb-infor');
	container.empty();

	data.forEach(function(item) {
		var newRow = $('<div class="row">');
		var newItem = $('<div class="col-md-12">');
		var itemHtml = '<div class="ceb-item-style-2">' +
			'<div class="ceb-infor">' +
			'<h2>' +
			'<a href="celebritysingle.html">' + item.boardTitle + '</a>' +
			'</h2>' +
			'<p>' + item.createdTime + '</p>' +
			'<p>' + (item.boardType && item.boardType.boardTypeTitle ? item.boardType.boardTypeTitle : 'XXX') + '</p>' +
			'<span>' + item.boardContent + '</span>' +
			'</div>' +
			'</div>';
		newRow.append(newItem);
		newItem.html(itemHtml);
		newRow.append(newItem);
		container.append(newRow);
	});
}






