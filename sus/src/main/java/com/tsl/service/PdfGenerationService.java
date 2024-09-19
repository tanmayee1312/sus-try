package com.tsl.service;

//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.tsl.pojo.S1CoalUsed;
//import com.tsl.pojo.S1FireExtinguisher;
//import com.tsl.pojo.S2PurchasedElectricity;
//
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//
//@Service
//public class PdfGenerationService {
//
//    public ByteArrayInputStream generatePdf(List<S1CoalUsed> coalUsedData, List<S1FireExtinguisher> fireExtinguisherData, List<S2PurchasedElectricity> electricityData) {
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            PdfWriter writer = new PdfWriter(out);
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf);
//
//            // Add a title
//            document.add(new Paragraph("Forms Data")
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setFontSize(18));
//
//            // Add S1CoalUsed Data
//            document.add(new Paragraph("S1 Coal Used Data")
//                    .setFontSize(16));
//            Table coalUsedTable = new Table(5);
//            coalUsedTable.addHeaderCell("Month");
//            coalUsedTable.addHeaderCell("Bagasse Purchased");
//            coalUsedTable.addHeaderCell("Type of Bagasse");
//            coalUsedTable.addHeaderCell("Bagasse Used");
//            coalUsedTable.addHeaderCell("Coal Cost");
//
//            for (S1CoalUsed coalUsed : coalUsedData) {
//                coalUsedTable.addCell(coalUsed.getMonth());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//                coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//                coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//            }
//            document.add(coalUsedTable);
//
//            // Add S1FireExtinguisher Data
//            document.add(new Paragraph("S1 Fire Extinguisher Data")
//                    .setFontSize(16));
//            Table fireExtinguisherTable = new Table(4);
//            fireExtinguisherTable.addHeaderCell("Type");
//            fireExtinguisherTable.addHeaderCell("Annual Refilling Quantity");
//            fireExtinguisherTable.addHeaderCell("Cylinders Purchased");
//            fireExtinguisherTable.addHeaderCell("Capacity of Cylinder");
//
//            for (S1FireExtinguisher fireExtinguisher : fireExtinguisherData) {
//                fireExtinguisherTable.addCell(fireExtinguisher.getType());
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getAnnualRefillingQuantity()));
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCylindersPurchased()));
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCapacityOfCylinder()));
//            }
//            document.add(fireExtinguisherTable);
//
//            // Add S2PurchasedElectricity Data
//            document.add(new Paragraph("S2 Purchased Electricity Data")
//                    .setFontSize(16));
//            Table electricityTable = new Table(6);
//            electricityTable.addHeaderCell("Month");
//            electricityTable.addHeaderCell("Electricity Imported");
//            electricityTable.addHeaderCell("Imported Charges");
//            electricityTable.addHeaderCell("Electricity Exported");
//            electricityTable.addHeaderCell("Fuel Used");
//            electricityTable.addHeaderCell("Fuel Quantity");
//
//            for (S2PurchasedElectricity electricity : electricityData) {
//                electricityTable.addCell(electricity.getMonth());
//                electricityTable.addCell(String.valueOf(electricity.getElectricityImported()));
//                electricityTable.addCell(String.valueOf(electricity.getImportedCharges()));
//                electricityTable.addCell(String.valueOf(electricity.getElectricityExported()));
//                electricityTable.addCell(String.valueOf(electricity.getFuelUsed()));
//                electricityTable.addCell(String.valueOf(electricity.getFuelQuantity()));
//            }
//            document.add(electricityTable);
//
//            document.close();
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (Exception e) {
//            throw new RuntimeException("Error generating PDF", e);
//        }
//    }
//}


// actual working code

//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.tsl.pojo.S1CoalUsed;
//import com.tsl.pojo.S1FireExtinguisher;
//import com.tsl.pojo.S2PurchasedElectricity;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.io.font.constants.StandardFonts;
//
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//
//@Service
//public class PdfGenerationService {
//
//    public ByteArrayInputStream generatePdf(List<S1CoalUsed> coalUsedData, List<S1FireExtinguisher> fireExtinguisherData, List<S2PurchasedElectricity> electricityData) {
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            PdfWriter writer = new PdfWriter(out);
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf);
//
//            // Add a title
//            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
//
//            // Add a title
//            document.add(new Paragraph("Final Report")
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setFontSize(18)
//                    .setFont(boldFont));
//
//            // Add S1CoalUsed Data
//            document.add(new Paragraph("Scope 1: Coal/ bagasse Used  (bagasse is by product )")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table coalUsedTable = new Table(5);
//            coalUsedTable.addHeaderCell("Month");
//            coalUsedTable.addHeaderCell("Bagasse Purchased");
//            coalUsedTable.addHeaderCell("Type of Bagasse");
//            coalUsedTable.addHeaderCell("Bagasse Used");
//            coalUsedTable.addHeaderCell("Coal Cost");
//
//            for (S1CoalUsed coalUsed : coalUsedData) {
//                coalUsedTable.addCell(coalUsed.getMonth());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//                coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//                coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//            }
//            document.add(coalUsedTable);
//
//            // Add spacing before next section
//            document.add(new Paragraph().setMarginBottom(20));
//
//            // Add S1FireExtinguisher Data
//            document.add(new Paragraph("Scope 1: Fire Extinguisher Refilling (CO2/DCP/FOAM Type)")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table fireExtinguisherTable = new Table(4);
//            fireExtinguisherTable.addHeaderCell("Type");
//            fireExtinguisherTable.addHeaderCell("Annual Refilling Quantity");
//            fireExtinguisherTable.addHeaderCell("Cylinders Purchased");
//            fireExtinguisherTable.addHeaderCell("Capacity of Cylinder");
//
//            for (S1FireExtinguisher fireExtinguisher : fireExtinguisherData) {
//                fireExtinguisherTable.addCell(fireExtinguisher.getType());
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getAnnualRefillingQuantity()));
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCylindersPurchased()));
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCapacityOfCylinder()));
//            }
//            document.add(fireExtinguisherTable);
//
//            // Add spacing before next section
//            document.add(new Paragraph().setMarginBottom(20));
//
//            // Add S2PurchasedElectricity Data
//            document.add(new Paragraph("Scope 2: Electricity Consumption")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table electricityTable = new Table(6);
//            electricityTable.addHeaderCell("Month");
//            electricityTable.addHeaderCell("Electricity Imported");
//            electricityTable.addHeaderCell("Imported Charges");
//            electricityTable.addHeaderCell("Electricity Exported");
//            electricityTable.addHeaderCell("Fuel Used");
//            electricityTable.addHeaderCell("Fuel Quantity");
//
//            for (S2PurchasedElectricity electricity : electricityData) {
//                electricityTable.addCell(electricity.getMonth());
//                electricityTable.addCell(String.valueOf(electricity.getElectricityImported()));
//                electricityTable.addCell(String.valueOf(electricity.getImportedCharges()));
//                electricityTable.addCell(String.valueOf(electricity.getElectricityExported()));
//                electricityTable.addCell(String.valueOf(electricity.getFuelUsed()));
//                electricityTable.addCell(String.valueOf(electricity.getFuelQuantity()));
//            }
//            document.add(electricityTable);
//
//            document.close();
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (Exception e) {
//            throw new RuntimeException("Error generating PDF", e);
//        }
//    }
//}

// updated code working 
//import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.tsl.pojo.S1CoalUsed;
//import com.tsl.pojo.S1FireExtinguisher;
//import com.tsl.pojo.S2PurchasedElectricity;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//
//@Service
//public class PdfGenerationService {
//
//    public ByteArrayInputStream generatePdf(List<S1CoalUsed> coalUsedData, List<S1FireExtinguisher> fireExtinguisherData, List<S2PurchasedElectricity> electricityData) {
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            PdfWriter writer = new PdfWriter(out);
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf);
//
//            // Add a title
//            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
//
//            // Add a title
//            document.add(new Paragraph("Final Report")
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setFontSize(18)
//                    .setFont(boldFont));
//
//            // Add S1CoalUsed Data
//            document.add(new Paragraph("Scope 1: Coal/ bagasse Used  (bagasse is by product )")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table coalUsedTable = new Table(5);
//            addHeaderCells(coalUsedTable, "Month", "Bagasse Purchased", "Type of Bagasse", "Bagasse Used", "Coal Cost");
//
//            for (S1CoalUsed coalUsed : coalUsedData) {
//                coalUsedTable.addCell(coalUsed.getMonth());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//                coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//                coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//            }
//            document.add(coalUsedTable);
//
//            // Add spacing before next section
//            document.add(new Paragraph().setMarginBottom(20));
//
//            // Add S1FireExtinguisher Data
//            document.add(new Paragraph("Scope 1: Fire Extinguisher Refilling (CO2/DCP/FOAM Type)")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table fireExtinguisherTable = new Table(4);
//            addHeaderCells(fireExtinguisherTable, "Type", "Annual Refilling Quantity", "Cylinders Purchased", "Capacity of Cylinder");
//
//            for (S1FireExtinguisher fireExtinguisher : fireExtinguisherData) {
//                fireExtinguisherTable.addCell(fireExtinguisher.getType());
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getAnnualRefillingQuantity()));
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCylindersPurchased()));
//                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCapacityOfCylinder()));
//            }
//            document.add(fireExtinguisherTable);
//
//            // Add spacing before next section
//            document.add(new Paragraph().setMarginBottom(20));
//
//            // Add S2PurchasedElectricity Data
//            document.add(new Paragraph("Scope 2: Electricity Consumption")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table electricityTable = new Table(6);
//            addHeaderCells(electricityTable, "Month", "Electricity Imported", "Imported Charges", "Electricity Exported", "Fuel Used", "Fuel Quantity");
//
//            for (S2PurchasedElectricity electricity : electricityData) {
//                electricityTable.addCell(electricity.getMonth());
//                electricityTable.addCell(String.valueOf(electricity.getElectricityImported()));
//                electricityTable.addCell(String.valueOf(electricity.getImportedCharges()));
//                electricityTable.addCell(String.valueOf(electricity.getElectricityExported()));
//                electricityTable.addCell(String.valueOf(electricity.getFuelUsed()));
//                electricityTable.addCell(String.valueOf(electricity.getFuelQuantity()));
//            }
//            document.add(electricityTable);
//
//            document.close();
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (Exception e) {
//            throw new RuntimeException("Error generating PDF", e);
//        }
//    }
//
//    private void addHeaderCells(Table table, String... headers) {
//        PdfFont boldFont;
//        try {
//            boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
//        } catch (Exception e) {
//            throw new RuntimeException("Error creating font", e);
//        }
//
//        for (String header : headers) {
//            Cell cell = new Cell().add(new Paragraph(header))
//                    .setBackgroundColor(new DeviceRgb(173, 216, 230	)) 
//                    .setFont(boldFont)
//                    .setTextAlignment(TextAlignment.CENTER);
//            table.addHeaderCell(cell);
//        }
//    }
//}


import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.TextAlignment;
import com.tsl.pojo.S1CoalUsed;
import com.tsl.pojo.S1FireExtinguisher;
import com.tsl.pojo.S2PurchasedElectricity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;



@Service
public class PdfGenerationService {

    public ByteArrayInputStream generatePdf(List<S1CoalUsed> coalUsedData, List<S1FireExtinguisher> fireExtinguisherData, List<S2PurchasedElectricity> electricityData) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add a title
            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

            // Add a title
            document.add(new Paragraph("Final Report")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(18)
                    .setFont(boldFont));

//            // Add S1CoalUsed Data
//            document.add(new Paragraph("Scope 1: Coal/ bagasse Used  (bagasse is by product )")
//                    .setFontSize(14)
//                    .setFont(boldFont));
//
//            Table coalUsedTable = new Table(5);
//            addHeaderCells(coalUsedTable, "Month", "Bagasse Purchased", "Type of Bagasse", "Bagasse Used", "Coal Cost");
//
//            for (S1CoalUsed coalUsed : coalUsedData) {
//                coalUsedTable.addCell(coalUsed.getMonth());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//                coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//                coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//                coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//            }
//            document.add(coalUsedTable);
//
//            // Add spacing before next section
//            document.add(new Paragraph().setMarginBottom(20));

            // Add S1FireExtinguisher Data
            document.add(new Paragraph("Scope 1: Fire Extinguisher Refilling (CO2/DCP/FOAM Type)")
                    .setFontSize(14)
                    .setFont(boldFont));

            Table fireExtinguisherTable = new Table(4);
            addHeaderCells(fireExtinguisherTable, "Type", "Annual Refilling Quantity", "Cylinders Purchased", "Capacity of Cylinder");

            for (S1FireExtinguisher fireExtinguisher : fireExtinguisherData) {
                fireExtinguisherTable.addCell(fireExtinguisher.getType());
                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getAnnualRefillingQuantity()));
                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCylindersPurchased()));
                fireExtinguisherTable.addCell(String.valueOf(fireExtinguisher.getCapacityOfCylinder()));
            }
            document.add(fireExtinguisherTable);

            // Add spacing before next section
            document.add(new Paragraph().setMarginBottom(20));

            // Add S2PurchasedElectricity Data
            document.add(new Paragraph("Scope 2: Electricity Consumption")
                    .setFontSize(14)
                    .setFont(boldFont));

            Table electricityTable = new Table(6);
            addHeaderCells(electricityTable, "Month", "Electricity Imported", "Imported Charges", "Electricity Exported", "Fuel Used", "Fuel Quantity");

            for (S2PurchasedElectricity electricity : electricityData) {
                electricityTable.addCell(electricity.getMonth());
                electricityTable.addCell(String.valueOf(electricity.getElectricityImported()));
                electricityTable.addCell(String.valueOf(electricity.getImportedCharges()));
                electricityTable.addCell(String.valueOf(electricity.getElectricityExported()));
                electricityTable.addCell(String.valueOf(electricity.getFuelUsed()));
                electricityTable.addCell(String.valueOf(electricity.getFuelQuantity()));
            }
            document.add(electricityTable);

            // Add watermark
            addWatermark(pdf, "Techknowgreen Solutions Limited");

            document.close();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }

    private void addWatermark(PdfDocument pdf, String watermarkText) {
        PdfFont watermarkFont;
        try {
            watermarkFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        } catch (Exception e) {
            throw new RuntimeException("Error creating font", e);
        }

        for (int i = 1; i <= pdf.getNumberOfPages(); i++) {
            PdfPage page = pdf.getPage(i);
            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdf);

            // Get the page dimensions
            float width = page.getPageSize().getWidth();
            float height = page.getPageSize().getHeight();

            pdfCanvas.saveState();

            // Set the font and size for the watermark text
            pdfCanvas.setFillColor(new DeviceRgb(200, 200, 200)); // Light gray color for watermark

            // Apply transformation matrix to rotate and position the text
            pdfCanvas.concatMatrix(
                (float) Math.cos(Math.toRadians(50)), (float) Math.sin(Math.toRadians(50)),
                (float) -Math.sin(Math.toRadians(50)), (float) Math.cos(Math.toRadians(50)),
                width / 8, height / 128
            );

            pdfCanvas.beginText()
                .setFontAndSize(watermarkFont, 40)
                .moveText(width / 8, height / 32) // Adjust text position
                .showText(watermarkText)
                .endText();

            pdfCanvas.restoreState();
        }
    }

    private void addHeaderCells(Table table, String... headers) {
        PdfFont boldFont;
        try {
            boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        } catch (Exception e) {
            throw new RuntimeException("Error creating font", e);
        }

        for (String header : headers) {
            Cell cell = new Cell().add(new Paragraph(header))
                    .setBackgroundColor(new DeviceRgb(173, 216, 230)) // Light blue background
                    .setFont(boldFont)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell);
        }
    }
}
