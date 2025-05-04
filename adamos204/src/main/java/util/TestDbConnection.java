package util;

import dao.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDbConnection {
    public static void main(String[] args) {
        try (Connection connection = DbUtil.getConnection()) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

