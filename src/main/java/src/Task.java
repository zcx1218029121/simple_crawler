package src;

import java.io.IOException;

/**
 * @ProjectName: simple_java_crawler
 * @Package: PACKAGE_NAME
 * @ClassName: Task
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/22 14:14
 * @Version: 1.0
 */
public abstract class Task {


    private long dueTime = 1000;


    public long getDueTime() {
        return dueTime;
    }

    public Task(String url) {
        this.url = url;

    }

    private String url;


    public Object execute(CrawlerContext context) throws IOException {
        return parse(context, new XResponse(HttpRequestHelper.get(this)));
    }

    public abstract Object parse(CrawlerContext context, XResponse response);


    public String getUrl() {
        return url;
    }


}
