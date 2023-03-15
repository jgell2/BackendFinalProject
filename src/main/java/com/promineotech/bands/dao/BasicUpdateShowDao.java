package com.promineotech.bands.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Genre;
import com.promineotech.bands.entity.Shows;

@Component
public class BasicUpdateShowDao implements UpdateShowDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public Shows updateShowBand(Long showPK, Shows show) {
    // @formatter:off
    String sql = ""
        + "UPDATE shows "
        + "SET band_fk = ?, city_fk = ?, venue_fk = ? "
        + "WHERE show_pk = ?";
    jdbcTemplate.update(sql, show.getBand().getBandPK(), 
        show.getCity().getCityPK(), show.getVenue().getVenuePK(), showPK);
    
    String deleteSql = "DELETE FROM shows_genre WHERE show_fk = ?";
    jdbcTemplate.update(deleteSql, showPK);
    
    String insertSql = "INSERT INTO shows_genre (show_fk, genre_fk) VALUES (?, ?)";
    for (Genre genre : show.getGenres()) {
      jdbcTemplate.update(insertSql, showPK, genre.getGenrePK());
    }
    
    return show;
  }

}
