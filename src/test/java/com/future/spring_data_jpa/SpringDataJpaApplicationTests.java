package com.future.spring_data_jpa;

import com.future.spring_data_jpa.pdf.untemplates.PdfTemplates;
import com.future.spring_data_jpa.user.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

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

    @Test
    public void demo1() {
        String path = ClassLoader.getSystemResource("static/test").getPath();
        File file = new File(path);
        File[] files = file.listFiles();
        if(files != null) {
            for (File file1 : files) {
                System.out.println(file1);
            }
        }
    }

    /***
     * @Description
     *一行一行读取
     * @return {@link }
     * @Date 2021/1/29 15:42
     * @Author huangsl
     */
    @Test
    public void demo2() throws Exception {
        //转成url后中文就可以识别了
        String path = ClassLoader.getSystemResource("static/test/测试.txt").toURI().getPath();
        try(FileReader fr = new FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            while ((str= br.readLine())!= null) {
                System.out.println(str);
            }
        }
    }

    /***
     * @Description 文件复制
     * @return {@link }
     * @Date 2021/1/29 15:42
     * @Author huangsl
     */
    @Test
    public void copyFile() throws Exception {
        String inputPath = ClassLoader.getSystemResource("static/test/测试.txt").toURI().getPath();
        File source = new File(inputPath);
        File destDir = new File("E:\\test");
        File dest = new File("E:\\test\\测试.txt");
        //上级目录必须存在
        if(!(destDir.exists() && destDir.isDirectory())){
            destDir.mkdirs();
        }
        try {
            Files.copy(source.toPath(),dest.toPath());
            System.out.println("文件复制成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /***
     * @Description
     *Files读取纯文本内容
     * @return {@link }
     * @Date 2021/2/1 11:11
     * @Author huangsl
     */
    @Test
    public void demo4() throws IOException {
        List<String> str = Files.readAllLines(Paths.get("E:\\test\\测试.txt"));
        for (String s : str) {
            System.out.println(s);
        }
    }

    @Test
    public void demo5() {
        int[] arr = {1,100,214,14425,3356,414,2536,67,6876};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void demo6() {
        ArrayList<UserInfo> list = new ArrayList<>();
        for (int i =0; i<10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId("1");
            userInfo.setAddress("beijing");
            list.add(userInfo);
        }
        list.forEach(userInfo -> System.out.println(userInfo.toString()));
    }

    @Test
    public void demo7() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == nums[i++]) {

            }
        }
    }
}
