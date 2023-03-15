package com.promineotech.bands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Band;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicViewBandsDao implements ViewBandsDao {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Band> fetchBands() {
    log.debug("DAO: Finalizing fetch bands");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM band";
    // @formatter:on
    
    List<Band> bands = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Band mapRow(ResultSet rs, int rowNum) throws SQLException {
        Band band = new Band();
        band.setBandPK(rs.getLong("band_pk"));
        band.setBandName(rs.getString("band_name"));
        band.setYearStarted(rs.getInt("year_started"));
        band.setNextShowDate(rs.getDate("next_show_date"));
        return band;
      }});
    
    return bands;
  }

}
