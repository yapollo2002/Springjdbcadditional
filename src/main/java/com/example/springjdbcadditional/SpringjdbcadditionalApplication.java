package com.example.springjdbcadditional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringjdbcadditionalApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringjdbcadditionalApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringjdbcadditionalApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {


        jdbcTemplate.query(
                "SELECT id, telNum, description FROM acounting",
                (rs, rowNum) -> new Acounting(rs.getInt("id"), rs.getInt("telNum"), rs.getString("description"))
        ).forEach(acounting -> log.info(acounting.toString()));
    }
}