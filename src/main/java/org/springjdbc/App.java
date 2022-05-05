package org.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "My Program Started....." );
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate template=context.getBean("jdbctemplate",JdbcTemplate.class);

        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";

        //Fire the Query
        int result=template.update(query,4,"Rocky","Tikapur");
        System.out.println("Number of record inserted..."+result);



    }
}
