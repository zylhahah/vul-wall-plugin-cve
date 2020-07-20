package com.vulwall.plugin.a.f.a;

import com.vulwall.plugin.a.f.*;
import org.apache.maven.artifact.*;
import org.apache.maven.shared.artifact.filter.collection.*;
import org.codehaus.plexus.util.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class DestFileFilter
        extends AbstractArtifactsFilter
        implements a {
    private boolean overWriteReleases;

    private boolean overWriteSnapshots;

    private boolean overWriteIfNewer;

    private boolean useSubDirectoryPerArtifact;

    private boolean useSubDirectoryPerType;

    private boolean useSubDirectoryPerScope;

    private boolean useRepositoryLayout;

    private boolean removeVersion;

    private boolean removeClassifier;

    private boolean prependGroupId;

    private boolean useBaseVersion;

    private File outputFileDirectory;

    public DestFileFilter(File outputFileDirectory) {
        this(false, false, false, false, false, false, false, false, false, false, outputFileDirectory);
    }

    public DestFileFilter(boolean overWriteReleases, boolean overWriteSnapshots, boolean overWriteIfNewer,
                          boolean useSubDirectoryPerArtifact, boolean useSubDirectoryPerType,
                          boolean useSubDirectoryPerScope, boolean useRepositoryLayout, boolean removeVersion,
                          boolean prependGroupId, boolean useBaseVersion, File outputFileDirectory) {
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
        this.overWriteReleases = overWriteReleases;
        this.overWriteSnapshots = overWriteSnapshots;
        this.overWriteIfNewer = overWriteIfNewer;
        this.useSubDirectoryPerArtifact = useSubDirectoryPerArtifact;
        this.useSubDirectoryPerType = useSubDirectoryPerType;
        this.useSubDirectoryPerScope = useSubDirectoryPerScope;
        this.useRepositoryLayout = useRepositoryLayout;
        this.removeVersion = removeVersion;
        this.prependGroupId = prependGroupId;
        this.useBaseVersion = useBaseVersion;
        this.outputFileDirectory = outputFileDirectory;
    }

    @Override
    public Set<Artifact> filter(Set<Artifact> artifacts)
            throws ArtifactFilterException {
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
        Set<Artifact> result = new LinkedHashSet<Artifact>();

        for (Artifact artifact : artifacts) {
            if (isArtifactIncluded(new com.vulwall.plugin.a.d.a(artifact))) {
                result.add(artifact);
            }
        }
        return result;
    }

    public boolean a() {
        return this.overWriteReleases;
    }

    public void b(boolean overWriteReleases) {
        this.overWriteReleases = overWriteReleases;
    }


    public boolean c() {
        return this.overWriteSnapshots;
    }


    public void d(boolean overWriteSnapshots) {
        this.overWriteSnapshots = overWriteSnapshots;
    }


    public boolean e() {
        return this.overWriteIfNewer;
    }


    public void f(boolean overWriteIfNewer) {
        this.overWriteIfNewer = overWriteIfNewer;
    }


    public File g() {
        return this.outputFileDirectory;
    }


    public void h(File outputFileDirectory) {
        this.outputFileDirectory = outputFileDirectory;
    }


    public boolean i() {
        return this.removeVersion;
    }


    public void a(boolean removeVersion) {
        this.removeVersion = removeVersion;
    }


    public boolean b() {
        return this.removeClassifier;
    }


    public void c(boolean removeClassifier) {
        this.removeClassifier = removeClassifier;
    }


    public boolean d() {
        return this.useSubDirectoryPerArtifact;
    }


    public void e(boolean useSubDirectoryPerArtifact) {
        this.useSubDirectoryPerArtifact = useSubDirectoryPerArtifact;
    }

    public boolean f() {
        return this.useSubDirectoryPerType;
    }

    public void t(boolean useSubDirectoryPerType) {
        this.useSubDirectoryPerType = useSubDirectoryPerType;
    }

    public boolean t() {
        return useRepositoryLayout;
    }

    public void w(boolean useRepositoryLayout) {
        this.useRepositoryLayout = useRepositoryLayout;
    }

    @Override
    public boolean isArtifactIncluded(com.vulwall.plugin.a.d.a item) throws ArtifactFilterException {
        Artifact artifact = item.getArtifact();

        boolean overWrite = (artifact.isSnapshot() && this.overWriteSnapshots)
                || (!artifact.isSnapshot() && this.overWriteReleases);

        File destFolder = item.getOutputDirectory();
        if (destFolder == null) {
            destFolder =
                    Util.getFormattedOutputDirectory(useSubDirectoryPerScope, useSubDirectoryPerType,
                            useSubDirectoryPerArtifact, useRepositoryLayout,
                            removeVersion, this.outputFileDirectory, artifact);
        }

        File destFile;
        if (StringUtils.isEmpty(item.getDestFileName())) {
            String formattedFileName = Util.getFormattedFileName(artifact, removeVersion, prependGroupId,
                    useBaseVersion, removeClassifier);
            destFile = new File(destFolder, formattedFileName);
        } else {
            destFile = new File(destFolder, item.getDestFileName());
        }

        return overWrite || !destFile.exists() || (overWriteIfNewer && getLastModified(
                artifact.getFile()) > getLastModified(destFile));
    }

    private long getLastModified(File file) throws ArtifactFilterException {
        try {
            return Files.getLastModifiedTime(file.toPath()).toMillis();
        } catch (IOException e) {
            throw new ArtifactFilterException("IO Exception", e);
        }
    }
}
