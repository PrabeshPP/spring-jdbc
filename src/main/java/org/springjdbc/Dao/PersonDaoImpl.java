package org.springjdbc.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springjdbc.entity.Person;

public class PersonDaoImpl implements  PersonDao{
   private JdbcTemplate jdbcTemplate;

   public PersonDaoImpl(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate=jdbcTemplate;
   }

    @Override
    public int insertData(Person person) {
       String query="insert into Person(Id,Name,Age) values(?,?,?)";
       int result=jdbcTemplate.update(query,person.getId(),person.getName(),person.getAge());
       return result;
    }
}
