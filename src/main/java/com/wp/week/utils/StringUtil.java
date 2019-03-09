package com.wp.week.utils;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final String[] BROWSER_TYPE = new String[]{"MSIE 6.0", "MSIE 7.0", "MSIE 8.0", "MSIE 9.0", "MSIE 10.0", "Maxthon", "QQBrowser", "GreenBrowser", "360SE", "Firefox", "Opera", "Chrome", "Safari"};

    public StringUtil() {
    }

    public static String subStrEllipsis(String str, int len) {
        if (isNotEmpty(str)) {
            return str.length() > len ? str.substring(0, len) + ".." : str;
        } else {
            return "";
        }
    }

    public static String replaceStr(String target, String chars, int len) {
        if (len != 0) {
            target = subStrEllipsis(target, len);
        }

        return isNotEmpty(target) ? target.replaceAll(chars, "<font color='red'>" + chars + "</font>") : "";
    }

    public static List<String> getImg(String s) {
        List<String> list = new ArrayList();
        String regex = "src=\"(.*?)\"";
        Pattern pa = Pattern.compile(regex, 32);
        Matcher ma = pa.matcher(s);

        while(ma.find()) {
            list.add(ma.group());
        }

        return list;
    }

    public static List getImagePath(String htmlStr) {
        String img = "";
        List pics = new ArrayList();
        String regEx_img = "<img.*src=(.*?)[^>]*?>";
        Pattern p_image = Pattern.compile(regEx_img, 2);
        Matcher m_image = p_image.matcher(htmlStr);

        while(m_image.find()) {
            img = m_image.group();
            Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img);

            while(m.find()) {
                pics.add(m.group(1));
            }
        }

        return pics;
    }

    public static String getFirstImagePath(String htmlStr) {
        String img = "";
        String pic = "";
        String regEx_img = "<img.*src=(.*?)[^>]*?>";
        Pattern p_image = Pattern.compile(regEx_img, 2);
        Matcher m_image = p_image.matcher(htmlStr);

        while(m_image.find()) {
            img = m_image.group();
            Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img);
            if (m.find()) {
                pic = m.group(1);
            }

            if (isNotEmpty(pic)) {
                break;
            }
        }

        return pic;
    }

    public static String getBrowseType(HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT");
        String[] arr$ = BROWSER_TYPE;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String type = arr$[i$];
            if (userAgent.indexOf(type) != -1) {
                return type;
            }
        }

        if (userAgent.indexOf("Gecko") > 0 && userAgent.indexOf("rv:11") > 0) {
            return "MSIE 11.0";
        } else {
            return userAgent;
        }
    }

    public static Boolean checkMobile(String mobileNumber) {
        if (mobileNumber.length() != 11) {
            return false;
        } else {
            Pattern mobileExp = Pattern.compile("^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|70)\\d{8}$");
            Pattern cmExp = Pattern.compile("(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)");
            Pattern cuExp = Pattern.compile("(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)");
            Pattern ctExp = Pattern.compile("(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)");
            Matcher matcher1 = mobileExp.matcher(mobileNumber);
            Matcher matcher2 = cmExp.matcher(mobileNumber);
            Matcher matcher3 = cuExp.matcher(mobileNumber);
            Matcher matcher4 = ctExp.matcher(mobileNumber);
            return !matcher1.matches() && !matcher2.matches() && !matcher3.matches() && !matcher4.matches() ? false : true;
        }
    }

    public static String escapeParam(String param) {
        param = param.replaceAll("%", "/%");
        param = param.replaceAll("_", "/_");
        return param;
    }



    public static boolean isEmpty(String str) {
        return null == str || "".equals(str.trim()) || "null".equals(str.trim());
    }

    public static boolean isNull(Object obj) {
        return null == obj;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static String firstCharToUpper(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String empty(String str) {
        return null == str ? "" : str;
    }

    public static String emptyIsZero(String str) {
        return null != str && !"".equals(str) ? str : "0";
    }

    public String firstCharUpper(String str) {
        return null != str && str.trim().length() != 0 ? str.substring(0, 1).toUpperCase() + str.substring(1) : "";
    }

    public static Integer isInteger(String val) {
        return Integer.parseInt(val);
    }

    public static Integer getIntegerOfObject(Object object) {
        String str = String.valueOf(object);
        return isNotEmpty(str) ? Integer.parseInt(str) : 0;
    }

    public static String converTemplate(String content, String... args) {
        for(int i = 1; i <= args.length; ++i) {
            String target = "\\{" + i + "\\}";
            content = content.replaceAll(target, args[i]);
        }

        return content;
    }

    public static String buildUUID() {
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }

    public static String escapeHtmlTag(String content, int length) {
        if (isNotEmpty(content)) {
            content = content.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "").replaceAll("</[a-zA-Z]+[1-9]?[^><]*>", "");
            if (length == 0) {
                return content;
            } else {
                if (content.length() > length) {
                    content = content.substring(0, length) + "..";
                }

                return content;
            }
        } else {
            return "";
        }
    }


    public static String chooseTwo(boolean result, String str1, String str2) {
        return result ? str1 : str2;
    }

}
