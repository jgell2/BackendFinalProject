package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Venue;

//interface containing the view methods on the DAO layer for venues
public interface ViewVenuesDao {

  List<Venue> fetchVenues();

}
