package com.example.lab2.util.row_mapper;

import com.example.lab2.entity.Group;
import com.example.lab2.entity.Instructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static com.example.lab2.util.DBConstants.*;

public class InstructorRowMapper implements RowMapper<Instructor> {

    @Override
    public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Instructor.builder().id(rs.getLong(INSTRUCTOR_ID)).email(rs.getString(INSTRUCTOR_EMAIL))
                .phoneNumber(rs.getString(INSTRUCTOR_PHONE_NUMBER)).firstName(rs.getString(INSTRUCTOR_FIRST_NAME))
                .secondName(rs.getString(INSTRUCTOR_SECOND_NAME)).carId(rs.getLong(INSTRUCTOR_CAR_ID)).build();
    }
}