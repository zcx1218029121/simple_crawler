package src.crawler;

import src.CrawlerContext;
import src.Task;

/**
 * @ProjectName: simple_java_crawler
 * @Package: src
 * @ClassName: BaseCrawler
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/28 16:56
 * @Version: 1.0
 */
public abstract class BaseCrawler {
    /**
     * 开始的url
     */
    private String startUrl;
    private String name;
    private CrawlerContext crawlerContext;

    abstract Object parse();

    void doParse() {
        Object result = parse();
        if (result instanceof Task) {
            crawlerContext.addTask((Task) result);
        } else {
            // todo 交给管道
        }
    }
}
