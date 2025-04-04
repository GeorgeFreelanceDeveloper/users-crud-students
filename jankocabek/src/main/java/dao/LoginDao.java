package dao;

import util.DbUtil;

import java.sql.*;


public class LoginDao {

    private static final String FIND_USER_QUERY =
            "SELECT authentication.password FROM authentication WHERE username = ?";


    public String checkAuth(final String userName) {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(FIND_USER_QUERY);
            ps.setString(1, userName);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            } else return null;
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
