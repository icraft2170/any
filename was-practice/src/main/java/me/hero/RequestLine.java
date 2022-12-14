package me.hero;

import java.util.Objects;

public class RequestLine {


  private final String method;
  private final String urlPath;
  private QueryStrings queryStrings;

  /**
   * GET http://localhost:8080/calculate?operand1=11&operator=*&operand2=55
   * @param requestLine
   */
  public RequestLine(String requestLine) {
    String[] tokens = requestLine.split(" ");
    this.method = tokens[0];
    String[] urlPathTokens = tokens[1].split("\\?");
    this.urlPath = urlPathTokens[0];
    if (urlPathTokens.length == 2) {
      this.queryStrings = new QueryStrings(urlPathTokens[1]);
    }
  }

  public RequestLine(String method, String urlPath, String queryString) {
    this.method = method;
    this.urlPath = urlPath;
    this.queryStrings = new QueryStrings(queryString);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RequestLine)) {
      return false;
    }
    RequestLine that = (RequestLine) o;
    return Objects.equals(method, that.method) && Objects.equals(urlPath,
        that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, urlPath, queryStrings);
  }

  public boolean isGetRequest() {
    return "GET".equals(this.method);
  }

  public boolean mathPath(String requestPath) {
    return urlPath.equals(requestPath);
  }

  public QueryStrings getQueryStrings() {
    return this.queryStrings;
  }
}
