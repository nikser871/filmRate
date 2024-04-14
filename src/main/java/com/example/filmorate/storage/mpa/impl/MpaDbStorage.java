package com.example.filmorate.storage.mpa.impl;

import com.example.filmorate.model.Genre;
import com.example.filmorate.model.Mpa;
import com.example.filmorate.storage.mpa.MpaStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

@Component
public class MpaDbStorage implements MpaStorage {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    MpaDbStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    public Collection<Mpa> getAllMpa() {
        String sql = "SELECT * FROM mpa";
        return jdbcTemplate.query(sql, (rs, rowNum) -> getMpa(rs));
    }

    @Override
    public Optional<Mpa> getMpaById(int id) {
        String sql = "SELECT * FROM mpa WHERE id = ?";
        return Optional.of(jdbcTemplate.query(sql, (rs, rowNum) -> getMpa(rs), id).get(0));
    }


    private Mpa getMpa(ResultSet rs) {
        try {
            return new Mpa(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
