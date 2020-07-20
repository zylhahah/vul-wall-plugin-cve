package com.vulwall.plugin.a.e;


import org.apache.maven.plugins.annotations.*;
import java.io.*;


public abstract class ac
    extends af
{

    @Parameter( property = "outputDirectory", defaultValue = "${project.build.directory}/dependency" )
    protected File outputDirectory;


    @Parameter( property = "mdep.stripVersion", defaultValue = "false" )
    protected boolean stripVersion = false;


    @Parameter( property = "mdep.stripClassifier", defaultValue = "false" )
    protected boolean stripClassifier = false;


    @Parameter( property = "mdep.useRepositoryLayout", defaultValue = "false" )
    protected boolean useRepositoryLayout;


    @Parameter( property = "mdep.useSubDirectoryPerScope", defaultValue = "false" )
    protected boolean useSubDirectoryPerScope;


    @Parameter( property = "mdep.useSubDirectoryPerType", defaultValue = "false" )
    protected boolean useSubDirectoryPerType;


    @Parameter( property = "mdep.useSubDirectoryPerArtifact", defaultValue = "false" )
    protected boolean useSubDirectoryPerArtifact;


    @Parameter( property = "mdep.failOnMissingClassifierArtifact", defaultValue = "false" )
    protected boolean failOnMissingClassifierArtifact = true;


    public File getOutputDirectory()
    {
        return this.outputDirectory;
    }


    public void setOutputDirectory( File theOutputDirectory )
    {
        this.outputDirectory = theOutputDirectory;
    }

    public boolean isUseSubDirectoryPerArtifact()
    {
        return this.useSubDirectoryPerArtifact;
    }


    public void setUseSubDirectoryPerArtifact( boolean theUseSubDirectoryPerArtifact )
    {
        this.useSubDirectoryPerArtifact = theUseSubDirectoryPerArtifact;
    }


    public boolean isUseSubDirectoryPerScope()
    {
        return this.useSubDirectoryPerScope;
    }


    public void setUseSubDirectoryPerScope( boolean theUseSubDirectoryPerScope )
    {
        this.useSubDirectoryPerScope = theUseSubDirectoryPerScope;
    }


    public boolean isUseSubDirectoryPerType()
    {
        return this.useSubDirectoryPerType;
    }


    public void setUseSubDirectoryPerType( boolean theUseSubDirectoryPerType )
    {
        this.useSubDirectoryPerType = theUseSubDirectoryPerType;
    }


    public boolean isFailOnMissingClassifierArtifact()
    {
        return failOnMissingClassifierArtifact;
    }


    public void setFailOnMissingClassifierArtifact( boolean failOnMissingClassifierArtifact )
    {
        this.failOnMissingClassifierArtifact = failOnMissingClassifierArtifact;
    }

    public boolean isStripVersion()
    {
        return stripVersion;
    }


    public void setStripVersion( boolean stripVersion )
    {
        this.stripVersion = stripVersion;
    }


    public boolean isUseRepositoryLayout()
    {
        return useRepositoryLayout;
    }


    public void setUseRepositoryLayout( boolean useRepositoryLayout )
    {
        this.useRepositoryLayout = useRepositoryLayout;
    }
}
