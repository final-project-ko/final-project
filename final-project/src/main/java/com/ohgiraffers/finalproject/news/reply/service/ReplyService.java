package com.ohgiraffers.finalproject.news.reply.service;

import com.ohgiraffers.finalproject.news.reply.dto.ReplyDTO;
import com.ohgiraffers.finalproject.news.reply.entity.Reply;
import com.ohgiraffers.finalproject.news.reply.entity.ReplyRequest;
import com.ohgiraffers.finalproject.news.reply.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply registReply(ReplyRequest reply) {

        Reply registReply = new Reply();
        registReply.setCommentCode(Integer.parseInt(reply.getCommentCode()));
        registReply.setUserId(Integer.parseInt(reply.getUserId()));
        registReply.setEmail(reply.getEmail());
        registReply.setContent(reply.getContent());
        registReply.setDate(LocalDate.now());

        Reply resultRegistReply = replyRepository.save(registReply);

        return resultRegistReply;
    }

    public List<ReplyDTO> findReply(int commentCode) {

        return replyRepository.findByCommentCode(commentCode)
                .stream()
                .map(reply -> {
                    ReplyDTO replyDTO = new ReplyDTO();
                    replyDTO.setCommentCode(reply.getCommentCode());
                    replyDTO.setReplyCode(reply.getReplyCode());
                    replyDTO.setUserId(reply.getUserId());
                    replyDTO.setEmail(reply.getEmail());
                    replyDTO.setContent(reply.getContent());
                    replyDTO.setDate(reply.getDate());

                    return replyDTO;
                })
                .toList();
    }
}
