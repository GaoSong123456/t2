package com.gs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gs.pojo.Department;
import com.gs.service.DepartmentService;

@Controller
public class PoiController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/print")
	public void print(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "/make/";
		InputStream is = new FileInputStream(
				new File(path + "tOUTPRODUCT.xlsx"));
		Workbook wb = new XSSFWorkbook(is); // 打开一个模板文件，工作簿 2007以上版本

		Sheet sheet = wb.getSheetAt(0);

		Row nRow = null;
		Cell nCell = null;
		int rowNo = 0; // 行号
		int colNo = 1; // 列号 模板表格中直接跳过了第一列

		// 获取模板上的单元格样式 数据行
		nRow = sheet.getRow(2);

		// 客户的样式
		nCell = nRow.getCell(1);
		CellStyle customStyle = nCell.getCellStyle();

		// 订单号的样式
		nCell = nRow.getCell(2);
		CellStyle contractNoStyle = nCell.getCellStyle();

		// 货号的样式
		nCell = nRow.getCell(3);
		CellStyle productNoStyle = nCell.getCellStyle();

		// 数量的样式
		nCell = nRow.getCell(4);
		CellStyle numStyle = nCell.getCellStyle();

		// 生产厂家的样式
		nCell = nRow.getCell(5);
		CellStyle factoryStyle = nCell.getCellStyle();

		// 日期的样式
		nCell = nRow.getCell(6);
		CellStyle dateStyle = nCell.getCellStyle();

		// 贸易条款的样式
		nCell = nRow.getCell(8);
		CellStyle tradeStyle = nCell.getCellStyle();

		// 处理大标题
		nRow = sheet.getRow(rowNo++); // 获取一个行对象
		nCell = nRow.getCell(colNo); // 获取一个单元格对象 nCell.setCellValue("12月份出货表");
										// //yyyy-MM

		rowNo++; // 跳过静态表格头

		// 处理内容
		List<Department> dataList = departmentService.selectAll();
		for (int j = 0; j < dataList.size(); j++) {
			colNo = 1; // 初始化
			Department de = dataList.get(j);

			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(24);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getId());
			nCell.setCellStyle(customStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getName());
			nCell.setCellStyle(contractNoStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getId());
			nCell.setCellStyle(productNoStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getId());
			nCell.setCellStyle(numStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getName());
			nCell.setCellStyle(factoryStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getName());
			nCell.setCellStyle(dateStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getName());
			nCell.setCellStyle(dateStyle);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(de.getName());
			nCell.setCellStyle(tradeStyle);
		}

		OutputStream os = new FileOutputStream("F:\\outproduct.xlsx");
		// wb.write(os);
		//
		// os.flush();
		// os.close();

		// ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);

		os.flush();
		os.close();
	}












sfgdsgzhiiiiiiiiiiiiiiiiiiiiiiiiiiii
}
