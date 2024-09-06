<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Corrupted Items List</title>
  </head>

  <body>
    <h2>Corrupted Items List</h2>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Item Name</th>
        <th>Reason</th>
        <th>Actions</th>
      </tr>
      <c:forEach var="corruptedItem" items="${corruptedItems}">
        <tr>
          <td>${corruptedItem.id}</td>
          <td>${corruptedItem.item.name}</td>
          <td>${corruptedItem.reason}</td>
          <td>
            <!-- <a href="/api/corrupted/${corruptedItem.id}">View</a> -->
            <form
              action="/api/corrupted/${corruptedItem.id}"
              method="get"
              style="display: inline"
            >
              <button type="submit">View</button>
            </form>
            <form
              action="/api/corrupted/${corruptedItem.id}/delete"
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
              action="/api/corrupted/${corruptedItem.id}/update"
              method="post"
              style="display: inline"
            >
              <input type="hidden" name="_method" value="PUT" />
              <input type="text" name="reason" placeholder="type some reason" />
              <button type="submit" onclick="return confirm('Are you sure ?');">
                Update Reason
              </button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    <a href="/api/items">Back to Items List</a>
  </body>
</html>
