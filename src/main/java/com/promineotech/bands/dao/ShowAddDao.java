package com.promineotech.bands.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.entity.City;
import com.promineotech.bands.entity.Genre;
import com.promineotech.bands.entity.Shows;
import com.promineotech.bands.entity.Venue;

public interface ShowAddDao {

  Optional<Band> fetchBand(String band);

  Optional<City> fetchCity(String city, String state);

  Optional<Venue> fetchVenue(String venue);

  List<Genre> fetchGenre(List<String> genres);

  Shows saveShow(Band band, City city, Venue venue, List<Genre> genres);

}
