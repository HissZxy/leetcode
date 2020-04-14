package app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import task.DBInit;
import task.FileSave;
import task.FileScanner;
import task.ScanCallback;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FileMeta> fileTable;

    @FXML
    private Label srcDirectory;

    private Thread task;
//获取标签
    public void initialize(URL location, ResourceBundle resources) {
        // 添加搜索框监听器，内容改变时执行监听事件
        //界面初始化时需要初始化数据库以及数据库表
        DBInit.init();
        searchField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                freshTable();
            }
        });
    }
/*
* 点击选择目录按钮发生的事件方法
*
*
* */
    public void choose(Event event) {
        // 选择文件目录
        DirectoryChooser directoryChooser=new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);
        if(file == null)
            return;
        // 获取选择的目录路径，并显示
        String path = file.getPath();

        // TODO
        srcDirectory.setText(path);
        //选择了目录需要执行目录的扫描;目录扫描任务
        //当该目录下的子文件与子文件夹都要扫描出来;
        if(task != null){
            task.interrupt();
        }
        task = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   System.out.println("执行文件扫描任务");
                    //回调接口定义  实例化的时候 用真的一个FileSave的实现类
                    ScanCallback callback = new FileSave();//文件扫描回调接口 做文件夹以及下一级子文件夹保存到数据库的操作
                    FileScanner scanner = new FileScanner(callback);//传入任务类
                    scanner.scan(path);//为了提高效率多线程执行扫描任务
                    //等待文件扫描任务执行完毕 waitFinish需要阻塞等待
                    //TODO
                    scanner.waitFinish();
                    System.out.println("任务执行完毕刷新表格");
                    //刷新表格：将扫描出来的子文件和子文件夹展示在表格当中；
                    freshTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        task.start();
    }

    // 刷新表格数据
    private void freshTable(){
        ObservableList<FileMeta> metas = fileTable.getItems();
        metas.clear();
        // TODO
    }
}