package com.laioffer.jupiter.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.jupiter.db.MySQLConnection;
import com.laioffer.jupiter.db.MySQLException;
import com.laioffer.jupiter.entity.FavoriteRequestBody;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "FavoriteServlet", value = "/favorite")
public class FavoriteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Get user ID from request URL, this is a temporary solution since we don’t support session now
      String userId = request.getParameter("user_id");
      // Get favorite item information from request body
      ObjectMapper mapper = new ObjectMapper();
      FavoriteRequestBody body = mapper.readValue(request.getReader(), FavoriteRequestBody.class);
      if (body == null) {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          return;
      }

      MySQLConnection connection = null;
      try {
          // Save the favorite item to the database
          connection = new MySQLConnection();
          connection.setFavoriteItem(userId, body.getFavoriteItem());
      } catch (MySQLException e) {
          throw new ServletException(e);
      } finally {
          if (connection != null) {
              connection.close();
          }
      }
  }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("user_id");
        ObjectMapper mapper = new ObjectMapper();
        FavoriteRequestBody body = mapper.readValue(request.getReader(), FavoriteRequestBody.class);
        if (body == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        MySQLConnection connection = null;
        try {
            // Remove the favorite item to the database
            connection = new MySQLConnection();
            connection.unsetFavoriteItem(userId, body.getFavoriteItem().getId());
        } catch (MySQLException e) {
            throw new ServletException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
