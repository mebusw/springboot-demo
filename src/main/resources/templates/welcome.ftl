<!DOCTYPE html>

<html lang="en">

<body>
	Date: ${time?date}
	<br>
	Time: ${time?time}
	<br>
	Message: ${message}

    <hr/>

    <form action="@{/logout}" method="post">
        <input type="submit" value="Sign Out"/>
    </form>

    <p>
    </p>
</body>

</html>