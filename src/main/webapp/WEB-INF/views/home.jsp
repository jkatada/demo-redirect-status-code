<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Home | Redirect Demo</title>
</head>

<body>
    <h1>Redirect Demo</h1>

    <h2>"redirect:xxxx"</h2>
    <form:form action="${pageContext.request.contextPath}/redirect1" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirect1</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/redirect2" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirect2</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/redirect3" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirect3</button>
    </form:form>
    <br>

    <h2>RedirectView</h2>
    <form:form action="${pageContext.request.contextPath}/redirectview1" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirectview1</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/redirectview2" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirectview2</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/redirectview3" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirectview3</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/redirectview4" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">redirectview4</button>
    </form:form>
    <br>

    <h2>ModelAndView + "redirect:xxx"</h2>
    <form:form action="${pageContext.request.contextPath}/modelandviewredirect1" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">modelandviewredirect1</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/modelandviewredirect2" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">modelandviewredirect2</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/modelandviewredirect3" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">modelandviewredirect3</button>
    </form:form>
    <br>

    <h2>ModelAndView + RedirectView</h2>
    <form:form action="${pageContext.request.contextPath}/modelandviewredirectview1" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">modelandviewredirectview1</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/modelandviewredirectview2" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">modelandviewredirectview2</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/modelandviewredirectview3" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">modelandviewredirectview3</button>
    </form:form>
    <br>

    <h2>Jsp View</h2>
    <form:form action="${pageContext.request.contextPath}/jsp1" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">jsp1</button>
    </form:form>
    <form:form action="${pageContext.request.contextPath}/jsp2" modelAttribute="userBean">
        name:
        <form:input path="name" value="name" /><br>
        password:
        <form:input path="password" value="password" /><br>
        <button type="submit">jsp2</button>
    </form:form>
    <br>

</body>

</html>