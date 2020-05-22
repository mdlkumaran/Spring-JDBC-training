package com.mdl.springdata.dao;

import com.mdl.springdata.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

@Component
public class jdbcDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int getCircleCount() {

        String sql =  "SELECT COUNT(*) FROM CIRCLE";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public String getCircleForParam(int circleId) {

        String sql =  "SELECT CIRCLETYPE FROM CIRCLE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
    }

    public Circle getCircleForId(int circleId) {

        String sql =  "SELECT * FROM CIRCLE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());

    }

    public List<Circle> getAllCirclesById(int circleId) {

        String sql =  "SELECT * FROM CIRCLE WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{circleId}, new CircleMapper());

    }

    public List<Circle> getAllCircles() {

        String sql =  "SELECT * FROM CIRCLE";
        return jdbcTemplate.query(sql, new CircleMapper());

    }

    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            fillRow(circle, resultSet);
            return circle;
        }

        private void fillRow(Circle circle, ResultSet resultSet) throws SQLException {
            ResultSetMetaData meta = resultSet.getMetaData();
            circle.setId(resultSet.getInt("ID"));
            circle.setName(resultSet.getString("CIRCLENAME"));
            circle.setType(resultSet.getString("CIRCLETYPE"));
        }
    }

    public void createTriangle() {
        String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }

    public void insertTriangle(int id, String name) {
        String sql = "INSERT INTO CIRCLE(id,name) VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{id, name});
    }

    public int triangleCount() {

        String sql =  "SELECT COUNT(*) FROM TRIANGLE";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public void insertCircle(int id, String name) {
        String sql = "INSERT INTO CIRCLE(id,circlename) values(:id,:name)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id)
                .addValue("name", name);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }
}
