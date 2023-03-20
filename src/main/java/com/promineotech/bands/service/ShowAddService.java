package com.promineotech.bands.service;

import com.promineotech.bands.entity.ShowRequest;
import com.promineotech.bands.entity.Shows;

//interface for the put operations for shows

public interface ShowAddService {

  Shows createShow(ShowRequest showRequest);


}
