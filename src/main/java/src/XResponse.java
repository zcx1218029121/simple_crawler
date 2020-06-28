package src;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * @ProjectName: simple_java_crawler
 * @Package: src.net
 * @ClassName: XResponse
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/28 17:15
 * @Version: 1.0
 */
public class XResponse implements Serializable {
    private HttpResponse httpResponse;

    private int responseCode;

    private String userAgent;

    private String version;

    private String contentType;

    private String StatusLine;

    private String strContent;

    public XResponse(HttpResponse httpResponse) {
        responseCode = httpResponse.getStatusLine().getStatusCode();
        version = httpResponse.getProtocolVersion().toString();
        contentType = httpResponse.getHeaders("Content-Type")[0].getValue();
        try {
            strContent = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getContentType() {
        return contentType;
    }

    public String getStatusLine() {
        return StatusLine;
    }

    public String getStrContent() {
        return strContent;
    }

}
