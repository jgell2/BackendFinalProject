package com.promineotech.bands.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.ShowRequest;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.ShowAddService;
import lombok.extern.slf4j.Slf4j;

//implementing class for the add show controller
@RestController
@Slf4j
public class BasicShowAddController implements ShowAddController {
  
  //implements an instnace of the Show Add service interface
  @Autowired
  private ShowAddService showAddService;

  /**logs a line in the console for the user to ensure request has passed into controller layer, 
   * returns the create show method on the service layer interface
   * */
  @Override
  public Shows createShow(ShowRequest showRequest) {
    log.debug("Show={}", showRequest);
    return showAddService.createShow(showRequest);
  }


}
