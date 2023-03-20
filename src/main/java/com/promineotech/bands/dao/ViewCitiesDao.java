package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.City;

//interface containing the view methods on the DAO layer for cities
public interface ViewCitiesDao {

  List<City> fetchCities();

}
