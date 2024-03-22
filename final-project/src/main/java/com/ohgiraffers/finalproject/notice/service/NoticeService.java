package com.ohgiraffers.finalproject.notice.service;

import com.ohgiraffers.finalproject.notice.dto.NoticeDTO;
import com.ohgiraffers.finalproject.notice.entity.Notice;
import com.ohgiraffers.finalproject.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice insertNotice(HashMap<String, String> notice) {

        Notice insertNotice = new Notice();
        insertNotice.setTitle(notice.get("title"));
        insertNotice.setContent(notice.get("values"));
        insertNotice.setDate(LocalDate.now());

        Notice insert = noticeRepository.save(insertNotice);

        return insert;
    }

    public List<NoticeDTO> findInputNotice(String inputText) {

            return noticeRepository.findAll()
                    .stream()
                    .filter(notice -> notice.getTitle().contains(inputText) || notice.getContent().contains(inputText))
                    .map(notice -> {
                        NoticeDTO noticeDTO = new NoticeDTO();
                        noticeDTO.setNotice_num(notice.getNum());
                        noticeDTO.setNotice_title(notice.getTitle());
                        noticeDTO.setNotice_content(notice.getContent());
                        noticeDTO.setNotice_date(notice.getDate());
                        return noticeDTO;
                    }).toList();
    }

    public List<NoticeDTO> findAllNotice() {

        return noticeRepository.findAll()
                .stream()
                .filter(notice -> !notice.getTitle().isEmpty() && !notice.getContent().isEmpty() && notice.getTitle().length()>5)
                .map(notice -> {
                    NoticeDTO noticeDTO = new NoticeDTO();
                    noticeDTO.setNotice_num(notice.getNum());
                    noticeDTO.setNotice_title(notice.getTitle());
                    noticeDTO.setNotice_content(notice.getContent());
                    noticeDTO.setNotice_date(notice.getDate());


                    return noticeDTO;
                }).toList();
    }

    public Notice modifyNotice(HashMap<String, String> notice) {

        Notice modifyNotice = new Notice();
        modifyNotice.setNum(Integer.parseInt(notice.get("num")));
        modifyNotice.setTitle(notice.get("title"));
        modifyNotice.setContent(notice.get("content"));
        modifyNotice.setDate(LocalDate.now());

        Notice modify = noticeRepository.save(modifyNotice);
        return modify;
    }

    public Notice deleteNotice(HashMap<String, String> notice) {

        Notice deleteNotice = new Notice();
        /*System.out.println(notice.get("num"));*/
        deleteNotice.setNum(Integer.parseInt(notice.get("num")));
        deleteNotice.setTitle("지워짐");
        deleteNotice.setContent(notice.get("content"));
        deleteNotice.setDate(LocalDate.now());
        Notice delete = noticeRepository.save(deleteNotice);
        return delete;
    }


}
