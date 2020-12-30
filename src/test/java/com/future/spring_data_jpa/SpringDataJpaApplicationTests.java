package com.future.spring_data_jpa;

import com.future.spring_data_jpa.pdf.untemplates.PdfTemplates;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
@Slf4j
class SpringDataJpaApplicationTests {

    @Test
    void contextLoads() {
        //未commit的代码直接在log中undo commit 或直接mixed
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

    /***
     * @Description
     * 吸血鬼数字
     * @return {@link }
     * @Date 2020/12/28 14:42
     * @Author huangsl
     */
    @Test
    public void xxgNum() {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=10; i<100; i++) {
            for (int j=10; j<100; j++) {
                if(i%10 == 0 && j%10 == 0){
                    continue;
                }
                String[] a = String.valueOf(i+""+j).split("");
                String[] b = String.valueOf(i*j).split("");
                Arrays.sort(a);
                Arrays.sort(b);
                if(Arrays.equals(a,b)){
                    set.add(i*j);
                }
            }
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
