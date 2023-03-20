package com.promineotech.bands.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.DeleteShowService;
import lombok.extern.slf4j.Slf4j;

//implementing class of the delete show controller
@RestController
@Slf4j
public class BasicDeleteShowController implements DeleteShowController {
  
  //implements an instance of the delete show service interface
  @Autowired
  private DeleteShowService deleteShowService;

  /**logs a line in the console for the user to ensure request has passed into controller layer 
   * and provides the PK of the show being deleted, 
   * returns the delete method on the service layer interface
   * */
  @Override
  public void deleteShow(Long showPK) {
    log.debug("Show = {} will be deleted.", showPK);
    deleteShowService.deleteShow(showPK);
  }

}
