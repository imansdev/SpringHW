<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Items List</title>
  </head>

  <body>
    <h2>Items List</h2>
    <form action="/api/items" method="get">
      <input type="text" name="name" placeholder="Filter by name" />
      <select name="catalog">
        <option value="">All Catalogs</option>
        <c:forEach var="catalog" items="${catalogs}">
          <option value="${catalog}">${catalog}</option>
        </c:forEach>
      </select>
      <input type="submit" value="Filter" />
    </form>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Catalog</th>
        <th>Price</th>
        <th>Actions</th>
      </tr>
      <c:forEach var="item" items="${items}">
        <tr>
          <td>${item.id}</td>
          <td>${item.name}</td>
          <td>${item.catalog}</td>
          <td>${item.price}</td>
          <td>
            <form
              action="/api/item/${item.id}"
              method="get"
              style="display: inline"
            >
              <button type="submit">View</button>
            </form>
            <form
              action="/api/item/${item.id}/edit"
              method="get"
              style="display: inline"
            >
              <button type="submit">Update</button>
            </form>
            <form
              action="/api/item/${item.id}/delete"
              method="post"
              style="display: inline"
            >
              <input type="hidden" name="_method" value="delete" />
              <button
                type="submit"
                onclick="return confirm('Are you sure you want to delete this item?');"
              >
                Delete
              </button>
            </form>
            <form
              action="/api/item/${item.id}/corrupt"
              method="post"
              style="display: inline"
            >
              <input type="text" name="reason" placeholder="type some reason" />
              <button type="submit" onclick="return confirm('Are you sure ?');">
                Move to Corrupted
              </button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    <a href="/api/item">Add New Item</a>
    <a href="/api/corruptedItems">Corrupte Items List</a>
  </body>
</html>
