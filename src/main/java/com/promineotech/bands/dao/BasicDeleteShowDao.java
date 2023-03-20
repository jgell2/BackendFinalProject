package com.promineotech.bands.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.bands.entity.Shows;


//implementing class of the delete shows dao interface
@Component
public class BasicDeleteShowDao implements DeleteShowDao {
  
  //uses a jdbc template object to talk to the database
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /*delete method runs a sql statement on the PK designated by the request body to delete a row from 
   * the database and uses the update method on the jdbcTemplate to to do that*/
  @Override
  public void deleteShow(Long showPK) {
    String sql = "DELETE FROM shows WHERE show_pk = ?";
    jdbcTemplate.update(sql, showPK);
  }

}
