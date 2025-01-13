<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="titlePage" value="Đặt lại mật khẩu" />
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="btn" />
	</tiles:putListAttribute>
	<tiles:putAttribute name="body">
		<div class="container d-flex justify-content-center mt-5">
			<div class="card custom-card">
				<div class="card-body">
					<h5 class="card-title text-center mb-4">Đặt lại mật khẩu</h5>
					<form action="ResetPasswordServlet" method="post">
						<input type="hidden" name="token" value="${param.token}" />
						<div class="mb-3">
							<label for="newPassword" class="form-label">Mật khẩu mới</label>
							<input type="password" class="form-control" id="newPassword"
								name="newPassword" required />
						</div>
						<button type="submit" class="btn btn-dark w-100">Đặt lại
							mật khẩu</button>
					</form>

				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
