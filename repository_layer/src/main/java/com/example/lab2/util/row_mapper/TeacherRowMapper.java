package com.example.lab2.util.row_mapper;

import com.example.lab2.entity.Student;
import com.example.lab2.entity.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.lab2.util.DBConstants.*;

public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Teacher.builder().id(rs.getLong(TEACHER_ID)).email(rs.getString(TEACHER_EMAIL))
                .phoneNumber(rs.getString(TEACHER_PHONE_NUMBER)).firstName(rs.getString(TEACHER_FIRST_NAME))
                .secondName(rs.getString(TEACHER_SECOND_NAME)).build();
    }
}