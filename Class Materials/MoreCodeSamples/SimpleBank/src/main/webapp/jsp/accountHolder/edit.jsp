<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New Account Holder</title>
    </head>
    <body>
        <h1>New Account Holder</h1>

        <sf:form method="POST" commandName="accountHolder" action="accountHolder" >         
            <fieldset> 
                <table cellspacing="0">
                    <tr>
                        <th><sf:label path="name">Full Name:</sf:label></th>
                        <td><sf:input path="name" size="15" /><br/>
                            <sf:errors path="name" cssClass="error" />
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input name="commit" type="submit" 
                                   value="I accept. Create now." /></td>
                    </tr>
                </table>
            </fieldset>
        </sf:form>


        <a href="home">Home</a>
    </body>
</html>
