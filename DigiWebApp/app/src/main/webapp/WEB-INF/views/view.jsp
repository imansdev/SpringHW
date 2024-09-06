<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>View Item</title>
    <style>
      .error {
        color: red;
      }
    </style>
  </head>

  <body>
    <h2>View Item</h2>
    <form:form
      action="/api/item/${item.id}/update"
      method="post"
      modelAttribute="item"
    >
      <input type="hidden" name="_method" value="put" />
      <div>
        <form:label path="name">Name:</form:label>
        <form:input path="name" required="true" />
        <form:errors path="name" cssClass="error" />
      </div>
      <div>
        <form:label path="catalog">Catalog:</form:label>
        <form:select path="catalog" required="true">
          <form:option value="" label="-- Select Catalog --" />
          <form:options items="${catalogs}" />
        </form:select>
        <form:errors path="catalog" cssClass="error" />
      </div>
      <div>
        <form:label path="price">Price:</form:label>
        <form:input path="price" type="number" required="true" min="0" />
        <form:errors path="price" cssClass="error" />
      </div>
      <div>
        <input type="submit" value="Update Item" />
      </div>
    </form:form>
    <a href="/api/items">Back to List</a>
  </body>
</html>
