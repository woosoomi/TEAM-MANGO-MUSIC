

// AJAX 요청 미구현 추후 구현 예정

function voteButtonClicked(voteId) {
    // AJAX 요청을 보냅니다.
    $.ajax({
        type: "PUT", // HTTP PUT 요청
        url: "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/voteProduct/update", // 업데이트 엔드포인트 URL
        contentType: "application/json",
        data: JSON.stringify({ voteId: voteId }), // 업데이트할 데이터
        success: function (data) {
            // 성공적으로 업데이트가 완료되면 이 부분이 실행됩니다.
            alert("투표가 완료되었습니다.");
        },
        error: function (xhr, textStatus, errorThrown) {
            // 오류가 발생하면 이 부분이 실행됩니다.
            alert("투표 업데이트 중 오류가 발생했습니다.");
        }
    });
}






// endDate는 추후 VoteDate의 데이터로 변경예정
var endDate = new Date('2023-11-15T23:59:59').getTime();

        // 카운트다운 업데이트 함수
        function updateCountdown() {
            var now = new Date().getTime();
            var timeLeft = endDate - now;

            if (timeLeft < 0) {
                document.getElementById('countdown-timer').innerHTML = "투표종료";
            } else {
                var days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
                var hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

                document.getElementById('days').innerHTML = days;
                document.getElementById('hours').innerHTML = hours;
                document.getElementById('minutes').innerHTML = minutes;
                document.getElementById('seconds').innerHTML = seconds;
            }
        }

        // 매 초마다 카운트다운 업데이트
        var countdownInterval = setInterval(updateCountdown, 1000);
