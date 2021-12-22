package com.brawlstars.asylum.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;


import com.brawlstars.asylum.model.Diagnose;
import com.brawlstars.asylum.model.Treatment;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDFInfo {


    public static ByteArrayInputStream citiesReport(Treatment treatment) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Font font = FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK);
            Chunk firstName = new Chunk("First name: " + treatment.getPatient().getFirstName(), font);
            Chunk secondName = new Chunk("Second name: " + treatment.getPatient().getSecondName(), font);
            Chunk patronymic = new Chunk("Patronymic: " + treatment.getPatient().getPatronymic(), font);
            Chunk startDate = new Chunk("Start date: " + format1.format(treatment.getStartOfTreatment().getTime()), font);
            Chunk dateEnd = new Chunk("End date: " + format1.format(treatment.getEndOfTreatment().getTime()), font);

            Chunk doctor = new Chunk("Doctor: ", font);
            Chunk firstNameDoctor = new Chunk("First name: " + treatment.getDoctor().getUser().getFirstName(), font);
            Chunk secondNameDoctor = new Chunk("Second name " +  treatment.getDoctor().getUser().getSecondName(), font);
            Chunk patronymicDoctor = new Chunk("Patronymic name: " + treatment.getDoctor().getUser().getPatronymic(), font);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);



            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph(firstName));
            document.add(new Paragraph(secondName));
            document.add(new Paragraph(patronymic));
            document.add(new Paragraph(startDate));
            document.add(new Paragraph(dateEnd));

            if (!treatment.getDiagnoses().isEmpty()) {

                PdfPCell hcell;
                hcell = new PdfPCell(new Phrase("Name", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Description", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                for (Diagnose diagnose : treatment.getDiagnoses()) {

                    PdfPCell cell;

                    cell = new PdfPCell(new Phrase(diagnose.getName()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(diagnose.getDescription()));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                }
                document.add(table);
            }



            document.add(new Paragraph(doctor));
            document.add(new Paragraph(firstNameDoctor));
            document.add(new Paragraph(secondNameDoctor));
            document.add(new Paragraph(patronymicDoctor));
           // document.add(table);

            document.close();

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


        return new ByteArrayInputStream(out.toByteArray());
    }
}