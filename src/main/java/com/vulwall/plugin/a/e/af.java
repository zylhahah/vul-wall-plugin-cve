package com.vulwall.plugin.a.e;

import java.io.File;
import java.util.*;

import com.vulwall.plugin.a.AbstractMojo;
import com.vulwall.plugin.a.f.*;
import org.apache.maven.artifact.*;
import org.apache.maven.artifact.handler.manager.*;
import org.apache.maven.plugin.*;
import org.apache.maven.plugins.annotations.*;
import com.vulwall.plugin.a.f.b.*;
import org.apache.maven.project.*;
import org.apache.maven.shared.artifact.filter.collection.*;
import org.apache.maven.shared.transfer.artifact.*;
import org.apache.maven.shared.transfer.artifact.resolve.*;
import org.apache.maven.shared.transfer.dependencies.resolve.*;
import org.apache.maven.shared.transfer.repository.*;
import org.codehaus.plexus.util.*;

public abstract class af
        extends AbstractMojo {
    @Component
    private ArtifactResolver artifactResolver;

    @Component
    private DependencyResolver dependencyResolver;

    @Component
    private RepositoryManager repositoryManager;

    @Parameter(property = "overWriteReleases", defaultValue = "false")
    protected boolean overWriteReleases;

    @Parameter(property = "overWriteSnapshots", defaultValue = "false")
    protected boolean overWriteSnapshots;

    @Parameter(property = "overWriteIfNewer", defaultValue = "true")
    protected boolean overWriteIfNewer;

    @Parameter(property = "excludeTransitive", defaultValue = "false")
    protected boolean excludeTransitive;

    @Parameter(property = "includeTypes", defaultValue = "")
    protected String includeTypes;

    @Parameter(property = "excludeTypes", defaultValue = "")
    protected String excludeTypes;

    @Parameter(property = "includeScope", defaultValue = "")
    protected String includeScope;

    @Parameter(property = "excludeScope", defaultValue = "")
    protected String excludeScope;

    @Parameter(property = "includeClassifiers", defaultValue = "")
    protected String includeClassifiers;

    @Parameter(property = "excludeClassifiers", defaultValue = "")
    protected String excludeClassifiers;

    @Parameter(property = "classifier", defaultValue = "")
    protected String classifier;

    @Parameter(property = "type", defaultValue = "")
    protected String type;

    @Parameter(property = "excludeArtifactIds", defaultValue = "")
    protected String excludeArtifactIds;

    @Parameter(property = "includeArtifactIds", defaultValue = "")
    protected String includeArtifactIds;

    @Parameter(property = "excludeGroupIds", defaultValue = "")
    protected String excludeGroupIds;

    @Parameter(property = "includeGroupIds", defaultValue = "")
    protected String includeGroupIds;

    @Parameter(property = "markersDirectory", defaultValue = "${project.build.directory}/dependency-maven-plugin-markers")
    protected File markersDirectory;

    @Parameter(property = "mdep.prependGroupId", defaultValue = "false")
    protected boolean prependGroupId = false;

    @Component
    private ProjectBuilder projectBuilder;

    @Component
    private ArtifactHandlerManager artifactHandlerManager;

    protected abstract ArtifactsFilter getMarkedArtifactFilter();

    protected Set<Artifact> getResolvedDependencies(boolean stopOnFailure)
            throws MojoExecutionException {
        Status status = getDependencySets(stopOnFailure);

        return status.getArtifacts();
    }

    protected Status getDependencySets(boolean stopOnFailure)
            throws MojoExecutionException {
        return getDependencySets(stopOnFailure, false);
    }

    protected Status getDependencySets(boolean stopOnFailure, boolean includeParents)
            throws MojoExecutionException {
        FilterArtifacts filter = new FilterArtifacts();

        filter.addFilter(new ProjectTransitivityFilter(getProject().getDependencyArtifacts(),
                this.excludeTransitive));

        filter.addFilter(new ScopeFilter(Util.cleanToBeTokenizedString(this.includeScope),
                Util.cleanToBeTokenizedString(this.excludeScope)));

        filter.addFilter(new TypeFilter(Util.cleanToBeTokenizedString(this.includeTypes),
                Util.cleanToBeTokenizedString(this.excludeTypes)));

        filter.addFilter(new ClassifierFilter(Util.cleanToBeTokenizedString(this.includeClassifiers),
                Util.cleanToBeTokenizedString(this.excludeClassifiers)));

        filter.addFilter(new GroupIdFilter(Util.cleanToBeTokenizedString(this.includeGroupIds),
                Util.cleanToBeTokenizedString(this.excludeGroupIds)));

        filter.addFilter(new ArtifactIdFilter(Util.cleanToBeTokenizedString(this.includeArtifactIds),
                Util.cleanToBeTokenizedString(this.excludeArtifactIds)));

        Set<Artifact> artifacts = getProject().getArtifacts();

        if (includeParents) {
            for (Artifact dep : new ArrayList<>(artifacts)) {
                addParentArtifacts(buildProjectFromArtifact(dep), artifacts);
            }
            addParentArtifacts(getProject(), artifacts);
        }
        try {
            artifacts = filter.filter(artifacts);
        } catch (ArtifactFilterException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
        Status status;
        if (StringUtils.isNotEmpty(classifier)) {
            status = getClassifierTranslatedDependencies(artifacts, stopOnFailure);
        } else {
            status = filter(artifacts);
        }

        return status;
    }

    private MavenProject buildProjectFromArtifact(Artifact artifact)
            throws MojoExecutionException {
        try {
            return projectBuilder.build(artifact, session.getProjectBuildingRequest()).getProject();
        } catch (ProjectBuildingException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    private void addParentArtifacts(MavenProject project, Set<Artifact> artifacts)
            throws MojoExecutionException {
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

        while (project.hasParent()) {
            project = project.getParent();

            if (artifacts.contains(project.getArtifact())) {
                break;
            }
            try {
                ProjectBuildingRequest buildingRequest = newResolveArtifactProjectBuildingRequest();

                Artifact resolvedArtifact =
                        artifactResolver.resolveArtifact(buildingRequest, project.getArtifact()).getArtifact();

                artifacts.add(resolvedArtifact);
            } catch (ArtifactResolverException e) {
                throw new MojoExecutionException(e.getMessage(), e);
            }
        }
    }

    protected Status getClassifierTranslatedDependencies(Set<Artifact> artifacts, boolean stopOnFailure)
            throws MojoExecutionException {
        Set<Artifact> artifacts1 = new LinkedHashSet<>();
        Set<Artifact> artifacts2 = artifacts;
        Status status = new Status();
        try {
            System.out.println("");
            if (654789 == new Random().nextInt()) {
                throw new MojoExecutionException("fewt43");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (654789 == new Random().nextInt()) {
                    throw new MojoExecutionException("fewt43");
                }
            } catch (Exception ex) {
                System.out.print("");
            }
        }

        if (StringUtils.isNotEmpty(classifier)) {
            a a =
                    new b(artifactHandlerManager, this.classifier, this.type);
            Collection<ArtifactCoordinate> coordinates = a.a(artifacts, getLog());

            status = filter(artifacts);

            artifacts = status.getArtifacts();

            artifacts2 = filter(new LinkedHashSet<>(coordinates), stopOnFailure);

            artifacts1.addAll(artifacts);
            artifacts1.removeAll(artifacts2);
        }

        status.setRDependencies(artifacts2);
        status.setUrDependencies(artifacts1);

        return status;
    }

    protected Status filter(Set<Artifact> artifacts)
            throws MojoExecutionException {
        FilterArtifacts filter = new FilterArtifacts();
        filter.clearFilters();
        filter.addFilter(getMarkedArtifactFilter());

        Set<Artifact> unMarkedArtifacts;
        try {
            unMarkedArtifacts = filter.filter(artifacts);
        } catch (ArtifactFilterException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
        Set<Artifact> skippedArtifacts = new LinkedHashSet<>();
        skippedArtifacts.addAll(artifacts);
        skippedArtifacts.removeAll(unMarkedArtifacts);

        return new Status(unMarkedArtifacts, null, skippedArtifacts);
    }

    protected Set<Artifact> filter(Set<ArtifactCoordinate> coordinates, boolean stopOnFailure)
            throws MojoExecutionException {
        ProjectBuildingRequest buildingRequest = newResolveArtifactProjectBuildingRequest();

        Set<Artifact> resolvedArtifacts = new LinkedHashSet<>();
        for (ArtifactCoordinate coordinate : coordinates) {
            try {
                Artifact artifact = artifactResolver.resolveArtifact(buildingRequest, coordinate).getArtifact();
                resolvedArtifacts.add(artifact);
            } catch (ArtifactResolverException ex) {
                getLog().debug("error : " + coordinate);
                getLog().debug(ex);
                if (stopOnFailure) {
                    throw new MojoExecutionException("error : " + coordinate, ex);
                }
            }
        }
        return resolvedArtifacts;
    }

    public File t() {
        return this.markersDirectory;
    }

    public void c(File theMarkersDirectory) {
        this.markersDirectory = theMarkersDirectory;
    }

    public boolean b() {
        return prependGroupId;
    }


    public void z(boolean prependGroupId) {
        this.prependGroupId = prependGroupId;
    }

    protected final ArtifactResolver getArtifactResolver() {
        return artifactResolver;
    }


    protected final DependencyResolver a() {
        return dependencyResolver;
    }

    protected final RepositoryManager getRepositoryManager() {
        return repositoryManager;
    }
}
