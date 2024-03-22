package com.ohgiraffers.finalproject.users.bookmark.service;


import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.users.bookmark.dto.BookmarkDTO;
import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import com.ohgiraffers.finalproject.users.bookmark.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;


    public Bookmark registBookmark(BookmarkDTO bookmarkDTO) {
       /* System.out.println("북마크="+bookmarkDTO.getUserId());*/

        List<Bookmark> existingBookmark = bookmarkRepository.findByNewsCode(bookmarkDTO.getNewsCode());

        if(bookmarkDTO.getUserId() == null || bookmarkDTO.getUserId().isEmpty()){
            throw new IllegalArgumentException("사용자 ID 필요함");
        }

//         만약 동일한 newsCode가 이미 등록되어 있다면 중복 등록을 막는다.
        if (!existingBookmark.isEmpty()) {
            throw new RuntimeException("이미 등록된 북마크입니다.");
        }



        Bookmark registBookmark = new Bookmark();
        registBookmark.setBookmarkCode(bookmarkDTO.getBookmarkCode());
        registBookmark.setUserId(bookmarkDTO.getUserId());
        registBookmark.setNewsCode(bookmarkDTO.getNewsCode());
        registBookmark.setTitle(bookmarkDTO.getTitle());
        registBookmark.setDescription(bookmarkDTO.getDescription());
        registBookmark.setImage(bookmarkDTO.getImage());
        registBookmark.setUrl(bookmarkDTO.getUrl());


        Bookmark resultResgistBookmark = bookmarkRepository.save(registBookmark);

        return resultResgistBookmark;
    }

    public List<BookmarkDTO> findByBookmark(String userId) {

        return bookmarkRepository.findByUserId(userId)
                .stream()
                .map(bookmark -> {
                    BookmarkDTO bookmarkDTO = new BookmarkDTO(); // newsDTO 생성 후 news의 내용을 newDTO에 저장
                    bookmarkDTO.setNewsCode(bookmark.getNewsCode());
                    bookmarkDTO.setUserId(bookmark.getUserId());
                    bookmarkDTO.setBookmarkCode(bookmark.getBookmarkCode());
                    bookmarkDTO.setTitle(bookmark.getTitle());
                    bookmarkDTO.setDescription(bookmark.getDescription());
                    bookmarkDTO.setImage(bookmark.getImage());
                    bookmarkDTO.setUrl(bookmark.getUrl());


                    return bookmarkDTO; // newsDTO 반환
                })
                .toList(); // bookmarkRepository를 통해 모든 book 찾아서 반환
    }

    public void deleteBookmark(String userId, Integer bookmarkCode) {

        Bookmark bookmark = bookmarkRepository.findByUserIdAndBookmarkCode(userId, bookmarkCode);

        if (bookmark != null) {
            bookmarkRepository.delete(bookmark);
        } else {
            throw new NoSuchElementException("사용자의 북마크를 찾을 수 없음: " + userId + ", " + bookmarkCode);
        }
    }

    public BookmarkDTO findByUserAndArticle(String userId, int newsCode) {

        Bookmark response = bookmarkRepository.findByUserIdAndNewsCode(userId, newsCode);

        if (response != null) {
            BookmarkDTO result = new BookmarkDTO();
            result.setBookmarkCode(response.getBookmarkCode());
            result.setNewsCode(response.getNewsCode());
            result.setTitle(response.getTitle());
            result.setDescription(response.getDescription());
            result.setUrl(response.getUrl());
            result.setImage(response.getImage());
            result.setUserId(response.getUserId());

            return result;
        } else {
            return null;
        }
    }

    public Bookmark registWebBookmark(HashMap<String, String> request) {

        Bookmark registBookmark = new Bookmark();

        registBookmark.setNewsCode(Integer.parseInt(request.get("newsCode")));
        registBookmark.setTitle(request.get("newsTitle"));
        registBookmark.setDescription(request.get("newsDescription"));
        registBookmark.setUrl(request.get("newsUrl"));
        registBookmark.setImage(request.get("newsImage"));
        registBookmark.setUserId(request.get("userId"));

        Bookmark response = bookmarkRepository.save(registBookmark);

        return response;
    }

    public int deleteWebBookmark(String userId, int bookmarkCode) {

        Bookmark selectedBookmark = bookmarkRepository.findByUserIdAndBookmarkCode(userId, bookmarkCode);
        /*System.out.println("selectedBookmark : " + selectedBookmark.toString());*/

        if (selectedBookmark != null) {
            bookmarkRepository.delete(selectedBookmark);
            return 1;
        } else {
            throw new NoSuchElementException("사용자의 북마크를 찾을 수 없음: " + userId + ", " + bookmarkCode);
        }
    }

    public List<HashMap<String,String>> findByWebBookmark(String userId) {

        return bookmarkRepository.findByUserId(userId)
                .stream()
                .map(bookmark -> {
                    HashMap<String,String> bookmarkDTO = new HashMap<>(); // newsDTO 생성 후 news의 내용을 newDTO에 저장
                    bookmarkDTO.put("code",String.valueOf(bookmark.getNewsCode()));
                    bookmarkDTO.put("userid",bookmark.getUserId());
                    bookmarkDTO.put("bookMarkCode",String.valueOf(bookmark.getBookmarkCode()));
                    bookmarkDTO.put("title",bookmark.getTitle());
                    bookmarkDTO.put("description",bookmark.getDescription());
                    bookmarkDTO.put("image",bookmark.getImage());
                    bookmarkDTO.put("url",bookmark.getUrl());


                    return bookmarkDTO; // newsDTO 반환
                })
                .toList(); // bookmarkRepository를 통해 모든 book 찾아서 반환
    }

}
