package com.ohgiraffers.finalproject.users.bookmark.repository;


import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {


}
