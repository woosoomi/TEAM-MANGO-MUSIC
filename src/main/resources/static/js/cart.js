$(document).ready(function() {
    // 전체 선택 체크박스 클릭 시 동작
    $('#selectAll').change(function() {
        var checkboxes = document.getElementsByClassName('checkbox2');
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = this.checked;
        }
    });

/*$('.delete-all-btn').click(function() {
    var checkedItems = document.querySelectorAll('.checkbox2:checked');
    var cartItemIds = Array.from(checkedItems).map(item => item.dataset.cartItemId);
    console.log(cartItemIds);

    if (cartItemIds.length > 0) {
        $.ajax({
            url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart_main/' + cartItemIds,
            type: 'DELETE',
            data: JSON.stringify({ cartItemIds: cartItemIds }), // 변경된 부분
            success: function(response) {
                console.log('삭제 성공:', response);
                // 여기에서 삭제된 상품들을 화면에서 숨기거나 제거하는 작업을 할 수 있습니다.
                
            },
            error: function(error) {
                console.error('삭제 실패:', error);
            }
        });
    } else {
        alert('삭제할 상품을 선택해주세요.');
    }
});*/


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
                alert("삭제 성공");
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


   // 페이지가 로드될 때 실행되는 부분
    var cartId = 1;
    calculateTotalPrice(cartId);

    // 총 가격을 업데이트하는 함수
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
    
    function updateCartItemQuantity(selectElement) {
        var selectedQty = selectElement.value;
        var productPrice = parseFloat(selectElement.parentElement.querySelector('.product-price').textContent);
        var totalPriceElement = selectElement.parentElement.querySelector('.total-price');

        var totalPrice = selectedQty * productPrice;
        totalPriceElement.textContent = totalPrice.toFixed(2) + '원';
    }

    
});