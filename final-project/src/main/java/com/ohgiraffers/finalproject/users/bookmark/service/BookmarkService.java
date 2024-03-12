package com.ohgiraffers.finalproject.users.bookmark.service;


import com.ohgiraffers.finalproject.users.bookmark.dto.BookmarkDTO;
import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import com.ohgiraffers.finalproject.users.bookmark.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;


    public Bookmark registBookmark(BookmarkDTO bookmarkDTO) {
        System.out.println("북마크="+bookmarkDTO.getEmail());

        Bookmark registBookmark = new Bookmark();
        registBookmark.setBookmarkCode(bookmarkDTO.getBookmarkCode());
        registBookmark.setEmail(bookmarkDTO.getEmail());
        registBookmark.setNewsCode(bookmarkDTO.getNewsCode());


        Bookmark resultResgistBookmark = bookmarkRepository.save(registBookmark);

        return resultResgistBookmark;
    }
}
