package com.ly.show.service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ExportUtil {

    /**
     * CSV文件列分隔符
     */

    private static final String CSV_COLUMN_SEPARATOR = ",";

    /**
     * CSV文件列分隔符
     */

    private static final String CSV_RN = "\r\n";

    /**
     * @paramdataList集合数据
     * @paramcolNames表头部数据
     * @parammapKey查找的对应数据
     * @paramresponse返回结果
     */

    public static boolean doExport(List<Map> dataList, String colNames, String mapKey, OutputStream os) {

        try {

            StringBuilder content=new StringBuilder();

//            StringBuffer buf = new StringBuffer();

            String[] colNamesArr = null;

            String[] mapKeyArr = null;

            colNamesArr = colNames.split(",");

            mapKeyArr = mapKey.split(",");

// 完成数据csv文件的封装

// 输出列头

            for (int i = 0; i < colNamesArr.length; i++) {

                content.append(colNamesArr[i]).append(CSV_COLUMN_SEPARATOR);

            }

            content.append(CSV_RN);

            if (null != dataList) {// 输出数据

                for (int i = 0; i < dataList.size(); i++) {

                    for (int j = 0; j < mapKeyArr.length; j++) {

                        content.append("\"" + dataList.get(i).get(mapKeyArr[j]) + "\"").append(CSV_COLUMN_SEPARATOR);

                    }

                    content.append(CSV_RN);

                }

            }

// 写出响应

            os.write(content.toString().getBytes(StandardCharsets.UTF_8));

            os.flush();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    /**
     * @throwsUnsupportedEncodingException setHeader
     */

    public static void responseSetProperties(String fileName, HttpServletResponse response) throws UnsupportedEncodingException{

// 设置文件后缀
        String fn = fileName + ".csv";
// 读取字符编码
        String utf = "UTF-8";

// 设置响应

        response.setContentType("application/ms-txt.numberformat:@");

        response.setCharacterEncoding(utf);

        response.setHeader("Pragma", "public");

        response.setHeader("Cache-Control", "max-age=30");

        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fn, utf));

    }
}
