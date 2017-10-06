package me.ji5.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class UserDao {
    private String username;
    private String realname;

    public void insertNewContent(JdbcTemplate jdbc) {
        jdbc.update("INSERT INTO tbl_demo(username, realname) VALUES(?, ?)", username, realname);
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

        /*public UserDao build() {
            UserDao userDao = new UserDao(null);
            userDao.setRealname(this.realname);
            userDao.setUsername(this.username);
            return userDao;
        }*/
    }
}
