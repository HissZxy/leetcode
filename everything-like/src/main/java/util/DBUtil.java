package util;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import task.DBInit;

import javax.sql.DataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static volatile DataSource DATA_SOURCE;

    /**
     * 提供获取数据库连接池的功能：
     * 使用单例模式（多线程安全版本）
     * 回顾多线程安全版本的单例模式：
     * 1.为什么在外层判断是否等于null
     * 2.synchronized加锁以后，为什么还要判断等于null
     * 3.为什么DataSource类变量要使用volatile关键字修饰
     * 多线程操作：原子性，可见性（主内存拷贝到工作内存），有序性
     * synchronized保证三个特性，volatile保证可见性，有序性
     * @return
     */
    private static DataSource getDataSource(){
        if(DATA_SOURCE == null){//目的：提高效率
            //刚开始所有进入这行代码的线程，DATA_SOURCE对象都是null
            //可能是第一个进去的线程，这时候DATA_SOURCE对象都是null
            // 也可能是第一个线程之后的线程进入并执行
            synchronized (DBUtil.class){
                if(DATA_SOURCE == null){
                    // 初始化操作，使用volatile关键字禁止指令重排序，建立内存屏障
                    SQLiteConfig config = new SQLiteConfig();
                    config.setDateStringFormat(Util.DATE_PATTERN);
                    DATA_SOURCE = new SQLiteDataSource(config);
                    ((SQLiteDataSource)DATA_SOURCE).setUrl(getUrl());
                }
            }
        }
        return DATA_SOURCE;
    }


    /**
     * 获取sqlite数据库文件url的方法
     * @return
     */
    private static String getUrl(){
        try {
            // 获取target编译文件夹的路径
            // 通过classLoader.getResource()/classLoader.getResourceAsStream()这样的方法
            // 默认的根路径为编译文件夹路径（target/classes）
            URL classesURL = DBUtil.class.getClassLoader().getResource("./");
            // 获取target/classes文件夹的父目录路径
            String dir = new File(classesURL.getPath()).getParent();
            // String dir = "D:/TMP";
            String url = "jdbc:sqlite://" + dir + File.separator + "everything-like.db";
            // new SqliteDateSource()，把这个对象的url设置进去，才会创建这个文件，如果
            // 文件已经存在，就会读取这个文件
            url = URLDecoder.decode(url, "UTF-8");
            System.out.println("获取数据库文件路径：" + url);
            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库文件路径失败", e);
        }
    }

    /**
     * 提供获取数据库连接的方法：
     * 从数据库连接池DataSource.getConnection()来获取数据库连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void main(String[] args) throws SQLException {
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    DataSource dataSource = DBUtil.getDataSource();
                }
            }).start();
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    /**
     * 释放数据库资源：
     * @param connection 数据库连接
     * @param statement sql执行对象
     * @param resultSet 结果集
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("释放数据库资源错误", e);
        }
    }
}


