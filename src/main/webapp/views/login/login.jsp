<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<fmt:bundle basename="messages">
    <tiles:insertDefinition name="baseLayout">
        <tiles:putAttribute name="titlePage">
            <fmt:message key="login.title"/>
        </tiles:putAttribute>

        <tiles:putListAttribute name="pageCss">
            <tiles:addAttribute value="hiddenEye" />
            <tiles:addAttribute value="btn" />
        </tiles:putListAttribute>

        <tiles:putListAttribute name="pageJs">
            <tiles:addAttribute value="hiddenEye" />
        </tiles:putListAttribute>

        <tiles:putAttribute name="body">
            <div class="container my-5 pt-5">
                <div class="row justify-content-center">
                    <!-- Login part -->
                    <div class="col-md-5 text-center">
                        <h1 class="text-center"><fmt:message key="login.title" /></h1>
                        <form id="loginForm" method="post" action="/WebMyPham/login">
                            <!-- Email -->
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="email" name="email"
                                    placeholder="<fmt:message key='login.emailLabel' />" required>
                                <label for="email"><fmt:message key="login.emailLabel" /></label>
                            </div>

                            <!-- Password -->
                            <div class="form-floating mb-3 position-relative">
                                <input type="password" class="form-control" id="password" name="password"
                                    placeholder="<fmt:message key='login.passwordLabel' />" required>
                                <label for="password"><fmt:message key="login.passwordLabel" /></label>
                                <button id="toggle-password" type="button"
                                    class="position-absolute top-50 end-7 translate-middle-y p-0">
                                    <i class="bi-eye-slash"></i>
                                </button>
                            </div>

                            <!-- Error -->
                            <c:if test="${not empty loginFail}">
                                <p class="text-danger text-start">${loginFail}</p>
                            </c:if>

                            <!-- Forgot password -->
                            <a href="${pageContext.request.contextPath}/views/login/forgotPass.jsp">
                                <fmt:message key="login.forgotPassword" />
                            </a>

                            <!-- Submit button -->
                            <input type="submit" class="btn btn-dark mt-3 w-100" id="submitLoginForm" name="action"
                                value="<fmt:message key='login.loginButton' />">
                        </form>
                    </div>

                    <!-- Register part -->
                    <div class="col-md-5 text-center">
                        <h1><fmt:message key="login.createAccount" /></h1>
                        <p><fmt:message key="login.accountDescription" /></p>
                        <a class="btn btn-dark btn-block mt-3"
                            href="${pageContext.request.contextPath}/views/login/register.jsp">
                            <fmt:message key="login.createAccount" />
                        </a>
                    </div>
                </div>
            </div>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</fmt:bundle>
