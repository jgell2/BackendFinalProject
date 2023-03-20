package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.service.ViewBandsService;
import lombok.extern.slf4j.Slf4j;

//implementing class for the view bands controller
@RestController
@Slf4j
public class BasicViewAllBandsController implements ViewAllBandsController {
  
  //implements the view bands service interface
  @Autowired
  private ViewBandsService viewBandsService;

  /**logs a line in the console for the user to ensure request has passed into controller layer, 
   * returns the fetch method on the service layer interface
   * */
  @Override
  public List<Band> fetchBands() {
    log.info("fetching all bands - controller");
    return viewBandsService.fetchBands();
  }
  
  

}
