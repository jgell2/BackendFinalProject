package com.promineotech.bands.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewCitiesDao;
import com.promineotech.bands.entity.City;
import lombok.extern.slf4j.Slf4j;

//implementing class for view cities service interface
@Service
@Slf4j
public class BasicViewCitiesService implements ViewCitiesService {
  
  //creates a new instance of the view cities DAO interface
  @Autowired
  private ViewCitiesDao viewCitiesDao;

  /**
   * logs a line in the console letting the user know the request has passed into the service layer,
   * runs and returns the fetch method on the Dao interface
   * */
  @Override
  public List<City> fetchCities() {
    log.info("fetching all cities - service");
    return viewCitiesDao.fetchCities();
  }

}
