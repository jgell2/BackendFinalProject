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

//implementing class of the view venues dao interface
@Component
@Slf4j
public class BasicViewVenuesDao implements ViewVenuesDao {
  
  //uses a jdbc template object to talk to the database
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /*fetch method first logs a line in the console to let the user know the request has passed into 
   * the DAO layer then a SQL statement is generated and a list of venues is created and the jdbc 
   * template is assigned as its value running the query method on it, the sql statement as well as 
   * a basic row mapper is used in the constructor*/
  @Override
  public List<Venue> fetchVenues() {
    log.debug("DAO: Finalizing fetch venues");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM venue";
    // @formatter:on
    
    List<Venue> venues = jdbcTemplate.query(sql, new RowMapper<>() {
//the row mapper method below creates the venue object and assigns the value to what is being returned
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
