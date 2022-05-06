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
        int result=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int change(Student student) {
        //Update the query
        String query="update  student set name=? ,city=? where id=?";
        int result=jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());

        //fire the query
        return result;
    }

    @Override
    public int delete(int studentID) {
        String query="delete from student where id=?";
        int result=jdbcTemplate.update(query,studentID);
        return result;
    }
}
