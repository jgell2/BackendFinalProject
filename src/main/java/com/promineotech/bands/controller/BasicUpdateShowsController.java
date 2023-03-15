package com.promineotech.bands.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.UpdateShowService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicUpdateShowsController implements UpdateShowsController {
  
  @Autowired
  private UpdateShowService updateShowService;

  @Override
  public Shows updateShowBand(Long showPK, Shows show) {
    log.debug("Show={} will be updated with the following JSON={}", showPK, show);
    return updateShowService.updateShowBand(showPK, show);
  }

}
