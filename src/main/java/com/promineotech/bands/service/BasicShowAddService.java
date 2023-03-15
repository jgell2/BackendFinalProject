package com.promineotech.bands.service;


import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ShowAddDao;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.entity.ShowRequest;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.entity.Venue;
import com.promineotech.bands.entity.City;
import com.promineotech.bands.entity.Genre;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicShowAddService implements ShowAddService {
  
  @Autowired
  private ShowAddDao showAddDao;

  @Override
  public Shows createShow(ShowRequest showRequest) {
    log.debug("Show={}", showRequest);
    Band band = getBand(showRequest);
    City city = getCity(showRequest);
    Venue venue = getVenue(showRequest);
    List<Genre> genres = getGenre(showRequest);
    
    return showAddDao.saveShow(band, city, venue, genres);
  }

  private List<Genre> getGenre(ShowRequest showRequest) {
    return showAddDao.fetchGenre(showRequest.getGenres());
  }

  private Venue getVenue(ShowRequest showRequest) {
    return showAddDao.fetchVenue(showRequest.getVenue()).orElseThrow(() -> new NoSuchElementException("Venue with ID=" + showRequest.getVenue() + " was not found"));
  }

  private City getCity(ShowRequest showRequest) {
    return showAddDao.fetchCity(showRequest.getCity(), showRequest.getState()).orElseThrow(() -> new NoSuchElementException("City with ID=" + showRequest.getCity() + " state =" + showRequest.getState() + " was not found"));
  }

  private Band getBand(ShowRequest showRequest) {
    return showAddDao.fetchBand(showRequest.getBand()).orElseThrow(() -> new NoSuchElementException("Band with ID=" + showRequest.getBand() + " was not found"));
  }


}


