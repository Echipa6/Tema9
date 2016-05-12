package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Vector;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;


public class Report {
    private JasperReportBuilder report;

    public void makeReport(Connection connection,String title,String interogare,Vector <String> coloane){
        JasperReportBuilder partReport;
        partReport = DynamicReports.report();//a new report
        for(int i = 0; i < coloane.size();i++){
        	partReport.addColumn(Columns.column(coloane.elementAt(i),coloane.elementAt(i),DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT).setHorizontalAlignment(HorizontalAlignment.LEFT));
        }
       
        partReport.addTitle(Components.text(title));
        partReport.setDataSource(interogare,connection);

        this.report=partReport;

    }
    public boolean writeReport(String numeFisier){
        try {
            this.report.toPdf(new FileOutputStream(numeFisier+".pdf"));//export the report to a pdf file
            return true;
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
