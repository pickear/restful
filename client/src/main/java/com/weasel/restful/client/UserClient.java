package com.weasel.restful.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by dell on 2017/3/15.
 */
public class UserClient {

    private final static HttpClient httpclient = HttpClientBuilder.create().build();


    @Test
    public void getUsers(){

        HttpGet get = new HttpGet("http://127.0.0.1:8010/restful/user");
        String result = execute(get);
        System.out.println(result);
    }

    @Test
    public void getUser(){

        HttpGet get = new HttpGet("http://127.0.0.1:8010/restful/user/1");
        get.setHeader("Accept","application/json");
        get.addHeader("version","1.0");
        String result = execute(get);
        System.out.println(result);
    }

    @Test
    public void createUser(){

        HttpPost post = new HttpPost("http://127.0.0.1:8010/restful/user");
        String userJson = "{\"id\":1}";
        post.setEntity(new StringEntity(userJson, ContentType.APPLICATION_JSON));
        String result = execute(post);
        System.out.println(result);
    }

    @Test
    public void deleteUser(){

        HttpDelete delete = new HttpDelete("http://127.0.0.1:8010/restful/user/1");
        String result = execute(delete);
        System.out.println(result);
    }

    @Test
    public void updateUser(){

        HttpPut put = new HttpPut("http://127.0.0.1:8010/restful/user/1");
        String userJson = "{\"id\":1}";
        put.setEntity(new StringEntity(userJson, ContentType.APPLICATION_JSON));
        String result = execute(put);
        System.out.println(result);
    }

    @Test
    public void portionUpateUser(){

        HttpPatch path = new HttpPatch("http://127.0.0.1:8010/restful/user/1");
        String userJson = "{\"id\":1}";
        path.setEntity(new StringEntity(userJson, ContentType.APPLICATION_JSON));
        String result = execute(path);
        System.out.println(result);
    }

    private String execute(HttpUriRequest request){
        try {
            return httpclient.execute(request, new AbstractResponseHandler<String>() {
                @Override
                public String handleEntity(HttpEntity httpEntity) throws IOException {
                    return EntityUtils.toString(httpEntity);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
