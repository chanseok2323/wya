package com.chanseok.common.file;

import com.chanseok.common.file.vo.FileVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class FileUtil {

    private static Random generator = new Random();
    private static final String fileIdSym = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM";

    private static final int BUFF_SIZE = 2048;
    private static final String separatorFileSlash = "/";
    private static final String separatorFileDot = ".";
    private static String fileRelPath;
    private static String fileAsltPath;

    private static Log logger = LogFactory.getLog(FileUtil.class);

    @Value("${wya.upload.aslt_path}")
    public void setFileAsltPath(String asltPath) {
        this.fileAsltPath = asltPath;
    }

    @Value("${wya.upload.rel_path}")
    public void setFileRelPath(String relPath) {
        this.fileRelPath = relPath;
    }

    public FileVO fileSave(MultipartFile file, String pathKey, String fileNm) {
        String originalFilename = file.getOriginalFilename();
        String fileName = getFileId();

        int index = originalFilename.lastIndexOf(separatorFileDot);
        String fileExt = originalFilename.substring(index + 1);

        String asltFilePath = fileAsltPath + pathKey + separatorFileSlash;
        String rltvPath = fileRelPath + pathKey + separatorFileSlash;

        asltFilePath = asltFilePath + getTimeStamp() + separatorFileSlash;
        rltvPath = rltvPath + getTimeStamp() + separatorFileSlash;

        File saveFolder = new File(asltFilePath);
        if(!saveFolder.exists() || saveFolder.isFile()) saveFolder.mkdir();

        FileVO fvo = new FileVO();
        fvo.setAbsPath(asltFilePath);
        fvo.setExtNm(fileExt);
        fvo.setFileId(fileNm);
        fvo.setRelPath(rltvPath);
        fvo.setSaveNm(fileName);
        fvo.setRealNm(originalFilename);

        fileWrite(fvo, file);

        return fvo;
     }

    private String getTimeStamp() {
        String pattern = "yyyyMMdd";

        SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
        Timestamp ts = new Timestamp(System.currentTimeMillis());

        return sdfCurrent.format(ts.getTime());
    }

    private static String getFileId() {
        String randomFileId = "";

        for(int i=0; i < 10; i++) {
            randomFileId = randomFileId + fileIdSym.charAt(generator.nextInt(fileIdSym.length()));
        }

        return System.currentTimeMillis() + randomFileId;
    }

    private static void fileWrite(FileVO fvo, MultipartFile file) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int bytesRead = 0;

        try {
            inputStream = file.getInputStream();
            File newFile = new File(fvo.getAbsPath());
            if(!newFile.isDirectory()) newFile.mkdir();

            outputStream = new FileOutputStream(fvo.getAbsPath() + File.separator + fvo.getSaveNm() + separatorFileDot + fvo.getExtNm());
            byte[] buffer = new byte[BUFF_SIZE];

            while ((bytesRead = inputStream.read(buffer, 0, BUFF_SIZE)) != -1) {
                outputStream.write(buffer, 0 ,bytesRead);
            }
        } catch (Exception e) {
            logger.info(e);
        } finally {
            close(inputStream);
            close(outputStream);
        }
    }

    private static void close(Closeable c) {
        if(c == null) return;
        try {
            c.close();
        } catch (Exception e) {
            logger.info(e);
        }
    }

}
