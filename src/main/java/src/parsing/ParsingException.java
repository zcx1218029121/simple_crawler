package src.parsing;


import src.exception.PersistenceException;

/**
 * xml 和token的解析异常
 * @author loafer
 */
public class ParsingException  extends PersistenceException {
    public ParsingException() {
        super();
    }

    public ParsingException(String message) {
        super(message);
    }

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParsingException(Throwable cause) {
        super(cause);
    }
}
