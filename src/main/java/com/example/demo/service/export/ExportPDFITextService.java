package com.example.demo.service.export;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class ExportPDFITextService {

    public void export(OutputStream os, FactureDTO facture) throws IOException, DocumentException {
        Document document = new Document();        
        PdfWriter.getInstance(document, os);
        document.open();
        PdfPTable table = new PdfPTable(4);
        
        PdfPCell cell = new PdfPCell();
        
        cell.setPhrase(new Phrase("Libelle"));
        table.addCell(cell);
        
        	    
	    document.add(new Paragraph(facture.getClient().getNom() + " "));
	    document.add(new Paragraph(facture.getClient().getPrenom() + "\n"));	    
	    document.add(table);	
       List<LigneFactureDTO> ligneFactures = facture.getLigneFactures();
       for (LigneFactureDTO l : ligneFactures) {
    	   String texte = "Designation : " + l.getDesignation() + "\n";
    	   texte += "Prix : " + l.getPrixUnitaire() + "\n";
    	   texte += " Quantité : " + l.getQuantite() + "\n";
    	   texte += "Prix total " + facture.totalFacture();
    	   document.add(new Paragraph(texte));
   		}
        document.close();
    }

	
}
