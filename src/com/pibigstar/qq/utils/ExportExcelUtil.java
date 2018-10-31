package com.pibigstar.qq.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pibigstar.qq.domain.User;
/**
 * 导出Excel工具类
 * @author pibigstar
 */
public class ExportExcelUtil {
	public static void export (List<User> users) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个Excel表单,参数为sheet的名字
		HSSFSheet sheet = workbook.createSheet("QQ好友");
		//创建表头
		setTitle(workbook, sheet);
		//新增数据行，并且设置单元格数据
		int rowNum = 1;
		for (User user:users) {
			HSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(user.getData());
			row.createCell(1).setCellValue(user.getNick());
			row.createCell(2).setCellValue(user.getAge());
			row.createCell(3).setCellValue(user.getCity());
			rowNum++;
		}
		String fileName = "qq-friends.xlsx";
		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		OutputStream os = new BufferedOutputStream(fos);  
		//将excel写入到输出流中
		workbook.write(os);
		os.flush();
		os.close();
	}

	private static void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){
		HSSFRow row = sheet.createRow(0);
		//设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
		sheet.setColumnWidth(0, 10*256);
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 20*256);
		sheet.setColumnWidth(3, 100*256);

		//设置为居中加粗
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		HSSFCell cell;
		cell = row.createCell(0);
		cell.setCellValue("QQ号");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("QQ昵称");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("年龄");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("城市");
		cell.setCellStyle(style);
	}
}
