package com.example.lab2.util.row_mapper;

import com.example.lab2.entity.Category;
import com.example.lab2.entity.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.example.lab2.util.DBConstants.*;

public class GroupRowMapper implements RowMapper<Group> {

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Group.builder().id(rs.getLong(GROUP_ID)).lecturesCovered(rs.getInt(GROUP_LECTURES_COVERED))
                .startDate(rs.getObject(GROUP_START_DATE, LocalDate.class))
                .categoryId(rs.getString(GROUP_CATEGORY_ID)).teacherId(rs.getLong(GROUP_TEACHER_ID)).build();
    }
}