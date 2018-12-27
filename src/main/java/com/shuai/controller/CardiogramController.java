package com.shuai.controller;



import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

/**
 * JsonController
 *
 * @author shuai
 * @date 2018/12/26
 */
@RestController
@RequestMapping("cardiogram")
public class CardiogramController {

	Logger logger = LoggerFactory.getLogger(CardiogramController.class);

	@Value("${json.cardiogramUrl}")
	private String filePath;

	@RequestMapping("view")
	public Object view(String name, String location, String fileName) throws Exception {

		String realPath = filePath + fileName;

		String jsonContent = FileUtils.readFileToString(new File(realPath), "UTF-8");

		/*------------------读取文件返回----------------------*/
		List<Object> list = (List<Object>) JSONObject.parse(jsonContent);
		return list;
	}

	@GetMapping("setJson")
	public Object setJson(String fileName) throws IOException {

		String realPath = filePath + fileName;

		/*------------------溯源信息----------------------*/
		List<Object> list = new ArrayList<>();

        /*------------------设备状态----------------------*/
        Map<String, Object> equipmentStatus = new HashMap<>();
        list.add(equipmentStatus);

        List<Object> statusData = new ArrayList<>();
        equipmentStatus.put("title", "设备状态");
        equipmentStatus.put("data", statusData);

        /*------------------设备状态second----------------------*/

        Map<String, Object> statusSecond = new HashMap<>();
        statusData.add(statusSecond);

        Map<String, Object> m0 = new HashMap<>();
        m0.put("name", "设备状态");
        m0.put("value", "维修中");

        statusSecond.put("type", 7);
        statusSecond.put("data", m0);

		/*------------------产品介绍----------------------*/

		Map<String, Object> product = new HashMap<>();
		list.add(product);

		List<Object> productData = new ArrayList<>();
		product.put("title", "产品介绍");
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

		/*------------------主要性能指标----------------------*/
		Map<String, Object> performance = new HashMap<>();
		productData.add(performance);

		List<Map<String, Object>> performanceData = new ArrayList<>();
        performance.put("title", "主要性能指标");
        performance.put("type", 8);
        performance.put("data", performanceData);

		Map<String, Object> mPerformance = new HashMap<>();
        mPerformance.put("name", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        mPerformance.put("value", "");
        performanceData.add(mPerformance);

        /*------------------产品说明----------------------*/
        Map<String, Object> explain = new HashMap<>();
        list.add(explain);

        List<Object> explainData = new ArrayList<>();
        explain.put("title", "产品说明");
        explain.put("data", explainData);


        /*------------------产品说明second----------------------*/
        Map<String, Object> explainSecond = new HashMap<>();
        explainData.add(explainSecond);

        List<Object> explainSecondData = new ArrayList<>();
        explainSecond.put("type", 9);
        explainSecond.put("data", explainSecondData);

        Map<String, Object> mExplainSecond01 = new HashMap<>();
        mExplainSecond01.put("name", "消耗功率");
        mExplainSecond01.put("value", "Max 75W");
        explainSecondData.add(mExplainSecond01);

        Map<String, Object> mExplainSecond02 = new HashMap<>();
        mExplainSecond02.put("name", "滤芯最大进水量");
        mExplainSecond02.put("value", "6000L");
        explainSecondData.add(mExplainSecond02);

		/*------------------生产厂家----------------------*/
		Map<String, Object> enterprise = new HashMap<>();
		list.add(enterprise);

		List<Object> enterpriseData = new ArrayList<>();
		enterprise.put("title", "生产厂家");
		enterprise.put("data", enterpriseData);


		/*------------------企业简介----------------------*/
		Map<String, Object> introduction = new HashMap<>();
		enterpriseData.add(introduction);

		List<Object> introductionData = new ArrayList<>();
		introduction.put("title", "企业简介");
		introduction.put("type", 4);
		introduction.put("data", introductionData);

		String info0 = "深圳邦键";
		Map<String, Object> introductionMap0 = new HashMap<>();
		introductionMap0.put("name", "text");
		introductionMap0.put("value", info0);
		introductionData.add(introductionMap0);

		/*------------------企业证书----------------------*/
		Map<String, Object> certificate = new HashMap<>();
		enterpriseData.add(certificate);

		List<Object> certificateData = new ArrayList<>();
        certificate.put("title", "企业证书");
        certificate.put("type", 2);
        certificate.put("data", certificateData);

        Map<String, Object> mCertificate01 = new HashMap<>();
        mCertificate01.put("name", "企业营业执照");
        mCertificate01.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        certificateData.add(mCertificate01);

		FileUtils.writeStringToFile(new File(realPath), JSONObject.toJSONString(list), "UTF-8");

		return list;
	}
}
