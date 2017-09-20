package com.thinkgem.jeesite.common.utils;



import com.thinkgem.jeesite.modules.act.entity.ExcelReport;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @文件名:excelUtil.java 
 * @功能描述：
 * @创建日期:2017年3月30日上午9:54:36 
 * @创建人：Duanshxi
 * @Copyright（c） 2017,all rights reserved by days 
 */
@Component("excelUtil")
public class ExcelUtil
{
	/***
	 * 
	 * @方法功能描述： 创建excel，可以单独使用
	 * @param excelReport
	 * @throws IOException 
	 * void
	 * @author duanshixi
	 * @创建时间： 2017年4月5日上午10:48:41
	 */
	public static void GenerateExcel(ExcelReport excelReport,String path) throws IOException{
	  	  try {
	  		    FileOutputStream fileOut;
				Workbook wb=null;
				if(excelReport.getSuffix().equals(".xls")){
					wb= new HSSFWorkbook();
				}
				if(excelReport.getSuffix().equals(".xlsx")){
					wb= new XSSFWorkbook();
				}
				GenerateManySheet(excelReport,wb);
				//生成excel
				fileOut = new FileOutputStream(path+excelReport.getFileName()+excelReport.getSuffix());
				wb.write(fileOut);
				fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	/***
	 * 
	 * @方法功能描述：扩展功能 创建excel，创建sheet
	 * @param excelReport
	 * @throws IOException 
	 * void
	 * @author duanshixi
	 * @创建时间： 2017年4月5日上午10:48:41
	 */
	private static void GenerateManySheet(ExcelReport excelReport,Workbook wb) throws IOException{
	  	  try {
	  		 List<ExcelReport> excelReports=new ArrayList<ExcelReport>();
	  		  if(!excelReport.getSheet()){excelReports.add(excelReport);
	  		    }else{
	  		    excelReports=excelReport.getList();
	  		    }
			  for (int sheeti = 0; sheeti < excelReports.size(); sheeti++) {
				ExcelReport excel=excelReports.get(sheeti);
				//创建工作表
				Sheet sheet = wb.createSheet(excel.getTitle());
				//表头样式
				CellStyle headerStyle=headerStyle(wb);
				//主体样式
				CellStyle bodyStyle=bodyStyle(wb);
				//设置title
				exportTitle(sheet,excel.getTitle(),headerStyle);
				//设置表头
				exportHeader(sheet,excel.getHeader(),headerStyle,excel.getHeaderType());
				//首先把字符串转成 JSONArray 对象
				JSONArray json =excel.getData();
				//业务
              if("prop".equals(excel.getProcess())){
                  propReport(excel,sheet,bodyStyle);
              }else{
                  int rowNum=sheet.getLastRowNum();
                  for (int i = 1; i <=json.size(); i++) {
                      Row row = sheet.createRow(i +rowNum );
                      row.setHeight((short) (20 * 20)); // 设置行高 基数为20
                      setExcelCell(row,json.getJSONObject(i-1),excel.getAttrs(),bodyStyle);
                  }
               }
			 }
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	/***
	 * 
	 * @方法功能描述：扩展功能 创建excel，创建sheet
	 * @param excelReport
	 * @throws IOException 
	 * void
	 * @author duanshixi
	 * @创建时间： 2017年4月5日上午10:48:41
	 */
	public void CreateManySheet(ExcelReport excelReport) throws IOException{
    		//如果文件不存在则从新生成,否则进行替换或者追加
		String path="";
    		String fileName=getFileAddress(excelReport.getFileName(),excelReport.getSuffix());
	  	  try {
	    		if (fileName==null){
	    			GenerateExcel(excelReport,path);
	    		}else{
		    		Workbook workbook =queryFileSuffix(fileName,excelReport.getSuffix());
		    		CellStyle bodyStyle= bodyStyle(workbook);
		    		GenerateManySheet(excelReport,workbook);
		    		closeFileStream(fileName,workbook);	
	    		}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	/**
	 * 
	 * @方法功能描述：创建，追加，替换
	 * @param excelReport 参数
	 * @throws IOException 
	 * void
	 * @author duanshixi
	 * @创建时间： 2017年4月5日下午2:20:27
	 */
	public void replaceData(ExcelReport excelReport) throws Exception {

		try {
			//如果文件不存在则从新生成,否则进行替换或者追加
			String fileName=getFileAddress(excelReport.getFileName(),excelReport.getSuffix());
			String path="";
			if (fileName==null){
				GenerateExcel(excelReport,path);
			}else{
			Workbook workbook =queryFileSuffix(fileName,excelReport.getSuffix());
			CellStyle bodyStyle= bodyStyle(workbook);
			//多个sheet
	  		 List<ExcelReport> excelReports=new ArrayList<ExcelReport>();
	  		  if(!excelReport.getSheet()){
	  			excelReports.add(excelReport);
	  		  }else{
	  		    excelReports=excelReport.getList();}//获取多个excel对象
		 for (int sheeti = 0; sheeti < excelReports.size(); sheeti++) {
			 ExcelReport excel=excelReports.get(sheeti);//创建一个excel对象
			 Sheet sheet = workbook.getSheet(excel.getTitle());//获取sheet
	         if(excel.getCheckAttr()==null&& excel.getColumnNo()==-1){//如果没有，则是追加，否则为替换
	        	 JSONArray json = excel.getData(); // 首先把字符串转成 JSONArray对象
	        	 int rowNum=sheet.getLastRowNum();
	        	 //追加单元格
	     		for (int k = 1; k <=json.size(); k++) {
	     			Row newRow = sheet.createRow(rowNum+ k);
	     			newRow.setHeight((short) (20 * 20)); // 设置行高 基数为20
	     			setExcelCell(newRow, json.getJSONObject(k-1),excel.getAttrs(),bodyStyle);
	     		}
	         }else{
	             replaceExcelCell(sheet,excel,bodyStyle);//替换单元格 
	            }
	        }
	         closeFileStream(fileName,workbook);
	         }
        } catch (IOException e) {
	        e.printStackTrace();
        }
	}
    /**
     * 
     * @方法功能描述：判断文件存在不存在，存在返回文件总名称，不存在为空
     * @param fileName
     * @param suffix
     * @return 
     * String
     * @author duanshixi
     * @创建时间： 2017年4月5日下午2:35:23
     */
    public String getFileAddress(String fileName,String suffix){
		StringBuilder sb = new StringBuilder();
		sb.append("D:/file/").append(fileName).append(suffix);
        File file=new File( sb.toString());
        if(file.exists()){
        	return sb.toString();
        }else{
        	return null;
        }
	 }
	
	
	/**
	 * 
	 * @方法功能描述： 根据后缀创建不同的对象
	 * @param fileToBeRead
	 * @return 
	 * HSSFWorkbook
	 * @author duanshxi
	 * @创建时间： 2017年3月31日上午11:04:35
	 */
    public Workbook queryFileSuffix(String fileToBeRead, String suffix){
  	    Workbook workbook = null;
		try {
			// 创建 Excel 文件的输入流对象
			FileInputStream excelFileInputStream = new FileInputStream(fileToBeRead);
			// 创建其对象，就打开这个 Excel 文件
			if(suffix.equals(".xlsx")){
			 workbook = new XSSFWorkbook(excelFileInputStream);
			 }
			if(suffix.equals(".xls")){
				 workbook = new HSSFWorkbook(excelFileInputStream);
		     }
			// 输入流使用后，及时关闭！
	         excelFileInputStream.close();
            } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
            }
		return workbook;
	}
/*    
    public  void writeCsv(ExcelReport excelReport) throws IOException {
    	FileOutputStream  excelFileOutPutStream = new FileOutputStream(this.getFileAddress(excelReport.getFileName(),excelReport.getSuffix()));
        CsvWriter cw = new CsvWriter(ou, ',', Charset.forName("UTF-8"));
        
        for( s: list) {
            
            cw.writeRecord(s);
        }
        
        //在文件中增加BOM，详细说明可以Google,该处的byte[] 可以针对不同编码进行修改
        ou.write(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF });
        
        cw.flush();
        cw.close();
    }*/
	 /**
	  * 
	  * @方法功能描述： 关闭输出流 
	  * @param fileToBeRead
	  * @param workbook
	  * @throws IOException 
	  * void
	  * @author Dingj
	  * @创建时间： 2017年3月31日上午11:04:57
	  */
     public  void closeFileStream(String fileToBeRead,Workbook workbook) throws IOException{
		// 首先要创建一个原始Excel文件的输出流对象！
		FileOutputStream excelFileOutPutStream;
        try {
	        excelFileOutPutStream = new FileOutputStream(fileToBeRead);
			// 将最新的 Excel 文件写入到文件输出流中，更新文件信息！
			workbook.write(excelFileOutPutStream);
			// 执行 flush 操作， 将缓存区内的信息更新到文件上
			excelFileOutPutStream.flush();
			// 关闭这个输出流对象
			excelFileOutPutStream.close();
            } catch (FileNotFoundException e) {
    	        // TODO Auto-generated catch block
    	        e.printStackTrace();
            }

		}
	/***
	 * 
	 * @方法功能描述： 生成标题
	 * @param sheet
	 * @param title
	 * @param style 
	 * void
	 * @author duanshixi
	 * @创建时间： 2017年4月10日下午3:14:28
	 */
    public static void exportTitle (Sheet sheet, String title, CellStyle style){
		// 显示标题
		Row title_row = sheet.createRow(0);
		title_row.setHeight((short) (40 * 20));
		Cell title_cell = title_row.createCell(0, Cell.CELL_TYPE_STRING);
		Row header_row = sheet.createRow(1);
		header_row.setHeight((short) (20 * 24));
		title_cell.setCellStyle(style);
		title_cell.setCellValue(title);
	}
	/**
	 * 
	 * @方法功能描述： 生成表头
	 * @param sheet
	 * @param headers 表头
	 * @param style   表格样式
	 * @param headerType 生成表头方式 1为子父级，2为常规
	 * void
	 * @author duanshixi
	 * @创建时间： 2017年4月1日上午10:50:12
	 */
    public static void exportHeader (Sheet sheet, String[] headers, CellStyle style, int headerType){
		Row header_row = sheet.createRow(1);//父表头
		Row header_row2 = null;//子表头
		if(headerType==1){//判断有无子表头
			header_row2= sheet.createRow(2);	
			header_row2.setHeight((short) (20 * 24));
		}
		 header_row.setHeight((short) (20 * 24));//父表头高
		 int cellNum=0;//设置列的初始值
		 for (Object keyName : headers) {
		 String key = keyName.toString();
		 CellRangeAddress region = null;
		 if(key.indexOf(",")==-1){
			Cell cell = header_row.createCell(cellNum, Cell.CELL_TYPE_STRING);
			sheet.setColumnWidth(cellNum, 20 * 256);//设置单元格宽带
			// 应用样式到 单元格上
			cell.setCellStyle(style);
			cell.setCellValue(key);
			if(headerType==1){
			 region = new CellRangeAddress(1,2,cellNum,cellNum);//纵向合并单元格
			 sheet.addMergedRegion(region);
			}
			 cellNum++;
		 }else{
		    String[] header=key.split(",");//子父级，下标 0：父，1:子
            String [] subHeader=header[1].split("/");
            Cell header_cell= header_row.createCell(cellNum, Cell.CELL_TYPE_STRING);//父级header
            header_cell.setCellStyle(style);
            header_cell.setCellValue(header[0]); 
            for (int i = 0; i < subHeader.length; i++) {
                Cell cell2= header_row2.createCell(cellNum, Cell.CELL_TYPE_STRING);//子级级header
   			    sheet.setColumnWidth(cellNum, 20 * 256);
                // 应用样式到 单元格上
                cell2.setCellStyle(style);
                cell2.setCellValue(subHeader[i]);
                cellNum++;
            }
            sheet.addMergedRegion(new CellRangeAddress(1, 1, cellNum-subHeader.length ,cellNum-1));//父级跨列
		   }
		 }	
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cellNum-1));//title 跨列
	}


    public static CellStyle headerStyle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER); // 水平方向上的对其方式
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直方向上的对其方式
		return style;
	}

    public static CellStyle bodyStyle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_LEFT); // 水平方向上的对其方式
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直方向上的对其方式
		return style;
	}

    private void replaceExcelCell (Sheet sheet, ExcelReport excelReport, CellStyle style){
    	Row row;
		int currentLastRowIndex = sheet.getLastRowNum();//总共行
		JSONArray json =excelReport.getData(); // 首先把字符串转成 JSONArray  对象
		JSONArray lossJson =excelReport.getData();//不一致的数据
		String [] attr=excelReport.getAttrs();
		String checkAttr=excelReport.getCheckAttr();
		int columnNo=excelReport.getColumnNo();
    	for (int icount = 0; icount <= currentLastRowIndex; icount++) {
    		row = sheet.getRow(icount);
    		Cell attrValue = row.getCell(columnNo);
    		 String arrtValur=attrValue.getStringCellValue();
    			for (int k = 0; k < json.size(); k ++) {
    				 String checkValue=isDate(json.getJSONObject(k).getString(checkAttr));
    				if (arrtValur.equals(checkValue)) {
    					// int newRowIndex = currentLastRowIndex + 1;
    					Row newRow = sheet.createRow(icount);
    					newRow.setHeight((short) (20 * 20)); // 设置行高 基数为20
    					setExcelCell(newRow,json.getJSONObject(k),attr,style);
    					lossJson.remove(json.getJSONObject(k));//删除存在的
    				}
    			}
    			continue;
    		}
    	 currentLastRowIndex = sheet.getLastRowNum();
    	 if(lossJson.size()>0){
    	 for (int k = 0; k < lossJson.size(); k++) {
    		 currentLastRowIndex++;
    		 Row newRow = sheet.createRow(currentLastRowIndex);
			 newRow.setHeight((short) (20 * 20)); // 设置行高 基数为20
			 setExcelCell(newRow,lossJson.getJSONObject(k),attr,style);

    	  }
    	 }
    	}
	/**
	 * 
	 * @方法功能描述： 设置单元格内容
	 * @param 
	 * @return 
	 * CellStyle
	 * @author duanshixi
	 * @创建时间： 2017年4月10日下午3:15:07
	 */
    public static void setExcelCell(Row row, JSONObject json, String[] attrs, CellStyle style){
		for (int j =0; j < attrs.length; j++) {
			Cell cell = row.createCell(j, Cell.CELL_TYPE_STRING);
			String attrValue=isDate(json.getString(attrs[j]));//获取每一列
			cell.setCellStyle(style);
			cell.setCellValue(attrValue=="null"?"":attrValue + "");
		}
	}
    public  static String isDate(String str){
		if(str.indexOf("time")>0){
			JSONObject json= JSONObject.fromObject(str);
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String date=sdf.format(new Date(Long.parseLong(String.valueOf(json.getString("time"))))); 
		   if(date.indexOf(" 00:00:00")>0){
			   return date.substring(0, date.indexOf(" 00:00:00"));
		   }else{
			   return date;
		   }
		}
		return str;
	}

	private static void propReport(ExcelReport excelReport, Sheet sheet, CellStyle bodyStyle){
		//首先把字符串转成 JSONArray 对象
		String [] headers=excelReport.getHeader();//获取表头
		String []attrs=excelReport.getAttrs();
		String [] totalAttrs=excelReport.getTotalCountAttrs();
		JSONArray json =excelReport.getData();//拿到道具的数据
		for (int i = 0; i < json.size(); i++) {
			JSONObject jsonObject=json.getJSONObject(i);//获取单个日期的值
			String date=jsonObject.keys().next().toString();//获取key--日期
			JSONArray array=jsonObject.getJSONArray(date);//根据日期拿去道具
			int rowNum=sheet.getLastRowNum();
			Row row = sheet.createRow(rowNum+1);
			row.setHeight((short) (20 * 20)); // 设置行高 基数为20
			Cell cell= row.createCell(0, Cell.CELL_TYPE_STRING);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(isDate(date)=="null"?"":date + "");
			for (int j = 0; j < array.size(); j++) {//道具
				JSONObject propList=array.getJSONObject(j);
				String id=propList.getString(excelReport.getCheckAttr());
				for (int k = 0; k < headers.length; k++) {//道具表头
					if(headers[k].indexOf(id)!=-1){//判断道具放置的位置
						Cell propCell=null;
						try {
							for (int l =0; l < attrs.length; l++) {
								 propCell= row.createCell(l+k);
								propCell.setCellStyle(bodyStyle);
								String attrValue=isDate(propList.getString(attrs[l]));//获取每一列
								propCell.setCellValue(attrValue=="null"?"":attrValue + "");
							}
						} catch (JSONException e) {
							propCell.setCellValue("-");
						}
						break;
					}
				}
			}
			int totalCell=headers.length-totalAttrs.length-1;
			for (int j = 0; j < totalAttrs.length; j++) {//道具总计
				Cell propCell =null;
				try {
					propCell= row.createCell(totalCell+j+1);
					propCell.setCellStyle(bodyStyle);
					JSONObject object=array.getJSONObject(0);
					String attrValue=object.getString(totalAttrs[j]);//获取每一列
					propCell.setCellValue(attrValue=="null"?"":attrValue + "");
				} catch (JSONException e) {
					propCell.setCellValue("-");
				}

			}
		}
	}

}
