package com.ohgiraffers.finalproject.news.comments.service;

import com.ohgiraffers.finalproject.news.comments.dto.CommentsDTO;
import com.ohgiraffers.finalproject.news.comments.entity.CommentRequest;
import com.ohgiraffers.finalproject.news.comments.entity.Comments;
import com.ohgiraffers.finalproject.news.comments.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public Comments registComment(CommentRequest comment) {
        System.out.println("email은????????????"+comment.getEmail());

        Comments registComment = new Comments();
        registComment.setNewsCode(Integer.parseInt(comment.getNewsCode()));
        registComment.setEmail(comment.getEmail());
        registComment.setContent(comment.getContent());
        registComment.setDate(LocalDate.now());

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
                    commentsDTO.setEmail(comments.getEmail());
                    commentsDTO.setContent(comments.getContent());
                    commentsDTO.setDate(comments.getDate());

                    return commentsDTO;
                })
                .toList();
    }

    public List<CommentsDTO> findAllComments(LocalDate today) {

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
}
