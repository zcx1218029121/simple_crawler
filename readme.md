java多线程练手用爬虫

## todo
- [ ] xpath 解析类的编写
- [ ] pip 持久化类的编写
- [ ] 利用反射自动配置上下文对象
## 简单使用
```java
CrawlerContext context = new CrawlerContext();
        // 添加爬虫任务
        context.addTask(new Task("https://baike.baidu.com/item/HTTP%E7%8A%B6%E6%80%81%E7%A0%81/5053660?fr=aladdin") {

            @Override
            public Object parse(CrawlerContext context, XResponse response) {
                System.out.println(response.getStrContent());
                return new Task("https://baike.baidu.com/item/HTTP%E7%8A%B6%E6%80%81%E7%A0%81/5053660?fr=aladdin") {
                    @Override
                    public Object parse(CrawlerContext context, XResponse response) {
                        return null;
                    }
                };
            }

        });

        //启动爬虫任务
        context.start();
```
在 parse 中返回的Task 就会被set到堵塞队列中执行