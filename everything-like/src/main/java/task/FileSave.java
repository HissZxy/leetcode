package task;

import util.DBUtil;
import util.PinyinUtil;

import java.io.File;
import java.sql.*;

public class FileSave implements ScanCallback {
//文件保存任务 实际的实现类
    @Override
    public void callback(File dir) {
        //文件夹下一级子文件和子文件夹保存到数据库
            File[] children = dir.listFiles();//文件夹下一级目录遍历
            if(children != null){
                for(File child : children){
                    System.out.println(child.getPath());
                    save(child);
                }
            }
       }


       /*
       * 文件信息保存到数据库
       *
       * */
       private void save(File file){

           Connection connection = null;
           PreparedStatement statement = null;

           try {
               //1.获取数据库连接
             connection =  DBUtil.getConnection();
               String sql = " insert into file_meta"+
                       "(name, path, size,  last_modified,  pinyin,  pinyin_first)"+
                       " values (?, ?, ?, ?, ?, ?)";
             //2.获取sql操作命令对象
               statement = connection.prepareStatement(sql);
               statement.setString(1,file.getName());
               statement.setString(2,file.getParent());
               statement.setLong(3, file.length());
               statement.setTimestamp(4, new Timestamp(file.lastModified()));

               String pinyin = null;
               String pinyin_first = null;
               //文件名包含汉子 需要获取拼音和拼音首字母保存到数据库
               if(PinyinUtil.containsChinese(file.getName())){
                   String[] pinyins = PinyinUtil.get(file.getName());
                   pinyin = pinyins[0];
                   pinyin_first = pinyins[1];
               }
               statement.setString(5,pinyin);
               statement.setString(6,pinyin_first);
               System.out.println("执行文件保存操作"+sql);
             //3.执行sql语句
             statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
               throw new RuntimeException("文件保存失败,sql insert语句",e);
           } finally {
              //释放资源
               DBUtil.close(connection,statement);

           }

       }
  }
