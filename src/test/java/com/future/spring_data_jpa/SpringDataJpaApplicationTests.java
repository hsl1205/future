package com.future.spring_data_jpa;

import com.future.spring_data_jpa.pdf.untemplates.PdfTemplates;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void pdfDemo() {
        PdfTemplates pdfTemplates = new PdfTemplates();
        pdfTemplates.demo();
    }

    @Test
    void useGit() {
        System.out.println("学习如何使用git");
        System.out.println("版本2");
    }
}
