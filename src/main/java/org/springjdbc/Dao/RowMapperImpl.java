package org.springjdbc.Dao;

import org.springframework.jdbc.core.RowMapper;
import org.springjdbc.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person=new Person();
        person.setAge(rs.getInt("Age"));
        person.setId(rs.getInt("Id"));
        person.setName(rs.getString("Name"));
        return person;
    }
}
