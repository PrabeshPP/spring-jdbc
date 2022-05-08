package org.springjdbc.Dao;

import org.springjdbc.entity.Person;

import java.util.List;

public interface PersonDao {
    int insertData(Person person);
    //Update data
    int updateData(Person person);

    int deleteData(int id);

    Person getSinglePerson(int studentId);
    List<Person> getAllPerson();
}
