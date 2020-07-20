package src.exception;

/**
 * @author loafer
 * @Description: mybatis的抽象错误类
 * 在mybatis-3中 被 @Deprecated 标注
 * @Date: 2020/7/6 17:59
 * @Version: 1.0
 */
@Deprecated
public class MybatisException extends RuntimeException {
    private static final long serialVersionUID = 3880206998166270511L;

    public MybatisException() {
        super();
    }

    public MybatisException(String messages) {
        super(messages);
    }

    public MybatisException(Throwable cause) {
        super(cause);
    }

    public MybatisException(String messages, Throwable cause) {
        super(messages, cause);
    }
}
