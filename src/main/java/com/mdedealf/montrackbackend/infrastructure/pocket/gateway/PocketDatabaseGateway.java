package com.mdedealf.montrackbackend.infrastructure.pocket.gateway;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PocketDatabaseGateway {
    private final JdbcTemplate jdbcTemplate;

    public PocketDatabaseGateway(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
