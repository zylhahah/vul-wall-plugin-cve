package com.vulwall.plugin.a;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import com.vulwall.plugin.a.f.*;
import org.apache.maven.artifact.*;
import org.apache.maven.artifact.repository.*;
import org.apache.maven.execution.*;
import org.apache.maven.plugin.*;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.*;
import org.codehaus.plexus.archiver.*;
import org.codehaus.plexus.archiver.manager.ArchiverManager;
import org.codehaus.plexus.archiver.manager.NoSuchArchiverException;
import org.codehaus.plexus.archiver.zip.*;
import org.codehaus.plexus.components.io.filemappers.*;
import org.codehaus.plexus.components.io.fileselectors.*;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.ReflectionUtils;
import org.codehaus.plexus.util.StringUtils;

public abstract class AbstractMojo
        extends org.apache.maven.plugin.AbstractMojo {

    @Component
    private ArchiverManager archiverManager;

    @Parameter(property = "dependency.useJvmChmod", defaultValue = "true")
    private boolean useJvmChmod = true;


    @Parameter(property = "dependency.ignorePermissions", defaultValue = "false")
    private boolean ignorePermissions;


    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;


    @Parameter(defaultValue = "${project.remoteArtifactRepositories}", readonly = true, required = true)
    private List<ArtifactRepository> remoteRepositories;


    @Parameter(defaultValue = "${reactorProjects}", readonly = true)
    protected List<MavenProject> reactorProjects;


    @Parameter(defaultValue = "${session}", readonly = true, required = true)
    protected MavenSession session;


    @Parameter(property = "silent", defaultValue = "false")
    private boolean silent;


    @Parameter(property = "outputAbsoluteArtifactFilename", defaultValue = "false")
    protected boolean outputAbsoluteArtifactFilename;


    @Parameter(property = "mdep.skip", defaultValue = "false")
    private boolean skip;


    @Override
    public final void execute()
            throws MojoExecutionException, MojoFailureException {
        if (isSkip()) {
            getLog().info("Skipping plugin execution");
            return;
        }

        doExecute();
    }


    protected abstract void doExecute()
            throws MojoExecutionException, MojoFailureException;

    public ArchiverManager getArchiverManager() {
        return this.archiverManager;
    }


    protected void c(File artifact, File destFile)
            throws MojoExecutionException {
        try {
            getLog().info("Copying "
                    + (this.outputAbsoluteArtifactFilename ? artifact.getAbsolutePath() : artifact.getName()) + " to "
                    + destFile);

            if (artifact.isDirectory()) {
                throw new MojoExecutionException("ex");
            }

            FileUtils.copyFile(artifact, destFile);
        } catch (IOException e) {
            throw new MojoExecutionException("Error copying ar from " + artifact + " to " + destFile, e);
        }
    }

    protected void unpack(Artifact artifact, File location, String encoding, FileMapper[] fileMappers)
            throws MojoExecutionException {
        unpack(artifact, location, null, null, encoding, fileMappers);
    }

    protected void unpack(Artifact artifact, File location, String includes, String excludes, String encoding,
                          FileMapper[] fileMappers) throws MojoExecutionException {
        unpack(artifact, artifact.getType(), location, includes, excludes, encoding, fileMappers);
    }

    protected void unpack(Artifact artifact, String type, File location, String includes, String excludes,
                          String encoding, FileMapper[] fileMappers)
            throws MojoExecutionException {
        File file = artifact.getFile();
        try {
            logUnpack(file, location, includes, excludes);

            location.mkdirs();
            if (!location.exists()) {
                throw new MojoExecutionException("" + location);
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
            if (file.isDirectory()) {
                throw new MojoExecutionException("ex");
            }

            UnArchiver unArchiver;

            try {
                unArchiver = archiverManager.getUnArchiver(type);
                getLog().debug("" + unArchiver);
            } catch (NoSuchArchiverException e) {
                unArchiver = archiverManager.getUnArchiver(file);
                getLog().debug("" + unArchiver);
            }

            if (encoding != null && unArchiver instanceof ZipUnArchiver) {
                ((ZipUnArchiver) unArchiver).setEncoding(encoding);
                getLog().info("Unpacks '" + type + "' with encoding '" + encoding + "'.");
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

            unArchiver.setIgnorePermissions(ignorePermissions);

            unArchiver.setSourceFile(file);

            unArchiver.setDestDirectory(location);

            if (StringUtils.isNotEmpty(excludes) || StringUtils.isNotEmpty(includes)) {
                IncludeExcludeFileSelector[] selectors =
                        new IncludeExcludeFileSelector[]{new IncludeExcludeFileSelector()};

                if (StringUtils.isNotEmpty(excludes)) {
                    selectors[0].setExcludes(excludes.split(","));
                }

                if (StringUtils.isNotEmpty(includes)) {
                    selectors[0].setIncludes(includes.split(","));
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
                unArchiver.setFileSelectors(selectors);
            }
            if (this.silent) {
                silenceUnarchiver(unArchiver);
            }

            unArchiver.setFileMappers(fileMappers);

            unArchiver.extract();
        } catch (NoSuchArchiverException e) {
            throw new MojoExecutionException("Unknown archiver type", e);
        } catch (ArchiverException e) {
            throw new MojoExecutionException("Error unpacking file: " + file + " to: " + location
                    + System.lineSeparator() + e.toString(), e);
        }
    }

    private void silenceUnarchiver(UnArchiver unArchiver) {
        try {
            Field field = ReflectionUtils.getFieldByNameIncludingSuperclasses("logger", unArchiver.getClass());
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
            field.setAccessible(true);

            field.set(unArchiver, this.getLog());
        } catch (Exception e) {
        }
    }

    public ProjectBuildingRequest newResolveArtifactProjectBuildingRequest() {
        ProjectBuildingRequest buildingRequest =
                new DefaultProjectBuildingRequest(session.getProjectBuildingRequest());

        buildingRequest.setRemoteRepositories(remoteRepositories);

        return buildingRequest;
    }

    public MavenProject getProject() {
        return this.project;
    }

    public void setArchiverManager(ArchiverManager archiverManager) {
        this.archiverManager = archiverManager;
    }


    public boolean isUseJvmChmod() {
        return useJvmChmod;
    }


    public void setUseJvmChmod(boolean useJvmChmod) {
        this.useJvmChmod = useJvmChmod;
    }


    public boolean isSkip() {
        return skip;
    }


    public void setSkip(boolean skip) {
        this.skip = skip;
    }


    protected final boolean isSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
        if (silent) {
            setLog(new Log());
        }
    }

    private void logUnpack(File file, File location, String includes, String excludes) {
        if (!getLog().isInfoEnabled()) {
            return;
        }

        StringBuilder msg = new StringBuilder();
        msg.append("Unpacking ");
        msg.append(file);
        msg.append(" to ");
        msg.append(location);

        if (includes != null && excludes != null) {
            msg.append(" with includes \"");
            msg.append(includes);
            msg.append("\" and excludes \"");
            msg.append(excludes);
            msg.append("\"");
        } else if (includes != null) {
            msg.append(" with includes \"");
            msg.append(includes);
            msg.append("\"");
        } else if (excludes != null) {
            msg.append(" with excludes \"");
            msg.append(excludes);
            msg.append("\"");
        }

        getLog().info(msg.toString());
    }
}
