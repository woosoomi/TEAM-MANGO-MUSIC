
// 전체 선택 체크박스 클릭 시 동작
$('#selectAll').change(function() {
	var checkboxes = document.getElementsByClassName('checkbox2');
	for (var i = 0; i < checkboxes.length; i++) {
		checkboxes[i].checked = this.checked;
	}
});

$('.delete-all-btn').click(function() {
	var checkedItems = document.querySelectorAll('.checkbox2:checked');
	var cartItemIds = Array.from(checkedItems).map(item => parseInt(item.dataset.cartItemId)); // cartItemId를 숫자로 변환
	console.log(cartItemIds);

	if (cartItemIds.length > 0) {
		$.ajax({
			url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/deleteByCartItems',
			type: 'DELETE',
			contentType: 'application/json',
			data: JSON.stringify(cartItemIds),
			success: function(response) {
				console.log('삭제 성공:', response);
				alert("삭제되었습니다.");
				location.reload();
			},
			error: function(error) {
				console.error('삭제 실패:', error);
			}
		});
	} else {
		alert('삭제할 상품을 선택해주세요.');
	}
});

// 총 가격을 업데이트하는 함수

function changeQuantity(amount, element) {
	var cartItemQtyElement = element.parentElement.querySelector('#cartItemQty');
	var currentQty = parseInt(cartItemQtyElement.value);
	var newQty = currentQty + amount;

	var relatedTextbox = element.parentElement.querySelector('.test');
	var cartItemId = relatedTextbox.dataset.cartitemid;
	if (newQty >= 1) {
		cartItemQtyElement.value = newQty;

		$.ajax({
			url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/updateQty/' + cartItemId,
			type: 'POST',
			data: { cartItemId: cartItemId, cartItemQty: newQty },
			success: function(data) {
				console.log('카트 아이템 수량이 업데이트되었습니다.');
				var newPrice = data.cartTotPrice;
				document.getElementById('cartTotPrice').innerHTML = newPrice + '원';
				location.reload();
			},
			error: function() {
				console.error('카트 아이템 수량 업데이트 중 오류가 발생했습니다.');
			}
		});
	}
}
function calculateTotalPrice(cartId) {
	console.log(cartId);
	$.ajax({
		url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/' + cartId,
		type: 'GET',
		success: function(data) {
			document.getElementById('cartTotPrice').innerHTML = data.cartTotPrice + '원';
			console.log(document.getElementById('cartTotPrice'));
		},
		error: function(error) {
			console.error('Error:', error);
		}
	});
}
