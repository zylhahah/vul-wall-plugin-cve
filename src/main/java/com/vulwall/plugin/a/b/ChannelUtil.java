package com.vulwall.plugin.a.b;

import com.vulwall.plugin.a.b.a.*;

public class ChannelUtil {

    public static b buildProjectScanReportRequest(ChannelConfig channelConfig, String json) {
        b b = new b();
        b.setEntity(json.getBytes());
        b.setUrl(channelConfig.getKEY() + "report/project/library");
        b.setMethod("post");
        return b;
    }
}
