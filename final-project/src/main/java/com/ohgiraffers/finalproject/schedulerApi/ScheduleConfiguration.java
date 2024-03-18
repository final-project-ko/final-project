package com.ohgiraffers.finalproject.schedulerApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ohgiraffers.finalproject.schedulerApi.article.Article;
import com.ohgiraffers.finalproject.schedulerApi.service.APIService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${us_total}")
    private String us_total;
    @Value("${us_business}")
    private String us_business;
    @Value("${us_entertainment}")
    private String us_entertainment;
    @Value("${us_general}")
    private String us_general;
    @Value("${us_health}")
    private String us_health;
    @Value("${us_science}")
    private String us_science;
    @Value("${us_sports}")
    private String us_sports;
    @Value("${us_technology}")
    private String us_technology;
    @Value("${kr_total}")
    private String kr_total;
    @Value("${kr_business}")
    private String kr_business;
    @Value("${kr_entertainment}")
    private String kr_entertainment;
    @Value("${kr_general}")
    private String kr_general;
    @Value("${kr_health}")
    private String kr_health;
    @Value("${kr_science}")
    private String kr_science;
    @Value("${kr_sports}")
    private String kr_sports;
    @Value("${kr_technology}")
    private String kr_technology;




    // 국내 헤드 라인 기사 받아 오는 메소드 - 국내 기사 메인 페이지

<<<<<<< HEAD
   @Scheduled(cron ="0 6 17 * * ?")
=======
   @Scheduled(cron ="0 40 8 * * ?")
>>>>>>> c9a88d25d9039370ae9eea032101b8041f52b750
   public void headLines(){
       String[] apiName = new String[]{kr_total,kr_business,kr_entertainment,kr_general,kr_health,kr_science,kr_sports,kr_technology,us_total,us_business,us_entertainment,us_general,us_health,us_science,us_sports,us_technology,};
       String[] apiNames = new String[]{"kr_total","kr_business","kr_entertainment","kr_general","kr_health","kr_science","kr_sports","kr_technology","us_total","us_business","us_entertainment","us_general","us_health","us_science","us_sports","us_technology"};

       for (int i = 0; i < apiName.length; i++) {
           UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiName[i]).build();
           List<Article> headLine = apiStart(uri);
           Object result = apiService.headLine(headLine,apiNames[i]);
       }

   }




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
            if(!urlToImageElement.isJsonNull()) {
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
