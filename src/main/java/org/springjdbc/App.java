package org.springjdbc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate jdbcTemplate=context.getBean("jdbctemplate",JdbcTemplate.class);
        String query="insert into Person(Id,Name,Age) values(?,?,?)";
        int result=jdbcTemplate.update(query,101,"Pirate",400);
        System.out.println(result);



    }
}
