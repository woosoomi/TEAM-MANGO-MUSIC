function userCreate() {
		if (document.f.userId.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			f.userId.focus();
			return false;
		}
		if (document.f.userPw.value == "") {
			alert("비밀번호를 입력하십시요.");
			f.userPw.focus();
			return false;
		}
		if (document.f.userName.value == "") {
			alert("이름을 입력하십시요.");
			f.userName.focus();
			return false;
		}
		if (document.f.userPhone.value == "") {
			alert("번호를 입력하십시요.");
			f.userPhone.focus();
			return false;
		}
		if (document.f.userEmail.value == "") {
			alert("이메일 주소를 입력하십시요.");
			f.email.focus();
			return false;
		}
		if (document.f.userJumin.value == "") {
			alert("주민번호를 입력하십시요.");
			f.userJumin.focus();
			return false;
		}
		if (document.f.userAddress.value == "") {
			alert("이메일 주소를 입력하십시요.");
			f.userAddress.focus();
			return false;
		}
		document.f.action = "user_write_action";
		document.f.method='POST';
		document.f.submit();
	}