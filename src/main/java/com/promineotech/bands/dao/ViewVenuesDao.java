package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Venue;

public interface ViewVenuesDao {

  List<Venue> fetchVenues();

}
