package com.zhou.haizhi.nexus.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhoumingbing on 2019-11-13
 */
@RestController
@RequestMapping("/mock")
public class MockDataController {

    @PostMapping("/external")
    public String external() {
        return "{\n" +
                "    \"success\": true,\n" +
                "    \"version\": \"1.0\",\n" +
                "    \"message\": \"\",\n" +
                "    \"payload\": {\n" +
                "        \"data\": {\n" +
                "            \"vertices\": [\n" +
                "                {\n" +
                "                    \"_tag\": \"START\",\n" +
                "                    \"_id\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"name\": \"A\",\n" +
                "                    \"reg_date\": \"2019-11-19 12:14:45\",\n" +
                "                    \"reg_city\": \"龙岩\",\n" +
                "                    \"utime\": \"2009-11-19 00:00:00\",\n" +
                "                    \"legal_representative\": \"李永元\",\n" +
                "                    \"reg_address\": \"福建省龙岩市新罗区陵园路81号\",\n" +
                "                    \"object_key\": \"81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"reg_capital\": \"1069050000\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"6\",\n" +
                "                        \"color\": \"#F3FF33\",\n" +
                "                        \"size\": \"NORMAL\"\n" +
                "                    },\n" +
                "                    \"_fieldUiConfigs\": [\n" +
                "                        {\n" +
                "                            \"ruleId\":1,\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"color\": \"#EE2108\",\n" +
                "                            \"ruleName\": \"不良客户\",\n" +
                "                            \"coverable\": \"N\",\n" +
                "                            \"priority\": 0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"ruleId\":2,\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"priority\": 1,\n" +
                "                            \"coverable\": \"Y\",\n" +
                "                            \"color\": \"#F3FF33\",\n" +
                "                            \"ruleName\": \"未准入客户\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"_detailUrl\": \"http://jira.sz.haizhi.com/browse/\",\n" +
                "                    \"_algorithmFilterType\":  [\"guarantee\"]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_tag\": \"MARK\",\n" +
                "                    \"_id\": \"company/81dcf84eea186e9c04c18b35bcf13bf5\",\n" +
                "                    \"name\": \"B\",\n" +
                "                    \"reg_date\": \"2015-08-25\",\n" +
                "                    \"reg_city\": \"北京\",\n" +
                "                    \"utime\": \"2018-06-25 00:00:00\",\n" +
                "                    \"legal_representative\": \"杨娟\",\n" +
                "                    \"reg_address\": \"北京市海淀区学院路甲5号2幢平房B-1031室\",\n" +
                "                    \"object_key\": \"81dcf84eea186e9c04c18b35bcf13bf5\",\n" +
                "                    \"reg_capital\": \"12345678901\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"26\",\n" +
                "                        \"color\": \"#33D4FF\",\n" +
                "                        \"size\": \"NORMAL\"\n" +
                "                    },\n" +
                "                    \"_fieldUiConfigs\": [\n" +
                "                        {\n" +
                "                            \"ruleId\":1,\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"priority\": 1,\n" +
                "                            \"coverable\": \"Y\",\n" +
                "                            \"color\": \"#33D4FF\",\n" +
                "                            \"ruleName\": \"准入客户\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"_detailUrl\": \"http://192.168.1.58:8087/gap/api/swagger-ui.html#/\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_tag\": \"END\",\n" +
                "                    \"_id\": \"Person/4AFA17AFDF37CA04C9B3841CD312D43F\",\n" +
                "                    \"name\": \"D\",\n" +
                "                    \"object_key\": \"4AFA17AFDF37CA04C9B3841CD312D43F\",\n" +
                "                    \"utime\": \"2018-05-01\",\n" +
                "                    \"ctime\": \"2018-05-01\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"9\",\n" +
                "                        \"color\": \"#C6C8C7\",\n" +
                "                        \"size\": \"LARGE\"\n" +
                "                    },\n" +
                "                    \"_detailUrl\": \"https://www.baidu.com/\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_tag\": null,\n" +
                "                    \"_id\": \"Company/344ae9c5f3862cf40bfd6121112a9c14\",\n" +
                "                    \"name\": \"C\",\n" +
                "                    \"reg_date\": \"2002-07-20 12:16:45\",\n" +
                "                    \"reg_city\": \"无锡\",\n" +
                "                    \"utime\": \"2002-07-20 00:00:00\",\n" +
                "                    \"legal_representative\": \"马龙\",\n" +
                "                    \"reg_address\": \"江苏省无锡国家高新技术产业开发区华山路5号\",\n" +
                "                    \"object_key\": \"344ae9c5f3862cf40bfd6121112a9c14\",\n" +
                "                    \"reg_capital\": \"1008950570\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"6\",\n" +
                "                        \"color\": \"#33FF8A\",\n" +
                "                        \"size\": \"LARGE\"\n" +
                "                    },\n" +
                "                    \"_fieldUiConfigs\": [\n" +
                "                        {\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"priority\": 1,\n" +
                "                            \"coverable\": \"Y\",\n" +
                "                            \"color\": \"#33FF8A\",\n" +
                "                            \"ruleName\": \"准入客户\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_tag\": null,\n" +
                "                    \"_id\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"name\": \"E\",\n" +
                "                    \"reg_date\": \"2005-02-13 12:15:45\",\n" +
                "                    \"reg_city\": \"大连\",\n" +
                "                    \"utime\": \"2005-02-13 00:00:00\",\n" +
                "                    \"legal_representative\": \"江奕忠\",\n" +
                "                    \"reg_address\": \"辽宁省大连市甘井子区营升路9号\",\n" +
                "                    \"object_key\": \"ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"reg_capital\": \"1567040000\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"6\",\n" +
                "                        \"color\": \"#C6C8C7\",\n" +
                "                        \"size\": \"LARGE\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_tag\": null,\n" +
                "                    \"_id\": \"Person/15095D14367F7F02655030D498A4BA03\",\n" +
                "                    \"name\": \"F\",\n" +
                "                    \"object_key\": \"15095D14367F7F02655030D498A4BA03\",\n" +
                "                    \"utime\": \"2019-05-01\",\n" +
                "                    \"ctime\": \"2019-05-01\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"26\",\n" +
                "                        \"color\": \"#33D4FF\",\n" +
                "                        \"size\": \"LARGE\"\n" +
                "                    },\n" +
                "                    \"_fieldUiConfigs\": [\n" +
                "                        {\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"color\": \"#EE2108\",\n" +
                "                            \"ruleName\": \"不良客户\",\n" +
                "                            \"coverable\": \"Y\",\n" +
                "                            \"priority\": 0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_tag\": null,\n" +
                "                    \"_id\": \"Person/534AD766ED4D0A8283EA0A9115886BB9\",\n" +
                "                    \"name\": \"胡明\",\n" +
                "                    \"object_key\": \"534AD766ED4D0A8283EA0A9115886BB9\",\n" +
                "                    \"utime\": \"2017-05-01\",\n" +
                "                    \"ctime\": \"2017-05-01\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"9\",\n" +
                "                        \"color\": \"#f06292\",\n" +
                "                        \"size\": \"\"\n" +
                "                    },\n" +
                "                    \"_fieldUiConfigs\": [\n" +
                "                        {\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"color\": \"#33FF8A\",\n" +
                "                            \"ruleName\": \"准入客户\",\n" +
                "                            \"coverable\": \"Y\",\n" +
                "                            \"priority\": 0,\n" +
                "                            \"size\": \"NORMAL\",\n" +
                "                            \"style\": \"13\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"edges\": [\n" +
                "                {\n" +
                "                    \"_from\": \"Person/4AFA17AFDF37CA04C9B3841CD312D43F\",\n" +
                "                    \"_to\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"_id\": \"officer/9XX5654944ADEE991715A1D521CM46O0\",\n" +
                "                    \"position\": \"高管\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"\",\n" +
                "                        \"color\": \"\",\n" +
                "                        \"size\": \"\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Person/4AFA17AFDF37CA04C9B3841CD312D43F\",\n" +
                "                    \"_to\": \"company/81dcf84eea186e9c04c18b35bcf13bf5\",\n" +
                "                    \"_id\": \"officer/9XX5654944ADEE991715A1D521CM46O1\",\n" +
                "                    \"position\": \"高管\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"\",\n" +
                "                        \"color\": \"\",\n" +
                "                        \"size\": \"\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"_to\": \"Company/344ae9c5f3862cf40bfd6121112a9c14\",\n" +
                "                    \"_id\": \"invest/TTXJ94944ADEE991715A1D521C6DFL03\",\n" +
                "                    \"invest_amount\": \"投资金额50000000\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"\",\n" +
                "                        \"color\": \"#f44336\",\n" +
                "                        \"size\": \"NORMAL\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"_to\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_id\": \"invest/JFK3L54944ADEE991715A1D521C68308\",\n" +
                "                    \"invest_amount\": \"投资金额80000000\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"\",\n" +
                "                        \"color\": \"#f44336\",\n" +
                "                        \"size\": \"NORMAL\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"_to\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_id\": \"invest/8218245\",\n" +
                "                    \"invest_amount\": \"投资金额800\",\n" +
                "                    \"_uiConfig\": {\n" +
                "                        \"style\": \"\",\n" +
                "                        \"color\": \"1\",\n" +
                "                        \"size\": \"LARGE\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Person/4AFA17AFDF37CA04C9B3841CD312D43F\",\n" +
                "                    \"_to\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_id\": \"officer/DF3L54944ADEE991715A1D521C6903FF\",\n" +
                "                    \"position\": \"高管\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Person/4AFA17AFDF37CA04C9B3841CD312D43F\",\n" +
                "                    \"_to\": \"Company/344ae9c5f3862cf40bfd6121112a9c14\",\n" +
                "                    \"_id\": \"invest/TTXJ94944ADEE991715A1D521C6DFL09\",\n" +
                "                    \"invest_amount\": \"投资\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_to\": \"Company/344ae9c5f3862cf40bfd6121112a9c14\",\n" +
                "                    \"_id\": \"guarantee/87JFL54944ADEE991715A1D521C6DF04\",\n" +
                "                    \"guarantee_type\": \"自然人担保\",\n" +
                "                    \"_detailUrl\": \"https://www.baidu.com/\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Person/15095D14367F7F02655030D498A4BA03\",\n" +
                "                    \"_to\": \"Company/344ae9c5f3862cf40bfd6121112a9c14\",\n" +
                "                    \"_id\": \"guarantee/JFK3L54944ADEE991715A1D521C68310\",\n" +
                "                    \"guarantee_type\": \"公司股东\",\n" +
                "                    \"ctime\": \"2019-08-06\",\n" +
                "                    \"_detailUrl\": \"https://www.baidu.com/\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Person/534AD766ED4D0A8283EA0A9115886BB9\",\n" +
                "                    \"_to\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_id\": \"officer/CCCP254944ADEE991715A1D521C6805D\",\n" +
                "                    \"position\": \"高管\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_to\": \"Person/15095D14367F7F02655030D498A4BA03\",\n" +
                "                    \"_id\": \"guarantee/PO3FL54944ADEE991715A1D521C68343\",\n" +
                "                    \"name\": \"担保\",\n" +
                "                    \"guarantee_type\": \"公司股东\",\n" +
                "                    \"object_key\": \"guarantee/PO3FL54944ADEE991715A1D521C68343\",\n" +
                "                    \"ctime\": \"2019-01-09\",\n" +
                "                    \"utime\": \"2019-09-09\",\n" +
                "                    \"to_key\": \"Person/15095D14367F7F02655030D498A4BA03\",\n" +
                "                    \"from_key\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"_to\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_id\": \"transfer_summary/9XX5654944ADEE991715A1D521CM46O1\",\n" +
                "                    \"content\": \"边详情测试_subRows\",\n" +
                "                    \"_subRows\": [\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3001万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3002万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3003万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3004万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3005万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3006万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3007万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3008万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"3009万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30010万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30011万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30012万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30013万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30014万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30015万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30016万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30017万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30018万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30019万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30020万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30021万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30022万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30023万\",\n" +
                "                            \"time\": \"2017-10-10 00:00:00\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"transfer_amount\": \"30024万美元\",\n" +
                "                            \"time\": \"2019-10-10 00:00:00\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"_from\": \"Company/81dcf84eea186e9c04c18b35bcf13bf6\",\n" +
                "                    \"_to\": \"Company/ed5cf39b0e708cfbe39ec8ea58a42e60\",\n" +
                "                    \"_id\": \"transfer_summary/9XX5654944ADEE991715A1D521CM46O2\",\n" +
                "                    \"content\": \"转账聚合\",\n" +
                "                    \"_detailEdgeUrl\": \"http://10.10.10.32:8081/searchEdgeDetail\",\n" +
                "                    \"_algorithmFilterType\": [\"guarantee\"]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"schemas\": [\n" +
                "                {\n" +
                "                    \"schema\": \"Person\",\n" +
                "                    \"schemaNameCn\": \"自然人\",\n" +
                "                    \"type\": \"VERTEX\",\n" +
                "                    \"displayField\": \"name\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"fieldNameCn\": \"姓名\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"object_key\",\n" +
                "                            \"fieldNameCn\": \"object_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"ctime\",\n" +
                "                            \"fieldNameCn\": \"创建时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"utime\",\n" +
                "                            \"fieldNameCn\": \"更新时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"Company\",\n" +
                "                    \"schemaNameCn\": \"企业\",\n" +
                "                    \"type\": \"VERTEX\",\n" +
                "                    \"displayField\": \"name\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"reg_date\",\n" +
                "                            \"fieldNameCn\": \"注册时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"fieldNameCn\": \"公司名\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"object_key\",\n" +
                "                            \"fieldNameCn\": \"object_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"reg_city\",\n" +
                "                            \"fieldNameCn\": \"注册城市\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"legal_representative\",\n" +
                "                            \"fieldNameCn\": \"法人\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"reg_address\",\n" +
                "                            \"fieldNameCn\": \"注册地址\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"reg_capital\",\n" +
                "                            \"fieldNameCn\": \"注册资本\",\n" +
                "                            \"type\": \"DOUBLE\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"company\",\n" +
                "                    \"schemaNameCn\": \"授权表中没有的公司\",\n" +
                "                    \"type\": \"VERTEX\",\n" +
                "                    \"displayField\": \"name\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"reg_date\",\n" +
                "                            \"fieldNameCn\": \"注册时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"name\",\n" +
                "                            \"fieldNameCn\": \"公司名\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"object_key\",\n" +
                "                            \"fieldNameCn\": \"object_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"reg_city\",\n" +
                "                            \"fieldNameCn\": \"注册城市\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"legal_representative\",\n" +
                "                            \"fieldNameCn\": \"法人\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"reg_address\",\n" +
                "                            \"fieldNameCn\": \"注册地址\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"reg_capital\",\n" +
                "                            \"fieldNameCn\": \"注册资本\",\n" +
                "                            \"type\": \"DOUBLE\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"officer\",\n" +
                "                    \"schemaNameCn\": \"高管\",\n" +
                "                    \"type\": \"EDGE\",\n" +
                "                    \"displayField\": \"position\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"position\",\n" +
                "                            \"fieldNameCn\": \"职位\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"object_key\",\n" +
                "                            \"fieldNameCn\": \"object_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"from_key\",\n" +
                "                            \"fieldNameCn\": \"from_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"to_key\",\n" +
                "                            \"fieldNameCn\": \"to_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"guarantee\",\n" +
                "                    \"schemaNameCn\": \"担保\",\n" +
                "                    \"type\": \"EDGE\",\n" +
                "                    \"displayField\": \"guarantee_type\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"ctime\",\n" +
                "                            \"fieldNameCn\": \"创建时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"guarantee_type\",\n" +
                "                            \"fieldNameCn\": \"担保类型\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"object_key\",\n" +
                "                            \"fieldNameCn\": \"object_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"from_key\",\n" +
                "                            \"fieldNameCn\": \"from_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"to_key\",\n" +
                "                            \"fieldNameCn\": \"to_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"transfer_summary\",\n" +
                "                    \"schemaNameCn\": \"转账汇总\",\n" +
                "                    \"type\": \"EDGE_SUMMARY\",\n" +
                "                    \"displayField\": \"content\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"_subRows.time\",\n" +
                "                            \"fieldNameCn\": \"转账时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"_subRows.transfer\",\n" +
                "                            \"fieldNameCn\": \"转账人\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"_subRows.transfor\",\n" +
                "                            \"fieldNameCn\": \"收款人\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"_subRows.transfer_amount\",\n" +
                "                            \"fieldNameCn\": \"转账金额\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"invest\",\n" +
                "                    \"schemaNameCn\": \"投资\",\n" +
                "                    \"type\": \"EDGE\",\n" +
                "                    \"displayField\": \"invest_amount\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"field\": \"ctime\",\n" +
                "                            \"fieldNameCn\": \"创建时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"utime\",\n" +
                "                            \"fieldNameCn\": \"更新时间\",\n" +
                "                            \"type\": \"DATETIME\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"object_key\",\n" +
                "                            \"fieldNameCn\": \"object_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"from_key\",\n" +
                "                            \"fieldNameCn\": \"from_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"field\": \"to_key\",\n" +
                "                            \"fieldNameCn\": \"to_key\",\n" +
                "                            \"type\": \"STRING\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"uiConfigs\": [\n" +
                "                {\n" +
                "                    \"schema\": \"Company\",\n" +
                "                    \"style\": \"2\",\n" +
                "                    \"color\": \"#2196f3\",\n" +
                "                    \"size\": \"SMALL\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"Person\",\n" +
                "                    \"style\": \"6\",\n" +
                "                    \"color\": \"#9c27b0\",\n" +
                "                    \"size\": \"SMALL\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"officer\",\n" +
                "                    \"style\": \"\",\n" +
                "                    \"color\": \"#7BC2BC\",\n" +
                "                    \"size\": \"SMALL\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"invest\",\n" +
                "                    \"style\": \"\",\n" +
                "                    \"color\": \"#358C85\",\n" +
                "                    \"size\": \"LARGE\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"schema\": \"guarantee\",\n" +
                "                    \"style\": \"\",\n" +
                "                    \"color\": \"#ba68c8\",\n" +
                "                    \"size\": \"SMALL\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"algorithmFilter\": [\n" +
                "                {\n" +
                "                    \"type\": \"guarantee\",\n" +
                "                    \"cName\": \"担保圈\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"type\": \"highRisk\",\n" +
                "                    \"cName\": \"高风险\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
