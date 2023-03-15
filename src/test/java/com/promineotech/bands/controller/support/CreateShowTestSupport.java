package com.promineotech.bands.controller.support;

public class CreateShowTestSupport extends BaseTest {
  
  protected String createShowBody() {
    // @formatter:off
    return "{\n"
        + "  \"band\":\"No Thanks\",\n"
        + "  \"city\":\"Omaha\",\n"
        + "  \"state\":\"Nebraska\",\n"
        + "  \"venue\":\"The Slowdown\",\n"
        + "  \"genres\":[\n"
        + "    \"Punk\",\n"
        + "    \"Goth\",\n"
        + "    \"Hardcore\"\n"
        + "  ]\n"
        + "}";
    // @formatter:on
  }

}
