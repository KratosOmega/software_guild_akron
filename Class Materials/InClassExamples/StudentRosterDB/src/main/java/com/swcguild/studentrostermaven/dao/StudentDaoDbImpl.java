/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class StudentDaoDbImpl implements StudentDao {
    
    // SQL STATEMENTS GO HERE
    // We need to use prepared statements
    
    private static final String SQL_INSERT_STUDENT =
            "INSERT INTO students (first_name, last_name, major, street, city, state, zipcode) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_SELECT_STUDENT_BY_ID =
            "SELECT * FROM students WHERE id = ?";
    
    private static final String SQL_SELECT_STUDENT_BY_LAST_NAME =
            "SELECT * FROM students WHERE last_name = ?";
    
    private static final String SQL_UPDATE_STUDENT=
            "UPDATE students SET first_name = ?, last_name = ?, major = ?, " +
            " street = ?, city=?, state=?, zipcode=? where id = ?";
    
    private static final String SQL_DELETE_STUDENT = 
            "DELETE FROM students WHERE id = ?";
    
   // private class variable for our JDBCTemplates
    private JdbcTemplate jdbcTemplate;

    // We're using setter injection for the JdbcTemplate
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly = false)
    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_INSERT_STUDENT,
                student.getFirstName(),
                student.getLastName(),
                student.getMajor(),
                student.getStreet(),
                student.getCity(),
                student.getState(),
                student.getZipcode()
                );
        student.setStudentId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public Student getStudentById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID, new StudentMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return jdbcTemplate.query(SQL_SELECT_STUDENT_BY_LAST_NAME, new StudentMapper(), lastName);
    }

    @Override
    public void removeStudent(int studentId) {
        jdbcTemplate.update(SQL_DELETE_STUDENT, studentId);
    }

    @Override
    public void updateStudent(Student student) {
        jdbcTemplate.update(SQL_UPDATE_STUDENT,
                student.getFirstName(),
                student.getLastName(),
                student.getMajor(),
                student.getStreet(),
                student.getCity(),
                student.getState(),
                student.getZipcode(),
                student.getStudentId()
                );
    }

    private static final class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student student = new Student();
            student.setStudentId(rs.getInt("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setMajor(rs.getString("major"));
            student.setStreet(rs.getString("street"));
            student.setCity(rs.getString("city"));
            student.setState(rs.getString("state"));
            student.setZipcode(rs.getString("zipcode"));
            return student;
        }

        
    }
    
}
