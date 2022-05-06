package org.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springjdbc.dao.StudentDao;
import org.springjdbc.entities.Student;

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

        StudentDao studentDao=context.getBean("dao", StudentDao.class);
        Student student=new Student();



    }
}
