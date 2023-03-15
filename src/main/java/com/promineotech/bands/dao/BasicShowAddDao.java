package com.promineotech.bands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.entity.City;
import com.promineotech.bands.entity.Genre;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.entity.Venue;

@Component
public class BasicShowAddDao implements ShowAddDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
  @Override
  public Shows saveShow(Band band, City city, Venue venue, List<Genre> genres) {
    SqlParams params = generateInsertSql(band, city, venue);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long showPK = keyHolder.getKey().longValue();
    saveGenres(genres, showPK);
    
    // @formatter:off
    return Shows.builder()
        .showPK(showPK)
        .band(band)
        .city(city)
        .venue(venue)
        .genres(genres)
        .build();
    // @formatter:on
  }


  private void saveGenres(List<Genre> genres, Long showPK) {
    for(Genre genre: genres) {
      SqlParams params = generateInsertSqlGenre(genre, showPK);
      jdbcTemplate.update(params.sql, params.source);
    }
    
  }


  private SqlParams generateInsertSqlGenre(Genre genre, Long showPK) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO shows_genre ("
        + "show_fk, genre_fk"
        + ") VALUES ("
        + ":show_fk, :genre_fk"
        + ")";
    // @formatter:on
    
    params.source.addValue("show_fk", showPK);
    params.source.addValue("genre_fk", genre.getGenrePK());
    
    return params;
  }


  private SqlParams generateInsertSql(Band band, City city, Venue venue) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO shows ("
        + "band_fk, city_fk, venue_fk"
        + ") VALUES ("
        + ":band_fk, :city_fk, :venue_fk"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("band_fk", band.getBandPK());
    params.source.addValue("city_fk", city.getCityPK());
    params.source.addValue("venue_fk", venue.getVenuePK());
    
    return params;
  }

  @Override
  public List<Genre> fetchGenre(List<String> genres) {
    if(genres.isEmpty()) {
      return new LinkedList<>();
    }
    
    Map<String, Object> params = new HashMap<>();
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM genre "
        + "WHERE genre_name IN(";
    // @formatter:on
    
    for(int index = 0; index < genres.size(); index++) {
      String key = "genre_" + index;
      sql += ":" + key + ", ";
      params.put(key, genres.get(index));
    }
    
    sql = sql.substring(0, sql.length() - 2);
    sql += ")";
    
    return jdbcTemplate.query(sql, params, new RowMapper<Genre>() {

      @Override
      public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Genre.builder()
            .genrePK(rs.getLong("genre_pk"))
            .genreName(rs.getString("genre_name"))
            .build();
        // @formatter:on
      }});
  }

  @Override
  public Optional<Band> fetchBand(String band) {
    String sql = ""
    + "SELECT * "
    + "FROM band "
    + "WHERE band_name = :band_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("band_name", band);
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new BandResultSetExtractor()));
  }
  
  @Override
  public Optional<City> fetchCity(String city, String state) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM city "
        + "WHERE city_name = :city_name "
        + "AND state_name = :state_name";
    // @ formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("city_name", city);
    params.put("state_name", state);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CityResultSetExtractor()));
  }


  @Override
  public Optional<Venue> fetchVenue(String venue) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM venue "
        + "WHERE venue_name = :venue_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("venue_name", venue);
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new VenueResultSetExtractor()));
  }
  
  class VenueResultSetExtractor implements ResultSetExtractor<Venue>{

    @Override
    public Venue extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      
      // @formatter:off
      return Venue.builder()
          .venuePK(rs.getLong("venue_pk"))
          .venueName(rs.getString("venue_name"))
          .build();
    }
    
  }

  class BandResultSetExtractor implements ResultSetExtractor<Band>{

    @Override
    public Band extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      
      // @formatter:off
      return Band.builder()
          .bandPK(rs.getLong("band_pk"))
          .bandName(rs.getString("band_name"))
          .yearStarted(rs.getInt("year_started"))
          .nextShowDate(rs.getDate("next_show_date"))
          .build();
    }
    
  }
  
  class CityResultSetExtractor implements ResultSetExtractor<City>{

    @Override
    public City extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      
      // @formatter:off
      return City.builder()
          .cityPK(rs.getLong("city_pk"))
          .cityName(rs.getString("city_name"))
          .stateName(rs.getString("state_name"))
          .build();
      // @formatter:on
    }
    
  }



  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
}
