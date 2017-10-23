package com.ntc.gaia.base.utils.tools;

/**
 * Created by guominchuxing on 2017/9/4.
 */
public class WinUtil {
    //湖州景区数组
    public static final String[] scenes = {"莫干山景区","南浔古镇","中南百草原","安吉竹博园","浙北大峡谷","安吉黄浦江源漂流","江南天池",
            "太湖旅游度假区","仙山湖风景区","中国扬子鳄村","新四军苏浙军区纪念馆","金钉子远古世界景区","菰城景区","安吉春山收藏馆"};
    public static final String[] scenes2 = {"南浔古镇","江南天池","中南百草原","安吉竹博园","浙北大峡谷","安吉漂流","莫干山景区",
            "太湖度假区","仙山湖","扬子鳄村","金钉子景区","菰城景区","春山收藏馆"};


    //集散中心大巴车发车状态数组
    public static final String[] status = {"未发车","已发车"};

    //游客乘坐各种交通工具比例的数组 rate1中产生1个，rate2、rate3分别产生2个
  //  passagePublicCarRate,passageDabaRate,passageTaxiRate,passageRentalCarRate,passageOtherCarRate
    public static final float[]  rate1= {30.5F,31.6F,32.8F,33.3F,34.5F,35.7F,36.8F,37.5F,38.3F,39.5F};
    public static final float[]  rate2= {20.1F,21.5F,22.6F,23.8F,24.5F,25.6F,26.7F,27.5F,28.8F,29.3F};
    public static final float[]  rate3= {10.3F,11.5F,12.5F,13.3F,14.5F,15.8F,16.1F,17.5F,18.3F,19.5F};
    public static final float[]  rate4= {1.3F,2.5F,3.5F,4.3F,5.5F,6.8F,7.1F,8.5F,8.3F,9.8F};
    public static final float[]  rate= {40.5F,40.8F,41.5F,42.0F,42.5F,42.8F,43.3F,43.5F,44.5F,45.3F};
    //游客到港人次数据
    public static final int[]  passagerCount= {800,810,815,825,830,835,850,860,865,880,
            900,950,980,1000,1250,1350,1500,1650,1700,1800 };

    //客流分类数组
    public static final String[]  carType= {"公交","出租","客运"};

    //到港车次
    public static final int[]  CarCount= {300,332,335,338,345,356,365,380,400,415,
            420,435,450,468,460,465,480,485,495,500};

    //游客到景区或酒店的趋势人数
    public static final int[]  passagerCount2= {
            200,215,220,235,268,320,330,345,360,380,
            420,480,500,650,660,800,880,960,1000,1200,
            1230,1250,1260,1280,1300,1310,1320,1330,1340,1350};

    //交通工具装载人次数据
    public static final int[]  passagerCount3= {
            200,303,205,506,208,410,211,313,515,216,
            318,220,623,525,326,428,230,733,635,536,
            850,860,880,1200,1100,1150,1130,960,1000,1150,
            230,560,680,385,512,425,365,388,428,650,
            300,320,565,520,408,710,611,310,535,226,};

    //景区负载状态
    public static final String[]  loadStatus= {"未饱和","基本饱和","饱和","超负荷"};

    //TotalDate校正数组
    public static final Integer[]  revise= {-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};



}
