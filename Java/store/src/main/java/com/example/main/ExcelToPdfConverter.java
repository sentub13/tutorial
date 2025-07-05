package com.example.main;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class ExcelToPdfConverter {

    public static void convertExcelToPdf(String excelPath, String pdfPath) throws Exception {
        try (InputStream excelFile = new FileInputStream(excelPath);
             Workbook workbook = WorkbookFactory.create(excelFile);
             PdfWriter writer = new PdfWriter(pdfPath);
             PdfDocument pdfDoc = new PdfDocument(writer);
             Document document = new Document(pdfDoc)) {

            Sheet sheet = workbook.getSheetAt(0); 
            int numCols = sheet.getRow(0).getLastCellNum();
            Table table = new Table(numCols);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue; 

                for (int j = 0; j < numCols; j++) {
//                	String cellValue = "Hello";
                	org.apache.poi.ss.usermodel.Cell cell = row.getCell(j);
//                	
//                	cellValue = cell.getStringCellValue();
                	
                	Double cellInteger = cell.getNumericCellValue();
                	
                	
	            	Paragraph para = new Paragraph(cellInteger.toString());
	                table.addCell(para);
                }
            }

            document.add(table);
        }
    }


}
