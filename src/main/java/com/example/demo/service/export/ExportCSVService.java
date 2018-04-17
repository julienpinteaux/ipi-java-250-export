package com.example.demo.service.export;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ClientDTO;

@Component
public class ExportCSVService {
	

    public void export(Writer writer, List <ClientDTO> client) throws IOException {
    	
    	XSSFWorkbook book = new XSSFWorkbook();
    	XSSFSheet sheet = book.createSheet("User Detail");		
    	int rowCount = 1;
    	
    	for (ClientDTO c : client)	    		
    	{     
    		writer.write(c.getNom().replace(";", "") + ";" + c.getPrenom().replace(";", "") + ";");
		}
	    writer.close();
		//Row row =  sheet.createRow(rowCount++);
		//row.createCell(0).setCellValue(c.getNom());
        //row.createCell(1).setCellValue(c.getPrenom());	       
        //writer.write(c.getNom() + " " + c.getPrenom());
    	book.close();
    }
}
