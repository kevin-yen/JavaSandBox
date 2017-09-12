class Version implements Comparable<Version> {
    private majorVersion
    private minorVersion
    private patchVersion

    Version(String version) {
        String[] versionStrings = version.split("\\.")

        majorVersion = Integer.parseInt(versionStrings[0])
        minorVersion = Integer.parseInt(versionStrings[1])
        patchVersion = Integer.parseInt(versionStrings[2])
    }

    static Version version(String version) {
        return new Version(version)
    }

    static int majorVersion(String version) {
        return new Version(version).majorVersion
    }

    static int minorVersion(String version) {
        return new Version(version).minorVersion
    }

    static int patchVersion(String version) {
        return new Version(version).patchVersion
    }

    int getMajorVersion() {
        return majorVersion
    }

    int getMinorVersion() {
        return minorVersion
    }

    int getPatchVersion() {
        return patchVersion
    }

    @Override
    int compareTo(Version version) {
        if (Integer.compare(this.majorVersion, version.majorVersion) != 0) {
            return Integer.compare(this.majorVersion, version.majorVersion)
        }
        else if (Integer.compare(this.minorVersion, version.minorVersion) != 0) {
            return Integer.compare(this.minorVersion, version.minorVersion)
        }
        else if (Integer.compare(this.patchVersion, version.patchVersion) != 0) {
            return Integer.compare(this.patchVersion, version.patchVersion)
        }
    }

}