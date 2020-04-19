

public class LinuxVersion extends OperatingSystemVersion {
    public void play(String fileName) {
        String osType = "Linux播放";
        this.vf.decode(osType,fileName);
    }
}