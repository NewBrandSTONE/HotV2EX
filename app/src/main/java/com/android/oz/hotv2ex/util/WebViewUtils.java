package com.android.oz.hotv2ex.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author O.z Young
 * @date 16/9/21
 * @desc WebView相关的工具类
 */

public class WebViewUtils {
    /**
     * @param htmlContent 原来的html
     * @return 改变img标签宽度以后的html
     */
    public static String changeImgWidth(String htmlContent) {
        Document doc_Dis = Jsoup.parse(htmlContent);
        Elements ele_Img = doc_Dis.getElementsByTag("img");
        if (ele_Img.size() != 0) {
            for (Element e_Img : ele_Img) {
                e_Img.attr("style", "width:100%");
            }
        }
        String newHtmlContent = doc_Dis.toString();
        return newHtmlContent;
    }

}
