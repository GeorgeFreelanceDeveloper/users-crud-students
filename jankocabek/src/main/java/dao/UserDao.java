package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;
import entity.User;


public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String FIND_USER_QUERY =
            "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE  id = ?";
    private static final String UPDATE_WITHOUT =
            "UPDATE users SET username = ?, email = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USER_QUERY =
            "SELECT * FROM users";

    public void create(final User user) {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassHash());
            ps.executeUpdate();
            final ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public User findById(final int id) {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(FIND_USER_QUERY);
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
            return null;
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public void update(final User user) {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(UPDATE_USER_QUERY);
            ps.setInt(4, user.getId());
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassHash());
            ps.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public void updateWithoutPassword(final User user) {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(UPDATE_WITHOUT);
            ps.setInt(3, user.getId());
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
        }
    }



    public boolean delete(final int userId) {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(DELETE_USER_QUERY);
            ps.setInt(1, userId);
            return ps.executeUpdate() != 0;
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    public List<User> findAll() {
        try (final Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(FIND_ALL_USER_QUERY);
            final ResultSet rs = ps.executeQuery();
            final List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getInt(1),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")));
            }
            return users;
        } catch (final SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
