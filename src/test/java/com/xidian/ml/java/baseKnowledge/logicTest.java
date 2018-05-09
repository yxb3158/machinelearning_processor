package com.xidian.ml.java.baseKnowledge;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

/**
 * Created by yxb on 2017/12/7.
 */
public class logicTest extends TestCase {
    @Test
    public void test1(){
        long a=244126140;
        long b = a & 255;
        System.out.println("dfghj");
        System.out.println(a);
        System.out.println(Long.toBinaryString(a));
        System.out.println(b);
        System.out.println(Long.toBinaryString(b));
    }

    @Test
    public void test2(){
        String json="{\"flavors\":[{\"name\":\"盖浇饭\",\"id\":209},{\"name\":\"简餐\",\"id\":265}],\"piecewise_agent_fee\":{\"is_extra\":true,\"description\":\"配送费¥7\",\"rules\":[{\"price\":15,\"fee\":7}],\"extra_fee\":4,\"tips\":\"夜间配送费¥7\"},\"albums\":[{\"cover_image_hash\":\"01ea3508ed8b85d3c865e2e9cd07e3eajpeg\",\"count\":1,\"name\":\"门面\",\"photos\":[{\"description\":\"门头照\",\"image_hash\":\"01ea3508ed8b85d3c865e2e9cd07e3eajpeg\",\"id\":44152186,\"type\":\"FRONT\"}]},{\"cover_image_hash\":\"0082818d74602a4b2ef826c411624116jpeg\",\"count\":1,\"name\":\"大堂\",\"photos\":[{\"description\":\"店内照\",\"image_hash\":\"0082818d74602a4b2ef826c411624116jpeg\",\"id\":44152194,\"type\":\"HALL\"}]}],\"distance\":0,\"scheme\":\"eleme://catering?restaurant_id=161689851\",\"latitude\":31.200556,\"rating\":4.8,\"description\":\"\",\"recommend\":{\"reason\":\"\",\"is_ad\":false},\"float_delivery_fee\":7,\"type\":0,\"platform\":0,\"max_applied_quantity_per_order\":-1,\"recommend_reasons\":[{\"name\":\"味道超赞\"},{\"name\":\"回头客多\"},{\"name\":\"配送飞快\"}],\"recent_order_num\":3220,\"is_stock_empty\":0,\"order_lead_time\":20,\"supports\":[{\"icon_color\":\"999999\",\"name\":\"开发票\",\"description\":\"该商家支持开发票，开票订单金额150元起，请在下单时填写好发票抬头\",\"id\":4,\"icon_name\":\"票\",\"two_characters_icon_name\":\"发票\"}],\"closing_count_down\":0,\"id\":161689851,\"float_minimum_order_amount\":15,\"only_use_poi\":false,\"longitude\":121.309011,\"address\":\"上海市闵行区新虹街道申滨路519弄68号一层\",\"is_new\":false,\"posters\":[{\"name\":\"上海\",\"image_hash\":\"23a547e02c7a464170a90986bb8116c2png\",\"id\":1061105,\"url\":\"eleme://restaurant_promotion?restaurant_id=161689851&banner_id=1061105\"}],\"favored\":false,\"weight\":{\"unit\":20000,\"unit_fee\":20000,\"maximum\":20000,\"basic\":20000},\"authentic_id\":7342643063340451,\"regular_customer_count\":0,\"rating_count\":951,\"is_premium\":true,\"phone\":\"13816164095 4008271999\",\"activities\":[{\"is_exclusive_with_food_activity\":true,\"icon_color\":\"70bc46\",\"name\":\"新用户立减(不与其他活动共享)\",\"description\":\"新用户下单立减17元(不与其它活动同享)\",\"attribute\":\"17.0\",\"id\":866750746,\"type\":103,\"icon_name\":\"首单\",\"tips\":\"新用户下单立减17元(不与其它活动同享)\"},{\"is_exclusive_with_food_activity\":true,\"icon_color\":\"f07373\",\"name\":\"【我呀北上～】大牌日\",\"description\":\"满16减15，满35减20，满50减26\",\"attribute\":\"{\\\"16\\\": {\\\"1\\\": 15.0, \\\"0\\\": 0}, \\\"50\\\": {\\\"1\\\": 26.0, \\\"0\\\": 0}, \\\"35\\\": {\\\"1\\\": 20.0, \\\"0\\\": 0}}\",\"id\":965596906,\"type\":102,\"icon_name\":\"满减\",\"tips\":\"满16减15，满35减20，满50减26\"},{\"icon_color\":\"f07373\",\"name\":\"【尊享】5折爆款\",\"description\":\"【尊享】5折爆款\",\"id\":326673746,\"icon_name\":\"折扣\",\"tips\":\"【尊享】5折爆款\"},{\"icon_color\":\"f07373\",\"name\":\"【年底特惠套餐】\",\"description\":\"【年底特惠套餐】\",\"id\":316152130,\"icon_name\":\"折扣\",\"tips\":\"【年底特惠套餐】\"},{\"icon_color\":\"f07373\",\"name\":\"【新年快乐】六折特惠\",\"description\":\"【新年快乐】六折特惠\",\"id\":315918762,\"icon_name\":\"折扣\",\"tips\":\"【新年快乐】六折特惠\"}],\"image_path\":\"016ae41719c47382f12c63cdaa73a0c2png\",\"is_valid\":1,\"name\":\"我呀便当(虹桥枢纽店)\",\"opening_hours\":[\"09:30/20:30\"],\"promotion_info\":\"喜欢我呀约我呀，超会撩人的我呀便当在全国拥有近七百家连锁店，口味统一，操作规范，是央视《领航》栏目的合作伙伴哦~\\n小哥哥小姐姐们，请和我呀一起创造美好的回忆吧！好看好吃还好玩，用心做的便当。\",\"support_tags\":[],\"next_business_time\":\"09:30\",\"shop_sign\":{\"image_hash\":\"638a0dd719b3105ecabde5c3401105e5png\",\"brand_story\":\"喜欢我呀约我呀！\\n新年新约法，打折太老套（还是折），满减太落后（依然减），介意我们简单粗暴的拜个年吗（狗年旺旺旺）\\n悄咪咪告诉你，我呀是立志要做便当界小网红的便当。浙江卫视主持人陈欢夸过，G20工作人员吃过，CCTV领航栏目邀过……求约！\\n小提示：单点配餐/饮料的订单是不外送的哦！ \"},\"delivery_mode\":{\"border\":\"FFFFFF\",\"color\":\"\",\"id\":3,\"is_solid\":true,\"text\":\"蜂鸟快送\",\"text_color\":\"FFFFFF\",\"icon_hash\":\"b9b45d2f6ff0dbeef3a78ef0e4e90abapng\"},\"status\":4}\t";
        JSONObject poiJson = JSONObject.parseObject(json);
        JSONArray activityList = poiJson.getJSONArray("activities");
        Long poiId = poiJson.getLong("id");

        System.out.println(activityList.get(0));
        System.out.println(poiId);
    }


    private String uncompress(String page) {
        return uncompress(page, "ISO-8859-1");
    }

    private String uncompress(String page, String zipCode) {
        if (page == null || page.length() == 0) return "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(page.getBytes(zipCode));
            GZIPInputStream gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n = gunzip.read(buffer);
            while (n >= 0) {
                out.write(buffer, 0, n);
                n = gunzip.read(buffer);
            }
            return out.toString();
        } catch (Exception e) {
            System.out.println("解析异常\n"+page);
            return "";
        }
    }


}
