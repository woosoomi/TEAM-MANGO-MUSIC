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

    var cartId = 1; // 적절한 값을 넣어주세요.

    document.addEventListener('DOMContentLoaded', function() {
        // 페이지가 로드될 때 실행되는 부분

        // 주문하기 버튼 클릭 시 이벤트
        document.querySelector('button').addEventListener('click', function() {
            fetch('/calculateTotalPrice/' + cartId)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    // 서버에서 받은 데이터(data)를 처리하는 코드 작성
                    document.getElementById('totPrice').innerHTML = data + '원';
                })
                .catch(error => {
                    // 에러 처리 코드 작성
                    console.error('Error:', error);
                });
        });
    });
