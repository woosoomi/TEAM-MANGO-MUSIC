
function voteButtonClicked(button) {
    // 사용자 ID와 투표 ID 추출
    var voteId = $(button).data("voteid");
    var userId = $(button).data("userid");
	console.log(userId);
	console.log(voteId);
    // 회원 투표 업데이트 실행
    $.ajax({
        type: "PUT",
        url: `/2023-05-JAVA-DEVELOPER-final-project-team1-mango/userVoteUpdate/${userId}/${voteId}`,
        contentType: "application/json",
        success: function (userData) {
            // 회원 투표 업데이트 실행 후, 투표 업데이트
            $.ajax({
                type: "PUT",
                url: "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/voteProduct/update",
                contentType: "application/json",
                data: JSON.stringify({ voteId: voteId }),
                success: function (data) {
                    alert("투표가 완료되었습니다.");
                    window.location.href = "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/productVote";
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert("투표 업데이트 중 오류가 발생했습니다.");
                }
            });
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("로그인이 필요한 서비스입니다.");
             window.location.href = "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/user_login_form";
        }
    });
}


/*
function voteButtonClicked(button) {
    // 클릭된 버튼에서 data-voteid 값을 얻어옵니다.
     const voteId = button.getAttribute("data-voteid");
     console.log(voteId);
	
	// 회원에게 voteId업데이트
	$.ajax({
		type: "PUT",
        url: "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/userVoteUpdate/{userId}/{voteId}",
        contentType: "application/json",
        data: JSON.stringify({ voteId: voteId }),
        success: function (data) {
            alert("투표가 완료되었습니다.");
   		
        
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("로그인이 필요한 메뉴입니다");
            window.location.href = "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/user_login_form"; 
     
        }
    });
	
   // 회원 투표 합으로 tot 업데이트.
    $.ajax({
        type: "PUT",
        url: "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/voteProduct/update",
        contentType: "application/json",
        data: JSON.stringify({ voteId: voteId }),
        success: function (data) {
            alert("투표가 완료되었습니다.");
   			window.location.href = "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/productVote"; 
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("투표 업데이트 중 오류가 발생했습니다.");
        }
    });
    
}

*/

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
