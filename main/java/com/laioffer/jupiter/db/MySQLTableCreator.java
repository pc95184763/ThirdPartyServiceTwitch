package com.laioffer.jupiter.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLTableCreator {

  public static void main(String[] args) {
    try {

      // Step 1 Connect to MySQL.
      System.out.println("Connecting to " + MySQLDBUtil.getMySQLAddress());
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(MySQLDBUtil.getMySQLAddress());

      if (conn == null) {
        return;
      }

      // Step 2 Drop tables in case they exist.

      // Step 3 Create new tables.

      // Step 4: insert fake user 1111/3229c1097c00d497a0fd282d586be050.

      conn.close();
      System.out.println("Import done successfully");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



}
