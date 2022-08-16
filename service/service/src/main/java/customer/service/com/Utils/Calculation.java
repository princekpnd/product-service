package customer.service.com.Utils;

import org.apache.poi.ss.usermodel.Cell;

import customer.service.com.Entity.ExcelEntity;


public class Calculation {
//	public ExcelEntity ExcelToString(Cell cell) {
//		ExcelEntity data = new ExcelEntity();
//		String cellType = cell.getCellType().toString();
//		if (cellType == "STRING") {
//			String cellValue = cell.getStringCellValue();
//			String withoutSpace = new String(cellValue).trim();
//			String replacedSpace = withoutSpace.replace(" ", "_");
//			
//			data.setName(withoutSpace);
//			data.setTitle(replacedSpace);
//		} else if (cellType == "NUMERIC") {
//			long cellValue = (long) cell.getNumericCellValue();
//			String intToString = String.valueOf(cellValue);
//			data.setName(intToString);
//			data.setTitle(intToString);
//		}
//		
//		return data;
//	}
}
