package org.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springjdbc.entities.Student;

public class StudentDaoImpl implements  StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";

        //Fire the Query
        int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }
}
