package com.vulwall.plugin.a.d;


import java.io.File;
import java.util.*;

import org.apache.maven.artifact.*;
import com.vulwall.plugin.a.f.*;
import org.apache.maven.shared.transfer.dependencies.*;
import org.codehaus.plexus.components.io.filemappers.*;

public class a
        implements DependableCoordinate {

    private String groupId;


    private String artifactId;


    private String version = null;


    private String type = "jar";


    private String classifier;


    private File outputDirectory;


    private String destFileName;


    private String overWrite;


    private String encoding;


    private boolean needsProcessing;


    private Artifact artifact;


    private String includes;


    private String excludes;


    private FileMapper[] fileMappers;


    public a() {
      
    }

    public a(Artifact artifact) {
        this.setArtifact(artifact);
        this.setArtifactId(artifact.getArtifactId());
        this.setClassifier(artifact.getClassifier());
        this.setGroupId(artifact.getGroupId());
        this.setType(artifact.getType());
        this.setVersion(artifact.getVersion());
    }

    private String filterEmptyString(String in) {
        if ("".equals(in)) {
            return null;
        }
        return in;
    }


    @Override
    public String getArtifactId() {
        return artifactId;
    }


    public void setArtifactId(String theArtifact) {
        this.artifactId = filterEmptyString(theArtifact);
    }


    @Override
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = filterEmptyString(groupId);
    }


    @Override
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = filterEmptyString(type);
    }


    @Override
    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = filterEmptyString(version);
    }

    public String getBaseVersion() {
        return ArtifactUtils.toSnapshotVersion(version);
    }


    @Override
    public String getClassifier() {
        return classifier;
    }


    public void setClassifier(String classifier) {
        this.classifier = filterEmptyString(classifier);
    }

    @Override
    public String toString() {
        if (this.classifier == null) {
            return groupId + ":" + artifactId + ":" + Objects.toString(version, "?") + ":" + type;
        } else {
            return groupId + ":" + artifactId + ":" + classifier + ":" + Objects.toString(version, "?") + ":"
                    + type;
        }
    }


    public File getOutputDirectory() {
        return outputDirectory;
    }


    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }


    public String getDestFileName() {
        return destFileName;
    }


    public void setDestFileName(String destFileName) {
        this.destFileName = filterEmptyString(destFileName);
    }


    public boolean isNeedsProcessing() {
        return this.needsProcessing;
    }


    public void setNeedsProcessing(boolean needsProcessing) {
        this.needsProcessing = needsProcessing;
    }


    public String getOverWrite() {
        return this.overWrite;
    }


    public void setOverWrite(String overWrite) {
        this.overWrite = overWrite;
    }


    public String getEncoding() {
        return this.encoding;
    }


    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }


    public Artifact getArtifact() {
        return this.artifact;
    }


    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }


    public String getExcludes() {
        return Util.cleanToBeTokenizedString(this.excludes);
    }


    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }


    public String getIncludes() {
        return Util.cleanToBeTokenizedString(this.includes);
    }


    public void setIncludes(String includes) {
        this.includes = includes;
    }

    public FileMapper[] getFileMappers() {
        return this.fileMappers;
    }


    public void setFileMappers(FileMapper[] fileMappers) {
        this.fileMappers = fileMappers;
    }
}
