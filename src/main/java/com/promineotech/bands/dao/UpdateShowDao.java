package com.promineotech.bands.dao;

import com.promineotech.bands.entity.Shows;

//interface containing the update methods on the DAO layer for shows
public interface UpdateShowDao {

  Shows updateShowBand(Long showPK, Shows show);

}
