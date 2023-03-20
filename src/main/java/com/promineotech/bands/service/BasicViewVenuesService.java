package com.promineotech.bands.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewVenuesDao;
import com.promineotech.bands.entity.Venue;
import lombok.extern.slf4j.Slf4j;


//implementing class for view venues service interface
@Service
@Slf4j
public class BasicViewVenuesService implements ViewVenuesService {
  
  //creates a new instance of the view venues DAO interface
  @Autowired
  ViewVenuesDao viewVenuesDao;

  /**
   * logs a line in the console letting the user know the request has passed into the service layer,
   * runs and returns the fetch method on the Dao interface
   * */
  @Override
  public List<Venue> fetchVenues() {
    log.info("fetching all venues - service");
    return viewVenuesDao.fetchVenues();
  }

}
