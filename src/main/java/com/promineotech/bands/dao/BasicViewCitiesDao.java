package com.promineotech.bands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.City;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicViewCitiesDao implements ViewCitiesDao {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<City> fetchBands() {
    log.debug("DAO: Finalizing fetch cities");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM city";
    // @ formatter:on
    
    List<City> cities = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();
        city.setCityPK(rs.getLong("city_pk"));
        city.setCityName(rs.getString("city_name"));
        city.setStateName(rs.getString("state_name"));
        return city;
      }
      
    });
    return cities;
  }

}
