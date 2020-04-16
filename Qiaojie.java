public class AVIFile implements VideoFile{
	public void decode(String osType, String fileName){
		System.out.println(osType + "AVIFile" + fileName + ".");
		}
}

//客户端测试
public class Client {
	public static void main(String a[]){		
		VideoFile vf;
		OperatingSystemVersion Version;
		
		vf = (VideoFile)XMLUtilVideo.getBean("vf");
		Version = (OperatingSystemVersion)XMLUtilVideo.getBean("Version");
		
		Version.setVideoFile(vf);
		Version.play("播放器");
	}
}

//LinuxVersion
public class LinuxVersion extends OperatingSystemVersion{
	public void play(String fileName){
		String Verison = "LinuxVersion";
		this.vf.decode(Verison, fileName);
	}
}

//MPEGFile
public class MPEGFile implements VideoFile{
	public void decode(String osType, String fileName){
		System.out.println(osType + "MPEGFile" + fileName + ".");
	}
}

//抽象类OperatingSystemVersion
public abstract class OperatingSystemVersion {
	protected VideoFile vf;
	public void setVideoFile(VideoFile vf){
		this.vf = vf;
	}
	public abstract void play(String fileName);
}

//RMVBFile
public class RMVBFile implements VideoFile{
	public void decode(String osType, String fileName){
		System.out.println(osType + "RMVBFile" + fileName + ".");
	}
}

//UnixVersion
public class UnixVersion extends OperatingSystemVersion{
	public void play(String fileName)
	{
		String Verison = "UnuxVersion";
		this.vf.decode(Verison, fileName);
	}
}

//播放器文件接口
public interface VideoFile {
	void decode(String osType, String fileName);
}

//WindowsVersion
public class WindowsVersion extends OperatingSystemVersion{
	public void play(String fileName){
		String Verison = "WindowsVersion";
		this.vf.decode(Verison, fileName);
	}
}

//WMVFile
public class WMVFile implements VideoFile{
	public void decode(String osType, String fileName){
		System.out.println(osType + "WMVFile" + fileName + ".");
	}
}

//XML操作工具类
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

public class XMLUtilVideo {
	public static Object getBean(String args)
	{
		try
		{
			//创建文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("configVideo.xml"));
			NodeList nl = null;
			Node classNode = null;
			String cName = null;
			nl = doc.getElementsByTagName("className");
			if(args.equals("vf"))
			{
				//获取包含类名的文本节点
				classNode = nl.item(0).getFirstChild();
			}
			else if(args.equals("Version"))
			{
				//获取包含类名的文本节点
				classNode = nl.item(1).getFirstChild();
			}
			cName = classNode.getNodeValue();
			//通过类名生成实例对象并返回
			Class<?> c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
