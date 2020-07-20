package src;


import src.parsing.XNode;
import src.parsing.XPathParser;

import java.util.List;

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
        context.addTask(new Task("http://120.79.55.82:1200/gamersky/news") {
            @Override
            public Object parse(CrawlerContext context, XResponse response) {
                XPathParser xPathParser = new XPathParser(response.getStrContent());
                List<XNode> xNodes = xPathParser.evalNodes("/rss/channel/item");
//                xNodes.forEach(n -> {
//
//                    System.out.println(n.getChildren().get(0).getStringBody(""));
//                    System.out.println(n.getChildren().get(3).getStringBody(""));
//
//                });
                System.out.println(xNodes.get(0).getChildren().get(3).getStringBody(""));
                context.addTask(new Task("https://adnmb2.com/t/28644382") {
                    @Override
                    public Object parse(CrawlerContext context, XResponse response) {
                        System.out.println(response.getStrContent());
                        XPathParser xPathParser = new XPathParser(response.getStrContent(),false);

//                     //   System.out.println(xPathParser.evalString(""));
                        return null;
                    }
                });
                return null;
            }

        });


        //启动爬虫任务
        context.start();
    }
}
