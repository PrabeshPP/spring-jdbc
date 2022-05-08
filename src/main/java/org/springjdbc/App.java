package org.springjdbc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springjdbc.Dao.PersonDao;
import org.springjdbc.Dao.PersonDaoImpl;
import org.springjdbc.entity.Person;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        PersonDao personDao=context.getBean("dao",PersonDaoImpl.class);
//        Person person=new Person();
//        person.setId(1000);
//        person.setName("Prabesh");
//        person.setAge(21);
//        int result=personDao.updateData(person);
        List<Person> list=personDao.getAllPerson();
        System.out.println(list);




    }
}
