package entity;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String passHash;
    private String email;

    public User(final String userName, final String email, final String password) {
        this.id = 0;
        this.userName = userName;
        this.email = email;
        this.passHash = getHashedPass(password);
    }

    public User(final int id, final String userName, final String email, final String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passHash = getHashedPass(password);
    }

    public User(final int id, final String userName, final String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setPassword(final String password) {
        this.passHash = getHashedPass(password);
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setId(final int id) {
        this.id = id;
    }

    private String getHashedPass(final String password) {
        return BCrypt.hashpw(password, generateSalt());
    }

    private String generateSalt() {
        return BCrypt.gensalt();
    }

    public boolean checkPassword(final String password) {
        return BCrypt.checkpw(password, this.passHash);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passHash='" + passHash + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return getId() == user.getId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassHash(), user.getPassHash()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassHash(), getEmail());
    }
}
