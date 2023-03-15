package com.promineotech.bands.service;

import com.promineotech.bands.entity.ShowRequest;
import com.promineotech.bands.entity.Shows;

public interface ShowAddService {

  Shows createShow(ShowRequest showRequest);


}
