package src.exception;

/**
 * @author loafer
 * 持久化错误类
 */
@SuppressWarnings("deprecation")
public class PersistenceException extends MybatisException {
    private static final long serialVersionUID = -7537395265357977271L;

    public PersistenceException() {
        super();
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }
}
