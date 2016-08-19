<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | YOGH</title>
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/blogSiteStyles.css" rel="stylesheet">
    </head>
    <body>
        <a id="link-to-home" href="${pageContext.request.contextPath}/">HOME</a>
        <div>
            <h2 id="login-title">YOGH Site Editor Login</h2>
            <!-- #1 - If login_error == 1 then there was a failed login attempt -->
            <!-- so display an error message -->
            <c:if test="${param.login_error == 1}">
                <br><br>
                <center>
                <h3 id="login-error">Wrong ID or PASSWORD!</h3>
                </center>
                <br><br><br>
            </c:if>
            <!-- #2 - Post to Spring security to check our authentication -->
            <form method="post" class="signin" action="j_spring_security_check">
                <fieldset>
                    <center>
                    <table cellspacing="0">
                        <tr>
                            <!--<th>
                                <label for="username">Username
                                </label>
                            </th>-->

                            <td><input id="username_or_email"
                                       placeholder="USERNAME"
                                       name="j_username"
                                       type="text" />
                            </td>
                        </tr>
                        <tr>
                            <!--<th><label for="password">Password</label></th>-->
                            <!-- #2b - must be j_password for Spring -->
                            <td><input id="password"
                                       placeholder="PASSWORD"
                                       name="j_password"
                                       type="password" />
                            </td>
                        </tr>
                        <tr>
                            <!--<th></th>-->
                            <td><center><input id="signIn" name="commit" type="submit" value="Sign In" /></center></td>
                        </tr>
                    </table>
                    </center>
                </fieldset>
            </form>
        </div>
    </body>
</html>