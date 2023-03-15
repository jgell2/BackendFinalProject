package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.service.ViewBandsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicViewAllBandsController implements ViewAllBandsController {
  
  @Autowired
  private ViewBandsService viewBandsService;

  @Override
  public List<Band> fetchBands() {
    log.info("fetching all bands - controller");
    return viewBandsService.fetchBands();
  }
  
  

}
