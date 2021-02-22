package com.future.spring_data_jpa.test;


/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :  MoneyEnum
 * 功能概要  :  测试enum
 * 创建时间  :  2020/12/30 14:39
 * 创建人    : huangsl
 */
public enum MoneyEnum {

    ONE(1,"一元","三潭印月，杭州西湖十景之一，位于西湖中部偏南，与湖心亭、阮公墩鼎足而立合称“湖中三岛”，犹如中国古代传说中的蓬莱三岛，故又称小瀛洲"),
    FIVE(5,"五元","泰山又名岱山、岱宗、岱岳、东岳、泰岳，位于山东省中部，隶属于泰安市，绵亘于泰安、济南、淄博三市之间，总面积24200公顷。主峰玉皇顶海拔1545米，气势雄伟磅礴，有“五岳之首”、“五岳之长”、五岳之尊、“天下第一山”之称"),
    TEN(1,"一元","夔门，在瞿塘峡入口处是长江三峡的西大门，又名“瞿塘关”，在巍峨壮丽的白帝城下，是出入四川盆地的门户。从白帝城向东，便进入长江三峡中最西面的瞿塘峡，全长约8公里，在三峡中最短，却最为雄伟险峻"),
    TWENTY(1,"一元","桂林是世界著名的风景游览城市，漓江水清澈秀丽，有着举世无双的喀斯特地貌。“山青、水秀、洞奇、石美”是桂林“四绝”"),
    FIFTY(1,"一元","布达拉宫始建于公元7世纪，是藏王松赞干布为远嫁西藏的唐朝文成公主而建。在拉萨海拔3700多米的红山上建造了999间房屋的宫宇。宫体主楼13层，高115米"),
    ONE_HUNDRED(1,"一元","人民大会堂为建国10周年首都十大建筑之一，也是北京的地标性建筑。它由1958年10月动工，1959年9月建成，仅用了10个多月的时间就建成了，创造了中国建筑史上的一大创举。它位于北京市中心、天安门广场西侧，西长安街南侧");

    private int code;

    private String values;

    private String description;

    MoneyEnum(int code, String values, String description) {
        this.code = code;
        this.values = values;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
