package com.vulwall.plugin.a.d;

public class d {


    public d(){}

    public d(String name, String groupId, String artifactId, String version){
        this.name = name;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    private String artifactId;

    private String name;

    private String version;

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
