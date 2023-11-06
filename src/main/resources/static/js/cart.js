$(document).ready(function() {
    // 전체 선택 체크박스가 변경될 때 실행되는 부분
    $('#selectAll').change(function() {
        var checkboxes = document.getElementsByClassName('checkbox');
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = this.checked;
        }
    });
    // 삭제 버튼 클릭 시 실행되는 부분
    $('.delete-btn').click(function() {
        var checkedItems = document.querySelectorAll('.checkbox:checked');
        var cartItemIds = Array.from(checkedItems).map(item => item.dataset.cartItemId);

        // AJAX 요청을 사용하여 서버에 삭제 요청을 보냅니다.
        $.ajax({
            url: '/2023-05-JAVA-DEVELOPER-final-project-team1-mango/cart',
            type: 'DELETE',
            data: JSON.stringify(cartItemIds),
            success: function(response) {
                console.log('삭제 성공:', response);
                // 여기에서 삭제된 상품들을 화면에서 숨기거나 제거하는 작업을 할 수 있습니다.
            },
            error: function(error) {
                console.error('삭제 실패:', error);
            }
        });
    });

    // 페이지가 로드될 때 실행되는 부분
    var cartId = 1;
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
    }
});
