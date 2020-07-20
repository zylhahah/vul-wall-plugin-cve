package com.vulwall.plugin.a.b;

import java.util.List;

public class ChannelConfig {


    private String KEY = "https://dependencysec.com/vulwall/";
    private int port;
    private String accessKey;

    private String authType;
    private String proxyHostName;
    private int proxyPort;
    private String proxyUser;
    private String proxyPassword;
    private String proxyDomain;

    public ChannelConfig(List<String> options) {
        if (null == options || options.isEmpty()) {
            return;
        }
        for (String option : options) {
            option = option.trim();
            if (option.indexOf("=") == -1) {
                continue;
            }
            String key = option.substring(0, option.indexOf("="));
            String value = option.substring(option.indexOf("=") + 1);
            if ("host".equals(key)) {
                this.KEY = value;
            } else if ("accessKey".equals(key)) {
                this.accessKey = value;
            } else if ("port".equals(key)) {
                this.port = Integer.valueOf(value);
            } else if ("authType".equals(key)) {
                this.authType = value;
            } else if ("proxyHostName".equals(key)) {
                this.proxyHostName = value;
            } else if ("proxyPort".equals(key)) {
                this.proxyPort = Integer.valueOf(value);
            } else if ("proxyUser".equals(key)) {
                this.proxyUser = value;
            } else if ("proxyPassword".equals(key)) {
                this.proxyPassword = value;
            } else if ("proxyDomain".equals(key)) {
                this.proxyDomain = value;
            }
        }
    }

    public boolean proxyEnable() {
        return (null != proxyDomain || (null != proxyHostName && 0 != proxyPort))
                &&
                (null != proxyUser && null != proxyPassword);
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getProxyHostName() {
        return proxyHostName;
    }

    public void setProxyHostName(String proxyHostName) {
        this.proxyHostName = proxyHostName;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getProxyDomain() {
        return proxyDomain;
    }

    public void setProxyDomain(String proxyDomain) {
        this.proxyDomain = proxyDomain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
