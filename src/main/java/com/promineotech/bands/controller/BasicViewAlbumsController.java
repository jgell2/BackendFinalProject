package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Album;
import com.promineotech.bands.service.ViewAlbumsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicViewAlbumsController implements ViewAlbumsController {
  
  @Autowired
  private ViewAlbumsService viewAlbumsService;

  @Override
  public List<Album> fetchAlbums() {
    log.info("fetching albums - controller");
    return viewAlbumsService.fetchAlbums();
  }

}
