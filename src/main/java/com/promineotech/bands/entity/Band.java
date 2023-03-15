package com.promineotech.bands.entity;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Band implements Comparable<Band>{
  private Long bandPK;
  private String bandName;
  private int yearStarted;
  private Date nextShowDate;


  
  
  @Override
  public int compareTo(Band that) {
    // @formatter:off
    return Comparator
        .comparing(Band::getBandName)
        .thenComparing(Band::getYearStarted)
        .compare(this, that);
  }


}
