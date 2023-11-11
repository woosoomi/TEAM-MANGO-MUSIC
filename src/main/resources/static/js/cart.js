$(document).ready(function() {
	// 페이지 로딩이 완료되면 실행될 코드
	calculateTotalPrice();

	//체크박스 전체선택과,개별선택 코드
	const allChk = document.querySelector('#checkboxAll');
	const checkboxes = document.querySelectorAll('.checkbox');

	allChk.addEventListener('click', function() {
		const isChecked = allChk.checked;
		checkboxes.forEach(function(checkbox) {
			checkbox.checked = isChecked;
		});
		calculateTotalPrice();
	});

	checkboxes.forEach(function(checkbox) {
		checkbox.addEventListener('click', function() {
			const cnt = checkboxes.length;
			const checkedCnt = document.querySelectorAll('.checkbox:checked').length;
			allChk.checked = cnt === checkedCnt;
			calculateTotalPrice();
		});
	});

	//장바구니 상품 삭제 기능
	$('.delete-all-btn').click(function() {
		const checkedItems = document.querySelectorAll('.checkbox:checked');
		const cartItemIds = Array.from(checkedItems).map(item => parseInt(item.dataset.cartItemId));

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

	// 수량변경 이벤트 리스너 연결
	$('.change-quantity-btn').click(function() {
		const amount = 1; // 변경할 수량
		const element = this; // 클릭된 버튼 엘리먼트
		changeQuantity(amount, element);
	});

});

// view 맨 아래 총 주문금액 계산
function calculateTotalPrice() {
	// 모든 체크박스 엘리먼트 선택
	const checkboxes = document.querySelectorAll('.checkbox');
	let total = 0;

	// 비동기 함수를 동기적으로 처리하기 위해 콜백 함수 사용
	// async await를 쓰려고 했지만 세미콜론 에러 발생해서 콜백 함수 사용함
	function processCheckbox(index) {
		if (index < checkboxes.length) {
			const checkbox = checkboxes[index];
			const cartItemId = checkbox.dataset.cartItemId;
			const productQty = 1;

			// Ajax 호출을 통해 상품 가격을 서버에서 가져옴
			$.ajax({
				url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/calculate/' + cartItemId,
				type: 'GET',
				dataType: 'json',
				success: function(data) {
					const productPrice = parseFloat(data);

					// 체크된 경우에만 가격을 더함
					if (checkbox.checked) {
						total += productPrice * productQty;
					}

					// 새로운 가격으로 updateTotalPrice 호출
					updateTotalPrice(cartItemId);

					// 다음 체크박스 처리
					processCheckbox(index + 1);
				},
				error: function(error) {
					console.error('Error:', error);

					// 에러가 발생하더라도 다음 체크박스 처리
					processCheckbox(index + 1);
				}
			});
		} else {
			// 전체 주문금액 업데이트
			const formattedTotal = formatNumberWithCommas(total);
			$('#cartTotPrice100 span#cartTotPrice').text('총 주문금액 : ' + formattedTotal + '원');
		}
	}
	processCheckbox(0);
}

// 상품 수량 변경, 수량변경으로 인한 함수 호출로 총 주문금액, 개별 상품 금액 업데이트
function changeQuantity(amount, element) {
	const cartItemQtyElement = element.parentElement.querySelector('#cartItemQty');
	const currentQty = parseInt(cartItemQtyElement.value);
	const newQty = currentQty + amount;
	const relatedTextbox = element.parentElement.querySelector('.test');
	const cartItemId = relatedTextbox.dataset.cartitemid;

	if (newQty >= 1) {
		cartItemQtyElement.value = newQty;

		// 서버에 수량 업데이트를 요청
		$.ajax({
			url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/updateQty/' + cartItemId,
			type: 'POST',
			data: { cartItemId: cartItemId, cartItemQty: newQty },
			success: function(data) {
				console.log('카트 아이템 수량이 업데이트되었습니다.');
				// 개별 상품의 가격 업데이트
				updateTotalPrice(cartItemId);
				// 전체 주문금액 재계산
				calculateTotalPrice();
			},
			error: function() {
				console.error('카트 아이템 수량 업데이트 중 오류가 발생했습니다.');
			}
		});
	}
}

// 개별 상품 수량변경으로 인한 금액 업데이트
function updateTotalPrice(cartItemId) {
	$.ajax({
		url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/calculate/' + cartItemId,
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			const formattedPrice = formatNumberWithCommas(parseFloat(data));
			$('#totalPrice[data-cartItemId="' + cartItemId + '"]').html(formattedPrice + '원');
		},
		error: function(error) {
			console.error('Error:', error);
		}
	});
}

// 상품 수량 text로 수량변경, 함수호출로 총금액,개별금액 업데이트
function updateQuantity(input) {
	input.addEventListener('input', function() {
		const newQty = parseInt(input.value);
		if (!isNaN(newQty) && newQty >= 1) {
			const relatedTextbox = input.parentElement.querySelector('.test');
			const cartItemId = relatedTextbox.dataset.cartitemid;

			// 서버에 수량 업데이트를 요청
			$.ajax({
				url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/updateQty/' + cartItemId,
				type: 'POST',
				data: { cartItemId: cartItemId, cartItemQty: newQty },
				success: function(data) {
					console.log('카트 아이템 수량이 업데이트되었습니다.');
					// 개별 상품의 가격 업데이트
					updateTotalPrice(cartItemId);
					// 전체 주문금액 재계산
					calculateTotalPrice();
				},
				error: function() {
					console.error('카트 아이템 수량 업데이트 중 오류가 발생했습니다.');
				}
			});
		} else {
			console.log('유효하지 않은 수량입니다.');
		}
	});
}

// 천의자리수마다 콤마표시
function formatNumberWithCommas(number) {
	return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/*function goBuy(){
	const checkedCnt = document.querySelectorAll('.checkbox:checked').length;
	if(checkedCnt == 0){
		alert("선택한 상품이 없습니다.");
		return;
	}
	
	let cartTotPrice = 0;
	let cartItemQty = 0;
	for(const check of checkedBoxes){
		const price = document.getElementById('productPrice').innerHTML;
		cartTotPrice = cartTotPrice + parseInt(price);
			
		const buyCnt = document.getElementById('cartItemQty').innerHTML;
		cartItemQty = cartItemQty + buyCnt;
		 
	}
	
}*/