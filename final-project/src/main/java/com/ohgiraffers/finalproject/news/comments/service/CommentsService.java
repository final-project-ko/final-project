package com.ohgiraffers.finalproject.news.comments.service;

import com.ohgiraffers.finalproject.news.comments.dto.CommentsDTO;
import com.ohgiraffers.finalproject.news.comments.entity.CommentRequest;
import com.ohgiraffers.finalproject.news.comments.entity.Comments;
import com.ohgiraffers.finalproject.news.comments.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public Comments registComment(HashMap<String, String> comment) {
        System.out.println("email은????????????"+comment.get("email"));

        Comments registComment = new Comments();
        registComment.setNewsCode(Integer.parseInt(comment.get("newsCode")));
        registComment.setUserId(comment.get("userId"));
        registComment.setEmail(comment.get("email"));
        registComment.setContent(comment.get("content"));
        registComment.setDate(LocalDate.now());
        registComment.setStatus("Y");
        registComment.setNotify(0);

        Comments resultRegistComment = commentsRepository.save(registComment);

        return resultRegistComment;
    }

    public List<CommentsDTO> findComments(Integer newsCode) {
        return commentsRepository.findByNewsCode(newsCode)
                .stream()
                .map(comments -> {
                    CommentsDTO commentsDTO = new CommentsDTO();
                    commentsDTO.setCommentCode(comments.getCommentCode());
                    commentsDTO.setNewsCode(comments.getNewsCode());
                    commentsDTO.setUserId(comments.getUserId());
                    commentsDTO.setEmail(comments.getEmail());

                    // 조건에 따라 content 설정
                    if ("Y".equals(comments.getStatus())) {
                        commentsDTO.setContent(comments.getContent());
                    } else if ("N".equals(comments.getStatus())) {
                        commentsDTO.setContent("작성자에 의해 삭제된 댓글입니다.");
                    } else if ("B".equals(comments.getStatus())) {
                        commentsDTO.setContent("다수의 신고에 의해 블라인드 처리된 댓글입니다.");
                    }

                    commentsDTO.setDate(comments.getDate());
                    commentsDTO.setStatus(comments.getStatus());
                    commentsDTO.setNotify(comments.getNotify());

                    return commentsDTO;
                })
                .toList();
    }

    public List<CommentsDTO> findTodayComments(LocalDate today) {

        return commentsRepository.findByDate(LocalDate.now())
                .stream()
                .map(comments -> {
                    CommentsDTO commentsDTO = new CommentsDTO();
                    commentsDTO.setCommentCode(comments.getCommentCode());
                    commentsDTO.setNewsCode(comments.getNewsCode());
                    commentsDTO.setEmail(comments.getEmail());
                    commentsDTO.setContent(comments.getContent());
                    commentsDTO.setDate(comments.getDate());
                    return commentsDTO;
                }).toList();
    }

    public List<CommentsDTO> findAllComments() {

        return commentsRepository.findAll()
                .stream()
                .map(comments -> {
                    CommentsDTO commentsDTO = new CommentsDTO();
                    commentsDTO.setCommentCode(comments.getCommentCode());
                    commentsDTO.setNewsCode(comments.getNewsCode());
                    commentsDTO.setEmail(comments.getEmail());
                    commentsDTO.setContent(comments.getContent());
                    commentsDTO.setDate(comments.getDate());
                    commentsDTO.setNotify(comments.getNotify());
                    return commentsDTO;
                }).toList();
    }




}
