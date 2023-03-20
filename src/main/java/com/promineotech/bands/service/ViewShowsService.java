package com.promineotech.bands.service;

import java.util.List;
import com.promineotech.bands.entity.Shows;

//interface for the get operations for Shows

public interface ViewShowsService {

  List<Shows> fetchShows();

}
