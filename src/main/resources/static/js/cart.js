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
            url: '/cartItem/' + cartItemId, // REST 컨트롤러의 엔드포인트 경로
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