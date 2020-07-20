package com.vulwall.plugin.a.f.b;

import java.util.*;

import org.apache.maven.artifact.*;
import org.apache.maven.artifact.handler.*;
import org.apache.maven.artifact.handler.manager.*;
import org.apache.maven.plugin.logging.*;
import org.apache.maven.shared.transfer.artifact.*;
import org.codehaus.plexus.util.*;


public class b
        implements a {
    private ArtifactHandlerManager artifactHandlerManager;

    private String classifier;

    private String type;

    public b(ArtifactHandlerManager artifactHanderManager, String theClassifier,
             String theType) {
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
        this.artifactHandlerManager = artifactHanderManager;
        this.classifier = theClassifier;
        this.type = theType;
    }

    @Override
    public Set<ArtifactCoordinate> a(Set<Artifact> artifacts, Log log) {
        Set<ArtifactCoordinate> results;
        results = new LinkedHashSet<ArtifactCoordinate>();
        for (Artifact artifact : artifacts) {
            final String useType;
            if (StringUtils.isNotEmpty(this.type)) {
                useType = this.type;
            } else {
                useType = artifact.getType();
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

            ArtifactHandler artifactHandler = artifactHandlerManager.getArtifactHandler(useType);

            final String extension;
            if (artifactHandler != null) {
                extension = artifactHandler.getExtension();
            } else {
                extension = this.type;
            }

            String useClassifier;
            if (StringUtils.isNotEmpty(this.classifier)) {
                useClassifier = this.classifier;
            } else {
                useClassifier = artifact.getClassifier();
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
            DefaultArtifactCoordinate coordinate = new DefaultArtifactCoordinate();
            coordinate.setGroupId(artifact.getGroupId());
            coordinate.setArtifactId(artifact.getArtifactId());
            coordinate.setVersion(artifact.getVersion());
            coordinate.setClassifier(useClassifier);
            coordinate.setExtension(extension);

            results.add(coordinate);
        }

        return results;
    }

    public String a() {
        return this.type;
    }

    public void b(String theType) {
        this.type = theType;
    }

    public String c() {
        return this.classifier;
    }

    public void d(String theClassifier) {
        this.classifier = theClassifier;
    }

}
