package me.hero.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import me.hero.QueryStrings;
import me.hero.RequestLine;

public class HttpRequest {
  private final RequestLine requestLine;

  public HttpRequest(BufferedReader br) throws IOException {
    this.requestLine = new RequestLine(br.readLine());
  }


  public QueryStrings getQueryStrings() {
    return requestLine.getQueryStrings();
  }

  public boolean isGetRequest() {
    return requestLine.isGetRequest();
  }

  public boolean matchPath(String path) {
    return requestLine.mathPath(path);
  }
}
