package util;

import helper.reportHelper.BbReportData;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class BbExportUtility {

   
	public static void exportToExcel(String sheetName, String[] headers,
          List<? extends BbReportData> list, OutputStream out) throws Exception {
			try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet(sheetName);


			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				headerRow.createCell(i).setCellValue(headers[i]);
			}
			
			int rowIdx = 1;
			for (BbReportData data : list) {
				Row row = sheet.createRow(rowIdx++);
				String[] rowData = data.getRowData();

				for (int i = 0; i < rowData.length; i++) {
					row.createCell(i).setCellValue(rowData[i] != null ? rowData[i] : "");
				}
			}

			for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
				sheet.autoSizeColumn(i);
			}

			workbook.write(out);  

			}
}

   
    public static void exportToPDF(String title, String[] headers,
                                   List<? extends BbReportData> list, OutputStream out) throws Exception {

        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, out);
        document.open();

        
        document.add(new Paragraph(title, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        document.add(Chunk.NEWLINE);

        
        int photoColIndex = -1;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase("profile") || headers[i].equalsIgnoreCase("photo")) {
                photoColIndex = i;
                break;
            }
        }

        
        int columnCount = photoColIndex == -1 ? headers.length : headers.length - 1;
        PdfPTable table = new PdfPTable(columnCount);
        table.setWidthPercentage(100);

        
        for (int i = 0; i < headers.length; i++) {
            if (i == photoColIndex) continue;
            PdfPCell cell = new PdfPCell(new Phrase(headers[i], FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        }

        
        for (BbReportData data : list) {
            String[] rowData = data.getRowData();
            for (int i = 0; i < rowData.length; i++) {
                if (i == photoColIndex) continue;
                table.addCell(rowData[i] != null ? rowData[i] : "");
            }
        }

        document.add(table);
        document.close();
    }
}
