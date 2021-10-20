package com.chanseok.common.file;

import com.chanseok.WyaApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WyaApplication.class)
class FileUtilTest {

    private static String fileAsltPath;

    @Value("${wya.upload.aslt_path}")
    public void setFileAsltPath(String asltPath) {
        this.fileAsltPath = asltPath;
    }

    @Test
    void application설정값을가져온다() {
        Assertions.assertThat(fileAsltPath).isEqualTo("D:/upload/");
    }

}