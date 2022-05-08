package org.springjdbc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springjdbc.Dao.PersonDao;
import org.springjdbc.Dao.PersonDaoImpl;
import org.springjdbc.entity.Person;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        PersonDao personDao=context.getBean("dao",PersonDaoImpl.class);
        Person person=new Person();
        person.setId(1000);
        person.setName("Asus");
        person.setAge(2100);
        int result=personDao.insertData(person);
        System.out.println(result+" row has been affected");




    }
}
