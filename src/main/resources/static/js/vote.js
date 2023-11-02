



function voteButtonClicked(voteId) {
    // AJAX 요청을 보냅니다.
    $.ajax({
        type: "PUT", // HTTP PUT 요청
        url: "/voteProduct/update", // 업데이트 엔드포인트 URL
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