package com.ohgiraffers.finalproject.news.reply.repository;

import com.ohgiraffers.finalproject.news.reply.dto.ReplyDTO;
import com.ohgiraffers.finalproject.news.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {


    List<Reply> findByCommentCode(int commentCode);
}
