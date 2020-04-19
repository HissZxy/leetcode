
public class Collera {
    public static void main(String args[]) {
        VideoFile vf;
        OperatingSystemVersion osType1 = new WindowsVersion();
        vf = new AVIFile();
        osType1.setVideo(vf);
        osType1.play("让子弹飞.AVI");

        OperatingSystemVersion osType2 = new LinuxVersion();
        vf = new AVIFile();
        osType2.setVideo(vf);
        osType2.play("让子弹飞.MPGE");

        OperatingSystemVersion osType3 = new UnixVersion();
        vf = new AVIFile();
        osType3.setVideo(vf);
        osType3.play("让子弹飞.RMVB");
    }
}