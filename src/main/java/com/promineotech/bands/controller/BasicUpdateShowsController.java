package com.promineotech.bands.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.UpdateShowService;
import lombok.extern.slf4j.Slf4j;

//implementing class of the update shows controller
@RestController
@Slf4j
public class BasicUpdateShowsController implements UpdateShowsController {
  
  //implements an instance of the update show service interface
  @Autowired
  private UpdateShowService updateShowService;

  /**logs a line in the console for the user to ensure request has passed into controller layer, 
   * returns the update show method on the service layer interface
   * */
  @Override
  public Shows updateShowBand(Long showPK, Shows show) {
    log.debug("Show={} will be updated with the following JSON={}", showPK, show);
    return updateShowService.updateShowBand(showPK, show);
  }

}
