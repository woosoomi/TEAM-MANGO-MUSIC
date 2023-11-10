//체크박스 전체선택, 개별선택
const allChk = document.querySelector('#checkboxAll');
allChk.addEventListener('click', function() {
	const isChecked = allChk.checked;
	const checkbox = document.querySelectorAll('.checkbox');

	if (isChecked) {
		for (i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = true;

		}
	} else {
		for (i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = false;
		}
	}
});

const checkbox = document.querySelectorAll('.checkbox');
for (const e of checkbox) {
	e.addEventListener('click', e => {
		const cnt = checkbox.length;
		const checkedCnt = document.querySelectorAll('.checkbox:checked').length;
		if (cnt == checkedCnt) {
			document.querySelector('#checkboxAll').checked = true;
		} else {
			document.querySelector('#checkboxAll').checked = false;
		}
	})
}

//전체삭제,선택삭제
$('.delete-all-btn').click(function() {
	var checkedItems = document.querySelectorAll('.checkbox:checked');
	var cartItemIds = Array.from(checkedItems).map(item => parseInt(item.dataset.cartItemId));

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

//수량변경
function changeQuantity(amount, element) {
	let cartItemQtyElement = element.parentElement.querySelector('#cartItemQty');
	let currentQty = parseInt(cartItemQtyElement.value);
	let newQty = currentQty + amount;
	let relatedTextbox = element.parentElement.querySelector('.test');
	var cartItemId = relatedTextbox.dataset.cartitemid;
	//let cartTotPriceElement = document.getElementById('priceTest');
	//let cartTot = parseInt(cartTotPriceElement.value);

	if (newQty >= 1) {
		cartItemQtyElement.value = newQty;
	}
	//수량변경 후 가격 업데이트
	$.ajax({
		url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/updateQty/' + cartItemId,
		type: 'POST',
		data: { cartItemId: cartItemId, cartItemQty: newQty, cartTot: cartTot },
		success: function(data) {
			console.log('카트 아이템 수량이 업데이트되었습니다.');
			let newPrice = data.cartTot;
			$('#price100 span#totalPrice').text(newPrice + '원');
			//document.getElementById('cartTotPrice').innerHTML = newPrice + '원';
			//location.reload();
			calculateTotalPrice(cartId);
		},
		error: function() {
			console.error('카트 아이템 수량 업데이트 중 오류가 발생했습니다.');
		}
	});
}

//수량별 가격 업데이트
//var cartId=5
//calculateTotalPrice(cartId)
function calculateTotalPrice(cartId) {
	var cartIdElement = document.getElementById('cartId');
	var cartId = cartIdElement.value;
	console.log(cartId);
	$.ajax({
		url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/' + cartId,
		type: 'GET',
		success: function(data) {
			let newPrice = data.cartTotPrice;
			//document.getElementById('cartTotPrice').innerHTML = newPrice + '원';
			console.log(document.getElementById('cartTotPrice'));
			$('#cartTotPrice100 span#cartTotPrice').text('총 주문금액 : ' + newPrice + '원');
		},
		error: function(error) {
			console.error('Error:', error);
		}
	});
}



/*document.querySelectorAll('.checkbox2').forEach(function(checkbox) {
	checkbox.addEventListener('change', function() {
		if (!this.checked) {
			var cartId = 5;
			var cartTotPriceElement = document.getElementById('priceTest');
			var cartTot = parseInt(cartTotPriceElement.value);
			calculateTotalPrice(cartId);
			function calculateTotalPrice(cartId) {
				var checkedItems = document.querySelectorAll('.checkbox2:not(checked)');
				var cartItemIds = Array.from(checkedItems).map(item => parseInt(item.dataset.cartItemId));
				if (cartItemIds.length > 0) {
					$.ajax({
						url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/' + cartId,
						type: 'GET',
						success: function(data) {
							var newPrice = data.cartTotPrice;
							var tot = newPrice-cartTot;
							//document.getElementById('cartTotPrice').innerHTML = newPrice + '원';
							console.log(document.getElementById('cartTotPrice'));
							$('#cartTotPrice100 span#cartTotPrice').text('총 주문금액 : ' + tot + '원');
						},
						error: function(error) {
							console.error('Error:', error);
						}
					});
				}

			}
		}else {
			var cartId = 5;
			var cartTotPriceElement = document.getElementById('priceTest');
			var cartTot = parseInt(cartTotPriceElement.value);
			calculateTotalPrice(cartId);
			function calculateTotalPrice(cartId) {
				var checkedItems = document.querySelectorAll('.checkbox2:not(checked)');
				var cartItemIds = Array.from(checkedItems).map(item => parseInt(item.dataset.cartItemId));
				if (cartItemIds.length > 0) {
					$.ajax({
						url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/' + cartId,
						type: 'GET',
						success: function(data) {
							var newPrice = data.cartTotPrice;
							var tot = newPrice+cartTot;
							//document.getElementById('cartTotPrice').innerHTML = newPrice + '원';
							console.log(document.getElementById('cartTotPrice'));
							$('#cartTotPrice100 span#cartTotPrice').text('총 주문금액 : ' + tot + '원');
						},
						error: function(error) {
							console.error('Error:', error);
						}
					});
				}

			}
		}
	});
});
*/

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




