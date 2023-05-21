package com.example.lab2.repository;

import com.example.lab2.entity.Group;
import com.example.lab2.entity.Student;
import com.example.lab2.entity.Teacher;
import com.example.lab2.util.row_mapper.GroupRowMapper;
import com.example.lab2.util.row_mapper.StudentRowMapper;
import com.example.lab2.util.row_mapper.TeacherRowMapper;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Records;
import org.jooq.conf.ParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lab2.util.DBConstants.*;
import static org.jooq.impl.DSL.*;

@Repository
public class SimpleQueryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SimpleQueryRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Group> query1(Long instructorId) {

        Query query = select().from(table(GROUPS_TABLE)).where(field(GROUP_ID).in(
                select(field(STUDENT_GROUP_ID)).from(table(STUDENTS_TABLE))
                        .where(field(STUDENT_INSTRUCTOR_ID).eq(instructorId))));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new GroupRowMapper());
    }


    public List<Student> query2(String carBrand) {

        Query query = select().from(table(STUDENTS_TABLE)).where(field(STUDENT_INSTRUCTOR_ID).in(
                select(field(INSTRUCTOR_ID)).from(table(INSTRUCTORS_TABLE)).innerJoin(table(CARS_TABLE))
                        .on(field(INSTRUCTOR_CAR_ID).eq(field(CAR_ID))).where(field(CAR_BRAND).eq(carBrand))));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new StudentRowMapper());
    }

    public List<Teacher> query3(String categoryId) {

        Query query = select().from(table(TEACHERS_TABLE)).where(field(TEACHER_ID).in(
                select(field(GROUP_TEACHER_ID)).from(table(GROUPS_TABLE))
                        .where(field(GROUP_CATEGORY_ID).eq(categoryId))));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new TeacherRowMapper());
    }

    public List<Teacher> query4(int studentsQuantity) {

        Query query = select().from(table(TEACHERS_TABLE)).where(field(TEACHER_ID).in(
                select(field(GROUP_TEACHER_ID)).from(table(GROUPS_TABLE)).innerJoin(table(STUDENTS_TABLE))
                        .on(field(GROUP_ID).eq(field(STUDENT_GROUP_ID))).groupBy(field(GROUP_ID))
                        .having(count().greaterOrEqual(studentsQuantity))));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new TeacherRowMapper());
    }

    public List<Student> query5(String teacherName) {

        Query query = select().from(table(STUDENTS_TABLE)).innerJoin(table(GROUPS_TABLE))
                .on(field(STUDENT_GROUP_ID).eq(field(GROUP_ID))).innerJoin(table(TEACHERS_TABLE))
                .on(field(GROUP_TEACHER_ID).eq(field(TEACHER_ID))).where(field(TEACHER_FIRST_NAME).eq(teacherName));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new StudentRowMapper());
    }
}
