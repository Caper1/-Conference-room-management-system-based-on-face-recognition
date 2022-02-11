package cn.cy.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import java.io.*;
public class Josn_load {
    public static void main(String[] args) {
    	 String path = "D:\\qq下载\\file_data.json";
         String s = readJsonFile(path);
         JSONObject jobj = JSON.parseObject(s);
         JSONObject aaa=(JSONObject) jobj.get("node");
         String symbolSize = (String)aaa.get("date");
         System.out.println(symbolSize);
    }
    //保存json 文件
    public static boolean createJsonFile(String jsonString, String filePath, String fileName) {
    	// 标记文件生成是否成功
    	boolean flag = true;
    	 // 拼接文件完整路径
        String fullPath = filePath + File.separator + fileName + ".json";

        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(fullPath);
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();
            // 格式化json字符串
            jsonString = JsonFormatTool.formatJson_simple(jsonString);

            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        // 返回是否成功的标记
        return flag;
    }
	 //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //json文件使用
    public static void User_json() {
    	  String path = "E:\\Myeclipse\\WorkPlace_graduate\\基于合同纠纷知识图谱构建及应用\\WebContent\\data\\data_node.json";
          String s = readJsonFile(path);
          JSONObject jobj = JSON.parseObject(s);
          JSONArray Nodes = jobj.getJSONArray("Nodes");//构建JSONArray数组
          for (int i = 0 ; i < Nodes.size();i++){
              JSONObject key = (JSONObject)Nodes.get(i);
              String symbolSize = (String)key.get("name");
              System.out.println(key.get("symbolSize"));
              System.out.println(symbolSize);
          }
    }

}
