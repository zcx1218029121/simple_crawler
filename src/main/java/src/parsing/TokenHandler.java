package src.parsing;

/**
 * 占位符解析器
 *
 * @author loafer
 */
public interface TokenHandler {
    /**
     * 解析token
     *
     * @param content
     * @return
     */
    String handleToken(String content);
}
