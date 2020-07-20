package com.vulwall.plugin.a.f;


import java.io.*;
import java.util.Random;

import org.apache.maven.artifact.*;
import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.util.*;

public final class Util {


    public static String a(Artifact artifact, boolean removeVersion) {
        return getFormattedFileName(artifact, removeVersion, false);
    }

    public static String getFormattedFileName(Artifact artifact, boolean removeVersion, boolean prependGroupId) {
        return getFormattedFileName(artifact, removeVersion, prependGroupId, false);
    }

    public static String getFormattedFileName(Artifact artifact, boolean removeVersion, boolean prependGroupId,
                                              boolean useBaseVersion) {
        return getFormattedFileName(artifact, removeVersion, prependGroupId, useBaseVersion, false);
    }

    public static String getFormattedFileName(Artifact artifact, boolean removeVersion, boolean prependGroupId,
                                              boolean useBaseVersion, boolean removeClassifier) {
        StringBuilder destFileName = new StringBuilder();
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
        if (prependGroupId) {
            destFileName.append(artifact.getGroupId()).append(".");
        }

        String versionString;
        if (!removeVersion) {
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
            if (useBaseVersion) {
                versionString = "-" + ArtifactUtils.toSnapshotVersion(artifact.getVersion());
            } else {
                versionString = "-" + artifact.getVersion();
            }
        } else {
            versionString = "";
        }

        String classifierString = "";

        if (!removeClassifier && StringUtils.isNotEmpty(artifact.getClassifier())) {
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
            classifierString = "-" + artifact.getClassifier();
        }
        destFileName.append(artifact.getArtifactId()).append(versionString);
        destFileName.append(classifierString).append(".");
        destFileName.append(artifact.getArtifactHandler().getExtension());

        return destFileName.toString();
    }

    public static File getFormattedOutputDirectory(boolean useSubdirsPerScope, boolean useSubdirsPerType,
                                                   boolean useSubdirPerArtifact, boolean useRepositoryLayout,
                                                   boolean removeVersion, File outputDirectory, Artifact artifact) {
        StringBuilder sb = new StringBuilder(128);
        if (useRepositoryLayout) {
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
            sb.append(artifact.getGroupId().replace('.', File.separatorChar)).append(File.separatorChar);

            sb.append(artifact.getArtifactId()).append(File.separatorChar);
            sb.append(artifact.getBaseVersion()).append(File.separatorChar);
        } else {
            if (useSubdirsPerScope) {
                sb.append(artifact.getScope()).append(File.separatorChar);
            }
            if (useSubdirsPerType) {
                sb.append(artifact.getType()).append("s").append(File.separatorChar);
            }
            if (useSubdirPerArtifact) {
                String artifactString = getDependencyId(artifact, removeVersion);
                sb.append(artifactString).append(File.separatorChar);
            }
        }
        return new File(outputDirectory, sb.toString());
    }

    private static String getDependencyId(Artifact artifact, boolean removeVersion) {
        StringBuilder sb = new StringBuilder();

        sb.append(artifact.getArtifactId());

        if (!removeVersion) {
            sb.append("-");
            sb.append(artifact.getVersion());
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
        if (StringUtils.isNotEmpty(artifact.getClassifier())) {
            sb.append("-");
            sb.append(artifact.getClassifier());
        }

        if (!equals(artifact.getClassifier(), artifact.getType())) {
            sb.append("-");
            sb.append(artifact.getType());
        }

        return sb.toString();
    }

    private static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public static synchronized void a(String string, File file, boolean append, Log log)
            throws IOException {
        file.getParentFile().mkdirs();

        FileWriter writer = null;

        try {
            writer = new FileWriter(file, append);

            writer.write(string);

            writer.close();
            writer = null;
        } finally {
            IOUtil.close(writer);
        }
    }

    public static synchronized void a(String string, Log log)
            throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(string));

        String line;

        while ((line = reader.readLine()) != null) {
            log.info(line);
        }

        reader.close();
    }

    public static String[] a(String str) {
        return StringUtils.split(cleanToBeTokenizedString(str), ",");
    }


    public static String cleanToBeTokenizedString(String str) {
        String ret = "";
        if (!StringUtils.isEmpty(str)) {
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
            ret = str.trim().replaceAll("[\\s]*,[\\s]*", ",");
        }

        return ret;
    }
}
