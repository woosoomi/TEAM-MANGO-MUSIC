export function user_login_form(responseJsonObject = {}) {
	let htmlTemplate =
		`<div class="login-wrapper" id="login-content">
								<div class="login-content">
									<a href="#" class="close">x</a>
									<h3>Login</h3>
									<form method="post" action="user_login_action">
										<div class="row">
											<label for="userId">UserId:<input type="text"
												name="userId" id="userId" placeholder="아이디"
												required="required" /></label>
										</div>
										<div class="row">
											<label for="password"> Password:<input
												type="password" name="password" id="password"
												placeholder="비밀번호" required="required" /></label>
										</div>
										<div class="row">
											<div class="remember">
												<a href="user_write_form">회원가입하기</a>
											</div>
											<div class="remember">
												<a href="userCheckIdPw">아이디찾기 / 비밀번호찾기</a>
											</div>
										</div>
										<div class="row">
											<button type="submit" id="loginButton">Login</button>
										</div>
									</form>
									<div class="row">
										<p>Or via social</p>
										<div class="social-btn-2">
											<a class="fb" href="#"><i class="ion-social-facebook"></i>Facebook</a><a
												class="tw" href="#"><i class="ion-social-twitter"></i>twitter</a>
										</div>
									</div>
								</div>
							</div>
						</div>`;

	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}