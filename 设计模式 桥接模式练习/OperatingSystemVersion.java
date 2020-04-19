
public abstract class OperatingSystemVersion {
    protected VideoFile vf;

    public void setVideo(VideoFile vf) {
        this.vf = vf;
    }

    public abstract void play(String fileName);
}