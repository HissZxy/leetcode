
public class AVIFile implements VideoFile {
    public void decode(String osType, String fileName) {
        System.out.println("系统："+osType+"文件名称："+fileName);
    }
}