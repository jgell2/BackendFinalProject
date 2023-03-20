package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.City;
import com.promineotech.bands.service.ViewCitiesService;
import lombok.extern.slf4j.Slf4j;

//implementing class for the view cities controller
@RestController
@Slf4j
public class BasicViewCitiesController implements ViewCitiesController {
  
  //implements the view cities service interface
  @Autowired
  private ViewCitiesService viewCitiesService;

  /**logs a line in the console for the user to ensure request has passed into controller layer, 
   * returns the fetch method on the service layer interface
   * */
  @Override
  public List<City> fetchCities() {
    log.info("fetching all cities - controller");
    return viewCitiesService.fetchCities();
  }

}
