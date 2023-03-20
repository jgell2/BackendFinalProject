package com.promineotech.bands.service;

import java.util.List;
import com.promineotech.bands.entity.City;

//interface for the get operations for Cities

public interface ViewCitiesService {

  List<City> fetchCities();

}
