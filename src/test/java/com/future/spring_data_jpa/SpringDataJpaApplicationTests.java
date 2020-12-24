package com.future.spring_data_jpa;

import com.future.spring_data_jpa.pdf.untemplates.PdfTemplates;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Test
    void contextLoads() {
        //未commit的代码直接在log中undo commit
        System.out.println("未commit的代码直接在log中undo commit");
        //本地保留修改的代码（工作区）  暂存区和commit的代码回退到指定版本
        System.out.println("Mixed（默认）：它回退到某个版本，本地会保留源码，回退commit和index file信息，若要提交重新commit");
        // 暂存区代码没有回退
        System.out.println("Soft：回退到某个版本。只回退了 commit 的信息，之前写的代码还是保留的，不会恢复到 index file 一级。如果还要提交，直接 commit");
        // 直接全部代码回到某个版本
        System.out.println("Hard：彻底回退到某个版本，本地的源码也会变为上一个版本的内容");
    }

    @Test
    void pdfDemo() {
        PdfTemplates pdfTemplates = new PdfTemplates();
        pdfTemplates.demo();
    }
}
