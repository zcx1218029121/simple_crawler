package src.exception;

/**
 * @ProjectName: simple_java_crawler
 * @Package: src.exception
 * @ClassName: SimpleJavaCrawler
 * @Author: loafer
 * @Description:
 * @Date: 2020/7/13 10:35
 * @Version: 1.0
 */
public class SimpleJavaCrawlerException extends RuntimeException {
    public SimpleJavaCrawlerException(String msg){
        super(msg);
    }
   public SimpleJavaCrawlerException(String msg,Throwable throwable){
        super(msg,throwable);
    }


}
