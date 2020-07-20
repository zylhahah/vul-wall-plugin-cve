package com.vulwall.plugin.a.b.a;


import org.apache.http.*;
import org.apache.http.message.*;
import java.util.*;


public class b {

  private Set<Header> headers;
  public byte[] entity;
  public String method;
  public String url;

  public b() {
    this.headers = new HashSet<Header>();
  }

  public void setHeader(String name, String value) {
    this.headers.add(new BasicHeader(name, value));
  }

  public void setHeader(Header header) {
    this.headers.add(header);
  }

  public Set<Header> getHeaders() {
    return this.headers;
  }

  public void setHeaders(Set<Header> headers) {
    this.headers = headers;
  }

  public byte[] getEntity() {
    return this.entity;
  }

  public void setEntity(byte[] entity) {
    this.entity = entity;
  }

  public String getMethod() {
    return this.method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


}
