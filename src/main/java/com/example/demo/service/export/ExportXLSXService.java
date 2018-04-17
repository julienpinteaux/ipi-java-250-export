package com.example.demo.service.export;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;


@Component
public class ExportXLSXService {
	
	public void exportClientsListe(OutputStream os, List <ClientDTO> clients) throws IOException {
	
		XSSFWorkbook worbook = new XSSFWorkbook();
		XSSFSheet sheet = worbook.createSheet("Client");		
		Integer cpt = 1;	
		
		/*
		 * Style du header
		 */
		CellStyle style = worbook.createCellStyle();
	    Font font = worbook.createFont();
	    font.setFontName("Arial");
	    font.setBold(true);	    
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    font.setBold(true);
	    font.setColor(HSSFColor.WHITE.index);
	    style.setFont(font);
	    
		
		/*
		 * Pour le header
		 */		
		Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Nom");
	    header.getCell(0).setCellStyle(style);
	    header.createCell(1).setCellValue("Prenom");
	    header.getCell(1).setCellStyle(style);


		
		for (ClientDTO c : clients) 		
		{
			Row row =  sheet.createRow(cpt++);			
	        row.createCell(0).setCellValue(c.getNom());
	        row.createCell(1).setCellValue(c.getPrenom());	       	        
		}
		worbook.write(os);
		worbook.close();	
	}
	
	/*
	 * XSSFWorbook workbook = new XSSFWorbook();
	 * XSSFSheet sheet = worbook.createsheet("client");
	 * worbook.write(os);
	 * worbook.close();
	 */
	
	
	public void exportClient(OutputStream os, List<FactureDTO> factures) throws IOException {
		
		XSSFWorkbook worbook = new XSSFWorkbook();	
		  
		Integer page = 1;
		Integer colonne = 0;
		
		for (FactureDTO f : factures)
		{
			Integer ligne = 1;
			List<LigneFactureDTO> ligneF = f.getLigneFactures();
			XSSFSheet sheet = worbook.createSheet("Facture"+ page);
			
			/*
			 * Style et header
			 */
			CellStyle style = worbook.createCellStyle();
		    Font font = worbook.createFont();
		    font.setFontName("Arial");
		    font.setBold(true);	    
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    font.setBold(true);
		    font.setColor(HSSFColor.WHITE.index);
		    style.setFont(font);
			
			Row header = sheet.createRow(0);
		    header.createCell(0).setCellValue("Id Facture");
		    header.getCell(0).setCellStyle(style);
		    header.createCell(1).setCellValue("Designation");
		    header.getCell(1).setCellStyle(style);
		    header.createCell(2).setCellValue("Prix unitaire");
		    header.getCell(2).setCellStyle(style);
		    header.createCell(3).setCellValue("Quantité");
		    header.getCell(3).setCellStyle(style);		
	        
	        for (LigneFactureDTO l : ligneF) {
	        	Row row =  sheet.createRow(ligne);
		        row.createCell(colonne).setCellValue(f.getId());
	        	row.createCell(colonne+1).setCellValue(l.getDesignation());
	        	row.createCell(colonne+2).setCellValue(l.getPrixUnitaire());
	        	row.createCell(colonne+3).setCellValue(l.getQuantite());
	        	ligne++;    	
	        }
	        Row row2 =  sheet.createRow(ligne);
	        row2.createCell(colonne).setCellValue(f.totalFacture());
	        
	        page++;
		}
		
		worbook.write(os);
		worbook.close();
	}
	

}
