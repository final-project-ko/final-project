package com.ohgiraffers.finalproject.scheduler;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ohgiraffers.finalproject.scheduler.article.Article;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ScheduleConfiguration {

    /*요청 api 목록 정의

newsapi  -  미국 7가지 카테고리 뉴스

https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=b2f485cd2f274a5ba62325da31653420


newsapi  - 한국 7가지 카테고리 뉴스

https://newsapi.org/v2/top-headlines?country=kr&category=business&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=kr&category=entertainment&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=kr&category=general&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=kr&category=health&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=kr&category=science&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=kr&category=sports&apiKey=b2f485cd2f274a5ba62325da31653420

https://newsapi.org/v2/top-headlines?country=kr&category=technology&apiKey=b2f485cd2f274a5ba62325da31653420

*/


   /* 지금 테스트로 1분에 한번씩 실행되게 해놨습니다. 테스트 실행 후 서버 꺼주셔야 api 요청 낭비가 되지 않아요 아니면
   *    cron 을 늘려주시면 더 천천히 실행 됩니다.
   * */
    @Scheduled(cron ="0 0/5 * * * ?")
    public void apiStart(){

        HashMap<String,Object> result = new HashMap<String,Object>();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        // 요청 url - 위 주석에 종류 적어놓음
        UriComponents uri = UriComponentsBuilder.fromHttpUrl("https://newsapi.org/v2/top-headlines?country=kr&apiKey=b2f485cd2f274a5ba62325da31653420").build();

        ResponseEntity<String> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);

        result.put("stateCode", resultMap.getStatusCode());
        result.put("body", resultMap.getBody());

        // api를 통해 받아온 응답을 String 으로 변환
        String jsonString = resultMap.getBody();

        // Gson 객체 생성
        Gson gson = new Gson();

        // jsonObject로 변환
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        // "articles" 키에 해당하는 JsonArray 추출
        JsonArray jsonArray = jsonObject.getAsJsonArray("articles");


        List<Article> articleList = new ArrayList<>();

        // 각 기사 추출
        for (JsonElement element: jsonArray) {
            JsonObject articleObject = element.getAsJsonObject();
            JsonElement descriptionElement = articleObject.get("description");
            JsonElement urlToImageElement = articleObject.get("urlToImage");
            // 여기서 각 article에 접근하여 필요한 작업 수행
            String title = articleObject.get("title").getAsString();
            String description = "";
            if(!descriptionElement.isJsonNull()) {
                description = articleObject.get("description").getAsString();
            }else {
                description = "null";
            }
            String url = articleObject.get("url").getAsString();
            String urlToImage = "";
            if(!descriptionElement.isJsonNull()) {
                urlToImage = articleObject.get("urlToImage").getAsString();
            }else {
                urlToImage = "null";
            }

            // 추출정보 담기
            Article article = new Article(title,description,url,urlToImage);
            System.out.println(article.getTitle());
            System.out.println(article.getDescription());
            System.out.println(article.getUrl());
            System.out.println(article.getUrlToImage());
            articleList.add(article);
        }





    }

}
