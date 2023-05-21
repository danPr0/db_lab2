package com.example.lab2.repository;

import com.example.lab2.entity.Teacher;
import com.example.lab2.util.row_mapper.TeacherRowMapper;
import org.jooq.Query;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.jooq.conf.ParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

import static com.example.lab2.util.DBConstants.*;
import static org.jooq.impl.DSL.*;

@Repository
public class ComplexQueryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ComplexQueryRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> query1() {

//        Query query = select().from(table(TEACHERS_TABLE))
//                .where(select(countDistinct(field(GROUP_CATEGORY_ID))).from(table(GROUPS_TABLE))
//                        .where(field(TEACHER_ID).eq(field(GROUP_TEACHER_ID)))
//                        .eq(select(count(field(CATEGORY_ID))).from(table(CATEGORIES_TABLE))));

        Query query = select().from(table(TEACHERS_TABLE)).where(notExists(select().from(table(CATEGORIES_TABLE))
                .where(notExists(select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE))
                        .where(field(GROUP_TEACHER_ID).eq(field(TEACHER_ID))
                                .and(field(CATEGORY_ID).eq(field(GROUP_CATEGORY_ID))))))));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new TeacherRowMapper());
    }

    public List<Teacher> query2(Long teacherId) {

//        SelectConditionStep<Record1<Object>> select1 = select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE))
//                .where(field(GROUP_TEACHER_ID).eq(field(TEACHER_ID)));
//        SelectConditionStep<Record1<Object>> select2 =
//                select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE)).where(field(GROUP_TEACHER_ID).eq(teacherId));

        Query query = select().from(table(TEACHERS_TABLE)).where(not(field(TEACHER_ID).eq(teacherId)).and(notExists(
                select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE))
                        .where(field(GROUP_TEACHER_ID).eq(field(TEACHER_ID))).and(not(field(GROUP_CATEGORY_ID).in(
                                select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE))
                                        .where(field(GROUP_TEACHER_ID).eq(teacherId))))))).and(notExists(
                select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE)).where(field(GROUP_TEACHER_ID).eq(teacherId)
                        .and(not(field(GROUP_CATEGORY_ID).in(select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE))
                                .where(field(GROUP_TEACHER_ID).eq(field(TEACHER_ID))))))))));

        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new TeacherRowMapper());
    }

    public List<Teacher> query3(Long teacherId) {

        Query query = select().from(table(TEACHERS_TABLE)).where(not(field(TEACHER_ID).eq(teacherId)).and(notExists(
                select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE)).where(field(GROUP_TEACHER_ID).eq(teacherId)
                        .and(not(field(GROUP_CATEGORY_ID).in(select(field(GROUP_CATEGORY_ID)).from(table(GROUPS_TABLE))
                                .where(field(GROUP_TEACHER_ID).eq(field(TEACHER_ID))))))))));
        System.out.println(query.getSQL());
        return jdbcTemplate.query(query.getSQL(ParamType.INLINED), new TeacherRowMapper());
    }
}
