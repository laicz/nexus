package com.zhou.haizhi.nexus.base;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;

import java.io.IOException;

/**
 * Create by zhoumingbing on 2019-11-19
 */
public class JSONTest {

    private String json = "[\n" +
            "    {\n" +
            "        \"uid\": \"ReadData_1RljnIq3C\",\n" +
            "        \"itemName\": \"读数据表\",\n" +
            "        \"outSlots\": [\n" +
            "            {\n" +
            "                \"uid\": \"ReadData_1RljnIq3C_out_0\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 565,\n" +
            "                    \"cy\": 247\n" +
            "                },\n" +
            "                \"tips\": \"数据\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"inSlots\": [],\n" +
            "        \"itemCode\": \"ReadData\",\n" +
            "        \"mainClass\":\"io.ReadFromHiveOrSQL\",\n" +
            "        \"styles\": {\n" +
            "            \"inSlots_num\": 0,\n" +
            "            \"outSlots_num\": 1,\n" +
            "            \"width\": 120,\n" +
            "            \"x\": 505,\n" +
            "            \"y\": 211,\n" +
            "            \"height\": 36\n" +
            "        },\n" +
            "        \"state\": \"None\",\n" +
            "        \"params\": {\n" +
            "            \"tableSQL\": \"Select * from dev_kip.inner_cust\",\n" +
            "            \"dataBase\": \"dev_kip\",\n" +
            "            \"rename\": \"行内企业\",\n" +
            "            \"dataTable\": \"inner_cust\",\n" +
            "            \"sqlState\": \"\",\n" +
            "            \"selectType\": \"SelectTable\",\n" +
            "            \"dataSource\": \"hive\"\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        \"uid\": \"GuaranteeGenealogy_lkUcAXfVz\",\n" +
            "        \"itemName\": \"担保族谱\",\n" +
            "        \"outSlots\": [\n" +
            "            {\n" +
            "                \"uid\": \"GuaranteeGenealogy_lkUcAXfVz_out_0\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 556,\n" +
            "                    \"cy\": 458\n" +
            "                },\n" +
            "                \"tips\": \"担保族谱结果\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"uid\": \"GuaranteeGenealogy_lkUcAXfVz_out_1\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 596,\n" +
            "                    \"cy\": 458\n" +
            "                },\n" +
            "                \"tips\": \"担保族谱结果\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"inSlots\": [\n" +
            "            {\n" +
            "                \"uid\": \"GuaranteeGenealogy_lkUcAXfVz_in_0\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 540,\n" +
            "                    \"cy\": 422\n" +
            "                },\n" +
            "                \"tips\": \"担保数据（必传）\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"uid\": \"GuaranteeGenealogy_lkUcAXfVz_in_1\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 564,\n" +
            "                    \"cy\": 422\n" +
            "                },\n" +
            "                \"tips\": \"行内企业（必传）\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"uid\": \"GuaranteeGenealogy_lkUcAXfVz_in_2\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 588,\n" +
            "                    \"cy\": 422\n" +
            "                },\n" +
            "                \"tips\": \"异常风险点（必传）\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"uid\": \"GuaranteeGenealogy_lkUcAXfVz_in_3\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 612,\n" +
            "                    \"cy\": 422\n" +
            "                },\n" +
            "                \"tips\": \"自然人融合\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"itemCode\": \"GuaranteeGenealogy\",\n" +
            "        \"mainClass\":\"business.GuaranteeGroup\",\n" +
            "        \"styles\": {\n" +
            "            \"inSlots_num\": 4,\n" +
            "            \"outSlots_num\": 1,\n" +
            "            \"width\": 120,\n" +
            "            \"x\": 516,\n" +
            "            \"y\": 422,\n" +
            "            \"height\": 36\n" +
            "        },\n" +
            "        \"state\": \"None\",\n" +
            "        \"params\": {}\n" +
            "    },\n" +
            "    {\n" +
            "        \"uid\": \"ReadData_y2T8GkPL5\",\n" +
            "        \"itemName\": \"读数据表\",\n" +
            "        \"outSlots\": [\n" +
            "            {\n" +
            "                \"uid\": \"ReadData_y2T8GkPL5_out_0\",\n" +
            "                \"slotType\": \"Dataset\",\n" +
            "                \"styles\": {\n" +
            "                    \"cx\": 423,\n" +
            "                    \"cy\": 182\n" +
            "                },\n" +
            "                \"tips\": \"数据\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"inSlots\": [],\n" +
            "        \"itemCode\": \"ReadData\",\n" +
            "        \"mainClass\":\"io.ReadFromHiveOrSQL\",\n" +
            "        \"styles\": {\n" +
            "            \"inSlots_num\": 0,\n" +
            "            \"outSlots_num\": 1,\n" +
            "            \"width\": 120,\n" +
            "            \"x\": 363,\n" +
            "            \"y\": 146,\n" +
            "            \"height\": 36\n" +
            "        },\n" +
            "        \"state\": \"None\",\n" +
            "        \"params\": {\n" +
            "            \"tableSQL\": \"Select * from guarantee.dev_kip\",\n" +
            "            \"dataBase\": \"dev_kip\",\n" +
            "            \"rename\": \"担保数据\",\n" +
            "            \"dataTable\": \"guarantee\",\n" +
            "            \"sqlState\": \"select * from guarantee;\",\n" +
            "            \"selectType\": \"HiveSQL\",\n" +
            "            \"dataSource\": \"hive\"\n" +
            "        }\n" +
            "    }\n" +
            "]";

    @Test
    public void removeLineBreak() {
        System.out.println(JSON.toJSONString(JSON.parseArray(json)));
    }

    @Test
    public void jsonParse() {
        String str = "{\"main_class\": \"business.GuaranteeGroup\",\"component_param\": {\"input_data_path\":[\"select * from dev_kip.guarantee\",\"Select * from dev_kip.inner_cust\",\"select * from dev_kip.guarantee\",\"\"],\"infer_schema\":\"true\",\"header\":\"true\",\"output_data_path\":[\"hive:dev_kip.GuaranteeGenealogy_lkUcAXfVz_out_0\",\"hive:dev_kip.GuaranteeGenealogy_lkUcAXfVz_out_1\"],\"sep\":\"   \"}, \"reply_message_path\": \"\" }";
        System.out.println(JSON.toJSONString(JSON.parseObject(str), true));
    }

    @Test
    public void json() throws IOException {
        String str = "{\"main_class\": \"business.GuaranteeGroup\",\"component_param\": {\"input_data_path\":[\"select * from dev_kip.guarantee\",\"Select * from dev_kip.inner_cust\",\"select * from dev_kip.guarantee\",\"\"],\"infer_schema\":\"true\",\"header\":\"true\",\"output_data_path\":[\"hive:dev_kip.GuaranteeGenealogy_lkUcAXfVz_out_0\",\"hive:dev_kip.GuaranteeGenealogy_lkUcAXfVz_out_1\"],\"sep\":\"   \"}, \"reply_message_path\": \"\" }";
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory.createParser(str);
        String text = parser.getText();
        System.out.println(text);
    }
}
