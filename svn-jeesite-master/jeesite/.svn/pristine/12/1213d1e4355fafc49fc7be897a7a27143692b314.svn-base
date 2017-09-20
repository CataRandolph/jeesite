package com.thinkgem.jeesite.modules.act.entity;






import net.sf.json.JSONArray;

import java.util.List;

/**
 * @文件名:excelReport.java
 * @功能描述：
 * @创建日期:2017年3月31日下午4:30:27
 * @创建人：duanshxi
 * @Copyright（c） 2017,all rights reserved by days
 */
public class ExcelReport {

    private String fileName; // 文件名

    private String suffix = ".xls"; // 文件后缀,默认为.xls

    private boolean sheet = false; // 默认为false,true 爲多sheet操作

    private String[] totalCountAttrs; // 总计的属性

    private String process; // prop 道具业务

    private String[] header; // 标题头

    private String[] attrs; // header的对应属性名称。

    private JSONArray data; // 数据

    private String title;

    private String checkAttr; // 要查询的属性

    private int columnNo = -1; // 要查询属性对应的单元格下标

    private int headerType = 0; // header的类型。1为复杂型，0或者空位简单型

    private List<ExcelReport> list; // 多sheet的时候使用list传值

    public ExcelReport() {
        super();
    }

    /**
     * 创建文件基础的构造，//默认为.xls,简单表头，通用型
     */
    public ExcelReport(String[] header, String[] attrs, JSONArray data, String fileName, String title) {
        super();
        this.header = header;
        this.attrs = attrs;
        this.data = data;
        this.fileName = fileName;
        this.title = title;
    }

    /**
     * 替換文件,默认文件类型.xls
     *
     * @param attrs
     * @param data
     * @param fileName
     * @param title
     * @param checkAttr//按照那个属性去替换，
     * @param columnNo//属性多对应的下标
     */
    public ExcelReport(String[] attrs, JSONArray data, String fileName, String title, String checkAttr, int columnNo) {
        super();
        this.attrs = attrs;
        this.data = data;
        this.fileName = fileName;
        this.title = title;
        this.checkAttr = checkAttr;
        this.columnNo = columnNo;
    }


    /**
     * 修改追加文件,默认文件类型.xls
     * @param attrs
     * @param data
     * @param fileName
     * @param title
     */
    public ExcelReport(String[] attrs, JSONArray data, String fileName, String title) {
        super();
        this.attrs = attrs;
        this.data = data;
        this.fileName = fileName;
        this.title = title;
    }

    /**
     * Creates many sheet excel
     *
     * @param fileName //文件名
     * @param suffix //后缀，默认为.xls
     * @param sheet // 多sheet的判断
     * @param list //多个sheet的数据礼盒
     */
    public ExcelReport(String fileName, String suffix, boolean sheet, List<ExcelReport> list) {
        super();
        this.fileName = fileName;
        this.suffix = suffix;
        this.sheet = sheet;
        this.list = list;
    }

    public String[] getAttrs() {
        return attrs;
    }

    public void setAttrs(String[] attrs) {
        this.attrs = attrs;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCheckAttr() {
        return checkAttr;
    }

    public void setCheckAttr(String checkAttr) {
        this.checkAttr = checkAttr;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int getHeaderType() {
        return headerType;
    }

    public void setHeaderType(int headerType) {
        this.headerType = headerType;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public boolean getSheet() {
        return sheet;
    }

    public void setSheet(boolean sheet) {
        this.sheet = sheet;
    }

    public List<ExcelReport> getList() {
        return list;
    }

    public void setList(List<ExcelReport> list) {
        this.list = list;
    }

    public String[] getTotalCountAttrs() {
        return totalCountAttrs;
    }

    public void setTotalCountAttrs(String[] totalCountAttrs) {
        this.totalCountAttrs = totalCountAttrs;
    }

}
