package com.kh.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing {

	public static void main(String[] args) {
		String serviceKey="OA%2BSL7ZlXt65YirQBc9DoC8I3C5f%2BfTs2y%2FsenvKTfOvBt5jugZylNr8jTexsSnw7S%2B7M1GhY6up4DKYkcg%2BwQ%3D%3D";
		String url="https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey="+ serviceKey +"&numOfRows=10&resultType=json";

		 try {
			URL requestUrl= new URL(url); //import java.net.URL;
			HttpURLConnection urlConnection =(HttpURLConnection) requestUrl.openConnection();
			urlConnection.setRequestMethod("GET");      // get방식 
			
			BufferedReader br= new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); // 스트림 처리 
			String line = null;
			
			
			StringBuffer responseBuffer = new StringBuffer();
			
			while((line = br.readLine()) !=null) {
				responseBuffer.append(line);
			}
			br.close();
			urlConnection.disconnect();
			
			String responseData = responseBuffer.toString();
			System.out.println(responseData);
			
			JSONObject jsonResponse = new JSONObject(responseData);
			
			JSONObject jsonData = jsonResponse.getJSONObject("getFoodKr");
			System.out.println(jsonData);
			
			JSONArray items=jsonData.getJSONArray("item"); // item이 배열로 되어있음 
			
			for(int i=0; i <items.length(); i++) {
				JSONObject result = items.getJSONObject(i);
				System.out.println(result.getString("MAIN_TITLE")); // 원하는 부분만 가져오기 
				System.out.println(result.getDouble("LNG"));		// 경도	
				System.out.println(result.getDouble("LAT")); // 위도 
				
				
			}
			
			
		} catch (Exception e) { 
			
			e.printStackTrace();
		} 
	}

}
