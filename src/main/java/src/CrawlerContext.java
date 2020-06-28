package src;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

/**
 * @ProjectName: simple_java_crawler
 * @Package: PACKAGE_NAME
 * @ClassName: CrawlerContext
 * @Author: loafer
 * @Description: 爬虫上下文
 * @Date: 2020/6/22 15:04
 * @Version: 1.0
 */
public class CrawlerContext {
    /**
     * 共享任务堵塞队列
     */
    private BlockingQueue<Task> tasksQueue;
    /**
     * 线程池
     */
    private static ThreadPoolExecutor threadPool;

    /**
     * 布隆过滤器
     */

    private BloomFilter<String> filter =
            BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 1000);

    public CrawlerConfig crawlerConfig = new CrawlerConfig();


    public CrawlerContext() {
        tasksQueue = new ArrayBlockingQueue<>(20);

        threadPool = (ThreadPoolExecutor) new ThreadPoolExecutor(0, crawlerConfig.getThreadMax(),
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

    }

    public boolean filter(Task task) {
        return filter.mightContain(task.getUrl());
    }

    public BlockingQueue<Task> getTasksQueue() {
        return tasksQueue;
    }


    public void addTask(Task task) {
        try {
            tasksQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        for (int i = 0; i < crawlerConfig.getThreadMax(); i++) {
            threadPool.execute(new TaskManager(this));
        }
        threadPool.shutdown();
    }
}
