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

	private static final String XLSX_FILE = "qq-friends.xlsx";

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
			row.createCell(0).setCellValue(rowNum);
			row.createCell(1).setCellValue(user.getData());
			row.createCell(2).setCellValue(user.getNick());
			row.createCell(3).setCellValue(user.getLabel());
			row.createCell(4).setCellValue(user.getGender());
			row.createCell(5).setCellValue(user.getCity());
			row.createCell(6).setCellValue(user.getBirthday());
			row.createCell(7).setCellValue(user.getLnick());
			rowNum++;
		}
		File file = new File(XLSX_FILE);
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
		sheet.setColumnWidth(0, 5*256);
		sheet.setColumnWidth(1, 10*256);
		sheet.setColumnWidth(2, 25*256);
		sheet.setColumnWidth(3, 10*256);
		sheet.setColumnWidth(4, 10*256);
		sheet.setColumnWidth(5, 10*256);
		sheet.setColumnWidth(6, 10*256);
		sheet.setColumnWidth(7, 50*256);


		//设置为居中加粗
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		HSSFCell cell;
		cell = row.createCell(0);
		cell.setCellValue("序号");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("QQ号");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("QQ昵称");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("备注");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("性别");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("城市");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("生日");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("个性签名");
		cell.setCellStyle(style);

	}
}
