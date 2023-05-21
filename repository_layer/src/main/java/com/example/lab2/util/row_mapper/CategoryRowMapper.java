package com.example.lab2.util.row_mapper;

import com.example.lab2.entity.Car;
import com.example.lab2.entity.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

import static com.example.lab2.util.DBConstants.*;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Category.builder().id(rs.getString(CATEGORY_ID)).description(rs.getString(CATEGORY_DESCRIPTION)).build();
    }
}