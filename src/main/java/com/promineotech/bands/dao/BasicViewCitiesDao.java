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

//implementing class of the view cities dao interface
@Component
@Slf4j
public class BasicViewCitiesDao implements ViewCitiesDao {
  
//uses a jdbc object to talk to the database
  @Autowired
  private JdbcTemplate jdbcTemplate;


  /*fetch method first logs a line in the console to let the user know the request has passed into 
   * the DAO layer then a SQL statement is generated and a list of cities is created and the jdbc 
   * template is assigned as its value running the query method on it, the sql statement as well as 
   * a basic row mapper is used in the constructor*/
  @Override
  public List<City> fetchCities() {
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
