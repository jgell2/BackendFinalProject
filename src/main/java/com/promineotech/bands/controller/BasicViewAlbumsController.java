package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Album;
import com.promineotech.bands.service.ViewAlbumsService;
import lombok.extern.slf4j.Slf4j;

//implementing class of albums controller
@RestController
@Slf4j
public class BasicViewAlbumsController implements ViewAlbumsController {
  
  //instance of the ViewAlbumsService class
  @Autowired
  private ViewAlbumsService viewAlbumsService;

  /*  logs a line to ensure that the request has gone through the controller 
   * then runs the fetch albums method on the service interface
   * */
  @Override
  public List<Album> fetchAlbums() {
    log.info("fetching albums - controller");
    return viewAlbumsService.fetchAlbums();
  }

}
