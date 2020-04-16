public class AVIFile implements VideoFile{
	public void decode(String osType, String fileName){
		System.out.println(osType + "AVIFile" + fileName + ".");
		}
}

//�ͻ��˲���
public class Client {
	public static void main(String a[]){		
		VideoFile vf;
		OperatingSystemVersion Version;
		
		vf = (VideoFile)XMLUtilVideo.getBean("vf");
		Version = (OperatingSystemVersion)XMLUtilVideo.getBean("Version");
		
		Version.setVideoFile(vf);
		Version.play("������");
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

//������OperatingSystemVersion
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

//�������ļ��ӿ�
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

//XML����������
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

public class XMLUtilVideo {
	public static Object getBean(String args)
	{
		try
		{
			//�����ĵ�����
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
				//��ȡ�����������ı��ڵ�
				classNode = nl.item(0).getFirstChild();
			}
			else if(args.equals("Version"))
			{
				//��ȡ�����������ı��ڵ�
				classNode = nl.item(1).getFirstChild();
			}
			cName = classNode.getNodeValue();
			//ͨ����������ʵ�����󲢷���
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
