package com.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("hello.do")
	public void hello() {
	}

	// http://localhost:8280/resteasy/rest/message/aaa
	// http://localhost:8280/resteasy/rest/userservice/users
	@RequestMapping("client2.do")
	public void restclient(HttpServletResponse hresponse) throws Exception {
		ClientRequest request = new ClientRequest(
				"http://localhost:38080/resteasy/rest/userservice/users");
		request.accept("application/json");
		ClientResponse<String> response = request.get(String.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(response.getEntity().getBytes())));

		String output;
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			hresponse.getWriter().write("rest response : " + output);
		}
	}
	@RequestMapping("client.do")
	public void xxx(HttpServletResponse hresponse) throws Exception{
		 URL restServiceURL = new URL("http://localhost:38080/resteasy/rest/userservice/user/trans/tingyun");

         HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
         httpConnection.setRequestMethod("GET");
         httpConnection.setRequestProperty("Accept", "application/json");

         if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                              + httpConnection.getResponseCode());
         }

         BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                (httpConnection.getInputStream())));

         String output;
     
         while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
    			hresponse.getWriter().write("rest response : " + output);

         }

         httpConnection.disconnect();

    

  
}
}

