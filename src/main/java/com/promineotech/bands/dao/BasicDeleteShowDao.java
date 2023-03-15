package com.promineotech.bands.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Shows;

@Component
public class BasicDeleteShowDao implements DeleteShowDao {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void deleteShow(Long showPK) {
    String sql = "DELETE FROM shows WHERE show_pk = ?";
    jdbcTemplate.update(sql, showPK);
  }

}
