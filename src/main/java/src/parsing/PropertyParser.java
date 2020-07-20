package src.parsing;

import java.util.Properties;

/**
 * mybatis 属性配置
 *
 * @author loafer
 */
public class PropertyParser {
    /**
     * mybatis 的前缀
     */
    private static final String KEY_PREFIX = "org.apache.ibatis.parsing.PropertyParser.";
    /**
     * 在mybatis 中的 默认
     * <property name="org.apache.ibatis.parsing.PropertyParser.enable-default-value" value="true"/>
     * 启动默认值配置
     */
    public static final String KEY_ENABLE_DEFAULT_VALUE = KEY_PREFIX + "enable-default-value";

    /**
     * <p>
     * The default separator is {@code ":"}.
     * </p>
     */
    public static final String KEY_DEFAULT_VALUE_SEPARATOR = KEY_PREFIX + "default-value-separator";
    /**
     * 默认值
     */
    private static final String ENABLE_DEFAULT_VALUE = "false";
    /**
     * 默认值分隔符
     */
    private static final String DEFAULT_VALUE_SEPARATOR = ":";

    private PropertyParser() {
        // 工具类应该私有构造函数
    }

    public static String parse(String string, Properties variables) {
        VariableTokenHandler handler = new VariableTokenHandler(variables);
        GenericTokenParser parser = new GenericTokenParser("${", "}", handler);
        return parser.parse(string);
    }

    private static class VariableTokenHandler implements TokenHandler {
        private final Properties variables;
        private final boolean enableDefaultValue;
        private final String defaultValueSeparator;

        private VariableTokenHandler(Properties variables) {
            this.variables = variables;
            this.enableDefaultValue = Boolean.parseBoolean(getPropertyValue(KEY_ENABLE_DEFAULT_VALUE, ENABLE_DEFAULT_VALUE));
            this.defaultValueSeparator = getPropertyValue(KEY_DEFAULT_VALUE_SEPARATOR, DEFAULT_VALUE_SEPARATOR);
        }

        /**
         * 如果 Properties 不存在 或者值不存在 使用默认值
         *
         * @param key
         * @param defaultValue
         * @return
         */
        private String getPropertyValue(String key, String defaultValue) {
            return (variables == null) ? defaultValue : variables.getProperty(key, defaultValue);
        }

        /**
         * 用 variables 替换 token占位符的内容
         * @param content
         * @return
         */
        @Override
        public String handleToken(String content) {
            if (variables != null) {

                String key = content;
                // 如果启用默认配置
                if (enableDefaultValue) {
                    // 查找分隔符
                    final int separatorIndex = content.indexOf(defaultValueSeparator);
                    String defaultValue = null;
                    if (separatorIndex >= 0) {
                        // 占位符的key
                        key = content.substring(0, separatorIndex);
                        // 获取默认值
                        defaultValue = content.substring(separatorIndex + defaultValueSeparator.length());
                    }
                    /**
                     * 用variables.getProperty(key, defaultValue);来获取值
                     * 说明 variables无值的时候才会用默认值
                     */
                    if (null != defaultValue) {
                        return variables.getProperty(key, defaultValue);
                    }
                }
                if (variables.containsKey(key)) {
                    return variables.getProperty(key);
                }
            }

            return String.format("${%s}", content);
        }
    }


}
