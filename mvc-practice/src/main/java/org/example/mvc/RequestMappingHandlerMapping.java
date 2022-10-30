package org.example.mvc;

import java.util.HashMap;
import java.util.Map;
import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;

public class RequestMappingHandlerMapping {
  // URI -> Controller (Router)
  private Map<String, Controller> mappings = new HashMap<>();

  void init() {
    mappings.put("/", new HomeController());
  }

  public Controller findHandler(String urlPath) {
    return mappings.get(urlPath);
  }
}
