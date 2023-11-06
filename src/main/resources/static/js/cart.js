$(document).ready(function() {
	$('#selectAll').change(function() {
		var checkboxes = document.getElementsByClassName('checkbox');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = this.checked;
		}
	});

$('.delete-btn').on("click", (function() {
    var cartItemId = $(this).data('cart-item-id'); // data-cart-item-id의 값을 가져옴
    $.ajax({
        url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart/' + cartItemId,
        type: 'DELETE',
        success: function(response) {
            console.log('삭제 성공:', response);
        },
        error: function(error) {
            console.error('삭제 실패:', error);
        }
    });
}));

document.addEventListener('DOMContentLoaded', function(e) {
	var cartId = 1;
	// 페이지가 로드될 때 실행되는 부분
	calculateTotalPrice(cartId);
	// 총 가격을 업데이트하는 함수
	function calculateTotalPrice(cartId) {
		console.log(cartId);
		$.ajax({
			url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart/' + cartId,
			type: 'GET',
			success: function(data) {
				document.getElementById('cartTotPrice').innerHTML = data.cartTotPrice + '원';
				console.log(document.getElementById('cartTotPrice'));
			},
			error: function(error) {
				console.error('Error:', error);
			}
		});
		e.preventDefault();
	}
});
});