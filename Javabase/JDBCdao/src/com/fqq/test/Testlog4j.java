package com.fqq.test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;  // 关键！

/**
 * @author: fqq
 * @Date: 2025/7/17 - 07 - 17 - 4:16
 * @Description: com.fqq.test
 * @version: 1.0
 */
public class Testlog4j {
    public static void main(String[] args) {

        Logger logger=LogManager.getLogger("com.fqq.dao.impl.EmpDaoImpl");
    }
}
