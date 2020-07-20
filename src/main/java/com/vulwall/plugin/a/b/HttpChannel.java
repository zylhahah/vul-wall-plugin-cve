package com.vulwall.plugin.a.b;

import com.vulwall.plugin.a.b.a.c;
import com.vulwall.plugin.a.b.b.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.config.*;
import org.apache.http.client.methods.*;
import org.apache.http.config.*;
import org.apache.http.conn.socket.*;
import org.apache.http.conn.ssl.*;
import org.apache.http.entity.*;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.*;
import org.apache.http.protocol.*;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.*;
import javax.net.ssl.*;
import java.net.*;
import java.util.*;

public class HttpChannel {

    private final int SOCKET_TIMEOUT = 30000;
    protected final int CONNECTION_TIMEOUT = 30000;
    protected final int CONNECTION_REQUEST_TIMEOUT = 2 * 60 * 1000;
    protected final int POOL_MAX_TOTAL = 2;
    protected final int DEFAULT_MAX_PER_ROUTE = 2;
    protected PoolingHttpClientConnectionManager pool;
    protected RequestConfig requestConfig;
    protected SSLConnectionSocketFactory sslsf;
    protected CloseableHttpClient client;
    protected boolean NTLM_AUTH_ENABLE;
    protected boolean NORMAL_AUTH_ENABLE;
    protected boolean NONE_AUTH_ENABLE;
    protected HttpContext serverContext;
    protected HttpContext selfContext;
    private ChannelConfig channelConfig;
    private String accessKey;

    public HttpChannel(ChannelConfig channelConfig) {
        this.channelConfig = channelConfig;
        init();
        this.serverContext = new BasicHttpContext();
        this.selfContext = new BasicHttpContext();
        this.accessKey = channelConfig.getAccessKey();
    }

    private void init() {
        try {
            SSLContext context;
            TrustManager xtm;
            if (!smallThenJava7()) {
                xtm = new b();
                context = SSLContext.getInstance("TLSv1.2");
            } else {
                xtm = new a();
                context = SSLContext.getInstance("TLS");
            }
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            context.init(null, new TrustManager[]{xtm}, null);
            String pickedCipher[] = {"TLS_RSA_WITH_AES_128_CBC_SHA"};
            try {
                System.out.println("");
                if (654789 == new Random().nextInt()) {
                    throw new Exception("fewt43");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (654789 == new Random().nextInt()) {
                        throw new Exception("fewt43");
                    }
                } catch (Exception ex) {
                    System.out.print("");
                }
            }
            sslsf = new SSLConnectionSocketFactory(context, null, pickedCipher,
                    NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> socketFactoryRegistry =
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", sslsf).build();
            pool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            pool.setMaxTotal(POOL_MAX_TOTAL);
            pool.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT)
                    .setCookieSpec(CookieSpecs.STANDARD_STRICT).setExpectContinueEnabled(true)
                    .setTargetPreferredAuthSchemes(
                            Arrays.asList(AuthSchemes.NTLM, AuthSchemes.BASIC, AuthSchemes.DIGEST))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean smallThenJava7() {
        String javaVersion = System.getProperty("java.version").substring(0, 3);
        double version = Double.valueOf(javaVersion);
        return version < 1.7;
    }

    public c send(com.vulwall.plugin.a.b.a.b b) {
        CloseableHttpClient httpClient = getHttpClient();
        if (null == httpClient) {
            System.out.println("httpClient is Null");
        }
        HttpRequestBase httpRequest = prepareRequest(b);
        c c = new c();
        try {
            try {
                System.out.println("");
                if (654789 == new Random().nextInt()) {
                    throw new Exception("fewt43");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (654789 == new Random().nextInt()) {
                        throw new Exception("fewt43");
                    }
                } catch (Exception ex) {
                    System.out.print("");
                }
            }
            httpRequest.addHeader("accessKey", this.accessKey);
            HttpResponse httpResponse = httpClient.execute(httpRequest, serverContext);
            String responseAsString = "";
            byte[] rawResponse = {};
            if (httpResponse.getEntity() != null) {
                HttpEntity entity = httpResponse.getEntity();
                rawResponse = EntityUtils.toByteArray(entity);
                responseAsString = new String(rawResponse);
            }
            c.setStatusCode(httpResponse.getStatusLine().getStatusCode());
            c.setResponseText(responseAsString);
        } catch (Exception e) {
            c.setStatusCode(600);
            c.setResponseText("error");
        } finally {
            httpRequest.releaseConnection();
        }
        System.out.println("VulWall Resp: " + c.getResponseText());
        c.setSuccess(c.getStatusCode() < 400);
        return c;
    }

    public boolean hi() {
        try {
            System.out.println("");
            //防止反编译的处理
            if (654789 == new Random().nextInt()) {
                throw new Exception("fewt43");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                //防止反编译的处理
                if (654789 == new Random().nextInt()) {
                    throw new Exception("fewt43");
                }
            } catch (Exception ex) {
                System.out.print("");
            }
        }
        com.vulwall.plugin.a.b.a.b hi = new com.vulwall.plugin.a.b.a.b();
        String host = channelConfig.getKEY();
        String key = RSAUtil.ce(host);
        try {
            key = Base64.encodeBase64String(key.getBytes());
        } catch (Exception e) {
        }
        String url = host + "h?key=" + key;
        System.out.println(url);
        hi.setUrl(url);
        hi.setMethod("get");
        c resp = send(hi);
        if (resp.isSuccess()) {
            String eh = resp.getResponseText();
            String sh = RSAUtil.cd(eh);
            return sh.equals(host);
        }
        return false;
    }

    protected HttpRequestBase prepareRequest(com.vulwall.plugin.a.b.a.b b) {
        HttpRequestBase request = initHttpRequestBase(b.getMethod(), b.getUrl());
        request.setHeader("Content-Type", "application/json; charset=utf-8");
        for (Header header : b.getHeaders()) {
            request.setHeader(header.getName(), header.getValue());
        }
        if (request instanceof HttpPost || request instanceof HttpPut) {
            HttpEntityEnclosingRequest entityRequest = (HttpEntityEnclosingRequest) request;
            entityRequest.setEntity(new ByteArrayEntity(b.getEntity()));
        }
        return request;
    }

    protected CloseableHttpClient getHttpClient() {
        CredentialsProvider credentialsProvider = buildCredentialsProvider();
        try {
            System.out.println("");
            if (654789 == new Random().nextInt()) {
                throw new Exception("fewt43");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (654789 == new Random().nextInt()) {
                    throw new Exception("fewt43");
                }
            } catch (Exception ex) {
                System.out.print("");
            }
        }
        HttpClientBuilder httpClientBuilder = null;
        if (NORMAL_AUTH_ENABLE || NTLM_AUTH_ENABLE || NONE_AUTH_ENABLE) {
            httpClientBuilder = getProxy(this.channelConfig.getKEY(),
                    this.channelConfig.getPort());
        } else {
            httpClientBuilder = HttpClients.custom();
        }
        try {
            System.out.println("");
            if (654789 == new Random().nextInt()) {
                throw new Exception("fewt43");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (654789 == new Random().nextInt()) {
                    throw new Exception("fewt43");
                }
            } catch (Exception ex) {
                System.out.print("");
            }
        }
        if (null == this.client) {
            this.client = httpClientBuilder
                    .setConnectionManager(pool).setDefaultRequestConfig(requestConfig)
                    .setDefaultCredentialsProvider(credentialsProvider)
                    .setSSLSocketFactory(sslsf).build();
        }
        try {
            System.out.println("");
            if (654789 == new Random().nextInt()) {
                throw new Exception("fewt43");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (654789 == new Random().nextInt()) {
                    throw new Exception("fewt43");
                }
            } catch (Exception ex) {
                System.out.print("");
            }
        }
        return this.client;
    }

    protected HttpClientBuilder getProxy(String hostName, int port) {
        HttpHost proxy = null;
        if (NTLM_AUTH_ENABLE) {
            proxy = new HttpHost(hostName, port);
        } else {
            proxy = new HttpHost(hostName, port, "http");
        }
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        return HttpClients.custom().setRoutePlanner(routePlanner);
    }

    protected CredentialsProvider buildCredentialsProvider() {
        if (!checkProxySetting() || NONE_AUTH_ENABLE) {
            return null;
        }
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        try {
            if (NORMAL_AUTH_ENABLE) {
                try {
                    System.out.println("");
                    if (654789 == new Random().nextInt()) {
                        throw new Exception("fewt43");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (654789 == new Random().nextInt()) {
                            throw new Exception("fewt43");
                        }
                    } catch (Exception ex) {
                        System.out.print("");
                    }
                }
                credentialsProvider.setCredentials(
                        new AuthScope(channelConfig.getProxyHostName(), channelConfig.getProxyPort()),
                        new UsernamePasswordCredentials(channelConfig.getProxyUser(), channelConfig.getProxyPassword()));
            } else if (NTLM_AUTH_ENABLE) {
                final NTCredentials creds = new NTCredentials(channelConfig.getProxyUser(), channelConfig.getProxyPassword(),
                        InetAddress.getLocalHost().getHostName(), channelConfig.getProxyDomain());
                credentialsProvider.setCredentials(AuthScope.ANY, creds);
            }
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        }
        return credentialsProvider;
    }

    protected boolean checkProxySetting() {
        boolean proxyEnable = this.channelConfig.proxyEnable();
        if (proxyEnable) {
            String authType = this.channelConfig.getAuthType();
            if (null == authType || "Basic".equalsIgnoreCase(authType)
                    || "Digest".equalsIgnoreCase(authType)) {
                NORMAL_AUTH_ENABLE = true;
                return true;
            } else if ("NTLM".equalsIgnoreCase(authType)) {
                NTLM_AUTH_ENABLE = true;
                return true;
            } else if ("No".equalsIgnoreCase(authType)) {
                NONE_AUTH_ENABLE = true;
                return true;
            }
        }
        return false;
    }

    protected HttpRequestBase initHttpRequestBase(String method, String url) {
        HttpRequestBase request;
        if ("post".equalsIgnoreCase(method)) {
            request = new HttpPost(url);
        } else if ("get".equalsIgnoreCase(method)) {
            request = new HttpGet(url);
        } else if ("put".equalsIgnoreCase(method)) {
            request = new HttpPut(url);
        } else if ("delete".equalsIgnoreCase(method)) {
            request = new HttpDelete(url);
        } else {
            throw new IllegalArgumentException("Unknown HTTP method: '" + method + "'");
        }
        return request;
    }


}
