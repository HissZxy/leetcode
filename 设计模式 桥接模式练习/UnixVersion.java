
public class UnixVersion extends OperatingSystemVersion {
    public void play(String fileName) {
        String osType = "Unix播放";
        this.vf.decode(osType,fileName);
    }

}