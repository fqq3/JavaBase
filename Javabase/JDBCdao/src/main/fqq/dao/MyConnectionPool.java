package main.fqq.dao;

import main.fqq.utill.PropertiesUtill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author: fqq
 * @Date: 2025/7/12 - 07 - 12 - 18:20
 * @Description: com.fqq.dao
 * @version: 1.0
 */
public class MyConnectionPool {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static int initSize;
    private static int maxSize;
    private static LinkedList<Connection> pool;
    private static Logger logger;
    static {
        logger= LogManager.getLogger(MyConnectionPool.class);
        //初始化
        PropertiesUtill propertiesUtill=new PropertiesUtill("/jdbc.properties");
        driver=propertiesUtill.getProperties("driver");
        url=propertiesUtill.getProperties("url");
        user=propertiesUtill.getProperties("user");
        password=propertiesUtill.getProperties("password");
        initSize=Integer.parseInt(propertiesUtill.getProperties("initSize"));
        maxSize=Integer.parseInt(propertiesUtill.getProperties("maxSize"));

        try{ //加载驱动
            Class.forName(driver);
        }catch(ClassNotFoundException e){
//            e.printStackTrace();
            logger.fatal("找不到数据库驱动类"+driver,e);//驱动类，异常对象
        }
        pool=new LinkedList<Connection>();//初始化数据库连接池pool
        for(int i=0;i<initSize;i++){//创建5个链接对象
            Connection connection=initConnection();
            if(null!=connection){
                pool.add(connection);
//                System.out.println("初始化连接"+connection.hashCode()+"放入连接池");
                logger.info("初始化连接"+connection.hashCode()+"放入连接池");
            }
            pool.add(initConnection());
        }
    }
    private static Connection initConnection(){ //初始化链接对象 private类内部使用
        try{
            return DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
//            e.printStackTrace();
            logger.fatal("初始化链接异常",e);
        }

        return null;
    }

    public static Connection getConnection(){ //外界使用的连接池获取链接
        Connection connection=null;
        if (pool.size()>0){
            connection=pool.removeFirst();//移除第一个元素
            logger.info("连接池中还有链接："+connection.hashCode());
        }else{
            connection=initConnection();
            logger.info("连接池空，新建链接："+connection.hashCode());
        }
        return connection;
    }
    public static void returnConnection(Connection con){
        if (null!=con){
            try{
                if(!con.isClosed()){//未关闭
                    if(pool.size()<maxSize){
                        try{
                            con.setAutoCommit( true);//自动提交
                            logger.debug("设置连接：" + con.hashCode() + "自动提交为True");
                        }catch (SQLException e){
//                            e.printStackTrace();
                            logger.fatal("自动提交出现异常");
                        }
                        pool.addLast(con);
                        logger.info("连接池未满,归还链接"+con.hashCode());
                    }else {
                        try {
                            con.close();
                            logger.info("连接池满了,归还链接"+con.hashCode());
                        } catch (SQLException e) {
//                            e.printStackTrace();
                            logger.fatal("归还链接异常");
                        }
                    }

                }else{
                    logger.info("链接"+con.hashCode()+"已关闭，无需归还");
                }
            }catch(SQLException e  ){
                e.printStackTrace();
            }


        }else{
            logger.warn("传入链接为null,不可归还");
        }
    }

}
