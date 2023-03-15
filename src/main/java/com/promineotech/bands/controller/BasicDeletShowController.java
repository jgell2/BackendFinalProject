package com.promineotech.bands.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.DeleteShowService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicDeletShowController implements DeleteShowController {
  
  @Autowired
  private DeleteShowService deleteShowService;

  @Override
  public void deleteShow(Long showPK) {
    log.debug("Show = {} will be deleted.", showPK);
    deleteShowService.deleteShow(showPK);
  }

}
