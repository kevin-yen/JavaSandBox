import org.gradle.internal.os.OperatingSystem as GroovyOperatingSystem

class OperatingSystem {

    private String name
    private String bitType

    OperatingSystem() {
        if (GroovyOperatingSystem.current().isLinux()) {
            name = "linux"
        }
        else if (GroovyOperatingSystem.current().isMacOsX()) {
            name = "mac"
        }
        else if (GroovyOperatingSystem.current().isWindows()) {
            name = "window"
        }
        else {
            name = "unix"
        }

        if (GroovyOperatingSystem.current().toString().contains("64")) {
            bitType = "64"
        }
        else {
            bitType = "32"
        }
    }

    static OperatingSystem current() {
        return new OperatingSystem()
    }

    String toString() {
        return name + bitType
    }

}