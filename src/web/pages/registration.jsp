<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/css/registration.css" />
</head>
<body>
<div id="welcome">
    <h2>Registration</h2>
    <hr />
    <form class="registration" method="post">
        <label for="firstName">
                <span>First Name:
                    <span class="required">*</span>
                </span>
            <input name="firstName" id="firstName" class="input-field" type="text" required>
        </label>
        <label for="lastName">
                <span>Last Name:
                    <span class="required">*</span>
                </span>
            <input name="lastName" id="lastName" class="input-field" type="text" required>
        </label>
        <label for="phone">
            <span>Phone:</span>
            <input name="phone" id="phone" class="input-field" type="text" >
        </label>
        <label for="email">
            <span>Email:</span>
            <input name="email" id="email" class="input-field" type="text" >
        </label>
        <label>
            <span>&nbsp;</span>
            <input class="input-field" type="submit" value="Submit">
        </label>
    </form>
</div>
</body>
</html>
