package me.ji5.exercise.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcApplicationTests {
    @Qualifier("dataSource")
    @Autowired
	private DataSource ds; //작성

	@Test
	public void contextLoads() {
	}

    @Test
    public void testConnection() throws Exception{ //작성
        System.out.println("ds : "+ ds);
        Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고
        System.out.println("con : "+con); //확인 후
        con.close(); //close
    }
}
