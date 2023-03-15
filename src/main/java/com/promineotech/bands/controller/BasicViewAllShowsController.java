package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.service.ViewShowsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicViewAllShowsController implements ViewAllShowsController {
  
  @Autowired
  private ViewShowsService viewShowsService;

  @Override
  public List<Shows> fetchShows() {
   log.info("fetching all shows - controller");
   return viewShowsService.fetchShows();
  }

}
