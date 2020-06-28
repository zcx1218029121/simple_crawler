package src;


import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskManager implements Runnable {

    private final BlockingQueue queue;
    volatile boolean canceled;
    private CrawlerContext crawlerContext;


    public TaskManager(CrawlerContext context) {
        queue = context.getTasksQueue();
        canceled = false;
        crawlerContext = context;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public void run() {

        while (!canceled) {
            try {
                // 执行任务
                try {
                    Task task = (Task) queue.poll(crawlerContext.crawlerConfig.getWaitTime(), TimeUnit.MILLISECONDS);
                    if (task == null) {
                        this.canceled = true;
                    } else {
                        // 布隆过滤器
                        if (!crawlerContext.filter(task)) {

                            Object result = task.execute(crawlerContext);
                            if (result instanceof Task){
                                crawlerContext.addTask((Task) result);
                            }else {
                            }
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
