package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Venue;
import com.promineotech.bands.service.ViewVenuesService;
import lombok.extern.slf4j.Slf4j;

//implementing class for the view venues controller
@RestController
@Slf4j
public class BasicViewAllVenuesController implements ViewAllVenuesController {
  
  //implements the view venues service interface
  @Autowired
  private ViewVenuesService viewVenuesService;

  /**logs a line in the console for the user to ensure request has passed into controller layer, 
   * returns the fetch method on the service layer interface
   * */
  @Override
  public List<Venue> fetchVenue() {
    log.info("fetching all venues - controller");
    return viewVenuesService.fetchVenues();
  }

}
