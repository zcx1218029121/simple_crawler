package src;

import java.io.Serializable;

/**
 * @ProjectName: simple_java_crawler
 * @Package: config
 * @ClassName: CrawlerConfig
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/28 13:20
 * @Version: 1.0
 */
public class CrawlerConfig implements Serializable, Cloneable {
    /**
     * 最大线程数
     */
    private final int DEFAULT_THREAD_MAX = 30;
    /**
     * 初始线程数
     */
    private final int DEFAULT_THREAD_MIN = 30;

    /**
     * 任务队列为空等待时间 单位毫秒
     */
    private final long DEFAULT_WAIT_TIME = 1000L;

    private int threadMax;

    private int threadMin;

    private long waitTime;

    public CrawlerConfig() {
        this.threadMax = DEFAULT_THREAD_MAX;
        this.threadMin = DEFAULT_THREAD_MIN;
        this.waitTime = DEFAULT_WAIT_TIME;
    }



    public int getThreadMax() {
        return threadMax;
    }

    public int getThreadMin() {
        return threadMin;
    }

    public long getWaitTime() {
        return waitTime;
    }
}
