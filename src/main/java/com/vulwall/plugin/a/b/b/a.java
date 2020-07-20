package com.vulwall.plugin.a.b.b;

import javax.net.ssl.*;
import java.security.cert.*;

public class a implements X509TrustManager {

  @Override
  public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

  }

  @Override
  public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
  }

  @Override
  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }

}
