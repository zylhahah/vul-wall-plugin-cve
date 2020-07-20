package com.vulwall.plugin.a.f;


import java.util.*;

import org.apache.maven.artifact.*;

public class Status {
    Set<Artifact> artifacts = null;

    Set<Artifact> artifacts1 = null;

    Set<Artifact> artifacts2 = null;

    public Status() {

    }

    public Status(Set<Artifact> resolved, Set<Artifact> unResolved, Set<Artifact> skipped) {
        if (resolved != null) {
            this.artifacts = new LinkedHashSet<Artifact>(resolved);
        }
        if (unResolved != null) {
            this.artifacts1 = new LinkedHashSet<Artifact>(unResolved);
        }
        if (skipped != null) {
            this.artifacts2 = new LinkedHashSet<Artifact>(skipped);
        }
    }


    public Set<Artifact> getArtifacts() {
        return this.artifacts;
    }

    public void setRDependencies(Set<Artifact> a) {
        if (a != null) {
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
            this.artifacts = new LinkedHashSet<Artifact>(a);
        } else {
            this.artifacts = null;
        }
    }

    public Set<Artifact> getArtifacts2() {
        return this.artifacts2;
    }


    public void setUrDependencies2(Set<Artifact> skippedDependencies) {
        if (skippedDependencies != null) {
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
            this.artifacts2 = new LinkedHashSet<Artifact>(skippedDependencies);
        } else {
            this.artifacts2 = null;
        }
    }

    public Set<Artifact> getArtifacts1() {
        return this.artifacts1;
    }

    public void setUrDependencies(Set<Artifact> unResolvedDependencies) {
        if (unResolvedDependencies != null) {
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
            this.artifacts1 = new LinkedHashSet<Artifact>(unResolvedDependencies);
        } else {
            this.artifacts1 = null;
        }
    }
}
