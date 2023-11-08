
document.addEventListener('DOMContentLoaded', function() {
	const searchInput = document.getElementById('searchInput');
	const musicContainer = document.getElementById('musicList');
	var initialData = $('#musicList').html();

	searchInput.addEventListener('keyup', function(event) {
		//타자 넣을때마다 검색 (key up) -> 검색칸 조건 X
		if (true) {
			const searchValue = searchInput.value;
			console.log(searchValue);
			filterItems(searchValue);
		}
	});

	var itemList = $(initialData).find('.movie-item-style-2').toArray();
	console.log(itemList);

	function filterItems(searchQuery) {
		musicContainer.innerHTML = '';


		itemList.forEach(function(item) {

			var musicName = $(item).find('.musicName').text();
			console.log(musicName);
			var artist = $(item).find('.artist').text();



			if (musicName.toLowerCase().startsWith(searchQuery.toLowerCase())) {
				musicContainer.appendChild(item);
			}
			if (artist.toLowerCase().startsWith(searchQuery.toLowerCase())) {
				musicContainer.appendChild(item);
			}
		});

	}
});

/*내림차순 */
/*$(document).ready(function() {
	var initialData = $('#musicList').html();
	var rankCount = $('#rank');
	var musicContainer = $('#musicList');
	
	function sortRank(ascending){
		var itemList = musicContainer.find('.movie-item-style-2').toArray();
		itemList.sort(function(a,b){
			var dataA = new Data($(a).find('p').eq(3).text());
			var dataB = new Data($(b).find('p').eq(3).text());
			return ascending ? dataB - dataA : dataA - dataB;
		});
		musicContainer.empty();
		$.each(itemList, function(index,item){
			musicContainer.append(item);
			
		});
	}
		rankCount.on('change', function() {
		var selectedOption = rankCount.val();
		if (selectedOption === 'latest') {
			sortRank(false); // 최신순으로 정렬
			}
		});
	});
*/




///////////goods list////////////
/*document.addEventListener('DOMContentLoaded', function() {
	const searchInput = document.getElementById('searchInput');
	const goodsContainer = document.getElementById('goodsList');
	var initialData = $('#goodsList').html();

	searchInput.addEventListener('keyup', function(event) {
		//타자 넣을때마다 검색 (key up) -> 검색칸 조건 X
		if (true) {
			const searchValue = searchInput.value;
			console.log(searchValue);
			filterItems(searchValue);
		}
	});

	var itemList = $(initialData).find('.movie-item-style-2').toArray();
	console.log(itemList);

	function filterItems(searchQuery) {
		goodsContainer.innerHTML = '';


		itemList.forEach(function(item) {

			var goodsName = $(item).find('.goodsName').text();
			console.log(goodsName);
			//var artist = $(item).find('.artist').text();



			if (musicName.toLowerCase().startsWith(searchQuery.toLowerCase())) {
				musicContainer.appendChild(item);
			}
			if (artist.toLowerCase().startsWith(searchQuery.toLowerCase())) {
				musicContainer.appendChild(item);
			}
		});

	}
});*/


/////////// top button 보이기 | 숨기기////////////////

$(function() { 
	$(window).scroll(function() {
    if ($(this).scrollTop() > 500) { //300 넘으면 버튼이 보여짐
      $('#topBtn').fadeIn();
    } else {
      $('#topBtn').fadeOut();
    }
  }); // 버튼 클릭시 
  $("#topBtn").click(function() { 
  	$('html, body').animate({ scrollTop : 0 // 0 까지 animation 이동
  	}, 400); // 속도 400 
  	return false; 
  }); 
});


/////////////// 로그인 유무? //////////////////

function loginChk() {
	let signIn = '<%=(String)session.getAttribute("userId")%>';
	if(signIn==null,""){
		alert("로그인 후 사용하실 수 있습니다.");
		window.location.href = "/2023-05-JAVA-DEVELOPER-final-project-team1-mango/user_login_form";
	}
}



