package com.example.lab2.util.row_mapper;

import com.example.lab2.entity.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

import static com.example.lab2.util.DBConstants.*;

class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Car.builder().id(rs.getLong(CAR_ID)).brand(rs.getString(CAR_BRAND)).model(rs.getString(CAR_MODEL))
                .year(rs.getObject(CAR_YEAR, Year.class)).categoryId(rs.getLong(CAR_CATEGORY_ID)).build();
    }
}