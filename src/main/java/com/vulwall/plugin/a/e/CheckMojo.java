package com.vulwall.plugin.a.e;


import java.io.File;
import java.util.*;

import com.alibaba.fastjson.*;
import com.vulwall.plugin.a.b.*;
import com.vulwall.plugin.a.b.ChannelConfig;
import com.vulwall.plugin.a.b.HttpChannel;
import com.vulwall.plugin.a.d.*;
import com.vulwall.plugin.a.f.*;
import org.apache.maven.artifact.*;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;
import com.vulwall.plugin.a.f.a.*;
import org.apache.maven.project.*;
import org.apache.maven.shared.artifact.filter.collection.*;
import org.apache.maven.shared.transfer.artifact.*;
import org.apache.maven.shared.transfer.artifact.install.*;
import org.apache.maven.shared.transfer.artifact.resolve.*;

@Mojo(name = "check", requiresDependencyResolution = ResolutionScope.TEST, defaultPhase = LifecyclePhase.PROCESS_SOURCES, threadSafe = true)
public class CheckMojo
        extends ac {

    @Component
    private ArtifactInstaller installer;

    @Parameter(property = "options")
    private List<String> options;

    @Parameter(property = "msg")
    private String msg;

    @Parameter(property = "args")
    private String args;

    @Parameter(property = "mdep.useBaseVersion", defaultValue = "true")
    protected boolean useBaseVersion = true;


    @Parameter(property = "mdep.addParentPoms", defaultValue = "false")
    protected boolean addParentPoms;


    @Override
    protected void doExecute() throws MojoExecutionException {
        Status dss = getDependencySets(this.failOnMissingClassifierArtifact, addParentPoms);
        Set<Artifact> artifacts = dss.getArtifacts();
        d d = new d(getProject().getName(),
                getProject().getGroupId(),
                getProject().getArtifact().getArtifactId(),
                getProject().getVersion());
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
        if (!useRepositoryLayout) {
            for (Artifact artifact : artifacts) {

                ca(artifact, isStripVersion(), this.prependGroupId, this.useBaseVersion,
                        this.stripClassifier);
            }
        } else {
            ProjectBuildingRequest buildingRequest =
                    getRepositoryManager().setLocalRepositoryBasedir(session.getProjectBuildingRequest(),
                            outputDirectory);

            for (Artifact artifact : artifacts) {
                ia(artifact, buildingRequest);
            }
        }

        Set<Artifact> allArtifact = new HashSet<>();
        if (null != dss.getArtifacts()) {
            allArtifact.addAll(dss.getArtifacts());
        }
        if (null != dss.getArtifacts2()) {
            allArtifact.addAll(dss.getArtifacts2());
        }
        if (null != dss.getArtifacts1()) {
            allArtifact.addAll(dss.getArtifacts1());
        }
        getLog().info("find libraries size " + allArtifact.size());
        List<com.vulwall.plugin.a.d.c> libraries = new ArrayList<>();
        for (Artifact artifact : allArtifact) {
            libraries.add(new com.vulwall.plugin.a.d.c(artifact));
        }
        ChannelConfig channelConfig = new ChannelConfig(options);
        HttpChannel httpChannel = new HttpChannel(channelConfig);
        String checkReportStr = JSONObject.toJSONString(
                new com.vulwall.plugin.a.d.b(d, libraries)
        );
        if (httpChannel.hi()) {
            httpChannel.send(
                    ChannelUtil.buildProjectScanReportRequest(channelConfig, checkReportStr)
            );
        } else {
            getLog().info("Incorrect Host: " + channelConfig.getKEY());
        }
    }


    private void ia(Artifact artifact, ProjectBuildingRequest buildingRequest) {
        try {
            installer.install(buildingRequest, Collections.singletonList(artifact));
            ibs(artifact, buildingRequest);

            if (!"pom".equals(artifact.getType())) {
                Artifact pomArtifact = getResolvedPomArtifact(artifact);
                if (pomArtifact != null && pomArtifact.getFile() != null && pomArtifact.getFile().exists()) {
                    installer.install(buildingRequest, Collections.singletonList(pomArtifact));
                    ibs(pomArtifact, buildingRequest);
                }
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
        } catch (ArtifactInstallerException e) {
            getLog().warn("unable to install " + artifact, e);
        }
    }

    private void ibs(Artifact artifact, ProjectBuildingRequest buildingRequest)
            throws ArtifactInstallerException {
        if (artifact.isSnapshot() && !artifact.getBaseVersion().equals(artifact.getVersion())) {
            String version = artifact.getVersion();
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
            try {
                artifact.setVersion(artifact.getBaseVersion());
                installer.install(buildingRequest, Collections.singletonList(artifact));
            } finally {
                artifact.setVersion(version);
            }
        }
    }


    protected void ca(Artifact artifact, boolean removeVersion, boolean prependGroupId,
                      boolean theUseBaseVersion, boolean removeClassifier)
            throws MojoExecutionException {

        String dfn = Util.getFormattedFileName(artifact, removeVersion, prependGroupId,
                theUseBaseVersion, removeClassifier);

        File d;
        d = Util.getFormattedOutputDirectory(useSubDirectoryPerScope, useSubDirectoryPerType,
                useSubDirectoryPerArtifact, useRepositoryLayout,
                stripVersion, outputDirectory, artifact);
        File df = new File(d, dfn);
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
        c(artifact.getFile(), df);
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
    }


    protected Artifact getResolvedPomArtifact(Artifact artifact) {
        DefaultArtifactCoordinate coordinate = new DefaultArtifactCoordinate();
        coordinate.setGroupId(artifact.getGroupId());
        coordinate.setArtifactId(artifact.getArtifactId());
        coordinate.setVersion(artifact.getVersion());
        coordinate.setExtension("pom");

        Artifact pomArtifact = null;
        try {
            ProjectBuildingRequest buildingRequest = newResolveArtifactProjectBuildingRequest();

            pomArtifact = getArtifactResolver().resolveArtifact(buildingRequest, coordinate).getArtifact();
        } catch (ArtifactResolverException e) {
            getLog().info(e.getMessage());
        }
        return pomArtifact;
    }

    @Override
    protected ArtifactsFilter getMarkedArtifactFilter() {
        return new DestFileFilter(this.overWriteReleases, this.overWriteSnapshots, this.overWriteIfNewer,
                this.useSubDirectoryPerArtifact, this.useSubDirectoryPerType,
                this.useSubDirectoryPerScope, this.useRepositoryLayout, this.stripVersion,
                this.prependGroupId, this.useBaseVersion, this.outputDirectory);
    }

}
