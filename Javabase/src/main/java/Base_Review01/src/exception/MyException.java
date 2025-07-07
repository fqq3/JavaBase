package exception;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/21 - 04 - 21 - 0:50
 * @Description: exception
 * @version: 1.0
 */
public class MyException extends RuntimeException {

    static final long serialVersionUID = -70348971907L;

    public MyException(){
    }
    public MyException(String msg){
        super(msg);
    }
}