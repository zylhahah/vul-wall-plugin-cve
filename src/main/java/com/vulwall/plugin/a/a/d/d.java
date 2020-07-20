package com.vulwall.plugin.a.a.d;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class d extends X509ExtendedTrustManager {

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
