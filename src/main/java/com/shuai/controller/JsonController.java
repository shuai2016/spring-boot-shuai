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
