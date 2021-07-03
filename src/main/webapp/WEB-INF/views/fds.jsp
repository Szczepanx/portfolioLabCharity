<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="donation">
    <label>
        <form:checkboxes
                type="checkbox"
                path="categories"
                items="${categories}" itemLabel="name" itemValue="id"/>
        <span class="checkbox"></span>
        <span class="description">ubrania, do wyrzucenia</span>
    </label>
</div>


    <label>
        <input type="checkbox" name="categories" value="toys" />
        <span class="checkbox"></span>
        <span class="description">zabawki</span>
    </label>
</div>

<div class="form-group form-group--checkbox">
    <label>
        <input type="checkbox" name="categories" value="books" />
        <span class="checkbox"></span>
        <span class="description">książki</span>
    </label>
</div>


    <label>
        <input type="checkbox" name="categories" value="other" />
        <span class="checkbox"></span>
        <span class="description">inne</span>
    </label>
</div>

<input type="submit">
</div>
</div>
</form:form>

</body>
</html>