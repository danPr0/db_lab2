package com.example.lab2.repository;

import com.example.lab2.entity.Group;
import com.example.lab2.entity.Student;
import com.example.lab2.util.row_mapper.GroupRowMapper;
import com.example.lab2.util.row_mapper.StudentRowMapper;
import org.jooq.conf.ParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.lab2.util.DBConstants.*;
import static org.jooq.impl.DSL.*;

@Repository
public class StudentsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertEntity(Student student) {

        String sql =
                insertInto(table(STUDENTS_TABLE)).values(student.getId(), student.getEmail(), student.getPhoneNumber(),
                        student.getFirstName(), student.getSecondName(), student.getPracticeCount(),
                        student.getGroupId(), student.getInstructorId()).getSQL(ParamType.INLINED);

        try {
            jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            return false;
        }

        return true;
    }

    public Optional<Student> getEntity(Long id) {

        String sql = select().from(table(STUDENTS_TABLE)).where(field(STUDENT_ID).eq(id)).getSQL(ParamType.INLINED);

        Optional<Student> result;
        try {
            result = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new StudentRowMapper()));
        } catch (DataAccessException e) {
            result = Optional.empty();
        }

        return result;
    }

    public int updateEntity(Student student) {

        String sql = update(table(STUDENTS_TABLE)).set(field(STUDENT_EMAIL), student.getEmail())
                .set(field(STUDENT_PHONE_NUMBER), student.getPhoneNumber())
                .set(field(STUDENT_FIRST_NAME), student.getFirstName())
                .set(field(STUDENT_SECOND_NAME), student.getSecondName())
                .set(field(STUDENT_PRACTICE_COUNT), student.getPracticeCount())
                .set(field(STUDENT_GROUP_ID), student.getGroupId())
                .set(field(STUDENT_INSTRUCTOR_ID), student.getInstructorId())
                .where(field(STUDENT_ID).eq(student.getId())).getSQL(ParamType.INLINED);

        return jdbcTemplate.update(sql);
    }

    public int deleteEntity(Long id) {

        String sql = delete(table(STUDENTS_TABLE)).where(field(STUDENT_ID).eq(id)).getSQL(ParamType.INLINED);

        return jdbcTemplate.update(sql);
    }
}
