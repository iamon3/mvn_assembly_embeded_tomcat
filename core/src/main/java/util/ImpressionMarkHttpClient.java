package util;
/**
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

**
 * This class functions as a HTTP client and makes and API calls to impression_mark web services.
 */
public class ImpressionMarkHttpClient {
/**
    private static final String BASE_URL = "http://localhost:9090/impression-mark/services";
    private static final String DOCUMENT_RESOURCE = "/documents";
    private static final String URL_PATH_SEPARATOR = "/";

    private static final String HTTP_HEADER_ACCEPT = "Accept";
    private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    private static final String MEDIA_TYPE_APPLICATION_JSON = "application/json";

    public static String createDocument() throws IOException {

        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(BASE_URL+DOCUMENT_RESOURCE+URL_PATH_SEPARATOR);

            // Add HTTP headers to HTTP request
            httpPost.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);
            httpPost.addHeader(HTTP_HEADER_CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);

            // Create JSON body required by POST document API call
            JSONObject jsonBody = new JSONObject();
            try {
                jsonBody.put("content", "book");
                jsonBody.put("author","chetan bhagat");
                jsonBody.put("title","5 point someone");
                jsonBody.put("topic","story");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(IOUtils.toInputStream(jsonBody.toString()));
            httpPost.setEntity(basicHttpEntity);

            // Make a POST HTTP call
            response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            InputStream responseStream = response.getEntity().getContent();

            if (responseStream != null) {
                responseContent = IOUtils.toString(responseStream);
                System.out.println("Response Content : " + responseContent);
            }
            System.out.println("Response Status: " + response.getStatusLine());
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return responseContent;
    }

    public static String fetchDocument() throws IOException {

        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpGet httpGet = new HttpGet(BASE_URL+DOCUMENT_RESOURCE+URL_PATH_SEPARATOR+"1");
            httpGet.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);

            // Make a GET request to the web service
            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            InputStream responseStream = response.getEntity().getContent();

            if (responseStream != null) {
                responseContent = IOUtils.toString(responseStream);
                System.out.println("Response Content : " + responseContent);
            }
            System.out.println("Response Status: " + response.getStatusLine());
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return responseContent;
    }

    public static String updateDocument() throws IOException {
        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpPut httpPut = new HttpPut(BASE_URL+DOCUMENT_RESOURCE+URL_PATH_SEPARATOR + "1");

            // Add HTTP headers to HTTP request
            httpPut.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);
            httpPut.addHeader(HTTP_HEADER_CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);

            // Create JSON body required by POST document API call
            JSONObject jsonBody = new JSONObject();
            try {
                jsonBody.put("author","CHETAN BHAGAT");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(IOUtils.toInputStream(jsonBody.toString()));
            httpPut.setEntity(basicHttpEntity);

            // Make a PUT HTTP call
            response = httpClient.execute(httpPut);

            HttpEntity entity = response.getEntity();
            InputStream responseStream = response.getEntity().getContent();

            if (responseStream != null) {
                responseContent = IOUtils.toString(responseStream);
                System.out.println("Response Content : " + responseContent);
            }
            System.out.println("Response Status: " + response.getStatusLine());
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return responseContent;
    }

    public static String deleteDocument() throws IOException {
        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpDelete httpDelete = new HttpDelete(BASE_URL+DOCUMENT_RESOURCE+URL_PATH_SEPARATOR+"1");
            httpDelete.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);

            // Make a DELETE request to the web service
            response = httpClient.execute(httpDelete);

            HttpEntity entity = response.getEntity();
            InputStream responseStream = response.getEntity().getContent();

            if (responseStream != null) {
                responseContent = IOUtils.toString(responseStream);
                System.out.println("Response Content : " + responseContent);
            }
            System.out.println("Response Status: " + response.getStatusLine());
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return responseContent;
    }

    /**
     * Returns an instance of Apache's ClosableHttpClient.
     *
    private static CloseableHttpClient getHttpClient(){
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        return closeableHttpClient;
    }
*/
}

