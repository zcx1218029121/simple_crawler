package src;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;

/**
 * @ProjectName: simple_java_crawler
 * @Package: net
 * @ClassName: HttpRequestFactory
 * @Author: loafer
 * @Date: 2020/6/28 13:52
 * @Version: 1.0
 */
public class HttpRequestHelper {


    public static HttpResponse get(Task task) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(task.getUrl());
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout((int) task.getDueTime()).setConnectTimeout((int) task.getDueTime()).build();
        get.setConfig(requestConfig);
        return httpClient.execute(get);
    }
}
