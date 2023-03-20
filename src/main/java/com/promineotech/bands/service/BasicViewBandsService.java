package com.promineotech.bands.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewBandsDao;
import com.promineotech.bands.entity.Band;
import lombok.extern.slf4j.Slf4j;

//implementing class for view bands service interface
@Service
@Slf4j
public class BasicViewBandsService implements ViewBandsService {
  
  //creates a new instance of the view bands DAO interface
  @Autowired
  private ViewBandsDao viewBandsDao;

  /**
   * logs a line in the console letting the user know the request has passed into the service layer,
   * runs and returns the fetch method on the Dao interface, if there are no bands, 
   * an error message is returned instead
   * */
  @Override
  public List<Band> fetchBands() {
    log.info("fetchBands running... - service");
    
    List<Band> bands = viewBandsDao.fetchBands();
    
    if(bands.isEmpty()) {
      String msg = String.format("No bands were found");
      
      throw new NoSuchElementException(msg);
    }
    
    return bands;
  }

}
