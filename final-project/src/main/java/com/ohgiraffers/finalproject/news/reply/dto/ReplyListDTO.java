package com.ohgiraffers.finalproject.news.reply.dto;

import java.util.List;

public class ReplyListDTO {

    private List<ReplyDTO> replys;

    public ReplyListDTO() {
    }

    public ReplyListDTO(List<ReplyDTO> replys) {
        this.replys = replys;
    }

    public List<ReplyDTO> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplyDTO> replys) {
        this.replys = replys;
    }

    @Override
    public String toString() {
        return "ReplyListDTO{" +
                "replys=" + replys +
                '}';
    }
}
