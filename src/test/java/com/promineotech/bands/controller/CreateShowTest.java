package com.promineotech.bands.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import com.promineotech.bands.controller.support.CreateShowTestSupport;
import com.promineotech.bands.entity.Shows;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0_Bands_Schema.sql",
    "classpath:flyway/migrations/V1.1_Bands_Data.sql"}, 
     config = @SqlConfig(encoding = "utf-8"))
class CreateShowTest extends CreateShowTestSupport{

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Test
  void testCreateShowOrderReturnsSuccess201() {
    //Given: a show as JSON
    String body = createShowBody();
    String uri = getBaseUriForShows();
    
    int numRowsShows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "shows");
    int numRowsGenres = JdbcTestUtils.countRowsInTable(jdbcTemplate, "shows_genre");
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
    //When: the show is sent
    ResponseEntity<Shows> response = getRestTemplate().exchange(uri, HttpMethod.POST, bodyEntity, Shows.class);
    
    //Then: a 201 status is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    
    //And: the returned show is correct
    assertThat(response.getBody()).isNotNull();
    
    Shows show = response.getBody();
    assertThat(show.getBand().getBandName()).isEqualTo("No Thanks");
    assertThat(show.getCity().getCityName()).isEqualTo("Omaha");
    assertThat(show.getCity().getStateName()).isEqualTo("Nebraska");
    assertThat(show.getVenue().getVenueName()).isEqualTo("The Slowdown");
    assertThat(show.getGenres()).hasSize(3);
    
    assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "shows")).isEqualTo(numRowsShows + 1);
    assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "shows_genre")).isEqualTo(numRowsGenres + 3);
  }

}
