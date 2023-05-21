package com.example.lab2.repository;

import com.example.lab2.entity.Group;
import com.example.lab2.util.row_mapper.GroupRowMapper;
import org.jooq.Query;
import org.jooq.conf.ParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.lab2.util.DBConstants.*;
import static org.jooq.impl.DSL.*;

@Repository
public class GroupRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertEntity(Group group) {

        String sql = insertInto(table(GROUPS_TABLE), field(GROUP_ID), field(GROUP_START_DATE), field(GROUP_CATEGORY_ID),
                field(GROUP_TEACHER_ID)).values(group.getId(), group.getStartDate(), group.getCategoryId(),
                group.getTeacherId()).getSQL(ParamType.INLINED);

        try {
            jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            return false;
        }

        return true;
    }

    public Optional<Group> getEntity(Long id) {

        String sql = select().from(table(GROUPS_TABLE)).where(field(GROUP_ID).eq(id)).getSQL(ParamType.INLINED);

        Optional<Group> result;
        try {
            result = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new GroupRowMapper()));
        } catch (DataAccessException e) {
            result = Optional.empty();
        }

        return result;
    }

    public int updateEntity(Group group) {

        String sql = update(table(GROUPS_TABLE)).set(field(GROUP_LECTURES_COVERED), group.getLecturesCovered())
                .set(field(GROUP_START_DATE), group.getStartDate()).set(field(GROUP_CATEGORY_ID), group.getCategoryId())
                .set(field(GROUP_TEACHER_ID), group.getTeacherId()).where(field(GROUP_ID).eq(group.getId()))
                .getSQL(ParamType.INLINED);

        return jdbcTemplate.update(sql);
    }

    public int deleteEntity(Long id) {

        String sql = delete(table(GROUPS_TABLE)).where(field(GROUP_ID).eq(id)).getSQL(ParamType.INLINED);

        return jdbcTemplate.update(sql);
    }
}
