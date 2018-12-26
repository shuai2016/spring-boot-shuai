package com.shuai.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shuai.util.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * JsonController
 *
 * @author shuai
 * @date 2018/12/26
 */
@RestController
@RequestMapping("json")
public class JsonController {
    @GetMapping("getJson")
    public Object getJson() throws IOException {
        String filePath = "E:\\myFile\\area.json";
        String jsonContent = FileUtil.ReadFile(filePath);
        System.out.println(jsonContent);

        Object object = JSONObject.parse(jsonContent);
        Map<String, Object> map = (Map<String, Object>) object;
        System.out.println(object);
        List<Object> list = (List<Object>) map.get("list");
        System.out.println(list);
        for (Object o : list) {
            Set<Map.Entry<String, Object>> entries = ((Map<String, Object>) o).entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                System.out.println(key);
                List<Map<String, Object>> list1 = (List<Map<String, Object>>) entry.getValue();
                for (Map<String, Object> map1 : list1) {
                    System.out.println("id : " + map1.get("id") + ",title : " + map1.get("title"));
                }
            }
        }

        return "getJson";
    }

    @GetMapping("setJson")
    public Object setJson() throws IOException {

        /*------------------溯源信息----------------------*/
        List<Object> list = new ArrayList<>();

        /*------------------产品信息----------------------*/

        Map<String, Object> product = new HashMap<>();
        list.add(product);

        List<Object> productData = new ArrayList<>();
        product.put("title", "产品信息");
        product.put("data", productData);

        /*------------------产品基本信息----------------------*/
        Map<String, Object> basic = new HashMap<>();
        productData.add(basic);

        List<Map<String, Object>> essential = new ArrayList<>();
        basic.put("title", "产品基本信息");
        basic.put("type", 1);
        basic.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        basic.put("data", essential);

        Map<String, Object> m1 = new HashMap<>();
        m1.put("name", "产品名称");
        m1.put("value", "佳士淳总裁机");
        essential.add(m1);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("name", "额定电压/频率");
        m2.put("value", "AC-100~240V/60Hz.50Hz");
        essential.add(m2);

        Map<String, Object> m3 = new HashMap<>();
        m3.put("name", "最大AC电流");
        m3.put("value", "1.5A");
        essential.add(m3);

        Map<String, Object> m4 = new HashMap<>();
        m4.put("name", "最大DC电流");
        m4.put("value", "2.5A");
        essential.add(m4);

        Map<String, Object> m5 = new HashMap<>();
        m5.put("name", "外观尺寸");
        m5.put("value", "92(W)*260(H)*120(D)mm");
        essential.add(m5);

        Map<String, Object> m6 = new HashMap<>();
        m6.put("name", "氧化还原单位");
        m6.put("value", "还原水最高可达-200MV以下");
        essential.add(m6);

        Map<String, Object> m7 = new HashMap<>();
        m7.put("name", "进水水质");
        m7.put("value", "20~40ppm RO水及经过处理之软水");
        essential.add(m7);

        Map<String, Object> m8 = new HashMap<>();
        m8.put("name", "启动流速");
        m8.put("value", "0.8L/MIN");
        essential.add(m8);

        Map<String, Object> m9 = new HashMap<>();
        m9.put("name", "净流水量");
        m9.put("value", "1.0~2.0L/MIN");
        essential.add(m9);

        Map<String, Object> m10 = new HashMap<>();
        m10.put("name", "净水压力");
        m10.put("value", "0.5~2kg/cm");
        essential.add(m10);

        Map<String, Object> m11 = new HashMap<>();
        m11.put("name", "消耗功率");
        m11.put("value", "Max 75W");
        essential.add(m11);

        Map<String, Object> m12 = new HashMap<>();
        m12.put("name", "滤芯最大进水量");
        m12.put("value", "6000L");
        essential.add(m12);

        /*------------------产品认证信息----------------------*/
        Map<String, Object> authentication = new HashMap<>();
        productData.add(authentication);

        List<Map<String, Object>> authenticationData = new ArrayList<>();
        authentication.put("title", "产品认证信息");
        authentication.put("type", 2);
        authentication.put("data", authenticationData);

        Map<String, Object> m13 = new HashMap<>();
        m13.put("name", "SGS质量体系认证");
        m13.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authenticationData.add(m13);

        Map<String, Object> m14 = new HashMap<>();
        m14.put("name", "CTI华检测认证");
        m14.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authenticationData.add(m14);

        Map<String, Object> m15 = new HashMap<>();
        m15.put("name", "iLac-MRA认证");
        m15.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authenticationData.add(m15);

        Map<String, Object> m16 = new HashMap<>();
        m16.put("name", "CNAS认证");
        m16.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authenticationData.add(m16);

        Map<String, Object> m17 = new HashMap<>();
        m17.put("name", "富邦财险");
        m17.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authenticationData.add(m17);

        /*------------------产品批次信息----------------------*/
        Map<String, Object> batch = new HashMap<>();
        productData.add(batch);

        List<Object> batchData = new ArrayList<>();
        batch.put("title", "产品批次信息");
        batch.put("type", 3);
        batch.put("data", batchData);

        Map<String, Object> m18 = new HashMap<>();
        m18.put("name", "JD-20180001");
        m18.put("value", "");
        batchData.add(m18);
        Map<String, Object> m19 = new HashMap<>();
        m19.put("name", "JD-20180002");
        m19.put("value", "");
        batchData.add(m19);
        Map<String, Object> m20 = new HashMap<>();
        m20.put("name", "JD-20180003");
        m20.put("value", "");
        batchData.add(m20);
        Map<String, Object> m21 = new HashMap<>();
        m21.put("name", "JD-20180004");
        m21.put("value", "");
        batchData.add(m21);
        Map<String, Object> m22 = new HashMap<>();
        m22.put("name", "JD-20180005");
        m22.put("value", "");
        batchData.add(m22);
        Map<String, Object> m23 = new HashMap<>();
        m23.put("name", "JD-20180006");
        m23.put("value", "");
        batchData.add(m23);
        Map<String, Object> m24 = new HashMap<>();
        m24.put("name", "JD-20180007");
        m24.put("value", "");
        batchData.add(m24);
        Map<String, Object> m25 = new HashMap<>();
        m25.put("name", "JD-20180008");
        m25.put("value", "");
        batchData.add(m25);
        Map<String, Object> m26 = new HashMap<>();
        m26.put("name", "JD-20180009");
        m26.put("value", "");
        batchData.add(m26);
        Map<String, Object> m27 = new HashMap<>();
        m27.put("name", "JD-20180010");
        m27.put("value", "");
        batchData.add(m27);

        /*------------------企业信息----------------------*/
        Map<String, Object> enterprise = new HashMap<>();
        list.add(enterprise);

        List<Object> enterpriseData = new ArrayList<>();
        enterprise.put("title", "企业信息");
        enterprise.put("data", enterpriseData);


        /*------------------企业介绍----------------------*/
        Map<String, Object> introduction = new HashMap<>();
        enterpriseData.add(introduction);

        List<Object> introductionData = new ArrayList<>();
        introduction.put("title", "企业介绍");
        introduction.put("type", 4);
        introduction.put("data", introductionData);

        String info0 =
                "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司";
        String info1 =
                "后置信息后置信息后置信息后置信息后置信息后置信息";
        Map<String, Object> introductionMap0 = new HashMap<>();
        introductionMap0.put("name", "text");
        introductionMap0.put("value", info0);
        introductionData.add(introductionMap0);
        Map<String, Object> introductionMap1 = new HashMap<>();
        introductionMap1.put("name", "img");
        introductionMap1.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        introductionData.add(introductionMap1);
        Map<String, Object> introductionMap2 = new HashMap<>();
        introductionMap2.put("name", "text");
        introductionMap2.put("value", info1);
        introductionData.add(introductionMap2);

        /*------------------电解水功效----------------------*/
        Map<String, Object> electrolysis = new HashMap<>();
        enterpriseData.add(electrolysis);

        List<Object> electrolysisData = new ArrayList<>();
        electrolysis.put("title", "电解水功效");
        electrolysis.put("type", 5);
        electrolysis.put("data", electrolysisData);

        Map<String, Object> m28 = new HashMap<>();
        m28.put("name", "活化细胞");
        m28.put("value", "");
        electrolysisData.add(m28);
        Map<String, Object> m29 = new HashMap<>();
        m29.put("name", "调节体内酸碱平衡");
        m29.put("value", "");
        electrolysisData.add(m29);
        Map<String, Object> m30 = new HashMap<>();
        m30.put("name", "增强免疫力");
        m30.put("value", "");
        electrolysisData.add(m30);
        Map<String, Object> m31 = new HashMap<>();
        m31.put("name", "渗透力强");
        m31.put("value", "");
        electrolysisData.add(m31);
        Map<String, Object> m32 = new HashMap<>();
        m32.put("name", "改善肠胃功能及新陈代谢");
        m32.put("value", "");
        electrolysisData.add(m32);

        /*------------------查询记录----------------------*/
        Map<String, Object> query = new HashMap<>();
        list.add(query);

        List<Object> queryData = new ArrayList<>();
        query.put("title", "查询记录");
        query.put("data", queryData);

        /*------------------记录信息----------------------*/
        Map<String, Object> record = new HashMap<>();
        queryData.add(record);

        List<Object> recordData = new ArrayList<>();
        record.put("title", "记录信息");
        record.put("type", 6);
        record.put("message", "该商品已被查询5次");
        record.put("data", recordData);

        Map<String, Object> m33 = new HashMap<>();
        String s1 = "乌干达0 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品";
        m33.put("name", s1);
        m33.put("value", "");
        recordData.add(m33);
        Map<String, Object> m34 = new HashMap<>();
        String s2 = "乌干达1 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品";
        m34.put("name", s2);
        m34.put("value", "");
        recordData.add(m34);
        Map<String, Object> m35 = new HashMap<>();
        String s3 = "乌干达2 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品";
        m35.put("name", s3);
        m35.put("value", "");
        recordData.add(m35);
        Map<String, Object> m36 = new HashMap<>();
        String s4 = "乌干达3 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品";
        m36.put("name", s4);
        m36.put("value", "");
        recordData.add(m36);
        Map<String, Object> m37 = new HashMap<>();
        String s5 = "乌干达4 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品";
        m37.put("name", s5);
        m37.put("value", "");
        recordData.add(m37);
        Map<String, Object> m38 = new HashMap<>();
        String s6 = "乌干达5 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品";
        m38.put("name", s6);
        m38.put("value", "");
        recordData.add(m38);
        // 倒序排列
        Collections.reverse(recordData);

        String strData = JSON.toJSONString(list);
        System.out.println(strData);
        File file = new File("E:\\myFile\\json\\data.json");
        file.createNewFile();

        Writer writer = new FileWriter(file);
        writer.write(strData);
        writer.close();

        return list;
    }

    @GetMapping("setJson1")
    public Object setJson1() throws IOException {

        /*------------------溯源信息----------------------*/
        Map<String, Object> map = new HashMap<>();

        /*------------------产品信息----------------------*/

        Map<String, Object> product = new HashMap<>();

        map.put("product", product);

        /*------------------产品基本信息----------------------*/
        Map<String, Object> basic = new HashMap<>();

        List<Map<String, Object>> essential = new ArrayList<>();

        Map<String, Object> m1 = new HashMap<>();
        m1.put("title", "产品名称");
        m1.put("value", "佳士淳总裁机");
        essential.add(m1);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("title", "额定电压/频率");
        m2.put("value", "AC-100~240V/60Hz.50Hz");
        essential.add(m2);

        Map<String, Object> m3 = new HashMap<>();
        m3.put("title", "最大AC电流");
        m3.put("value", "1.5A");
        essential.add(m3);

        Map<String, Object> m4 = new HashMap<>();
        m4.put("title", "最大DC电流");
        m4.put("value", "2.5A");
        essential.add(m4);

        Map<String, Object> m5 = new HashMap<>();
        m5.put("title", "外观尺寸");
        m5.put("value", "92(W)*260(H)*120(D)mm");
        essential.add(m5);

        Map<String, Object> m6 = new HashMap<>();
        m6.put("title", "氧化还原单位");
        m6.put("value", "还原水最高可达-200MV以下");
        essential.add(m6);

        Map<String, Object> m7 = new HashMap<>();
        m7.put("title", "进水水质");
        m7.put("value", "20~40ppm RO水及经过处理之软水");
        essential.add(m7);

        Map<String, Object> m8 = new HashMap<>();
        m8.put("title", "启动流速");
        m8.put("value", "0.8L/MIN");
        essential.add(m8);

        Map<String, Object> m9 = new HashMap<>();
        m9.put("title", "净流水量");
        m9.put("value", "1.0~2.0L/MIN");
        essential.add(m9);

        Map<String, Object> m10 = new HashMap<>();
        m10.put("title", "净水压力");
        m10.put("value", "0.5~2kg/cm");
        essential.add(m10);

        Map<String, Object> m11 = new HashMap<>();
        m11.put("title", "消耗功率");
        m11.put("value", "Max 75W");
        essential.add(m11);

        Map<String, Object> m12 = new HashMap<>();
        m12.put("title", "滤芯最大进水量");
        m12.put("value", "6000L");
        essential.add(m12);

        basic.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        basic.put("essential", essential);

        product.put("basic", basic);

        /*------------------产品认证信息----------------------*/
        List<Map<String, Object>> authentication = new ArrayList<>();

        Map<String, Object> m13 = new HashMap<>();
        m13.put("title", "SGS质量体系认证");
        m13.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authentication.add(m13);

        Map<String, Object> m14 = new HashMap<>();
        m14.put("title", "CTI华检测认证");
        m14.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authentication.add(m14);

        Map<String, Object> m15 = new HashMap<>();
        m15.put("title", "iLac-MRA认证");
        m15.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authentication.add(m15);

        Map<String, Object> m16 = new HashMap<>();
        m16.put("title", "CNAS认证");
        m16.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authentication.add(m16);

        Map<String, Object> m17 = new HashMap<>();
        m17.put("title", "富邦财险");
        m17.put("img", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        authentication.add(m17);

        product.put("authentication", authentication);

        /*------------------产品批次信息----------------------*/
        List<Object> batch = new ArrayList<>();
        batch.add("JD-20180001");
        batch.add("JD-20180002");
        batch.add("JD-20180003");
        batch.add("JD-20180004");
        batch.add("JD-20180005");
        batch.add("JD-20180006");
        batch.add("JD-20180007");
        batch.add("JD-20180008");
        batch.add("JD-20180009");
        batch.add("JD-20180010");
        batch.add("JD-20180011");
        batch.add("JD-20180012");
        batch.add("JD-20180013");
        batch.add("JD-20180014");
        batch.add("JD-20180015");
        batch.add("JD-20180016");
        batch.add("JD-20180017");
        batch.add("JD-20180018");
        batch.add("JD-20180019");
        batch.add("JD-20180020");
        batch.add("JD-20180021");
        batch.add("JD-20180022");
        batch.add("JD-20180023");
        batch.add("JD-20180024");
        batch.add("JD-20180025");
        batch.add("JD-20180026");
        batch.add("JD-20180027");
        batch.add("JD-20180028");
        batch.add("JD-20180029");
        batch.add("JD-20180030");

        product.put("batch", batch);

        /*------------------企业信息----------------------*/
        Map<String, Object> enterprise = new HashMap<>();

        map.put("enterprise", enterprise);

        /*------------------企业介绍----------------------*/

        String introduction =
                "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司" +
                        "厦门市世纪闽生置业有限公司";

        enterprise.put("introduction", introduction);

        /*------------------电解水功效----------------------*/
        List<String> electrolysis = new ArrayList<>();
        String s1 = "活化细胞";
        electrolysis.add(s1);
        String s2 = "调节体内酸碱平衡";
        electrolysis.add(s2);
        String s3 = "增强免疫力";
        electrolysis.add(s3);
        String s4 = "渗透力强";
        electrolysis.add(s4);
        String s5 = "改善肠胃功能及新陈代谢";
        electrolysis.add(s5);

        enterprise.put("electrolysis", electrolysis);

        /*------------------查询记录----------------------*/

        Map<String, Object> query = new HashMap<>();

        map.put("query", query);

        /*------------------记录信息----------------------*/
        Map<String, Object> record = new HashMap<>();

        String message = "该商品已被查询5次";
        List<String> note = new ArrayList<>();
        note.add("乌干达0 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品");
        note.add("乌干达1 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品");
        note.add("乌干达2 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品");
        note.add("乌干达3 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品");
        note.add("乌干达4 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品");
        note.add("乌干达5 于2018年12月22日 11:37:02 在北京朝阳区崔各庄乡绿地中心 扫描查询了该商品");
        // 倒序排列
        Collections.reverse(note);
        record.put("note", note);
        record.put("msg", message);

        query.put("record", record);

        String strData = JSON.toJSONString(map);
        System.out.println(strData);
        File file = new File("E:\\myFile\\json\\data.json");
        file.createNewFile();

        Writer writer = new FileWriter(file);
        writer.write(strData);
        writer.close();

        return map;
    }

    public void info() {
        /**
         *      Map<String,Object> essential = new HashMap<>();
         * 		essential.put("产品名称","佳士淳总裁机");
         * 		essential.put("额定电压/频率","AC-100~240V/60Hz.50Hz");
         * 		essential.put("最大AC电流","1.5A");
         * 		essential.put("最大DC电流","2.5A");
         * 		essential.put("外观尺寸","92(W)*260(H)*120(D)mm");
         * 		essential.put("氧化还原单位","还原水最高可达-200MV以下");
         * 		essential.put("进水水质","20~40ppm RO水及经过处理之软水");
         * 		essential.put("启动流速","0.8L/MIN");
         * 		essential.put("净流水量","1.0~2.0L/MIN");
         * 		essential.put("净水压力","0.5~2kg/cm");
         * 		essential.put("消耗功率","Max 75W");
         * 		essential.put("滤芯最大进水量","6000L");
         **/
    }

}
