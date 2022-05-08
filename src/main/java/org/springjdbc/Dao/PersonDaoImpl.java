package org.springjdbc.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springjdbc.entity.Person;

import java.util.List;

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

    @Override
    public int updateData(Person person) {
        String query="update Person set Name=?,Age=? where Id=?";
        int  result=jdbcTemplate.update(query,person.getName(),person.getAge(),person.getId());
        return result;
    }

    @Override
    public int deleteData(int id) {
       String query="delete from Person where id=?";
       int result=jdbcTemplate.update(query,id);
        return 0;
    }

    @Override
    public Person getSinglePerson(int studentId) {
       String query="select * from Person where id=?";
        RowMapper<Person> rowMapper=new RowMapperImpl();
       Person result=jdbcTemplate.queryForObject(query,rowMapper,studentId);
       return result;
    }

    @Override
    public List<Person> getAllPerson() {
        String query="select * from Person";
        RowMapper<Person> rowMapper=new RowMapperImpl();
        List<Person> list=jdbcTemplate.query(query,rowMapper);
        return list;
    }
}
