package com.vulwall.plugin.a.c;

import com.vulwall.plugin.a.f.FileIDUtil;
import org.apache.maven.artifact.Artifact;

public class c {

    public c(){}

    public c(Artifact artifact){
        this.artifactId = artifact.getArtifactId();
        this.groupId = artifact.getGroupId();
        this.version = artifact.getBaseVersion();
        this.id = FileIDUtil.createId(artifact.getFile());
    }

    private String id;

    private String groupId;

    private String artifactId;

    private String version;

    private String path;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId( String groupId )
    {
        this.groupId = groupId;
    }

    public String getArtifactId()
    {
        return artifactId;
    }

    public void setArtifactId( String artifactId )
    {
        this.artifactId = artifactId;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion( String version )
    {
        this.version = version;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath( String path )
    {
        this.path = path;
    }


}
