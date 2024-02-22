package com.ohgiraffers.finalproject.schedulerApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ohgiraffers.finalproject.schedulerApi.article.Article;
import com.ohgiraffers.finalproject.schedulerApi.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private APIService apiService;

    /*요청 api 목록 정의

newsapi  -  미국 7가지 카테고리 뉴스

https://newsapi.org/v2/top-headlines?country=us&apiKey=b2f485cd2f274a5ba62325da31653420  -- 종합 헤드라인 us_total

https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=b2f485cd2f274a5ba62325da31653420  --us_business

https://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=b2f485cd2f274a5ba62325da31653420 --us_entertainment

https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=b2f485cd2f274a5ba62325da31653420 --us_general

https://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=b2f485cd2f274a5ba62325da31653420 --us_health

https://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=b2f485cd2f274a5ba62325da31653420 --us_science

https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=b2f485cd2f274a5ba62325da31653420 --us_sports

https://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=b2f485cd2f274a5ba62325da31653420 --us_technology


newsapi  - 한국 7가지 카테고리 뉴스

https://newsapi.org/v2/top-headlines?country=kr&apiKey=b2f485cd2f274a5ba62325da31653420 -- 종합 헤드라인  kr_total

https://newsapi.org/v2/top-headlines?country=kr&category=business&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_business

https://newsapi.org/v2/top-headlines?country=kr&category=entertainment&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_entertainment

https://newsapi.org/v2/top-headlines?country=kr&category=general&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_general

https://newsapi.org/v2/top-headlines?country=kr&category=health&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_health

https://newsapi.org/v2/top-headlines?country=kr&category=science&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_science

https://newsapi.org/v2/top-headlines?country=kr&category=sports&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_sports

https://newsapi.org/v2/top-headlines?country=kr&category=technology&apiKey=b2f485cd2f274a5ba62325da31653420 --kr_technology

*/


   /* 지금 테스트로 1분에 한번씩 실행되게 해놨습니다. 테스트 실행 후 서버 꺼주셔야 api 요청 낭비가 되지 않아요 아니면
   *    cron 을 늘려주시면 더 천천히 실행 됩니다.
   * */


    // 국내 헤드 라인 기사 받아 오는 메소드 - 국내 기사 메인 페이지
   @Scheduled(cron ="0 0 5 * * ?")
   public void krHeadLines(){
       UriComponents uri = UriComponentsBuilder.fromHttpUrl("https://newsapi.org/v2/top-headlines?country=kr&apiKey=b2f485cd2f274a5ba62325da31653420").build();
       List<Article> krHeadLine = apiStart(uri);
       Object result = apiService.krHeadLine(krHeadLine);
   }

   // 해외 헤드 라인 기사 받아 오는 메소드 - 해외 기사 메인 페이지
/*    @Scheduled(cron ="0 0/5 * * * ?")
    public void usHeadLines(){
        UriComponents uri = UriComponentsBuilder.fromHttpUrl("https://newsapi.org/v2/top-headlines?country=us&apiKey=b2f485cd2f274a5ba62325da31653420").build();
        List<Article> usHeadLine = apiStart(uri);
        Integer result = apiService.usHeadLines(usHeadLine);
    }*/



    public List<Article> apiStart(UriComponents uri){

        HashMap<String,Object> result = new HashMap<String,Object>();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);


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
            articleList.add(article);

        }


        return articleList;

    }

}
