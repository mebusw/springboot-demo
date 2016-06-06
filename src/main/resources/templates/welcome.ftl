<!DOCTYPE html>

<html lang="en">

<body>
	Date: ${time?date}
	<br>
	Time: ${time?time}
	<br>
	Message: ${message}

    <hr/>

    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
        <input type="hidden"
                    name="${_csrf.parameterName}"
                    value="${_csrf.token}"/>
    </form>

    <p>
    </p>
</body>

</html>