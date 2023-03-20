package com.promineotech.bands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.entity.City;
import com.promineotech.bands.entity.Genre;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.entity.Venue;
import lombok.extern.slf4j.Slf4j;

//implementing class of the view shows dao interface
@Component
@Slf4j
public class BasicViewShowsDao implements ViewShowsDao {

  //uses a jdbc object to talk to the database
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  /*fetch shows method logs a line in the console so the user is aware that the request has passed 
   * into the DAO layer then a SQL statement is generated and passed into the jdbc template object 
   * with the query method as well as a custom row mapper called "Show Row Mapper"*/
  @SuppressWarnings("deprecation")
  @Override
  public List<Shows> fetchShows() {
    log.debug("DAO: Finalizing fetch Show...");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM shows";
    // @formatter:on
    
    List<Shows> shows =  jdbcTemplate.query(sql, new ShowsRowMapper(jdbcTemplate)); 

    /**the loop below assigns the Genres to the respective component in a show object utilizing a 
     * sql statement and the query method**/
    for (Shows show : shows) {
      List<Genre> genres = jdbcTemplate.query("SELECT * "
          + "FROM genre INNER JOIN shows_genre ON genre.genre_pk = shows_genre.genre_fk "
          + "WHERE shows_genre.show_fk = ?", 
          new Object[] { show.getShowPK() }, new GenreRowMapper());
      show.setGenres(genres);
  }

  return shows;

  
}

//Shows row mapper uses a jdbc template to create the Show object
class ShowsRowMapper implements RowMapper<Shows>{
  private final JdbcTemplate jdbcTemplate;

  
  public ShowsRowMapper(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /*below uses the row mapper method and the jdbc template's query for object method to assign the 
   * values of each custom object component to their respective components in the entity class*/
  @SuppressWarnings("deprecation")
  @Override
  public Shows mapRow(ResultSet rs, int rowNum) throws SQLException {
    Shows show = new Shows();
    show.setShowPK(rs.getLong("show_pk"));
    
    Long bandFk = rs.getLong("band_fk");
    Band band = jdbcTemplate.queryForObject(
        "SELECT * FROM band WHERE band_pk = ?",
        new Object[] {bandFk},
        new BeanPropertyRowMapper<>(Band.class));
    show.setBand(band);
    
    Long venueFk = rs.getLong("venue_fk");
    Venue venue = jdbcTemplate.queryForObject(
        "SELECT * FROM venue WHERE venue_pk = ?",
        new Object[] {venueFk},
        new BeanPropertyRowMapper<>(Venue.class));
    show.setVenue(venue);
    
    Long cityFk = rs.getLong("city_fk");
    City city = jdbcTemplate.queryForObject(
        "SELECT * FROM city WHERE city_pk= ?",
        new Object[] {cityFk},
        new BeanPropertyRowMapper<>(City.class));
    show.setCity(city);
    
    return show;
  }
}

/*The genre row mapper is used to create the Genre object and assign the values to 
 * the list in the Show entity*/
public class GenreRowMapper implements RowMapper<Genre> {

  @Override
  public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
      Genre genre = new Genre();
      genre.setGenrePK(rs.getLong("genre_pk"));
      genre.setGenreName(rs.getString("genre_name"));
      return genre;
  }
}

}

