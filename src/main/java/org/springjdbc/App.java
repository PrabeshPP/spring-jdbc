package org.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springjdbc.dao.StudentDao;
import org.springjdbc.dao.StudentDaoImpl;
import org.springjdbc.entities.Student;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "My Program Started....." );
        ApplicationContext context=new AnnotationConfigApplicationContext(JDBCConfig.class);
//        JDBCConfig jdbcConfig=new JDBCConfig();
        StudentDao studentDao= context.getBean("studentDao1",StudentDao.class);
        Student student=new Student();

//        student=studentDao.getStudent(40);
//        System.out.println(student);

        List<Student> students=studentDao.getListStudent();
        System.out.println(students);


    }
}
