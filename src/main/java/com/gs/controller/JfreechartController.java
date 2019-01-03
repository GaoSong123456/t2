package com.gs.controller;

import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gs.service.DepartmentService;
import com.gs.vo.DepartmentchartVo;

@Controller
public class JfreechartController {
	@Autowired
	private DepartmentService departmentService;
	DepartmentchartVo departmentchartVo = new DepartmentchartVo();
	List<DepartmentchartVo> list = null;

	// 柱状图
	@RequestMapping("/zhu")
	public String zhu(HttpServletRequest request, Model model)
			throws IOException {
		list = departmentService.getSumForDepartment();
		// 生成dataSet数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (list != null && list.size() > 0) {
			for (DepartmentchartVo dv : list) {
				dataset.addValue(dv.getSum(), "部门名称", dv.getName()); // 第一个值为数值，第二个值为子标题，第三个值为字符型
			}
		}

		JFreeChart chart = ChartFactory.createBarChart3D("部门人数分类统计报表", // 主表题
				"部门名称", // X轴标题
				"数量", // Y轴的标题
				dataset, // 图表需要的数据
				PlotOrientation.VERTICAL, // 图表的方法,水平还是垂直
				true, // 是否显示图例
				true, // 是否显示工具提示
				true); // 首产生url链接

		// 获取图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();

		// 获取x轴
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot
				.getDomainAxis();

		// 获取y轴
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();

		// 绘图区域对象 xxxRender
		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot
				.getRenderer();

		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 处理子标题乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理X轴乱码
		// 处理x轴上的乱码
		categoryAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理x轴外的乱码
		categoryAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));

		// 处理Y轴乱码
		// 处理Y轴上的乱码
		numberAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理Y轴外的乱码
		numberAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理Y轴的刻度
		// 设置y轴不是使用自动刻度
		numberAxis3D.setAutoTickUnitSelection(false);
		// 设置刻度
		NumberTickUnit numberTickUnit = new NumberTickUnit(1);
		numberAxis3D.setTickUnit(numberTickUnit);
		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理图形的的宽度
		barRenderer3D.setMaximumBarWidth(0.08);

		// 处理柱体上的数字
		barRenderer3D
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// 设置柱体上的数字可见
		barRenderer3D.setBaseItemLabelsVisible(true);

		// 处理柱体上的数字的字体
		barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 保存生成的图形到某个路径下
		// 获取图片的保存的路径
		String reaPath = request.getServletContext().getRealPath("/make");

		String filename = "test.jpeg";

		File file = new File(reaPath, filename);
		ChartUtilities.saveChartAsJPEG(file, chart, 600, 400);

		model.addAttribute("zhu", filename);

		return "/jfreechart/testjfreechart";

	}

	// 折线图
	@RequestMapping("/line")
	public String line(HttpServletRequest request, Model model)
			throws IOException {
		list = departmentService.getSumForDepartment();
		// 生成dataSet数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (list != null && list.size() > 0) {
			for (DepartmentchartVo dv : list) {
				dataset.addValue(dv.getSum(), "部门名称", dv.getName()); // 第一个值为数值，第二个值为子标题，第三个值为字符型
			}
		}

		JFreeChart chart = ChartFactory.createLineChart("部门人数分类统计报表", // 主表题
				"部门名称", // X轴标题
				"数量", // Y轴的标题
				dataset, // 图表需要的数据
				PlotOrientation.VERTICAL, // 图表的方法,水平还是垂直
				true, // 是否显示图例
				true, // 是否显示工具提示
				true); // 首产生url链接

		// 获取图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();

		// 获取x轴
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();

		// 获取y轴
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();

		// 绘图区域对象 xxxRender
		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
				.getRenderer();

		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 处理子标题乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理X轴乱码
		// 处理x轴上的乱码
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理x轴外的乱码
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));

		// 处理Y轴乱码
		// 处理Y轴上的乱码
		numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理Y轴外的乱码
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理Y轴的刻度
		// 设置y轴不是使用自动刻度
		numberAxis.setAutoTickUnitSelection(false);
		// 设置刻度
		NumberTickUnit numberTickUnit = new NumberTickUnit(1);
		numberAxis.setTickUnit(numberTickUnit);
		/**
		 * *********************************************************************
		 * ****************************
		 */

		// 处理线形上的数字
		lineAndShapeRenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// 设置柱体上的数字可见
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);

		// 处理柱体上的数字的字体
		lineAndShapeRenderer
				.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

		// 处理拐角处的点
		Rectangle rectangle = new Rectangle(8, 8); // 矩形
		lineAndShapeRenderer.setSeriesShape(0, rectangle); // 0表示第一条线
		lineAndShapeRenderer.setSeriesShapesVisible(0, true);

		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 保存生成的图形到某个路径下
		// 获取图片的保存的路径

		String reaPath = request.getServletContext().getRealPath("/make");

		String filename = "test2.jpeg";

		File file = new File(reaPath, filename);
		ChartUtilities.saveChartAsJPEG(file, chart, 600, 400);

		model.addAttribute("line", filename);

		return "/jfreechart/testjfreechart";

	}

	// 饼图
	@RequestMapping("/pie")
	public String pie(HttpServletRequest request, Model model)
			throws IOException {
		list = departmentService.getSumForDepartment();
		// 生成dataSet数据
		DefaultPieDataset dataset = new DefaultPieDataset(); // dataset类型不同
		if (list != null && list.size() > 0) {
			for (DepartmentchartVo dv : list) {
				dataset.setValue(dv.getName(), dv.getSum()); // 第一个值为字符串，第二个值为数值
			}
		}

		JFreeChart chart = ChartFactory.createPieChart3D("部门人数分类统计报表", // 主表题
				dataset, // 图表需要的数据
				true, // 是否显示图例
				true, // 是否显示工具提示
				true); // 首产生url链接

		// 获取图表区域对象
		PiePlot3D piePlot3D = (PiePlot3D) chart.getPlot();

		/**
		 * *********************************************************************
		 * ****************************
		 */
		// 处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 处理子标题乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		/**
		 * *********************************************************************
		 * ****************************
		 */

		// 处理饼图标题乱码
		piePlot3D.setLabelFont(new Font("宋体", Font.BOLD, 18));

		/*
		 * dataset.setValue("销售部", 5);{0}:销售部{1}:5{2}:5所占 的百分比():自己可以随意添加
		 */
		// 处理饼图显示的信息
		String labelFormat = "{0}:{1}:({2})";
		piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator(
				labelFormat));

		// 保存生成的图形到某个路径下
		// 获取图片的保存的路径

		String reaPath = request.getServletContext().getRealPath("/make");

		String filename = "test3.jpeg";

		File file = new File(reaPath, filename);
		ChartUtilities.saveChartAsJPEG(file, chart, 600, 400);

		model.addAttribute("pie", filename);

		return "/jfreechart/testjfreechart";

	}
}
