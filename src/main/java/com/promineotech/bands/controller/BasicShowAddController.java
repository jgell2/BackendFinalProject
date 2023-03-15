package com.promineotech.bands.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.ShowRequest;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.ShowAddService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicShowAddController implements ShowAddController {
  
  @Autowired
  private ShowAddService showAddService;

  @Override
  public Shows createShow(ShowRequest showRequest) {
    log.debug("Show={}", showRequest);
    return showAddService.createShow(showRequest);
  }


}
