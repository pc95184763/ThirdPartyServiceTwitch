package com.laioffer.jupiter.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.jupiter.entity.Game;
import com.laioffer.jupiter.external.TwitchClient;
import com.laioffer.jupiter.external.TwitchException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


@WebServlet(name = "GameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
// 1     response.getWriter().print("Hello Summer 2021") ;

//      String gamename = request.getParameter("gamename") ;
//      response.getWriter().print("Game is :" + gamename);

//    json
//    response.setContentType("application/json");
//    JSONObject game = new JSONObject();
//    game.put("name", "World of Warcraft");
//    game.put("developer", "Blizzard Entertainment");
//    game.put("release_time", "Feb 11, 2005");
//    game.put("website", "https://www.worldofwarcraft.com");
//    game.put("price", 49.99);
//    response.getWriter().print(  game);

// jackson
//      response.setContentType("application/json");
//      ObjectMapper mapper = new ObjectMapper();
//      Game.Builder builder = new Game.Builder();
//      builder.setName("World of Warcraft");
//      builder.setDeveloper("Blizzard Entertainment");
//      builder.setReleaseTime("MAY 20, 2021");
//      builder.setWebsite("https://www.worldofwarcraft.com");
//      builder.setPrice(88.99);
//
//
//      Game game = builder.build();
//      response.getWriter().print(mapper.writeValueAsString(game) );

//    part5
//    String gameName = request.getParameter("game_name");
//    TwitchClient client = new TwitchClient();
//
//    // Let the client know the returned data is in JSON format.
//    response.setContentType("application/json;charset=UTF-8");
//    try {
//      // Return the dedicated game information if gameName is provided in the request URL, otherwise return the top x games.
//      if (gameName != null) {
//        response.getWriter().print(new ObjectMapper().writeValueAsString(client.searchGame(gameName)));
//      } else {
//        response.getWriter().print(new ObjectMapper().writeValueAsString(client.topGames(0)));
//      }
//    } catch (TwitchException e) {
//      throw new ServletException(e);
//    }

    // Get gameName from request URL.
    String gameName = request.getParameter("game_name");
    TwitchClient client = new TwitchClient();

    // Let the client know the returned data is in JSON format.
    response.setContentType("application/json;charset=UTF-8");
    try {
      // Return the dedicated game information if gameName is provided in the request URL, otherwise return the top x games.
      if (gameName != null) {
        response.getWriter().print(new ObjectMapper().writeValueAsString(client.searchGame(gameName)));
      } else {
        response.getWriter().print(new ObjectMapper().writeValueAsString(client.topGames(0)));
      }
    } catch (TwitchException e) {
      throw new ServletException(e);
    }
  }

//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//    String name = jsonRequest.getString("name");
//    String developer = jsonRequest.getString("developer");
//    String releaseTime = jsonRequest.getString("release_time");
//    String website = jsonRequest.getString("website");
//    float price = jsonRequest.getFloat("price");
//
//    // Print game information to IDE console
//    System.out.println("Name is: " + name);
//    System.out.println("Developer is: " + developer);
//    System.out.println("Release time is: " + releaseTime);
//    System.out.println("Website is: " + website);
//    System.out.println("Price is: " + price);
//
//    // Return status = ok as response body to the client
//    response.setContentType("application/json");
//    JSONObject jsonResponse = new JSONObject();
//    jsonResponse.put("status", "ok");
//    response.getWriter().print(jsonResponse);
//
//  }
}
