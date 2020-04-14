package task;
//接口回调 读取目录
/*
*吧此接口 传入到 FileScanner 里
*通过这个接口 对文件夹进行一个操作
*
* */


import java.io.File;

public interface ScanCallback {
//对文件夹的扫描任务进行回调 处理文件夹将文件夹下一级的子文件夹保存数据库
void callback(File dir);

}
