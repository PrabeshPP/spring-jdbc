package org.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springjdbc.dao.StudentDao;
import org.springjdbc.dao.StudentDaoImpl;

import javax.sql.DataSource;


@Configuration
public class JDBCConfig {

    @Bean("ds")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUsername("root");
        ds.setPassword("Prabesh12345###");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        return  ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;

    }

    @Bean("Dao")
    public StudentDaoImpl getStudentDao(){
        StudentDaoImpl studentDao=new StudentDaoImpl();
        studentDao.setJdbcTemplate(getTemplate());
        return studentDao;
    }



}
