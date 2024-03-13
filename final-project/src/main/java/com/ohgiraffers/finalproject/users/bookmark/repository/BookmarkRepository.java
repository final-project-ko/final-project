package com.ohgiraffers.finalproject.users.bookmark.repository;


import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

    List<Bookmark> findByUserId(String userId);

    List<Bookmark> findByNewsCode(Integer newsCode);
}
