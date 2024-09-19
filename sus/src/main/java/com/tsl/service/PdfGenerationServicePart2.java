
//package com.tsl.service;
//
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.colors.ColorConstants;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.tsl.pojo.S1ArcWelding;
//import com.tsl.pojo.S1CompanyOwnedVehicles;
//import com.tsl.repository.S1ArcWeldingRepository;
//import com.tsl.repository.S1CompanyOwnedVehiclesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class PdfGenerationServicePart2 {
//
//    @Autowired
//    private S1ArcWeldingRepository arcWeldingRepository;
//
//    @Autowired
//    private S1CompanyOwnedVehiclesRepository companyOwnedVehiclesRepository;
//
//    public ByteArrayInputStream generateCombinedPdf(Long loginId, String year) throws IOException {
//        List<S1ArcWelding> arcWeldingList = arcWeldingRepository.findByYearAndLoginId(year, loginId);
//        List<S1CompanyOwnedVehicles> vehiclesList = companyOwnedVehiclesRepository.findByLoginIdAndYear(loginId, year);
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(out);
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//
//        PdfFont font = pdf.getDefaultFont();
//
//        // Add heading
//        Paragraph heading = new Paragraph("Final Report")
//                .setFont(font)
//                .setFontSize(18)
//                .setBold()
//                .setTextAlignment(TextAlignment.CENTER);
//        document.add(heading);
//
//        // Add space between heading and first table
//        document.add(new Paragraph("\n"));
//
//        // Arc Welding Table
//        Paragraph arcWeldingTitle = new Paragraph("Scope 1: Welding Electrodes")
//                .setFont(font)
//                .setFontSize(14)
//                .setBold()
//                .setTextAlignment(TextAlignment.CENTER);
//        document.add(arcWeldingTitle);
//
//        Table arcWeldingTable = new Table(6);
//        arcWeldingTable.addHeaderCell(new Cell().add(new Paragraph("Month").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        arcWeldingTable.addHeaderCell(new Cell().add(new Paragraph("Electrodes Purchased").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        arcWeldingTable.addHeaderCell(new Cell().add(new Paragraph("Electrode Purpose").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        arcWeldingTable.addHeaderCell(new Cell().add(new Paragraph("Open Circuit Voltage").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        arcWeldingTable.addHeaderCell(new Cell().add(new Paragraph("Close Circuit Voltage").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        arcWeldingTable.addHeaderCell(new Cell().add(new Paragraph("Electrodes Cost").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//
//        for (S1ArcWelding welding : arcWeldingList) {
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getMonth())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getElectrodesPurchased()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getElectrodePurpose())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getOpenCircuitVoltage()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getCloseCircuitVoltage()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getElectrodesCost()))));
//        }
//        document.add(arcWeldingTable);
//
//        // Add space between tables
//        document.add(new Paragraph("\n"));
//
//        // Company Owned Vehicles Table
//        Paragraph vehiclesTitle = new Paragraph("Scope 1: Company Owned Vehicles")
//                .setFont(font)
//                .setFontSize(14)
//                .setBold()
//                .setTextAlignment(TextAlignment.CENTER);
//        document.add(vehiclesTitle);
//
//        Table vehiclesTable = new Table(4);
//        vehiclesTable.addHeaderCell(new Cell().add(new Paragraph("Month").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        vehiclesTable.addHeaderCell(new Cell().add(new Paragraph("Consumption").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        vehiclesTable.addHeaderCell(new Cell().add(new Paragraph("Cylinders Purchased").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//        vehiclesTable.addHeaderCell(new Cell().add(new Paragraph("Cylinder Capacity").setFont(font)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//
//        for (S1CompanyOwnedVehicles vehicle : vehiclesList) {
//            vehiclesTable.addCell(new Cell().add(new Paragraph(vehicle.getMonth())));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getConsumption()))));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylindersPurchased()))));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylinderCapacity()))));
//        }
//        document.add(vehiclesTable);
//
//        document.close();
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//}
//
//package com.tsl.service;
//
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfPage;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.tsl.pojo.S1ArcWelding;
//import com.tsl.pojo.S1CompanyOwnedVehicles;
//import com.tsl.repository.S1ArcWeldingRepository;
//import com.tsl.repository.S1CompanyOwnedVehiclesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class PdfGenerationServicePart2 {
//
//    @Autowired
//    private S1ArcWeldingRepository arcWeldingRepository;
//
//    @Autowired
//    private S1CompanyOwnedVehiclesRepository companyOwnedVehiclesRepository;
//
//    
//    
//    public ByteArrayInputStream generateCombinedPdf(Long loginId, String year) throws IOException {
//        List<S1ArcWelding> arcWeldingList = arcWeldingRepository.findByYearAndLoginId(year, loginId);
//        List<S1CompanyOwnedVehicles> vehiclesList = companyOwnedVehiclesRepository.findByLoginIdAndYear(loginId, year);
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(out);
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//
//        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
//
//        // Add watermark
//        addWatermark(pdf, "Techknowgreen Solutions Limited");
//
//        // Title
//        Paragraph title = new Paragraph("Final Report")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(18)
//                .setTextAlignment(TextAlignment.CENTER);
//        document.add(title);
//
//        // Arc Welding Table
//        Table arcWeldingTable = new Table(7);
//        addHeaderCells(arcWeldingTable, "Month", "Year","Electrodes Purchased", "Electrode Purpose", "Open Circuit Voltage", "Close Circuit Voltage", "Electrodes Cost");
//
//        for (S1ArcWelding welding : arcWeldingList) {
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getMonth())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getYear())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getElectrodesPurchased()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getElectrodePurpose())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getOpenCircuitVoltage()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getCloseCircuitVoltage()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getElectrodesCost()))));
//        }
//        document.add(new Paragraph("Scope 1: Welding Electrodes").setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14).setTextAlignment(TextAlignment.CENTER));
//        document.add(arcWeldingTable);
//
//        // Company Owned Vehicles Table
//        Table vehiclesTable = new Table(4);
//        addHeaderCells(vehiclesTable, "Month", "Consumption", "Cylinders Purchased", "Cylinder Capacity");
//
//        for (S1CompanyOwnedVehicles vehicle : vehiclesList) {
//            vehiclesTable.addCell(new Cell().add(new Paragraph(vehicle.getMonth())));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getConsumption()))));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylindersPurchased()))));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylinderCapacity()))));
//        }
//        document.add(new Paragraph("Scope 1: Company Owned Vehicles").setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14).setTextAlignment(TextAlignment.CENTER));
//        document.add(vehiclesTable);
//
//        document.close();
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//
//    private void addWatermark(PdfDocument pdf, String watermarkText) {
//        PdfFont watermarkFont;
//        try {
//            watermarkFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
//        } catch (Exception e) {
//            throw new RuntimeException("Error creating font", e);
//        }
//
//        for (int i = 1; i <= pdf.getNumberOfPages(); i++) {
//            PdfPage page = pdf.getPage(i);
//            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdf);
//
//            // Get the page dimensions
//            float width = page.getPageSize().getWidth();
//            float height = page.getPageSize().getHeight();
//
//            pdfCanvas.saveState();
//
//            // Set the font and size for the watermark text
//            pdfCanvas.setFillColor(new DeviceRgb(200, 200, 200)); // Light gray color for watermark
//
//            // Apply transformation matrix to rotate and position the text
//            pdfCanvas.concatMatrix(
//                (float) Math.cos(Math.toRadians(45)), (float) Math.sin(Math.toRadians(45)),
//                (float) -Math.sin(Math.toRadians(45)), (float) Math.cos(Math.toRadians(45)),
//                width / 4, height / 2 // Position the watermark text in the center
//            );
//
//            pdfCanvas.beginText()
//                .setFontAndSize(watermarkFont, 50) // Adjust font size
//                .moveText(0, 0) // Position the watermark text
//                .showText(watermarkText)
//                .endText();
//
//            pdfCanvas.restoreState();
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
//                    .setBackgroundColor(new DeviceRgb(173, 216, 230)) // Light blue background
//                    .setFont(boldFont)
//                    .setTextAlignment(TextAlignment.CENTER);
//            table.addHeaderCell(cell);
//        }
//    }
//}


//--------------------working fetching 4 tables data ------------------------------------------
//package com.tsl.service;
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfPage;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.properties.HorizontalAlignment;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.itextpdf.layout.properties.UnitValue;
//import com.tsl.pojo.S1Acetylene;
//import com.tsl.pojo.S1ArcWelding;
//import com.tsl.pojo.S1Discharge;
//import com.tsl.pojo.S1LPGConsumption;
//import com.tsl.repository.S1AcetyleneRepository;
//import com.tsl.repository.S1ArcWeldingRepository;
//import com.tsl.repository.S1DischargeRepository;
//import com.tsl.repository.S1LPGConsumptionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class PdfGenerationServicePart2 {
//
//    @Autowired
//    private S1ArcWeldingRepository arcWeldingRepository;
//
//    @Autowired
//    private S1LPGConsumptionRepository companyOwnedVehiclesRepository;
//
//    @Autowired
//    private S1AcetyleneRepository acetyleneRepository;
//    
//    @Autowired
//    private S1DischargeRepository dischargeRepository;
//
//    @Autowired
//    private DownstreamLeasedAssetsRepository downstreamLeasedAssetsRepository;
//    
//    @Autowired
//    private S1CoalUsedRepository s1CoalUsedRepository;
//
//    public ByteArrayInputStream generateCombinedPdf(Long loginId, String year) throws IOException {
//        List<S1ArcWelding> arcWeldingList = arcWeldingRepository.findByYearAndLoginId(year, loginId);
//        List<S1LPGConsumption> vehiclesList = companyOwnedVehiclesRepository.findByLoginIdAndYear(loginId, year);
//        List<S1Acetylene> acetyleneList = acetyleneRepository.findByLoginIdAndYear(loginId, year);
//        List<S1Discharge> dischargeList = dischargeRepository.findByLogin_IdAndYear(loginId, year); // Fetch discharge data
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(out);
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//
//        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
//
//        // Add watermark
//        addWatermark(pdf, "Techknowgreen Solutions Limited");
//
//        // Title
//        Paragraph title = new Paragraph("Final Report")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(18)
//                .setTextAlignment(TextAlignment.CENTER);
//        document.add(title);
//
//        // Arc Welding Table
//        Table arcWeldingTable = new Table(7);
//        arcWeldingTable.setWidth(UnitValue.createPercentValue(95)); // 95% of page width
//        arcWeldingTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(arcWeldingTable, "Month", "Year", "Electrodes Purchased", "Electrode Purpose", "Open Circuit Voltage", "Close Circuit Voltage", "Electrodes Cost");
//
//        for (S1ArcWelding welding : arcWeldingList) {
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getMonth())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getYear())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getElectrodesPurchased()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(welding.getElectrodePurpose())));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getOpenCircuitVoltage()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getCloseCircuitVoltage()))));
//            arcWeldingTable.addCell(new Cell().add(new Paragraph(String.valueOf(welding.getElectrodesCost()))));
//        }
//        document.add(new Paragraph("Scope 1: Welding Electrodes")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(arcWeldingTable);
//
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
//
//        // Company Owned Vehicles Table
//        Table vehiclesTable = new Table(5);
//        vehiclesTable.setWidth(UnitValue.createPercentValue(95)); // 95% of page width
//        vehiclesTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(vehiclesTable, "Month", "Year", "Consumption", "Cylinders Purchased", "Cylinder Capacity");
//
//        for (S1LPGConsumption vehicle : vehiclesList) {
//            vehiclesTable.addCell(new Cell().add(new Paragraph(vehicle.getMonth())));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(vehicle.getYear())));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getConsumption()))));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylindersPurchased()))));
//            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylinderCapacity()))));
//        }
//        document.add(new Paragraph("Scope 1: LPG Consumption in Canteen")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(vehiclesTable);
//
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
//
//        // S1 Acetylene Table
//        Table acetyleneTable = new Table(5);
//        acetyleneTable.setWidth(UnitValue.createPercentValue(95)); // 95% of page width
//        acetyleneTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(acetyleneTable, "Month", "Year", "Acetylene Cylinder Purchased", "Cylinder Capacity", "Material Cost");
//
//        for (S1Acetylene acetylene : acetyleneList) {
//            acetyleneTable.addCell(new Cell().add(new Paragraph(acetylene.getMonth())));
//            acetyleneTable.addCell(new Cell().add(new Paragraph(acetylene.getYear())));
//            acetyleneTable.addCell(new Cell().add(new Paragraph(String.valueOf(acetylene.getAcetyleneCylinderPurchased()))));
//            acetyleneTable.addCell(new Cell().add(new Paragraph(String.valueOf(acetylene.getCylinderCapacity()))));
//            acetyleneTable.addCell(new Cell().add(new Paragraph(String.valueOf(acetylene.getMaterialCost()))));
//        }
//        document.add(new Paragraph("Scope 1: Acetylene Cylinder")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(acetyleneTable);
//
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
//
//        // S1 Discharge Table
//        Table dischargeTable = new Table(4); // Adjusted for discharge table
//        dischargeTable.setWidth(UnitValue.createPercentValue(95)); // 95% of page width
//        dischargeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(dischargeTable, "Month", "Year", "Molasis Used", "CO2 Released Fermentation");
//
//        for (S1Discharge discharge : dischargeList) {
//            dischargeTable.addCell(new Cell().add(new Paragraph(discharge.getMonth())));
//            dischargeTable.addCell(new Cell().add(new Paragraph(discharge.getYear())));
//            dischargeTable.addCell(new Cell().add(new Paragraph(String.valueOf(discharge.getMolasisUsed()))));
//            dischargeTable.addCell(new Cell().add(new Paragraph(String.valueOf(discharge.getCo2ReleasedFermentation()))));
//        }
//        document.add(new Paragraph("Scope 1: Discharge of CO2 due to fermentation distillery ")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(dischargeTable);

        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
//
//        // S1 Discharge Table
//        Table dischargeTable = new Table(4);
//        dischargeTable.setWidth(UnitValue.createPercentValue(95));
//        dischargeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(dischargeTable, "Month", "Year", "Molasis Used", "CO2 Released Fermentation");
//
//        for (S1Discharge discharge : dischargeList) {
//            dischargeTable.addCell(new Cell().add(new Paragraph(discharge.getMonth())));
//            dischargeTable.addCell(new Cell().add(new Paragraph(discharge.getYear())));
//            dischargeTable.addCell(new Cell().add(new Paragraph(String.valueOf(discharge.getMolasisUsed()))));
//            dischargeTable.addCell(new Cell().add(new Paragraph(String.valueOf(discharge.getCo2ReleasedFermentation()))));
//        }
//        document.add(new Paragraph("Scope 1: Discharge of CO2 due to fermentation distillery ")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(dischargeTable);
//
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
//
//        // Downstream Leased Assets Table
//        Table leasedAssetsTable = new Table(7);
//        leasedAssetsTable.setWidth(UnitValue.createPercentValue(95));
//        leasedAssetsTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(leasedAssetsTable, "Month", "Year", "Area of Leased Assets", "Scope 1 Diesel in DG Sets", "Scope 2 Electricity Consumption", "Total Built-Up Area of Building", "Total Building Occupancy Rate");
//
//        for (DownstreamLeasedAssets assets : downstreamLeasedAssetsList) {
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(assets.getMonth())));
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(assets.getYear())));
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(String.valueOf(assets.getAreaOfLeasedAssets()))));
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(String.valueOf(assets.getScope1DieselInDGSets()))));
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(String.valueOf(assets.getScope2ElectricityConsumption()))));
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(String.valueOf(assets.getTotalBuiltUpAreaOfBuilding()))));
//            leasedAssetsTable.addCell(new Cell().add(new Paragraph(String.valueOf(assets.getTotalBuildingOccupancyRate()))));
//        }
//        document.add(new Paragraph("Scope 3: Downstream Leased Assets")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(leasedAssetsTable);
//        
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
//        
//        
//        Table coalUsedTable = new Table(6);
//        coalUsedTable.setWidth(UnitValue.createPercentValue(95));
//        coalUsedTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//
//        // Add header cells
//        addHeaderCells(coalUsedTable, "Month", "Year", "Monthly Bagasse Purchased", "Type Of Bagasse", "Monthly Bagasse Used", "Coal Cost");
//
//        // Add data rows
//        for (S1CoalUsed coalUsed : coalUsedList) {
//            coalUsedTable.addCell(coalUsed.getMonth());
//            coalUsedTable.addCell(coalUsed.getYear());
//            coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//            coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//            coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//            coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//        }
//
//        // Add the table to the document
//        document.add(new Paragraph("Scope 1: Coal/ bagasse Used  (bagasse is by product )")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(coalUsedTable);
//        addWatermark(pdf, "Techknowgreen Solutions Limited");
//        document.close();
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//
//    private void addWatermark(PdfDocument pdf, String watermarkText) {
//        PdfFont watermarkFont;
//        try {
//            watermarkFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
//        } catch (Exception e) {
//            throw new RuntimeException("Error creating font", e);
//        }
//
//        for (int i = 1; i <= pdf.getNumberOfPages(); i++) {
//            PdfPage page = pdf.getPage(i);
//            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdf);
//
//            // Get the page dimensions
//            float width = page.getPageSize().getWidth();
//            float height = page.getPageSize().getHeight();
//
//            pdfCanvas.saveState();
//
//            // Set the font and size for the watermark text
//            pdfCanvas.setFillColor(new DeviceRgb(200, 200, 200)); // Light gray color for watermark
//
//            // Apply transformation matrix to rotate and position the text
//            pdfCanvas.concatMatrix(
//                (float) Math.cos(Math.toRadians(50)), (float) Math.sin(Math.toRadians(50)),
//                (float) -Math.sin(Math.toRadians(50)), (float) Math.cos(Math.toRadians(50)),
//                width / 8, height / 128
//            );
//
//            pdfCanvas.beginText()
//                .setFontAndSize(watermarkFont, 40)
//                .moveText(width / 8, height / 32) // Adjust text position
//                .showText(watermarkText)
//                .endText();
//
//            pdfCanvas.restoreState();
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
//                    .setBackgroundColor(new DeviceRgb(173, 216, 230)) // Light blue background
//                    .setFont(boldFont)
//                    .setTextAlignment(TextAlignment.CENTER);
//            table.addHeaderCell(cell);
//        }
//    }
//}


//----------------------------------------------best working fetching 6 tables 
package com.tsl.service;

import com.itextpdf.io.font.constants.StandardFonts;
import java.text.DecimalFormat;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.tsl.pojo.S1Acetylene;
import com.tsl.pojo.S1CoalUsed;
import com.tsl.pojo.S1CompanyOwnedVehicle;
import com.tsl.pojo.S1Discharge;
import com.tsl.pojo.S1FireExtinguisher;
import com.tsl.pojo.S1LPGConsumption;
import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.pojo.S3PurchasedGoodsAndServices;
import com.tsl.pojo.WasteGenerated;
import com.tsl.pojo.BusinessTravelAir;
import com.tsl.pojo.BusinessTravelHotelStay;
import com.tsl.pojo.BusinessTravelRail;
import com.tsl.pojo.BusinessTravelRoad;
import com.tsl.pojo.EmployeeCommute;
import com.tsl.pojo.GeneralInformation;
import com.tsl.repository.S1AcetyleneRepository;
import com.tsl.repository.S1CoalUsedRepository;
import com.tsl.repository.S1CompanyOwnedVehicleRepository;
import com.tsl.repository.S1DischargeRepository;
import com.tsl.repository.S1FireExtinguisherRepository;
import com.tsl.repository.S1LPGConsumptionRepository;
import com.tsl.repository.S2PurchasedElectricityRepository;
import com.tsl.repository.S3PurchasedGoodsAndServicesRepository;
import com.tsl.repository.WasteGeneratedRepository;
import com.tsl.repository.BusinessTravelAirRepository;
import com.tsl.repository.BusinessTravelHotelStayRepository;
import com.tsl.repository.BusinessTravelRailRepository;
import com.tsl.repository.BusinessTravelRoadRepository;
import com.tsl.repository.EmployeeCommuteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfGenerationServicePart2 {



    @Autowired
    private S1LPGConsumptionRepository s1LPGConsumptionRepository;

    @Autowired
    private S1AcetyleneRepository acetyleneRepository;
    
    @Autowired
    private S1DischargeRepository dischargeRepository;


    
    @Autowired
    private S1CoalUsedRepository s1CoalUsedRepository;
    

    
    @Autowired
    private S2PurchasedElectricityRepository s2PurchasedElectricityRepository;

    
 
    
    @Autowired
    private S1FireExtinguisherRepository fireExtinguisherRepository;
    
    
    @Autowired
    private S3PurchasedGoodsAndServicesRepository s3PurchasedGoodsAndServicesRepository;
    
    
    @Autowired
    private WasteGeneratedRepository wasteGeneratedRepository;
    
    
    @Autowired
    private BusinessTravelAirRepository businessTravelAirRepository;
    
    @Autowired
    private BusinessTravelRailRepository businessTravelRailRepository;
    
    @Autowired
    private BusinessTravelRoadRepository businessTravelRoadRepository;
    
    
    @Autowired
    private BusinessTravelHotelStayRepository businessTravelHotelStayRepository;
    
    
    @Autowired
    private S1CompanyOwnedVehicleRepository companyOwnedVehicleRepository;
    
    @Autowired
    private EmployeeCommuteRepository employeeCommuteRepository;
    
    
    
    public ByteArrayInputStream generateCombinedPdf(Long loginId, String year) throws IOException {
        List<S1LPGConsumption> lpgsList = s1LPGConsumptionRepository.findByLoginIdAndYear(loginId, year);
        List<S1Acetylene> acetyleneList = acetyleneRepository.findByLoginIdAndYear(loginId, year);
        List<S1Discharge> dischargeList = dischargeRepository.findByLogin_IdAndYear(loginId, year); 
        List<S1CoalUsed> coalUsedList = s1CoalUsedRepository.findByLoginIdAndYear(loginId, year);
        List<S2PurchasedElectricity> purchasedElectricityList = s2PurchasedElectricityRepository.findByLoginIdAndYear(loginId, year);
        List<S1FireExtinguisher> fireExtinguisherList = fireExtinguisherRepository.findByLoginIdAndYear(loginId, year);
        List<S3PurchasedGoodsAndServices> purchasedGoodsAndServicesList=s3PurchasedGoodsAndServicesRepository.findByLoginIdAndYear(loginId, year);
        List<WasteGenerated> wasteGeneratedList = wasteGeneratedRepository.findByLogin_IdAndYear(loginId, year);
        List<BusinessTravelAir> businessTravelAirList = businessTravelAirRepository.findByLoginIdAndYear(loginId, year);
        List<BusinessTravelRail> businessTravelRailList = businessTravelRailRepository.findByLoginIdAndYear(loginId, year);
        List<BusinessTravelRoad> businessTravelRoadList = businessTravelRoadRepository.findByLoginIdAndYear(loginId, year);
        List<BusinessTravelHotelStay> businessTravelHotelStayList = businessTravelHotelStayRepository.findByLoginIdAndYear(loginId, year);
        List<S1CompanyOwnedVehicle> vehicleList = companyOwnedVehicleRepository.findByLoginIdAndYear(loginId, year);
        List<EmployeeCommute> employeeCommuteList = employeeCommuteRepository.findByLoginIdAndYear(loginId, year);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        DecimalFormat formatter = new DecimalFormat("#");


        // Title
        Paragraph title = new Paragraph("Final Report")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(title);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(50));
        
        


        

//----------------------------------LPG-----------------------------
      /*
        // Scope 1: LPG Consumption in Canteen
        Table vehiclesTable = new Table(4);
        vehiclesTable.setWidth(UnitValue.createPercentValue(95));
        vehiclesTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
        addHeaderCells(vehiclesTable, "Month","Consumption", "Cylinders Purchased", "Cylinder Capacity");

        for (S1LPGConsumption vehicle : lpgsList) {
            vehiclesTable.addCell(new Cell().add(new Paragraph(vehicle.getMonth())));
            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getConsumption()))));
            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylindersPurchased()))));
            vehiclesTable.addCell(new Cell().add(new Paragraph(String.valueOf(vehicle.getCylinderCapacity()))));
        }
        document.add(new Paragraph("Scope 1: LPG Consumption in Canteen")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(vehiclesTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));
    */
     // Create a new table with 4 columns
        Table vehiclesTable = new Table(UnitValue.createPercentArray(new float[]{1, 2, 2, 2}));
        vehiclesTable.setWidth(UnitValue.createPercentValue(95));
        vehiclesTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add header cells
        addHeaderCells(vehiclesTable, "Month", "Consumption (UOM)", "Cylinder Capacity (UOM)", "CO2 Emission");

        // Populate the table with data
        for (S1LPGConsumption lpg : lpgsList) {
            vehiclesTable.addCell(new Cell().add(new Paragraph(lpg.getMonth())));
            
            // Combine consumption and UOM into one cell
            String consumptionText = String.format("%.2f %s", lpg.getConsumption(), lpg.getConsumptionUOM());
            vehiclesTable.addCell(new Cell().add(new Paragraph(consumptionText)));
            
            // Combine cylinder capacity and UOM into one cell
            String cylinderCapacityText = String.format("%.2f %s", lpg.getCylinderCapacity(), lpg.getCylinderCapacityUOM());
            vehiclesTable.addCell(new Cell().add(new Paragraph(cylinderCapacityText)));
            
            // Add CO2 emission
            vehiclesTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", lpg.getCo2Emission()))));
        }

        // Add the total CO2 emission row
        if (!lpgsList.isEmpty()) {
            double totalCO2Emission = lpgsList.stream().mapToDouble(S1LPGConsumption::getCo2Emission).sum();
            vehiclesTable.addCell(new Cell(1, 3).add(new Paragraph("Total CO2 Emission")).setBold());
            vehiclesTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", totalCO2Emission))));
        }

        // Add a title and the table to the document
        document.add(new Paragraph("Scope 1: LPG Consumption in Canteen")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(vehiclesTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));


        //--------------------------------------------------------
/*
        // S1 Acetylene Table
        Table acetyleneTable = new Table(4);
        acetyleneTable.setWidth(UnitValue.createPercentValue(95));
        acetyleneTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
        addHeaderCells(acetyleneTable, "Month","Acetylene Cylinder Purchased", "Cylinder Capacity", "Material Cost");

        for (S1Acetylene acetylene : acetyleneList) {
            acetyleneTable.addCell(new Cell().add(new Paragraph(acetylene.getMonth())));
            acetyleneTable.addCell(new Cell().add(new Paragraph(String.valueOf(acetylene.getAcetyleneCylinderPurchased()))));
            acetyleneTable.addCell(new Cell().add(new Paragraph(String.valueOf(acetylene.getCylinderCapacity()))));
            acetyleneTable.addCell(new Cell().add(new Paragraph(String.valueOf(acetylene.getMaterialCost()))));
        }
        document.add(new Paragraph("Scope 1: Acetylene Cylinder")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(acetyleneTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(60));
*/

        DecimalFormat decimalFormat = new DecimalFormat("#.##"); 

        document.setMargins(40, 40, 40, 40);

        // S1 Acetylene Table with fixed widths
        Table acetyleneTable = new Table(new float[]{2, 4, 4, 4, 4}); 
        acetyleneTable.setWidth(UnitValue.createPercentValue(100)); 
        acetyleneTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        addHeaderCells(acetyleneTable, "Month", "Acetylene Cylinder Purchased", "Cylinder Capacity", "Material Cost(Rs)", "Monthly Emission");

        Double yearlyEmission = null;

        for (int i = 0; i < acetyleneList.size(); i++) {
            S1Acetylene acetylene = acetyleneList.get(i);

            acetyleneTable.addCell(new Cell().add(new Paragraph(acetylene.getMonth())
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10))); 
            
            acetyleneTable.addCell(new Cell().add(new Paragraph(decimalFormat.format(acetylene.getAcetyleneCylinderPurchased()))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10))); 

            String cylinderCapacityWithUOM = decimalFormat.format(acetylene.getCylinderCapacity()) + " " + acetylene.getCylinderCapacityUOM();
            acetyleneTable.addCell(new Cell().add(new Paragraph(cylinderCapacityWithUOM)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10))); 
            
            acetyleneTable.addCell(new Cell().add(new Paragraph(decimalFormat.format(acetylene.getMaterialCost()))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10)));

            acetyleneTable.addCell(new Cell().add(new Paragraph(decimalFormat.format(acetylene.getMonthlyEmission()))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10))); 

            if (i == 0) {
                yearlyEmission = acetylene.getYearlyEmission();
            }
        }

        if (yearlyEmission != null) {
            acetyleneTable.addCell(new Cell(1, 5).add(new Paragraph(""))); 
            acetyleneTable.addCell(new Cell(1, 3)
                    .add(new Paragraph("Total Emission"))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(10));

            acetyleneTable.addCell(new Cell().add(new Paragraph(""))); 

            acetyleneTable.addCell(new Cell().add(new Paragraph(decimalFormat.format(yearlyEmission)))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(10)); 
        }

        document.add(new Paragraph("Scope 1: Acetylene Cylinder")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(10));

        document.add(acetyleneTable); 

        document.add(new Paragraph().setMarginBottom(60));


        //---------------------------------------S1 Discharge Table---------------------------------------------
        // S1 Discharge Table
        
        /*
        Table dischargeTable = new Table(3);
        dischargeTable.setWidth(UnitValue.createPercentValue(95));
        dischargeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
        addHeaderCells(dischargeTable, "Month","Molasis Used", "CO2 Released Fermentation");

        for (S1Discharge discharge : dischargeList) {
            dischargeTable.addCell(new Cell().add(new Paragraph(discharge.getMonth())));
            dischargeTable.addCell(new Cell().add(new Paragraph(String.valueOf(discharge.getMolasisUsed()))));
            dischargeTable.addCell(new Cell().add(new Paragraph(String.valueOf(discharge.getCo2ReleasedFermentation()))));
        }
        document.add(new Paragraph("Scope 1: Discharge of CO2 due to fermentation distillery ")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(dischargeTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));
*/
        

        Paragraph heading = new Paragraph("Scope 1: Discharge of CO2 due to fermentation distillery ")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER);

        Table dischargeTable = new Table(5); // Changed to 5 columns
        dischargeTable.setWidth(UnitValue.createPercentValue(95));
        dischargeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        addHeaderCells(dischargeTable, "Month", "Molasis Used (UOM)", "CO2 Released (UOM)", "Ethanol Produced (UOM)", "Monthly Emission"); 

        Double percentageOfSugarInMolasis = null;


        for (int i = 0; i < dischargeList.size(); i++) {
            S1Discharge discharge = dischargeList.get(i);
            
            if (i == 0) {
                percentageOfSugarInMolasis = discharge.getPercentageOfSugarInMolasis();
            }
            
            String molasisUsedFormatted = decimalFormat.format(discharge.getMolasisUsed());
            String co2ReleasedFormatted = decimalFormat.format(discharge.getCo2ReleasedFermentation());
            String ethanolProducedFormatted = decimalFormat.format(discharge.getEthanolProduced());
            String monthlyEmissionFormatted = decimalFormat.format(discharge.getMonthlyEmission()) + " Tonnes";

            dischargeTable.addCell(new Cell().add(new Paragraph(discharge.getMonth())).setFontSize(10));
            dischargeTable.addCell(new Cell().add(new Paragraph(molasisUsedFormatted + " " + discharge.getMolasisUsedUOM())).setFontSize(10));
            dischargeTable.addCell(new Cell().add(new Paragraph(co2ReleasedFormatted + " " + discharge.getCo2ReleasedFermentationUOM())).setFontSize(10));
            dischargeTable.addCell(new Cell().add(new Paragraph(ethanolProducedFormatted + " " + discharge.getEthanolProducedUOM())).setFontSize(10));
            dischargeTable.addCell(new Cell().add(new Paragraph(monthlyEmissionFormatted)).setFontSize(10));
            
            yearlyEmission = discharge.getYearlyEmission();
        }

        document.add(heading);

        Paragraph percentageParagraph = new Paragraph("Percentage of Sugar in Molasis: " + percentageOfSugarInMolasis + "%")
                .setFontSize(10)
                .setMarginBottom(10)
                .setTextAlignment(TextAlignment.LEFT);
        document.add(percentageParagraph);
        document.add(dischargeTable);

        document.add(new Paragraph().setMarginBottom(40));

        if (yearlyEmission != null) {
            String yearlyEmissionFormatted = decimalFormat.format(yearlyEmission) + " Tonnes";

            Table emissionTable = new Table(3);
            emissionTable.setWidth(UnitValue.createPercentValue(95));
            emissionTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
            
            emissionTable.addCell(new Cell(1, 2).add(new Paragraph("Total CO2 Emission")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(10)));
            
            emissionTable.addCell(new Cell().add(new Paragraph(yearlyEmissionFormatted))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(10));
            
            document.add(emissionTable);
        }




      //-------------------------------------------------------------------------------------  
     // Assume coalUsedList is a list of S1CoalUsed objects
     // Assume coalUsedList is a list of S1CoalUsed objects

//     // coal bagasse table
//        Table coalUsedTable = new Table(6); // Updated to include 6 columns instead of 7
//        coalUsedTable.setWidth(UnitValue.createPercentValue(95));
//        coalUsedTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//
//        addHeaderCells(coalUsedTable, 
//            "Month",
//            "Monthly Coal Purchased", 
//            "Type Of Coal", 
//            "Monthly Coal Used", 
//            "Coal Cost",
//            "Monthly Emissions"   // New header, removed the Yearly Emissions header
//        );
//
//        double totalYearlyEmissions = 0.0;
//
//        // Add data rows and calculate totalYearlyEmissions
//        for (S1CoalUsed coalUsed : coalUsedList) {
//            coalUsedTable.addCell(coalUsed.getMonth());
//            coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//            coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//            coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//            coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//            coalUsedTable.addCell(String.format("%.2f", coalUsed.getTotalEmissions()));   // Format to 2 decimal places
//            
//            totalYearlyEmissions += coalUsed.getTotalEmissions();
//        }
//
//        // Add a blank row to separate data from the Yearly Emissions total
//        coalUsedTable.addCell(new Cell(1, 4).add(new Paragraph("")));
//
//        // Add the "Yearly Emissions" label in the last row
//        coalUsedTable.addCell(new Cell().add(new Paragraph("Yearly Emissions")
//            .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//            .setTextAlignment(TextAlignment.CENTER)));
//
//        // Add the total yearly emissions value, formatted to 2 decimal places
//        coalUsedTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", totalYearlyEmissions))
//            .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//            .setTextAlignment(TextAlignment.CENTER)));
//
//        // Add the table to the document
//        document.add(new Paragraph("Scope 1: Coal Used")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(coalUsedTable);
//
//        document.add(new Paragraph().setMarginBottom(40));

     // coal bagasse table
        Table coalUsedTable = new Table(6); 
        coalUsedTable.setWidth(UnitValue.createPercentValue(95));
        coalUsedTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
        coalUsedTable.setFontSize(10); 

        addHeaderCells(coalUsedTable, 
            "Month",
            "Monthly Coal Purchased", 
            "Type Of Coal", 
            "Monthly Coal Used", 
            "Coal Cost",
            "Monthly Emissions"   
        );

        double totalYearlyEmissions = 0.0;

        for (S1CoalUsed coalUsed : coalUsedList) {
            coalUsedTable.addCell(coalUsed.getMonth());
            coalUsedTable.addCell(formatNumber(coalUsed.getMonthlyCoalPurchased())+ " Tonnes"); 
            coalUsedTable.addCell(coalUsed.getTypeOfCoal()); 
            coalUsedTable.addCell(formatNumber(coalUsed.getMonthlyCoalUsed())+ " Tonnes"); 
            coalUsedTable.addCell(formatNumber(coalUsed.getCoalCost())); 
            coalUsedTable.addCell(formatNumber(coalUsed.getTotalEmissions()));   
            
            totalYearlyEmissions += coalUsed.getTotalEmissions();
        }

        coalUsedTable.addCell(new Cell(1, 4).add(new Paragraph("").setFontSize(10)));

        coalUsedTable.addCell(new Cell().add(new Paragraph("Yearly Emissions")
            .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
            .setTextAlignment(TextAlignment.CENTER)
            .setFontSize(10))); 

        coalUsedTable.addCell(new Cell().add(new Paragraph(formatNumber(totalYearlyEmissions) + " tCO2e")
            .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
            .setTextAlignment(TextAlignment.CENTER)
            .setFontSize(10))); 

        document.add(new Paragraph("Scope 1: Coal Used")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(coalUsedTable);

        document.add(new Paragraph().setMarginBottom(40));


//     // coal bagasse table
//     Table coalUsedTable = new Table(7); // Updated to include 7 columns
//     coalUsedTable.setWidth(UnitValue.createPercentValue(95));
//     coalUsedTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//
//     // Add header cells
//     addHeaderCells(coalUsedTable, 
//         "Month",
//         "Monthly Bagasse Purchased", 
//         "Type Of Bagasse", 
//         "Monthly Bagasse Used", 
//         "Coal Cost",
//         "Total Emissions",   // New header
//         "Yearly Emissions"   // New header
//     );
//
//     // Add data rows
//     for (S1CoalUsed coalUsed : coalUsedList) {
//         coalUsedTable.addCell(coalUsed.getMonth());
//         coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagassePurchased()));
//         coalUsedTable.addCell(coalUsed.getTypeOfBagasse());
//         coalUsedTable.addCell(String.valueOf(coalUsed.getMonthlyBagasseUsed()));
//         coalUsedTable.addCell(String.valueOf(coalUsed.getCoalCost()));
//         coalUsedTable.addCell(String.valueOf(coalUsed.getTotalEmissions()));   // New data column
//         coalUsedTable.addCell(String.valueOf(coalUsed.getYearlyEmissions()));  // New data column
//     }
//
//     // Add the table to the document
//     document.add(new Paragraph("Scope 1: Coal/Bagasse Used (Bagasse is by-product)")
//             .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//             .setFontSize(14)
//             .setTextAlignment(TextAlignment.CENTER));
//     document.add(coalUsedTable);
//
//     // Add spacing before the next table
//     document.add(new Paragraph().setMarginBottom(40));
//
//     // Assuming yearly_emissions is the same for all rows
//     if (!coalUsedList.isEmpty()) {
//         double yearlyEmissions = coalUsedList.get(0).getYearlyEmissions();
//         
//         // Add yearly emissions below the table
//         document.add(new Paragraph("Yearly Emissions: " + String.format("%.2f", yearlyEmissions))
//                 .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                 .setFontSize(12)
//                 .setTextAlignment(TextAlignment.RIGHT));
//     }


        //--------------------------------earlier S2PurchasedElectricity--------------------------------------------------
       /* 
     // Create Table for S2PurchasedElectricity
        Table purchasedElectricityTable = new Table(6);
        purchasedElectricityTable.setWidth(UnitValue.createPercentValue(95));
        purchasedElectricityTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        addHeaderCells(purchasedElectricityTable, "Month","Electricity Imported", "Imported Charges", "Electricity Exported", "Fuel Used", "Fuel Quantity");

        for (S2PurchasedElectricity electricity : purchasedElectricityList) {
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(electricity.getMonth())));
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(String.valueOf(electricity.getElectricityImported()))));
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(String.valueOf(electricity.getImportedCharges()))));
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(String.valueOf(electricity.getElectricityExported()))));
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(electricity.getFuelUsed())));
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(String.valueOf(electricity.getFuelQuantity()))));
        }

        document.add(new Paragraph("Scope 2: Electricity Consumption")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(purchasedElectricityTable);

        document.add(new Paragraph().setMarginBottom(40));
        */
//------------------------------------------- now S2PurchasedElectricity----------------------------------------
        
        
     // Create Table for S2PurchasedElectricity
        Table purchasedElectricityTable = new Table(9); // Adjusted for the number of columns
        purchasedElectricityTable.setWidth(UnitValue.createPercentValue(95));
        purchasedElectricityTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add Header Cells
        addHeaderCells(purchasedElectricityTable, "Month", "Electricity Imported", "Imported Charges", "Electricity Exported", 
                        "Exported Charges", "Fuel Used", "Fuel Quantity", "Imported Emission", "Exported Emission");

        // Create DecimalFormat to format decimal values to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.##");

        // Initialize variable to hold total emission
        double totalEmission = 0;

        // Add Data Rows
        for (S2PurchasedElectricity electricity : purchasedElectricityList) {
            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(electricity.getMonth()))
                .setFontSize(10)); // Reducing font size

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getElectricityImported()) + " " + electricity.getElectricityImportedUOM()))
                .setFontSize(10)); // Format decimal value

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getImportedCharges())))
                .setFontSize(10)); // Format decimal value

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getElectricityExported()) + " " + electricity.getElectricityExportedUOM()))
                .setFontSize(10)); // Format decimal value

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getExportedCharges())))
                .setFontSize(10)); // Format decimal value

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(electricity.getFuelUsed()))
                .setFontSize(10).setTextAlignment(TextAlignment.LEFT)); // Wrap long text, reduce font size

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getFuelQuantity()) + " " + electricity.getFuelUOM()))
                .setFontSize(10)); // Format decimal value

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getImportedEmission())))
                .setFontSize(10)); // Format decimal value

            purchasedElectricityTable.addCell(new Cell().add(new Paragraph(df.format(electricity.getExportedEmission())))
                .setFontSize(10)); // Format decimal value

            // Assuming you want to get the totalEmission from the first row's data
            if (purchasedElectricityList.indexOf(electricity) == 0) {
                totalEmission = electricity.getTotalEmission();
            }
        }

        // Add Total Emission Row (Bold and aligned to the right)
        purchasedElectricityTable.addCell(new Cell(1, 8) // Span across all columns except the last one
                .add(new Paragraph("Total Emission")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(10))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)); // Align to the right

        purchasedElectricityTable.addCell(new Cell()
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .add(new Paragraph(String.format("%.2f Tonnes", totalEmission)))
                .setFontSize(10)) // Format decimal value
                .setHorizontalAlignment(HorizontalAlignment.RIGHT); // Align to the right

        // Add Title and Table to Document
        document.add(new Paragraph("Scope 2: Electricity Consumption")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(purchasedElectricityTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));





     //---------------------------------------------------------------------------------------------------------------------------------------

        
//        // S1 Fire Extinguisher Table
//        Table fireExtinguisherTable = new Table(4);
//        fireExtinguisherTable.setWidth(UnitValue.createPercentValue(95));
//        fireExtinguisherTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(fireExtinguisherTable, "Type", "Annual Refilling Quantity", "Cylinders Purchased", "Capacity of Cylinder");
//
//        for (S1FireExtinguisher extinguisher : fireExtinguisherList) {
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(extinguisher.getType())));
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getAnnualRefillingQuantity()))));
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getCylindersPurchased()))));
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getCapacityOfCylinder()))));
//        }
//
//        // Retrieve the aggregate total tonnes from the first row
//        double aggregateTotalTonnes = fireExtinguisherList.get(0).getAggregateTotalTonnes();
//
//        // Add the aggregate total row
//        fireExtinguisherTable.addCell(new Cell(1, 3) // Span across 3 columns
//                .add(new Paragraph("Total Emission"))
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setTextAlignment(TextAlignment.RIGHT));
//        fireExtinguisherTable.addCell(new Cell()
//        		.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .add(new Paragraph(String.format("%.2f Tonnes", aggregateTotalTonnes))));
//
//
//        // Add table and header to document
//        document.add(new Paragraph("Scope 1: Fire Extinguisher Refilling ")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(fireExtinguisherTable);
//
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));

        
        //---------------------------------------------------------------------------------------------------------------------------------------

     // S1 Fire Extinguisher Table
        Table fireExtinguisherTable = new Table(5);
        fireExtinguisherTable.setWidth(UnitValue.createPercentValue(95));
        fireExtinguisherTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add table headers
        addHeaderCells(fireExtinguisherTable, "Type", "Annual Refilling Quantity", "Cylinders Purchased", "Capacity of Cylinder", "Emission");

        // Populate the table with extinguisher data
        for (S1FireExtinguisher extinguisher : fireExtinguisherList) {
            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(extinguisher.getType())));
            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getAnnualRefillingQuantity()))));
            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getCylindersPurchased()))));
            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getCapacityOfCylinder()))));
            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", extinguisher.getTotalTonnes()))));
        }

     // Get the aggregate total tonnes from the first row
        double aggregateTotalTonnes = fireExtinguisherList.isEmpty() ? 0.0 : fireExtinguisherList.get(0).getAggregateTotalTonnes();


        // Add the aggregate total row
        fireExtinguisherTable.addCell(new Cell(1, 4) // Span across 3 columns
                .add(new Paragraph("Total Emission"))
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setTextAlignment(TextAlignment.RIGHT));
        fireExtinguisherTable.addCell(new Cell()
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .add(new Paragraph(String.format("%.2f Tonnes", aggregateTotalTonnes))));

        // Add title and table to document
        document.add(new Paragraph("Scope 1: Fire Extinguisher Refilling (CO2/DCP/FOAM Type)")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(fireExtinguisherTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));

        
        //---------------------------------------------------------------------------------------------------------------------------------------
//        // S1 Fire Extinguisher Table
//        Table fireExtinguisherTable = new Table(4);
//        fireExtinguisherTable.setWidth(UnitValue.createPercentValue(95));
//        fireExtinguisherTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        addHeaderCells(fireExtinguisherTable, "Type", "Annual Refilling Quantity", "Cylinders Purchased", "Capacity of Cylinder");
//
//        for (S1FireExtinguisher extinguisher : fireExtinguisherList) {
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(extinguisher.getType())));
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getAnnualRefillingQuantity()))));
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getCylindersPurchased()))));
//            fireExtinguisherTable.addCell(new Cell().add(new Paragraph(String.valueOf(extinguisher.getCapacityOfCylinder()))));
//        }
//        document.add(new Paragraph("Scope 1: Fire Extinguisher Refilling (CO2/DCP/FOAM Type)")
//                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
//                .setFontSize(14)
//                .setTextAlignment(TextAlignment.CENTER));
//        document.add(fireExtinguisherTable);
//
//        // Add spacing before the next table
//        document.add(new Paragraph().setMarginBottom(40));
        

        // S3 Purchased Goods and Services Table
        Table goodsServicesTable = new Table(4);
        goodsServicesTable.setWidth(UnitValue.createPercentValue(95));
        goodsServicesTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
        addHeaderCells(goodsServicesTable, "Name of Goods/Services","Classification of Goods/Services", "Quantity Unit Purchased (Annually)", "Unit Of Measurement");

        for (S3PurchasedGoodsAndServices item : purchasedGoodsAndServicesList) {
            goodsServicesTable.addCell(new Cell().add(new Paragraph(item.getNameOfGoodsServices())));
            goodsServicesTable.addCell(new Cell().add(new Paragraph(item.getClassificationOfGoodsServices())));
            goodsServicesTable.addCell(new Cell().add(new Paragraph(String.valueOf(item.getQuantityUnitPurchasedAnnually()))));
            goodsServicesTable.addCell(new Cell().add(new Paragraph(item.getUnitOfMeasurement())));
        }

        document.add(new Paragraph("Category 1: Purchased Goods and Services")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(goodsServicesTable);

        // Add spacing before the next section
        document.add(new Paragraph().setMarginBottom(40));

        
        // Waste Generated Table
        Table wasteGeneratedTable = new Table(6); // Adjust column count based on your needs
        wasteGeneratedTable.setWidth(UnitValue.createPercentValue(95));
        wasteGeneratedTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Adding header cells
        addHeaderCells(wasteGeneratedTable,"Type of Waste", "Unit of Measurement", "Annual Quantity", "Waste Disposal Method", "Amount Spent for Waste Disposal", "Amount Received");

        // Adding data rows
        for (WasteGenerated waste : wasteGeneratedList) {
            wasteGeneratedTable.addCell(new Cell().add(new Paragraph(waste.getTypeOfWaste())));
            wasteGeneratedTable.addCell(new Cell().add(new Paragraph(waste.getUnitOfMeasurement())));
            wasteGeneratedTable.addCell(new Cell().add(new Paragraph(String.valueOf(waste.getAnnualQuantity()))));
            wasteGeneratedTable.addCell(new Cell().add(new Paragraph(waste.getWasteDisposalMethod())));
            wasteGeneratedTable.addCell(new Cell().add(new Paragraph(String.valueOf(waste.getAmountSpentForWasteDisposal()))));
            wasteGeneratedTable.addCell(new Cell().add(new Paragraph(String.valueOf(waste.getAmountReceived()))));
        }

        // Add title and table to the document
        document.add(new Paragraph("Category 5: Waste Generation ")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(wasteGeneratedTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(20));
        
        
        
     // Business Travel Air table
        Table businessTravelAirTable = new Table(6);
        businessTravelAirTable.setWidth(UnitValue.createPercentValue(95));
        businessTravelAirTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add header cells
        addHeaderCells(businessTravelAirTable, "Arrival", "Departure", "Class", "Trip", "No. of Passengers", "Air Fare");

        // Add data rows
        for (BusinessTravelAir businessTravelAir : businessTravelAirList) {
            businessTravelAirTable.addCell(businessTravelAir.getArrival());
            businessTravelAirTable.addCell(businessTravelAir.getDeparture());
            businessTravelAirTable.addCell(businessTravelAir.getTravelClass());
            businessTravelAirTable.addCell(businessTravelAir.getTrip());
            businessTravelAirTable.addCell(String.valueOf(businessTravelAir.getNumberOfPassengers()));
            businessTravelAirTable.addCell(String.valueOf(businessTravelAir.getAirFare()));
        }

        // Add the table to the document
        document.add(new Paragraph("Category 6: Business Travel-Air")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(businessTravelAirTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));

     // Business Travel Rail Table
        Table businessTravelRailTable = new Table(6);
        businessTravelRailTable.setWidth(UnitValue.createPercentValue(95));
        businessTravelRailTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add header cells
        addHeaderCells(businessTravelRailTable, "Arrival", "Departure", "Distance Per Trip", "Trip", "No. of Passengers", "Rail Fare");

        // Assuming `businessTravelRailList` is your list of BusinessTravelRail objects
        for (BusinessTravelRail rail : businessTravelRailList) {
            businessTravelRailTable.addCell(new Cell().add(new Paragraph(rail.getArrival())));
            businessTravelRailTable.addCell(new Cell().add(new Paragraph(rail.getDeparture())));
            businessTravelRailTable.addCell(new Cell().add(new Paragraph(String.valueOf(rail.getDistancePerTrip()))));
            businessTravelRailTable.addCell(new Cell().add(new Paragraph(rail.getTrip())));
            businessTravelRailTable.addCell(new Cell().add(new Paragraph(String.valueOf(rail.getNumberOfPassengers()))));
            businessTravelRailTable.addCell(new Cell().add(new Paragraph(String.valueOf(rail.getRailFare()))));
        }

        // Add the table to the document
        document.add(new Paragraph("Category 6: Business Travel-Rail")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(businessTravelRailTable);

        // Add spacing before the next section
        document.add(new Paragraph().setMarginBottom(40));
        
        // Business Travel Road Table
        Table businessTravelRoadTable = new Table(6);
        businessTravelRoadTable.setWidth(UnitValue.createPercentValue(95));
        businessTravelRoadTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        addHeaderCells(businessTravelRoadTable,"Type of Vehicle", "Type of Fuel", "Distance Travelled Per Trip", "Trip", "No. of Passengers", "Fare");

        for (BusinessTravelRoad road : businessTravelRoadList) {
            businessTravelRoadTable.addCell(new Cell().add(new Paragraph(road.getTypeOfVehicle())));
            businessTravelRoadTable.addCell(new Cell().add(new Paragraph(road.getTypeOfFuel())));
            businessTravelRoadTable.addCell(new Cell().add(new Paragraph(road.getDistanceTravelledPerTrip())));
            businessTravelRoadTable.addCell(new Cell().add(new Paragraph(String.valueOf(road.getTrip()))));
            businessTravelRoadTable.addCell(new Cell().add(new Paragraph(String.valueOf(road.getNumberOfPassengers()))));
            businessTravelRoadTable.addCell(new Cell().add(new Paragraph(String.valueOf(road.getFare()))));
        }

        document.add(new Paragraph("Category 6: Business Travel-Road")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(businessTravelRoadTable);

        // Add spacing before the next table or section
        document.add(new Paragraph().setMarginBottom(40));
        
        
     // Business Travel Hotel Stay Table
        Table businessTravelHotelStayTable = new Table(4);
        businessTravelHotelStayTable.setWidth(UnitValue.createPercentValue(95));
        businessTravelHotelStayTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Adding Header Cells
        addHeaderCells(businessTravelHotelStayTable,"Number of Rooms Occupied", "Number of Nights", "Location of Hotel", "Cost");

        // Adding Data Rows
        for (BusinessTravelHotelStay stay : businessTravelHotelStayList) {
            businessTravelHotelStayTable.addCell(new Cell().add(new Paragraph(String.valueOf(stay.getNumberOfRoomsOccupied()))));
            businessTravelHotelStayTable.addCell(new Cell().add(new Paragraph(String.valueOf(stay.getNumberOfNights()))));
            businessTravelHotelStayTable.addCell(new Cell().add(new Paragraph(stay.getLocationOfHotel())));
            businessTravelHotelStayTable.addCell(new Cell().add(new Paragraph(String.valueOf(stay.getCost()))));
        }

        // Adding Table Title and Table to Document
        document.add(new Paragraph("Category 6: Business Travel-Hotel Stay")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(businessTravelHotelStayTable);

        // Add spacing before the next table
        document.add(new Paragraph().setMarginBottom(40));
        
        
        // S1 Company Owned Vehicle Table
        Table vehicleTable = new Table(9); // Adjust the number of columns to match your fields
        vehicleTable.setWidth(UnitValue.createPercentValue(100));

     // Use fixed layout to ensure columns fit within the page
        vehicleTable.setFixedLayout();
        vehicleTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add header cells
        addHeaderCells(vehicleTable, 
            "Type of Vehicle Fuel", 
            "Consumption", 
            "Cost", 
            "Vehicle Name and Model", 
            "Mileage", 
            "Engine Capacity (CC)", 
            "Yearly Distance Travelled", 
            "Average Monthly Distance Travelled", 
            "No of Travel Days");

        // Add data rows
        for (S1CompanyOwnedVehicle vehicle : vehicleList) {
            vehicleTable.addCell(new Cell().add(new Paragraph(vehicle.getTypeOfVehicleFuel())).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getConsumption()))).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getCost()))).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(vehicle.getVehicleNameAndModel())).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getMileage()))).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getEngineCapacityCC()))).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getYearlyDistanceTravelled()))).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getAverageMonthlyDistanceTravelled()))).setFont(font).setFontSize(8));
            vehicleTable.addCell(new Cell().add(new Paragraph(formatter.format(vehicle.getNoOfTravelDays()))).setFont(font).setFontSize(8));
        }

        // Add the table and a title to the document
        document.add(new Paragraph("Scope 1: Company Owned Vehicle")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(8)
                .setTextAlignment(TextAlignment.CENTER));
        document.add(vehicleTable);

        // Add spacing before the next section
        document.add(new Paragraph().setMarginBottom(60));
        
        
        // Employee Commute Table
        Table employeeCommuteTable = new Table(5);
        employeeCommuteTable.setWidth(UnitValue.createPercentValue(95));
        employeeCommuteTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Add table headers
        addHeaderCells(employeeCommuteTable, "Name",  "Mode of Commute", "Fuel Type", 
                       "Distance Travelled per Day", "No of Working Days per Year");

        // Add table rows
        for (EmployeeCommute commute : employeeCommuteList) {
            employeeCommuteTable.addCell(new Cell().add(new Paragraph(commute.getName())));
            employeeCommuteTable.addCell(new Cell().add(new Paragraph(commute.getModeOfCommute())));
            employeeCommuteTable.addCell(new Cell().add(new Paragraph(commute.getFuelType())));
            employeeCommuteTable.addCell(new Cell().add(new Paragraph(String.valueOf(commute.getDistanceTravelledPerDay()))));
            employeeCommuteTable.addCell(new Cell().add(new Paragraph(String.valueOf(commute.getNoOfWorkingDaysPerYear()))));
        }

        // Add a title for the table
        document.add(new Paragraph("Category 7: Employee Commuting")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));
        
        // Add the table to the document
        document.add(employeeCommuteTable);

        // Add spacing before the next section
        document.add(new Paragraph().setMarginBottom(60));

//      addWatermark(pdf, "Techknowgreen Solutions Limited");
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
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
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell);
        }
    }

 // Helper method to format numbers
    private String formatNumber(double value) {
        if (Math.floor(value) == value) {
            return String.format("%d", (int) value); // No decimal places
        } else {
            return String.format("%.2f", value); // Up to 2 decimal places
        }
    }
}
