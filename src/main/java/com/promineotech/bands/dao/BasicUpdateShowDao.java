package com.promineotech.bands.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Genre;
import com.promineotech.bands.entity.Shows;

//implementing class of the update shows dao interface
@Component
public class BasicUpdateShowDao implements UpdateShowDao {

  //uses a jdbc object to talk to the database
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  /*Update ShowBand method first uses a SQL statement to change 
   * the components of a show when a particular show PK is passed in
   * */
  @Override
  public Shows updateShowBand(Long showPK, Shows show) {
    // @formatter:off
    String sql = ""
        + "UPDATE shows "
        + "SET band_fk = ?, city_fk = ?, venue_fk = ? "
        + "WHERE show_pk = ?";
    //sql statement as well as the get methods for each component's PKs are ran
    jdbcTemplate.update(sql, show.getBand().getBandPK(), 
        show.getCity().getCityPK(), show.getVenue().getVenuePK(), showPK);
    
    //a new SQL string is passed through to delete the show & genre relationship in the shows_genre table
    String deleteSql = "DELETE FROM shows_genre WHERE show_fk = ?";
    jdbcTemplate.update(deleteSql, showPK);
    
    //a final sql statement is passed into our database to create a new relationship with genres for this update
    String insertSql = "INSERT INTO shows_genre (show_fk, genre_fk) VALUES (?, ?)";
    for (Genre genre : show.getGenres()) {
      jdbcTemplate.update(insertSql, showPK, genre.getGenrePK());
    }
    
    return show;
  }

}
