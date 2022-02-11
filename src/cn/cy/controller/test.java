package cn.cy.controller;

import org.apache.commons.collections.CollectionUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {
	 
    public static void main(String[] args) {
 
        JSONObject dataSet = new JSONObject();
 
        JSONArray value_out = new JSONArray(); // value的外层JSONArray
        JSONArray inner_12 = new JSONArray(); // 内层12
        inner_12.add("20180612");
        inner_12.add("54505");
        inner_12.add("2");
        System.out.println(inner_12);
 
        JSONArray inner_13 = new JSONArray(); // 内层13
        inner_13.add("20180613");
        inner_13.add("54505");
        inner_13.add("2");
        System.out.println(inner_13);
        JSONArray inner_14 = new JSONArray(); // 内层14
        inner_14.add("20180614");
        inner_14.add("54505");
        inner_14.add("2");
 
        // 往外层JSONArray中套JSONArray
        value_out.add(inner_12);
        value_out.add(inner_13);
        value_out.add(inner_14);
        
        System.out.println(value_out);
        dataSet.put("result", value_out); // put(key1, value1)
        dataSet.put("sum", value_out); // put(key2,value2)
        System.out.println(dataSet);
        JSONArray result = dataSet.getJSONArray("result"); // 获取到的是二维数组，JSONArray套JSONArray
        JSONArray sum = dataSet.getJSONArray("sum");
 
        String date0 = result.getJSONArray(0).getString(0);  // 获取第一个元素的date
 
        System.out.println(date0);
        if (!CollectionUtils.isEmpty(result)) {
            for (int i = 0; i < result.size(); i++) {
                JSONArray record = result.getJSONArray(i); // 获取内层json数组
                String date = record.getString(0);
                System.out.println(date);
            }
        }
    }
}