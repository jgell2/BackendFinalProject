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

@Component
@Slf4j
public class BasicViewAlbumsDao implements ViewAlbumsDao {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

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
