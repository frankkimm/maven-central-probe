package de.kimmlingen.test.probe;

/**
 * Probe artifact: tries out signing and uploading to Maven Central before the first real release.
 */
public final class Probe {

    private Probe() {
    }

    /**
     * Returns a greeting.
     *
     * @return the greeting
     */
    public static String hello() {
        return "probe";
    }
}
