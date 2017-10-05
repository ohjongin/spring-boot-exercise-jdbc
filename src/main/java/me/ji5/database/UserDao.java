package me.ji5.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    private String username;
    private String realname;

    private final JdbcTemplate jdbc;

    @Autowired
    public UserDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public UserDao() {
        this.jdbc = null;
    }

    public void insertNewContent() {
        jdbc.update("INSERT INTO tbl_demo(username, realname) VALUES(?, ?)", this.username, this.realname);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public static class UserBuilder {
        private String username;
        private String realname;

        public UserBuilder() {
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder realname(String realname) {
            this.realname = realname;
            return this;
        }

        public UserDao build() {
            UserDao userDao = new UserDao();
            userDao.setRealname(this.realname);
            userDao.setUsername(this.username);
            return userDao;
        }
    }
}
