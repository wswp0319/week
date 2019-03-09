package com.wp.week.base.generate;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自动生成MyBatis的实体类、实体映射XML文件、Mapper、Service、ServiceImpl、Controller
 *
 * @author wp
 * @version v1.0
 * @date 2018-12-15
 */
@SuppressWarnings("hiding")
public class EntityUtil {
    /**
     * *********************************使用前必读*******************
     * *
     * * 使用前请将moduleName更改为自己模块的名称即可（一般情况下与数据库名一致），其他无须改动。
     * *
     * **********************************************************
     */
    private final String type_char = "char";
    private final String type_date = "date";
    private final String type_timestamp = "timestamp";
    private final String type_int = "int";
    private final String type_bigint = "bigint";
    private final String type_text = "text";
    private final String type_bit = "bit";
    private final String type_decimal = "decimal";
    private final String type_blob = "blob";
    private final String type_double = "double";
    private final String type_time = "time";


    private final String bean_path = "D:";
    private final String mapper_path = "D:";
    private final String xml_path = "D:";

    private final String service_path = "D:";
    private final String service_impl_path = "D:";
    private final String controller_path = "D:";

    private final String bean_package = "com.demo.domain";
    private final String mapper_package = "com.demo.mapper";
    private final String service_package = "com.demo.service";
    private final String service_impl_package = "com.demo.service";
    private final String controller_package = "com.demo.controller";

    //库名
    private final String moduleName = "girl"; // 对应模块名称（根据自己模块做相应调整!!!务必修改^_^）
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "admin";
    private final String url = "jdbc:mysql://127.0.0.1:3306/" + moduleName + "?characterEncoding=utf8";


    private String tableName = null;
    private String beanName = null;
    private String mapperName = null;
    private Connection conn = null;


    public static void main(String[] args) {
        try {
            //customizeTables有值，生成指定表，否则生成全库的表
            List<String> customizeTables = new ArrayList<>();
            customizeTables.add("tb_daily");
            new EntityUtil().generate(customizeTables);

            //自动打开生成文件的目录
            // Runtime.getRuntime().exec("cmd /c start explorer D:\\");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate(List customizeTables) throws ClassNotFoundException, SQLException, IOException {
        init();
        String prefix = "show full fields from ";
        List<String> columns = null;
        List<String> types = null;
        List<String> comments = null;
        PreparedStatement pstate = null;
        List<String> tables = null;
        if (customizeTables.size() == 0) {
            tables = getTables();
        } else {
            tables = customizeTables;
        }

        Map<String, String> tableComments = getTableComment();
        for (String table : tables) {
            columns = new ArrayList<String>();
            types = new ArrayList<String>();
            comments = new ArrayList<String>();
            pstate = conn.prepareStatement(prefix + table);
            ResultSet results = pstate.executeQuery();
            while (results.next()) {
                columns.add(results.getString("FIELD"));
                types.add(results.getString("TYPE"));
                comments.add(results.getString("COMMENT"));
            }
            tableName = table;
            processTable(table);
            //          this.outputBaseBean();
            String tableComment = tableComments.get(tableName);
            buildEntityBean(columns, types, comments, tableComment);
            buildMapper();
            buildMapperXml(columns, types, comments);
            buildService();
            buildServiceImpl();
            buildController();
        }
        conn.close();
    }

    private void init() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
    }

    /**
     * 获取所有的表
     *
     * @return
     * @throws SQLException
     */
    private List<String> getTables() throws SQLException {
        List<String> tables = new ArrayList<String>();
        PreparedStatement pstate = conn.prepareStatement("show tables");
        ResultSet results = pstate.executeQuery();
        while (results.next()) {
            String tableName = results.getString(1);
            //          if ( tableName.toLowerCase().startsWith("yy_") ) {
            tables.add(tableName);
            //          }
        }
        return tables;
    }

    private void processTable(String table) {
        StringBuffer sb = new StringBuffer(table.length());
        String tableNew = table.toLowerCase();
        String[] tables = tableNew.split("_");
        String temp = null;
        for (int i = 1; i < tables.length; i++) {
            temp = tables[i].trim();
            sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
        }
        beanName = sb.toString();
        mapperName = beanName + "Mapper";
    }

    private String processType(String type) {
        if (type.indexOf(type_char) > -1) {
            return "String";
        } else if (type.indexOf(type_bigint) > -1) {
            return "Long";
        } else if (type.indexOf(type_int) > -1) {
            return "Integer";
        } else if (type.indexOf(type_date) > -1) {
            return "java.util.Date";
        } else if (type.indexOf(type_text) > -1) {
            return "String";
        } else if (type.indexOf(type_timestamp) > -1) {
            return "java.util.Date";
        } else if (type.indexOf(type_bit) > -1) {
            return "Boolean";
        } else if (type.indexOf(type_decimal) > -1) {
            return "java.math.BigDecimal";
        } else if (type.indexOf(type_blob) > -1) {
            return "byte[]";
        } else if (type.indexOf(type_double) > -1) {
            return "Double";
        } else if (type.indexOf(type_time) > -1) {
            return "String";
        }
        return null;
    }

    private String processField(String field) {
        StringBuffer sb = new StringBuffer(field.length());
        //field = field.toLowerCase();
        String[] fields = field.split("_");
        String temp = null;
        sb.append(fields[0]);
        for (int i = 1; i < fields.length; i++) {
            temp = fields[i].trim();
            sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
        }
        return sb.toString();
    }

    /**
     * 将实体类名首字母改为小写
     *
     * @param beanName
     * @return
     */
    private String processResultMapId(String beanName) {
        return beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
    }

    /**
     * 构建类上面的注释
     *
     * @param bw
     * @param text
     * @return
     * @throws IOException
     */
    private BufferedWriter buildClassComment(BufferedWriter bw, String text) throws IOException {
        bw.newLine();
        bw.write("/**");
        bw.newLine();
        bw.write(" * ");
        bw.newLine();
        bw.write(" * " + text);
        bw.newLine();
        bw.write(" * ");
        bw.newLine();
        bw.write(" **/");
        return bw;
    }

    /**
     * 构建方法上面的注释
     *
     * @param bw
     * @param text
     * @return
     * @throws IOException
     */
    private BufferedWriter buildMethodComment(BufferedWriter bw, String text) throws IOException {
        bw.newLine();
        bw.write("\t/**");
        bw.newLine();
        bw.write("\t * ");
        bw.newLine();
        bw.write("\t * " + text);
        bw.newLine();
        bw.write("\t * ");
        bw.newLine();
        bw.write("\t **/");
        return bw;
    }

    /**
     * 生成实体类
     *
     * @param columns
     * @param types
     * @param comments
     * @throws IOException
     */
    private void buildEntityBean(List<String> columns, List<String> types, List<String> comments, String tableComment)
            throws IOException {
        File folder = new File(bean_path);
        if (!folder.exists()) {
            folder.mkdir();
        }

        File beanFile = new File(bean_path, beanName + "Dto.java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile)));
        bw.write("package " + bean_package + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import java.io.Serializable;");
        bw.newLine();
        //bw.write("import lombok.Data;");
        //      bw.write("import javax.persistence.Entity;");
        bw = buildClassComment(bw, tableComment);
        bw.newLine();
        bw.write("@SuppressWarnings(\"serial\")");
        bw.newLine();
        //      bw.write("@Entity");
        //bw.write("@Data");
        //bw.newLine();
        bw.write("public class " + beanName + "Dto implements Serializable {");
        bw.newLine();
        bw.newLine();
        int size = columns.size();
        for (int i = 0; i < size; i++) {
            bw.write("\t/**" + comments.get(i) + "**/");
            bw.newLine();
            bw.write("\tprivate " + processType(types.get(i)) + " " + processField(columns.get(i)) + ";");
            bw.newLine();
            bw.newLine();
        }
        // 生成get 和 set方法
        String tempField = null;
        String _tempField = null;
        String tempType = null;
        for (int i = 0; i < size; i++) {
            tempType = processType(types.get(i));
            _tempField = processField(columns.get(i));
            tempField = _tempField.substring(0, 1).toUpperCase() + _tempField.substring(1);
            bw.newLine();
            //          bw.write("\tpublic void set" + tempField + "(" + tempType + " _" + _tempField + "){");
            bw.write("\tpublic void set" + tempField + "(" + tempType + " " + _tempField + "){");
            bw.newLine();
            //          bw.write("\t\tthis." + _tempField + "=_" + _tempField + ";");
            bw.write("\t\tthis." + _tempField + " = " + _tempField + ";");
            bw.newLine();
            bw.write("\t}");
            bw.newLine();
            bw.newLine();
            bw.write("\tpublic " + tempType + " get" + tempField + "(){");
            bw.newLine();
            bw.write("\t\treturn this." + _tempField + ";");
            bw.newLine();
            bw.write("\t}");
            bw.newLine();
        }
        bw.newLine();
        bw.write("}");
        bw.newLine();
        bw.flush();
        bw.close();
    }

    /**
     * 构建Mapper文件
     *
     * @throws IOException
     */
    private void buildMapper() throws IOException {
        File folder = new File(mapper_path);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File mapperFile = new File(mapper_path, mapperName + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
        bw.write("package " + mapper_package + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import com.jm.base.IMapper;");
        bw.newLine();
        bw.write("import " + bean_package + "." + beanName + "Dto;");
        bw.newLine();
        bw.write("import org.springframework.stereotype.Repository;");
        bw.newLine();
        bw = buildClassComment(bw, mapperName + "数据库操作接口类");
        bw.newLine();
        bw.write("@Repository");
        bw.newLine();
        //      bw.write("public interface " + mapperName + " extends " + mapper_extends + "<" + beanName + "> {");
        bw.write("public interface " + mapperName + "<T extends " + mapperName.replaceAll("Mapper", "") + "Dto" + "> extends IMapper<T> {");
        bw.newLine();

        // ----------定义Mapper中的方法End----------
        bw.newLine();
        bw.write("}");
        bw.flush();
        bw.close();
    }
    /**
     * 构建Controller文件
     *
     * @throws IOException
     */
    private void buildController() throws IOException {
        File folder = new File(controller_path);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File mapperFile = new File(controller_path, mapperName.replace("Mapper", "Controller") + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
        bw.write("package " + controller_package + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import com.jm.base.AjaxList;");
        bw.newLine();
        bw.write("import org.springframework.stereotype.Controller;");
        bw.newLine();
        bw.write("import org.springframework.web.bind.annotation.RequestMapping;");
        bw.newLine();
        bw.write("import org.springframework.web.bind.annotation.ResponseBody;");
        bw.newLine();
        bw.write("import javax.servlet.http.HttpServletRequest;");
        bw.newLine();
        bw.newLine();

       bw.write("@Controller");
        bw.newLine();
        bw.write("@RequestMapping(value = \"rul\")");

        bw.newLine();
        //      bw.write("public interface " + mapperName + " extends " + mapper_extends + "<" + beanName + "> {");
        bw.write("public class " + mapperName.replace("Mapper", "Controller") +" {");
        bw.newLine();
        bw.newLine();
        bw.write("\t");
        bw.write("@RequestMapping(value = \"subUrl\")");
        bw.newLine();
        bw.write("\t");
        bw.write("@ResponseBody");
        bw.newLine();
        bw.write("\t");
        bw.write("public AjaxList methodName(HttpServletRequest request) {");
        bw.newLine();
        bw.newLine();
        bw.write("\t");
        bw.write("\t");
        bw.write("return null;");
        bw.newLine();
        bw.write("\t");
        bw.write("}");
        // ----------定义Mapper中的方法End----------
        bw.newLine();
        bw.write("}");
        bw.flush();
        bw.close();
    }
    /**
     * 构建Service文件
     *
     * @throws IOException
     */
    private void buildService() throws IOException {
        File folder = new File(service_path);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File mapperFile = new File(service_path, mapperName.replace("Mapper", "Service") + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
        bw.write("package " + service_package + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import com.jm.base.service.BaseService;");
        bw.newLine();
        bw.write("import " + bean_package + "." + beanName + "Dto;");
        bw.newLine();
        bw.newLine();
        //      bw.write("public interface " + mapperName + " extends " + mapper_extends + "<" + beanName + "> {");
        bw.write("public interface " + mapperName.replace("Mapper", "Service") + " extends BaseService<" + mapperName.replaceAll("Mapper", "") + "Dto" + "> {");
        bw.newLine();

        // ----------定义Mapper中的方法End----------
        bw.newLine();
        bw.write("}");
        bw.flush();
        bw.close();
    }

    /**
     * 构建ServiceImpl文件
     *
     * @throws IOException
     */
    private void buildServiceImpl() throws IOException {
        File folder = new File(service_impl_path);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File mapperFile = new File(service_impl_path, mapperName.replace("Mapper", "Service") + "Impl" + ".java");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
        bw.write("package " + service_impl_package + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import com.jm.base.IMapper;");
        bw.newLine();
        bw.write("import com.jm.base.service.impl.BaseServiceImpl;");
        bw.newLine();
        bw.write("import " + bean_package + "." + beanName + "Dto;");
        bw.newLine();
        bw.write("import " + mapper_package + "." + beanName + "Mapper;");
        bw.newLine();
        bw.write("import org.springframework.beans.factory.annotation.Autowired;");
        bw.newLine();
        bw.write("import org.springframework.stereotype.Service;");
        bw.newLine();
        bw.newLine();
        bw.write("@Service");
        bw.newLine();
        //      bw.write("public interface " + mapperName + " extends " + mapper_extends + "<" + beanName + "> {");
        bw.write("public class " + mapperName.replace("Mapper", "ServiceImpl") + " extends BaseServiceImpl<" + mapperName.replaceAll("Mapper", "") + "Dto" + "> implements " + mapperName.replace("Mapper", "Service") + " {");
        bw.newLine();

        // ----------定义Mapper中的方法End----------
        bw.newLine();
        bw.write("\t");
        bw.write("@Autowired");
        bw.newLine();
        bw.write("\t");
        bw.write("private " + mapperName + "<" + mapperName.replaceAll("Mapper", "") + "Dto" + "> " + lowerFristCase(mapperName) + ";");
        bw.newLine();
        bw.newLine();
        bw.write("\t");
        bw.write("@Override");
        bw.newLine();
        bw.write("\t");
        bw.write("public IMapper<" + mapperName.replaceAll("Mapper", "") + "Dto" + "> getMapper() {");
        bw.newLine();
        bw.write("\t");
        bw.write("\t");
        bw.write("return " + lowerFristCase(mapperName) + ";");
        bw.newLine();
        bw.write("\t");
        bw.write("}");
        bw.newLine();
        bw.newLine();

        bw.write("}");
        bw.flush();
        bw.close();
    }

    private String lowerFristCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


    /**
     * 构建实体类映射XML文件
     *
     * @param columns
     * @param types
     * @param comments
     * @throws IOException
     */
    private void buildMapperXml(List<String> columns, List<String> types, List<String> comments) throws IOException {
        File folder = new File(xml_path);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File mapperXmlFile = new File(xml_path, mapperName + ".xml");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperXmlFile)));
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        bw.newLine();
        bw.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" ");
        bw.newLine();
        bw.write("    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        bw.newLine();
        bw.write("<mapper namespace=\"" + mapper_package + "." + mapperName + "\">");
        bw.newLine();
        bw.newLine();

        buildSQL(bw, columns, types);
        bw.write("</mapper>");
        bw.flush();
        bw.close();
    }

    private void buildSQL(BufferedWriter bw, List<String> columns, List<String> types) throws IOException {
        StringBuilder sb = new StringBuilder();

        int size = columns.size();
        // 通用结果列
        bw.write("\t<!-- 字段-->");

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(columns.get(i));
            } else {
                sb.append(columns.get(i) + ",");
            }
        }

        bw.newLine();
        // 查询（根据主键ID查询）
        bw.write("\t<!-- 查询（根据主键ID查询） -->");
        bw.newLine();
        bw.write("\t<select id=\"selInfo\" resultType=\""
                + bean_package + "." + beanName + "Dto" + "\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t <include refid=\"sqlColumns\" />");
        bw.newLine();
        bw.write("\t\t FROM " + tableName);
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</select>");
        bw.newLine();
        bw.newLine();
        // 查询完
        // 删除（根据主键ID删除）
        bw.write("\t<!--删除：根据主键ID删除-->");
        bw.newLine();
        bw.write("\t<delete id=\"del\" parameterType=\"" + bean_package + "." + beanName + "Dto" + "\">");
        bw.newLine();
        bw.write("\t\t DELETE FROM " + tableName);
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</delete>");
        bw.newLine();
        bw.newLine();
        // 删除完
        // 添加insert方法
        bw.write("\t<!-- 添加 -->");
        bw.newLine();
        bw.write("\t<insert id=\"add\" parameterType=\"" + bean_package + "." + beanName + "Dto" + "\" keyColumn=\"" + processField(columns.get(0)) + "\" useGeneratedKeys=\"true" + "\">");
        bw.newLine();
        bw.write("\t\t INSERT INTO " + tableName);
        bw.newLine();
        bw.write(" \t\t\t(");
        bw.newLine();
        bw.write(" \t\t\t");
        for (int i = 0; i < size; i++) {
            bw.write(columns.get(i));
            if (i != size - 1) {
                bw.write(",");
                bw.newLine();
                bw.write("\t\t\t");
            }
        }
        bw.newLine();
        bw.write(" \t\t\t");
        bw.write(") ");
        bw.newLine();
        bw.write("\t\t VALUES ");
        bw.newLine();
        bw.write(" \t\t\t(");
        bw.newLine();
        bw.write(" \t\t\t");
        for (int i = 0; i < size; i++) {
            bw.write("#{" + processField(columns.get(i)) + "}");
            if (i != size - 1) {
                bw.write(",");
                bw.newLine();
                bw.write("\t\t\t");
            }
        }
        bw.newLine();
        bw.write(" \t\t\t");
        bw.write(") ");
        bw.newLine();
        bw.write("\t</insert>");
        bw.newLine();
        bw.newLine();

        // 修改update方法
        bw.write("\t<!-- 修 改-->");
        bw.newLine();
        bw.write("\t<update id=\"edit\" parameterType=\"" + bean_package + "." + beanName + "Dto" + "\">");
        bw.newLine();
        bw.write("\t\t UPDATE " + tableName);
        bw.newLine();
        bw.write("\t\t");
        bw.write("<trim prefix=\"SET\" suffixOverrides=\",\"> ");
        bw.newLine();
        String tempField = null;
        for (int i = 1; i < size; i++) {
            tempField = processField(columns.get(i));
            bw.write("\t\t\t<if test=\"" + tempField + " != null\">");
            bw.write("" + columns.get(i) + " = #{" + tempField + "},");
            bw.write("</if>");
            if (i != size - 1) {
                bw.newLine();
            }
        }
        bw.newLine();
        bw.write("\t\t");
        bw.write("</trim>");
        bw.newLine();
        bw.write("\t\t WHERE " + columns.get(0) + " = #{" + processField(columns.get(0)) + "}");
        bw.newLine();
        bw.write("\t</update>");
        bw.newLine();

        bw.newLine();

        try {
            System.err.println(sb.toString());
            generateSqlColumns(bw, sb.toString());
            bw.newLine();
            bw.newLine();
            bw.write("\t<!-- 条件-->");
            bw.newLine();
            generateSqlWhere(bw, sb.toString());
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bw.newLine();
        bw.write("\t<select id=\"count\" resultType=\""
                + "int" + "\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t count(" + processField(columns.get(0)) + ")");
        bw.newLine();
        bw.write("\t\t FROM " + tableName);
        bw.newLine();
        bw.write("\t\t <include refid=\"sqlWhere\"/>");
        bw.newLine();
        bw.write("\t</select>");

        bw.newLine();
        bw.newLine();
        bw.write("\t<select id=\"list\" resultType=\""
                + bean_package + "." + beanName + "Dto" + "\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t <include refid=\"sqlColumns\"/>");
        bw.newLine();
        bw.write("\t\t FROM " + tableName);
        bw.newLine();
        bw.write("\t\t <include refid=\"sqlWhere\"/>");
        bw.newLine();
        bw.write("\t</select>");


        bw.newLine();
        bw.newLine();
        bw.write("\t<select id=\"queryPage\" resultType=\""
                + bean_package + "." + beanName + "Dto" + "\">");
        bw.newLine();
        bw.write("\t\t SELECT");
        bw.newLine();
        bw.write("\t\t <include refid=\"sqlColumns\"/>");
        bw.newLine();
        bw.write("\t\t FROM " + tableName);
        bw.newLine();
        bw.write("\t\t <include refid=\"sqlWhere\"/>");
        bw.newLine();
        bw.write("\t</select>");
        bw.newLine();
        bw.newLine();
    }

    /**
     * 获取所有的数据库表注释
     *
     * @return
     * @throws SQLException
     */
    private Map<String, String> getTableComment() throws SQLException {
        Map<String, String> maps = new HashMap<String, String>();
        PreparedStatement pstate = conn.prepareStatement("show table status");
        ResultSet results = pstate.executeQuery();
        while (results.next()) {
            String tableName = results.getString("NAME");
            String comment = results.getString("COMMENT");
            maps.put(tableName, comment);
        }
        return maps;
    }

    private static void generateSqlWhere(BufferedWriter bw, String sqlStr) throws Exception {
        String sqlColumnStr = sqlStr.replaceAll(" ", "");
        String[] sqlColumnsStrs = sqlColumnStr.split(",");

        bw.write("\t<sql id=\"sqlWhere\">" + "\r\n" + "    \t<where>");
        int length = sqlColumnsStrs.length;

        bw.newLine();
        bw.write("\t");
        for (int y = 0; y < length; y++) {
            String[] split = sqlColumnsStrs[y].split("_");
            StringBuilder temp = new StringBuilder();
            spliceStr(split, temp);
            bw.write("    \t<if test=\"" + split[0] + temp + " != null\">" + " and " + sqlColumnsStrs[y] + " = #{" + split[0] + temp + "}</if>" + " \r\n" + "    ");
        }
        bw.write("\t</where>");
        bw.newLine();
        bw.write("\t" + "</sql>");
    }

    private static void generateSqlColumns(BufferedWriter bw, String sqlStr) throws Exception {
        String sqlColumnStr = sqlStr.replaceAll(" ", "");
        String[] sqlColumnsStrs = sqlColumnStr.split(",");

        bw.write("\t<sql id=\"sqlColumns\">" + "\r\n" + "    ");
        int length = sqlColumnsStrs.length;

        for (int y = 0; y < length; y++) {
            String[] split = sqlColumnsStrs[y].split("_");
            StringBuilder temp = new StringBuilder();
            spliceStr(split, temp);
            if (y == length - 1) {
                bw.write("\t" + sqlColumnsStrs[y] + " " + split[0] + temp + "    ");
                bw.newLine();
                bw.write("\t" + "</sql>");
            } else {
                bw.write("\t" + sqlColumnsStrs[y] + " " + split[0] + temp + ", \r\n" + "    ");
            }
        }
    }


    private static void spliceStr(String[] split, StringBuilder temp) {
        for (int x = 0; x < split.length; x++) {
            if (x == 0) {
                continue;
            }
            char[] chars = split[x].toCharArray();
            chars[0] -= 32;
            String s = String.valueOf(chars);
            temp.append(s);
        }
    }
}