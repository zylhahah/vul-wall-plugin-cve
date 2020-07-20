package com.vulwall.plugin.a.b.b;

import javax.net.ssl.*;
import java.net.Socket;
import java.security.cert.*;

public class b extends X509ExtendedTrustManager {

  @Override
  public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    // TODO Auto-generated method stub

  }

  @Override
  public X509Certificate[] getAcceptedIssuers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2)
      throws CertificateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
      throws CertificateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2)
      throws CertificateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
      throws CertificateException {
    // TODO Auto-generated method stub

  }

}
