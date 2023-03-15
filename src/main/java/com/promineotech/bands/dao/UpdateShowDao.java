package com.promineotech.bands.dao;

import com.promineotech.bands.entity.Shows;

public interface UpdateShowDao {

  Shows updateShowBand(Long showPK, Shows show);

}
