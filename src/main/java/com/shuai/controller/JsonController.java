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
@RequestMapping("json")
public class JsonController {

	Logger logger = LoggerFactory.getLogger(JsonController.class);

	@Value("${json.url}")
	private String filePath;

	@RequestMapping("view")
	public Object view(String name, String location, String fileName) throws Exception {

		String realPath = filePath + fileName;

		String jsonContent = FileUtils.readFileToString(new File(realPath), "UTF-8");

		List<Object> list = (List<Object>) JSONObject.parse(jsonContent);

		logger.info("/*------------------查询记录----------------------*/");
		Map<String, Object> query = (Map<String, Object>) list.get(2);
		List<Object> queryData = (List<Object>) query.get("data");
		logger.info("/*------------------记录信息----------------------*/");
		Map<String, Object> record = (Map<String, Object>) queryData.get(0);

		List<Map<String, Object>> recordData = (List<Map<String, Object>>) record.get("data");
		if (recordData == null) {
			recordData = new ArrayList<>();
			record.put("data", recordData);
		}

		String message = "<p>\n" +
				"    该商品已被查询<span style=\"color: rgb(84, 141, 212);\">{0}</span>次\n" +
				"</p>";
		String note = "<p>\n" +
				"    {0} 于<span style=\"color: rgb(84, 141, 212);\">{1,time, yyyy年MM月dd日 HH:mm:ss}</span> 在<span style=\"color: rgb(84, 141, 212);\">{2}</span> 扫描查询了该商品\n" +
				"</p>";

		Map<String, Object> map = new HashMap();
		String s1 = MessageFormat.format(note, name, new Date(), location);
		map.put("name", s1);
		map.put("value", "");
		recordData.add(map);
		int size = recordData.size();

		record.put("message", MessageFormat.format(message, size));

		FileUtils.writeStringToFile(new File(realPath), JSONObject.toJSONString(list), "UTF-8");

		logger.info("message={}", message);
		for (Map<String, Object> m : recordData) {
			logger.info(m.get("name") + " : " + m.get("value"));
		}

		/*------------------读取文件返回----------------------*/
		List<Object> list1 = (List<Object>) JSONObject.parse(jsonContent);
		Map<String, Object> query1 = (Map<String, Object>) list1.get(2);
		List<Object> queryData1 = (List<Object>) query1.get("data");
		Map<String, Object> record1 = (Map<String, Object>) queryData1.get(0);
		List<Map<String, Object>> recordData1 = (List<Map<String, Object>>) record1.get("data");
		if (recordData1 != null && recordData1.size() > 0) {
			// 倒序排列
			Collections.reverse(recordData1);
		}
		return list1;
	}

	@GetMapping("getJson")
	public Object getJson(String fileName) throws IOException {
		String realPath = filePath + fileName;

		String jsonContent = FileUtils.readFileToString(new File(realPath), "UTF-8");
		System.out.println(jsonContent);

		List<Object> list = (List<Object>) JSONObject.parse(jsonContent);

		System.out.println("/*------------------产品信息----------------------*/");
		Map<String, Object> product = (Map<String, Object>) list.get(0);
		Object productTitle = product.get("title");
		System.out.println(productTitle);
		List<Object> productData = (List<Object>) product.get("data");

		System.out.println("/*------------------产品基本信息----------------------*/");
		Map<String, Object> basic = (Map<String, Object>) productData.get(0);
		Object basicTitle = basic.get("title");
		System.out.println(basicTitle);
		Object basicType = basic.get("type");
		System.out.println(basicType);
		Object img = basic.get("img");
		System.out.println(img);
		List<Map<String, Object>> essential = (List<Map<String, Object>>) basic.get("data");
		for (Map<String, Object> map : essential) {
			System.out.println(map.get("name") + " : " + map.get("value"));
		}

		System.out.println("/*------------------产品认证信息----------------------*/");
		Map<String, Object> authentication = (Map<String, Object>) productData.get(1);
		Object authenticationTitle = authentication.get("title");
		System.out.println(authenticationTitle);
		Object authenticationType = authentication.get("type");
		System.out.println(authenticationType);
		List<Map<String, Object>> authenticationData = (List<Map<String, Object>>) authentication.get("data");
		for (Map<String, Object> map : authenticationData) {
			System.out.println(map.get("name") + " : " + map.get("value"));
		}
		System.out.println("/*------------------产品批次信息----------------------*/");
		Map<String, Object> batch = (Map<String, Object>) productData.get(2);
		Object batchTitle = batch.get("title");
		System.out.println(batchTitle);
		Object batchType = batch.get("type");
		System.out.println(batchType);
		List<Map<String, Object>> batchData = (List<Map<String, Object>>) batch.get("data");
		for (Map<String, Object> map : batchData) {
			System.out.println(map.get("name") + " : " + map.get("value"));
		}

		System.out.println("/*------------------企业信息----------------------*/");
		Map<String, Object> enterprise = (Map<String, Object>) list.get(1);
		Object enterpriseTitle = enterprise.get("title");
		System.out.println(enterpriseTitle);
		List<Object> enterpriseData = (List<Object>) enterprise.get("data");

		System.out.println("/*------------------企业介绍----------------------*/");
		Map<String, Object> introduction = (Map<String, Object>) enterpriseData.get(0);
		Object introductionTitle = introduction.get("title");
		System.out.println(introductionTitle);
		Object introductionType = introduction.get("type");
		System.out.println(introductionType);
		List<Map<String, Object>> introductionData = (List<Map<String, Object>>) introduction.get("data");
		for (Map<String, Object> map : introductionData) {
			System.out.println(map.get("name") + " : " + map.get("value"));
		}

		System.out.println("/*------------------电解水功效----------------------*/");
		Map<String, Object> electrolysis = (Map<String, Object>) enterpriseData.get(1);
		Object electrolysisTitle = electrolysis.get("title");
		System.out.println(electrolysisTitle);
		Object electrolysisType = electrolysis.get("type");
		System.out.println(electrolysisType);
		List<Map<String, Object>> electrolysisData = (List<Map<String, Object>>) electrolysis.get("data");
		for (Map<String, Object> map : electrolysisData) {
			System.out.println(map.get("name") + " : " + map.get("value"));
		}

		System.out.println("/*------------------查询记录----------------------*/");
		Map<String, Object> query = (Map<String, Object>) list.get(2);
		Object queryTitle = query.get("title");
		System.out.println(queryTitle);
		List<Object> queryData = (List<Object>) query.get("data");

		System.out.println("/*------------------记录信息----------------------*/");
		Map<String, Object> record = (Map<String, Object>) queryData.get(0);
		Object recordTitle = record.get("title");
		System.out.println(recordTitle);
		Object recordType = record.get("type");
		System.out.println(recordType);
		Object recordMessage = record.get("message");
		System.out.println(recordMessage);
		List<Map<String, Object>> recordData = (List<Map<String, Object>>) record.get("data");
		for (Map<String, Object> map : recordData) {
			System.out.println(map.get("name") + " : " + map.get("value"));
		}

		// 倒序排列
		Collections.reverse(recordData);

		return list;
	}

	@GetMapping("setJson")
	public Object setJson(String fileName) throws IOException {

		String realPath = filePath + fileName;

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
		Map<String, Object> m001 = new HashMap<>();
		m001.put("name", "JD-20180011");
		m001.put("value", "");
		batchData.add(m001);
		Map<String, Object> m002 = new HashMap<>();
		m002.put("name", "JD-20180012");
		m002.put("value", "");
		batchData.add(m002);
		Map<String, Object> m003 = new HashMap<>();
		m003.put("name", "JD-20180013");
		m003.put("value", "");
		batchData.add(m003);
		Map<String, Object> m004 = new HashMap<>();
		m004.put("name", "JD-20180014");
		m004.put("value", "");
		batchData.add(m004);
		Map<String, Object> m005 = new HashMap<>();
		m005.put("name", "JD-20180015");
		m005.put("value", "");
		batchData.add(m005);
		Map<String, Object> m006 = new HashMap<>();
		m006.put("name", "JD-20180016");
		m006.put("value", "");
		batchData.add(m006);
		Map<String, Object> m007 = new HashMap<>();
		m007.put("name", "JD-20180017");
		m007.put("value", "");
		batchData.add(m007);
		Map<String, Object> m008 = new HashMap<>();
		m008.put("name", "JD-20180018");
		m008.put("value", "");
		batchData.add(m008);
		Map<String, Object> m009 = new HashMap<>();
		m009.put("name", "JD-20180019");
		m009.put("value", "");
		batchData.add(m009);
		Map<String, Object> m010 = new HashMap<>();
		m010.put("name", "JD-20180020");
		m010.put("value", "");
		batchData.add(m010);
		Map<String, Object> m011 = new HashMap<>();
		m011.put("name", "JD-20180021");
		m011.put("value", "");
		batchData.add(m011);
		Map<String, Object> m012 = new HashMap<>();
		m012.put("name", "JD-20180022");
		m012.put("value", "");
		batchData.add(m012);
		Map<String, Object> m013 = new HashMap<>();
		m013.put("name", "JD-20180023");
		m013.put("value", "");
		batchData.add(m013);
		Map<String, Object> m014 = new HashMap<>();
		m014.put("name", "JD-20180024");
		m014.put("value", "");
		batchData.add(m014);
		Map<String, Object> m015 = new HashMap<>();
		m015.put("name", "JD-20180025");
		m015.put("value", "");
		batchData.add(m015);
		Map<String, Object> m016 = new HashMap<>();
		m016.put("name", "JD-20180026");
		m016.put("value", "");
		batchData.add(m016);
		Map<String, Object> m017 = new HashMap<>();
		m017.put("name", "JD-20180027");
		m017.put("value", "");
		batchData.add(m017);
		Map<String, Object> m018 = new HashMap<>();
		m018.put("name", "JD-20180028");
		m018.put("value", "");
		batchData.add(m018);
		Map<String, Object> m019 = new HashMap<>();
		m019.put("name", "JD-20180029");
		m019.put("value", "");
		batchData.add(m019);
		Map<String, Object> m020 = new HashMap<>();
		m020.put("name", "JD-20180030");
		m020.put("value", "");
		batchData.add(m020);

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

		String info0 = "<p style=\"text-indent: 2em;\">\n" +
				"    厦门市世纪闽生置业有限公司，作为水行业的先驱者，打造佳士淳（Just Drink）品牌，并一直致力于开拓电解水对人体健康的促进作用。公司汇集了无隔膜电解模块、反渗透膜、超滤膜、连续电去离子设备、离子交换树脂等水处理技术与核心设备，生产出从过滤杀菌到电解分流为一体的电解水设备。<br/>\n" +
				"</p>";
		String info1 = "<p style=\"text-indent: 2em;\">\n" +
				"    电解水发展百年，如今慢慢的从医用养生行列走人平常百姓之家。友因健康公司正以电解水为基础，为树立行业新标杆而努力。以水融入生活、改变生活。\n" +
				"</p>";
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
		m28.put("name", "活化细胞，利于抗衰老、恢复青春，去除细胞膜或血管内有害物，抑制氧自由基作用。");
		m28.put("value", "");
		electrolysisData.add(m28);
		Map<String, Object> m29 = new HashMap<>();
		m29.put("name", "调节体内酸碱平衡，改善酸碱体质，减少高血压、通风等心脑血管疾病发生的可能。");
		m29.put("value", "");
		electrolysisData.add(m29);
		Map<String, Object> m30 = new HashMap<>();
		m30.put("name", "增强免疫力，提高巨噬细胞活性，从而增强免疫功能。解酒、解毒，各种杂醇类分子或农药、读物可被小分子团溶解。");
		m30.put("value", "");
		electrolysisData.add(m30);
		Map<String, Object> m31 = new HashMap<>();
		m31.put("name", "渗透力强，可深入组织或细胞膜间隙等，活化细胞组织，改善各系统血液循环功能。");
		m31.put("value", "");
		electrolysisData.add(m31);
		Map<String, Object> m32 = new HashMap<>();
		m32.put("name", "改善肠胃功能及新陈代谢，促进循环、神经及内分泌均衡，减少脂肪积蓄，促进脂肪分解。");
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
		String message = "<p>\n" +
				"    该商品已被查询<span style=\"color: rgb(84, 141, 212);\">5</span>次\n" +
				"</p>";
		record.put("message", message);
		record.put("data", recordData);

		Map<String, Object> m33 = new HashMap<>();
		String s1 = "<p>\n" +
				"    乌干达0 于<span style=\"color: rgb(84, 141, 212);\">2018年12月22日 11:37:02</span> 在<span style=\"color: rgb(84, 141, 212);\">北京朝阳区崔各庄乡绿地中心</span> 扫描查询了该商品\n" +
				"</p>";
		m33.put("name", s1);
		m33.put("value", "");
		recordData.add(m33);
		Map<String, Object> m34 = new HashMap<>();
		String s2 = "<p>\n" +
				"    乌干达1 于<span style=\"color: rgb(84, 141, 212);\">2018年12月22日 11:37:02</span> 在<span style=\"color: rgb(84, 141, 212);\">北京朝阳区崔各庄乡绿地中心</span> 扫描查询了该商品\n" +
				"</p>";
		m34.put("name", s2);
		m34.put("value", "");
		recordData.add(m34);
		Map<String, Object> m35 = new HashMap<>();
		String s3 = "<p>\n" +
				"    乌干达2 于<span style=\"color: rgb(84, 141, 212);\">2018年12月22日 11:37:02</span> 在<span style=\"color: rgb(84, 141, 212);\">北京朝阳区崔各庄乡绿地中心</span> 扫描查询了该商品\n" +
				"</p>";
		m35.put("name", s3);
		m35.put("value", "");
		recordData.add(m35);
		Map<String, Object> m36 = new HashMap<>();
		String s4 = "<p>\n" +
				"    乌干达3 于<span style=\"color: rgb(84, 141, 212);\">2018年12月22日 11:37:02</span> 在<span style=\"color: rgb(84, 141, 212);\">北京朝阳区崔各庄乡绿地中心</span> 扫描查询了该商品\n" +
				"</p>";
		m36.put("name", s4);
		m36.put("value", "");
		recordData.add(m36);
		Map<String, Object> m37 = new HashMap<>();
		String s5 = "<p>\n" +
				"    乌干达4 于<span style=\"color: rgb(84, 141, 212);\">2018年12月22日 11:37:02</span> 在<span style=\"color: rgb(84, 141, 212);\">北京朝阳区崔各庄乡绿地中心</span> 扫描查询了该商品\n" +
				"</p>";
		m37.put("name", s5);
		m37.put("value", "");
		recordData.add(m37);

		FileUtils.writeStringToFile(new File(realPath), JSONObject.toJSONString(list), "UTF-8");

		return list;
	}
}
