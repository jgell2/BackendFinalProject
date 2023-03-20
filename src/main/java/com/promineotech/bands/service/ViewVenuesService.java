package com.promineotech.bands.service;

import java.util.List;
import com.promineotech.bands.entity.Venue;

//interface for the get operations for Venues
public interface ViewVenuesService {

  List<Venue> fetchVenues();

}
