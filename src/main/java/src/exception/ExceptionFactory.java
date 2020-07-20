package src.exception;


import src.executor.ErrorContext;

/**
 * 错误信息的静态工厂类 目的是把错误信息 交给context来存储一下
 *
 * @Author: loafer
 */
public class ExceptionFactory {
    private ExceptionFactory() {
        // 私有化 错误工厂 避免外部调用
    }

    /**
     * 将错误信息放到 context来存储
     * 包裹一下返回
     *
     * @param message
     * @param e
     * @return
     */
    public static RuntimeException wrapException(String message, Exception e) {
        return new PersistenceException(ErrorContext.instance().message(message).cause(e).toString(), e);

    }
}
