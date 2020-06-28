package src;


/**
 * @ProjectName: simple_java_crawler
 * @Package: PACKAGE_NAME
 * @ClassName: App
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/28 13:18
 * @Version: 1.0
 */
public class App {
    private CrawlerContext crawlerContext;

    public static void main(String[] args) {
        CrawlerContext context = new CrawlerContext();
        // 添加爬虫任务
        context.addTask(new Task("https://baike.baidu.com/item/HTTP%E7%8A%B6%E6%80%81%E7%A0%81/5053660?fr=aladdin") {

            @Override
            public Object parse(CrawlerContext context, XResponse response) {
                System.out.println(response.getStrContent());
                return null;
            }

        });

        //启动爬虫任务
        context.start();
    }
}
