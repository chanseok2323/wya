package com.chanseok.common.file.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class FileVO {
    private int seq;    //일련번호
    private String fileId;  //파일아이디
    private String relPath; //상대경로
    private String absPath; //절대경로
    private String saveNm;  //저장파일명
    private String extNm;   //확장자명
    private String realNm;  //실제파일이름
    private int regNo;      //등록자
    private LocalDateTime regDt;  //등록일시
}
