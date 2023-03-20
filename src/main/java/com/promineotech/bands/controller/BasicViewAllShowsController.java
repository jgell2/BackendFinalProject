package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.ViewShowsService;
import lombok.extern.slf4j.Slf4j;

//implementing class for the view shows controller
@RestController
@Slf4j
public class BasicViewAllShowsController implements ViewAllShowsController {
  
  //implements the view shows service interface
  @Autowired
  private ViewShowsService viewShowsService;

  /**logs a line in the console for the user to ensure request has passed into controller layer, 
   * returns the fetch method on the service layer interface
   * */
  @Override
  public List<Shows> fetchShows() {
   log.info("fetching all shows - controller");
   return viewShowsService.fetchShows();
  }

}
