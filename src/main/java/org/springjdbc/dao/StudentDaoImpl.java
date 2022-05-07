package org.springjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springjdbc.entities.Student;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements  StudentDao {

    @Autowired
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

    //Getting a Single Student Data
    @Override
    public Student getStudent(int studentId) {
        //
        String query="select * from student where id=?";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        Student student =jdbcTemplate.queryForObject(query, rowMapper,studentId);
        return student;
    }

    @Override
    public List<Student> getListStudent() {
        //Selecting multiple students
        String query="select * from student";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        List<Student> list=jdbcTemplate.query(query,rowMapper);
        return list;
    }
}
