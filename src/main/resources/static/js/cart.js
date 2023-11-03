$(document).ready(function() {
	$('#selectAll').change(function() {
		var checkboxes = document.getElementsByClassName('checkbox');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = this.checked;
		}
	});

	$('.delete-btn').click(function() {
		var cartItemId = $(this).data('cart-item-id');
		// AJAX 요청을 사용하여 서버에 삭제 요청을 보냅니다.
		$.ajax({
			url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart/' + cartItemId, // REST 컨트롤러의 엔드포인트 경로
			type: 'DELETE',
			success: function(response) {
				// 삭제 성공 시 실행할 코드
				console.log('삭제 성공:', response);
			},
			error: function(error) {
				// 삭제 실패 시 실행할 코드
				console.error('삭제 실패:', error);
			}
		});
	});
	
});
document.addEventListener('DOMContentLoaded', function(e) {
    var cartId = 8;
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
