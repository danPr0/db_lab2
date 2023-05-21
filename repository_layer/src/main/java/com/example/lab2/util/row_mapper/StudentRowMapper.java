package com.example.lab2.util.row_mapper;

import com.example.lab2.entity.Instructor;
import com.example.lab2.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.lab2.util.DBConstants.*;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Student.builder().id(rs.getLong(STUDENT_ID)).email(rs.getString(STUDENT_EMAIL))
                .phoneNumber(rs.getString(STUDENT_PHONE_NUMBER)).firstName(rs.getString(STUDENT_FIRST_NAME))
                .secondName(rs.getString(STUDENT_SECOND_NAME)).practiceCount(rs.getInt(STUDENT_PRACTICE_COUNT))
                .groupId(rs.getLong(STUDENT_GROUP_ID)).instructorId(rs.getLong(STUDENT_INSTRUCTOR_ID)).build();
    }
}