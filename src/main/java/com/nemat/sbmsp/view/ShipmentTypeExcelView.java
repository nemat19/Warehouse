package com.nemat.sbmsp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.nemat.sbmsp.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
//		Download + File name
		response.addHeader("content-Disposition", "attachment;filename=ShipmentType.xlsx");
		
//		read data from controller
		@SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("obs");

		//		create new sheet
		Sheet sheet = workbook.createSheet("ShipmentTypes");
		setHead(sheet);
		setBody(sheet, list);
		
//		Sheet s = workbook.createSheet("TEST");
//		Row r =s.createRow(0);
//		Cell c = r.createCell(0);
//		c.setCellValue("Hello");
	}
	
//	row#0 Creation
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("DESCRIPTION");
	}
	
	private void setBody(Sheet sheet, List<ShipmentType> list) {
		int rowNum = 1;
		for(ShipmentType st:list) {
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(st.getId());
			row.createCell(1).setCellValue(st.getShipmentMode());
			row.createCell(2).setCellValue(st.getShipmentCode());
			row.createCell(3).setCellValue(st.getEnableShipment());
			row.createCell(4).setCellValue(st.getShipmentGrade());
			row.createCell(5).setCellValue(st.getDescription());
			rowNum++;
			
		}
	}
}
