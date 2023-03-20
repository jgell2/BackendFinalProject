package com.promineotech.bands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Album;
import com.promineotech.bands.entity.Band;
import lombok.extern.slf4j.Slf4j;

//implementing class of the DAO level interface for the get operation on album
@Component
@Slf4j
public class BasicViewAlbumsDao implements ViewAlbumsDao {
  
  //instantiates an instance of the jdbc template object used to pass data to and from the DB
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /*fetch album method prints a log line in the console to let user know the data has 
   *passed through into the data layer then a SQL statement is ran and passed into the jdbcTemplate 
   *object where the query method is ran on it which takes the sql statement and a class called 
   * "Album Row Mapper" which implements a standard Row Mapper and passes the jdbc template object in
   * the constructor
   * */
  @Override
  public List<Album> fetchAlbums() {
    log.debug("DAO: finalizing fetch Albums...");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM album";
    // @formatter:on
    
    List<Album> albums = jdbcTemplate.query(sql, new AlbumsRowMapper(jdbcTemplate));
    
    return albums;
  }
  
  /*the AlbumsRowMapper class builds an album object to be returned to the user accessing 
   * the URI "/view-albums." A custom row mapper such as this is needed because the album entity 
   * utilizes the band foreign key and as a result needs to create the band object to set the fk's 
   * value equal to it. Once the album object is created it is then passed back to our main class 
   * and returned as a list of albums
   * */
  class AlbumsRowMapper implements RowMapper<Album>{
    private final JdbcTemplate jdbcTemplate;
    
    public AlbumsRowMapper(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
      Album album = new Album();
      album.setAlbumPK(rs.getLong("album_pk"));
      album.setAlbumName(rs.getString("album_name"));
      
      Long bandFk = rs.getLong("band_fk");
      Band band = jdbcTemplate.queryForObject("SELECT * FROM band WHERE band_pk = ?", 
          new Object[] {bandFk}, 
          new BeanPropertyRowMapper<>(Band.class));
      album.setBand(band);
      return album;
    }
    
  }

}
