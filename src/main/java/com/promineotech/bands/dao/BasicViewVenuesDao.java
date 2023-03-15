package com.promineotech.bands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Venue;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicViewVenuesDao implements ViewVenuesDao {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Venue> fetchVenues() {
    log.debug("DAO: Finalizing fetch venues");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM venue";
    // @formatter:on
    
    List<Venue> venues = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Venue mapRow(ResultSet rs, int rowNum) throws SQLException {
        Venue venue = new Venue();
        venue.setVenuePK(rs.getLong("venue_pk"));
        venue.setVenueName(rs.getString("venue_name"));
        return venue;
      }
      
    });
  return venues;
  }

}
