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
	public Object view( String fileName) throws Exception {

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
		m1.put("value", "数字式十二道心电图机");
		essential.add(m1);

		Map<String, Object> m2 = new HashMap<>();
		m2.put("name", "生产企业");
		m2.put("value", "深圳邦健生物医疗设备股份有限公司");
		essential.add(m2);

		Map<String, Object> m3 = new HashMap<>();
		m3.put("name", "产品注册证号");
		m3.put("value", "粤食药监械（准）字2013第2210203号");
		essential.add(m3);

		Map<String, Object> m4 = new HashMap<>();
		m4.put("name", "规格型号");
		m4.put("value", "ECG-1210");
		essential.add(m4);

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
        mExplainSecond01.put("name", "医疗机械注册证");
        mExplainSecond01.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
        explainSecondData.add(mExplainSecond01);

        Map<String, Object> mExplainSecond02 = new HashMap<>();
        mExplainSecond02.put("name", "医疗机械注册证登记表");
        mExplainSecond02.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
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

		String info0 = "<p style=\"text-indent: 2em;\">\n" +
				"    深圳邦键生物医疗设备股份有限公司成立于1996年，2012年正式成立股份有限公司。经过10多年的发展，已成为国家高新技术企业、软件企业、广东省医疗器械产业十强、广东省医药行业创新企业，深圳市成长型工业企业500强、深圳市数字式心电图机高技术产此化示范基地企业、深圳市双相除颤器产业化示范基地企业、深圳市母婴键康平台产业化示范基地企业。形成了以7大产品线为主，拥有强大研发团队和享有多项自主知识产权的高科技医疗设备企业，是一家致力于为全球客户提供优质医疗器械产品的知名医疗设备供应商。公司的主要产品为数字式心电图机、多参数监护仪、胎儿监护仪、B型超声诊断及除颤器、输液泵、医疔IT等。\n" +
				"</p>\n" +
				"<p style=\"text-indent: 2em;\">\n" +
				"    深圳邦健生物医疗设备股份有限公司凭借优良的产品性能、真诚的服务和完善的客户体系，目前产品不仅覆盖了国内2000 多个市县，而且已远销全球100多个国家和地区，全球众多国家和地区以及中国市场建立起完善的销售、服务网络。在国内外享有良好的声誉。目前心电图机国内装机量近10万台，近10000家使用机构，国内排名遥遥领先。\n" +
				"</p>\n" +
				"<p style=\"text-indent: 2em;\">\n" +
				"    作为深圳市医疗器械协会理事单位，深圳邦健生物医疔设备股份有限公司秉承“为员工创造机会、为顾客创造价值、共同推动社会进步和人类健康事业的发展&quot;的宗旨，定位于专业提供市场适应力强、技术含量高、性能价格比优越的医疗产品来满足日益发展的市场需求。不断为客户提供优质的产品与服务，是我们孜孜不懈的追求。在这一理念的指引下，我扪的产品曾先后获得国家重点新产品奖、广东省重大科技成果奖、广东省优秀新产品奖等荣誉。\n" +
				"</p>\n" +
				"<p style=\"text-indent: 2em;\">\n" +
				"    同时，公司获得了TUV质量管理体系认证、中国CMD质量管理体系认证、欧盟产品安全CE认证，获得FDA510 (k) 上市许可。\n" +
				"</p>\n" +
				"<p style=\"text-indent: 2em;\">\n" +
				"    我们的目标是：为创造中国人自己的世界性民族品牌而努力奋斗！<br/><br/><br/><br/>\n" +
				"</p>";
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

		Map<String, Object> mCertificate02 = new HashMap<>();
		mCertificate02.put("name", "税务登记证");
		mCertificate02.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
		certificateData.add(mCertificate02);

		Map<String, Object> mCertificate03 = new HashMap<>();
		mCertificate03.put("name", "医疗器械生产企业许可证");
		mCertificate03.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
		certificateData.add(mCertificate03);

		Map<String, Object> mCertificate04 = new HashMap<>();
		mCertificate04.put("name", "组织机构代码证");
		mCertificate04.put("value", "https://www.easyicon.net/api/resizeApi.php?id=1082117&size=128");
		certificateData.add(mCertificate04);

		FileUtils.writeStringToFile(new File(realPath), JSONObject.toJSONString(list), "UTF-8");

		return list;
	}
}
