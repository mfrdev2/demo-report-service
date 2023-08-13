package com.example.custom;

import net.sf.jasperreports.components.ComponentsExtensionsRegistryFactory;
import net.sf.jasperreports.components.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;
import net.sf.jasperreports.engine.component.ComponentKey;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.type.*;
import net.sf.jasperreports.view.JasperViewer;

import java.util.*;

public class TableReport {
    private static final String FIELD_NAME = "aField";
    private static final String PARAMETER_DATA = "tableData";

    public static void main(String[] args) throws JRException {
        TableReport tableReport = new TableReport();


        JasperReport report = JasperCompileManager.compileReport(tableReport.createReport(tableData()));
        Map<String, Object> params = new HashMap<>();
        List<Map<String, Object>> data = tableData();
        params.put(PARAMETER_DATA, data);

        JasperPrint print = JasperFillManager.fillReport(report, params);
        JasperViewer.viewReport(print);
    }

    private static List<Map<String, Object>> tableData() {
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        data.add(getData());
        return data;
    }

    private static Map<String, Object> getData() {
        Map<String,Object> data =new HashMap<>();
        data.put("FR" ,"RR");
        data.put("FX" ,"XX");
        data.put("NN" ,"YY");
        data.put("PP" ,"KK");

        data.put("TT" ,"KK5451522222222222222222222ss");
        data.put("N" ,"KK");
        data.put("s" ,"KK");
        data.put("p" ,"KK");

        data.put("app" ,"KK");
        data.put("ss" ,"KK");
        data.put("sss" ,"KK");
        data.put("yy" ,"KK");

        data.put("sx" ,"KK");
        data.put("mm" ,"KK");
        data.put("tt" ,"KK");
        return data;
    }


    public JasperDesign createReport(List<Map<String, Object>> data) throws JRException {
        //the report
        final JasperDesign jasperDesign = new JasperDesign();
        if (Objects.isNull(data) || data.isEmpty()) {
            return jasperDesign;
        }

        Map<String, Object> stringObjectMap = data.get(0);

        ArrayList<String> fieldList = new ArrayList<>(stringObjectMap.keySet());

        initPageConfigure(jasperDesign);

        JRDesignParameter parameter = new JRDesignParameter();
        parameter.setValueClass(List.class);
        parameter.setName(PARAMETER_DATA);
        jasperDesign.addParameter(parameter);

        //the subdataset
        String datasetName = "tableDataset";
        JRDesignDataset subdataset = new JRDesignDataset(false);
        subdataset.setName(datasetName);
        //subdataset field
        initFields(subdataset, fieldList);
        jasperDesign.addDataset(subdataset);

        //the table element
        JRDesignComponentElement tableElement = new JRDesignComponentElement(jasperDesign);
        tableElement.setX(0);
        tableElement.setY(0);
        tableElement.setWidth(200);
        tableElement.setHeight(60);

        ComponentKey componentKey = new ComponentKey(ComponentsExtensionsRegistryFactory.NAMESPACE, "c",
                ComponentsExtensionsRegistryFactory.TABLE_COMPONENT_NAME);
        tableElement.setComponentKey(componentKey);

        StandardTable table = new StandardTable();


        //the table data source
        JRDesignDatasetRun datasetRun = new JRDesignDatasetRun();
        datasetRun.setDatasetName(datasetName);
        datasetRun.setDataSourceExpression(new JRDesignExpression(
                "new net.sf.jasperreports.engine.data.JRMapCollectionDataSource($P{" + PARAMETER_DATA + "})"));
        table.setDatasetRun(datasetRun);

        //first column
        StandardColumn recNoColumn = createColumn(jasperDesign,51, 90, "SL No.", "$V{REPORT_COUNT}");
        table.addColumn(recNoColumn);
        //init column
        initColumnData(jasperDesign,table, fieldList);

        tableElement.setComponent(table);

        JRDesignBand title = new JRDesignBand();
        title.setHeight(60);
        title.addElement(tableElement);
        jasperDesign.setTitle(title);

        return jasperDesign;
    }

    private void initPageConfigure(JasperDesign jasperDesign) {
        jasperDesign.setName("TableReport");
        jasperDesign.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
        jasperDesign.setPageWidth(860);
        jasperDesign.setPageHeight(595);
        jasperDesign.setOrientation(OrientationEnum.LANDSCAPE);
        jasperDesign.setBottomMargin(20);
        jasperDesign.setTopMargin(20);
        jasperDesign.setLeftMargin(20);
        jasperDesign.setRightMargin(20);

    }

    private void initColumnData(JasperDesign jasperDesign, StandardTable table, ArrayList<String> fieldList) {
        for (String fieldName : fieldList) {
            StandardColumn fieldColumn = createColumn(jasperDesign,51, 90, fieldName, "$F{" + fieldName + "}");
            table.addColumn(fieldColumn);
        }
    }

    private static void initFields(JRDesignDataset subdataset, ArrayList<String> fieldList) throws JRException {
        for (String fieldName : fieldList) {
            JRDesignField field = new JRDesignField();
            field.setValueClass(String.class);
            field.setName(fieldName);
            subdataset.addField(field);
        }

    }

    private StandardColumn createColumn(JasperDesign jasperDesign,int width, int height, String headerText, String detailExpression) {
        StandardColumn column = new StandardColumn();
        column.setWidth(width);

        //column header
        DesignCell header = new DesignCell();
        header.setDefaultStyleProvider(jasperDesign);
        header.getLineBox().getPen().setLineWidth(1f);
        header.setHeight(40);

        JRDesignStaticText headerElement = new JRDesignStaticText(jasperDesign);
        headerElement.setX(0);
        headerElement.setY(0);
        headerElement.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
        headerElement.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
        headerElement.setWidth(width);
        headerElement.setHeight(40);
        headerElement.setText(headerText);

        header.addElement(headerElement);
        column.setColumnHeader(header);

        //column detail
        DesignCell detail = new DesignCell();
        detail.setDefaultStyleProvider(jasperDesign);
        detail.getLineBox().getPen().setLineWidth(1f);
        detail.setHeight(height);

        JRDesignTextField detailElement = new JRDesignTextField(jasperDesign);
        detailElement.setX(0);
        detailElement.setY(0);
        detailElement.setWidth(width);
        detailElement.setHeight(height);
        detailElement.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
        detailElement.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
        detailElement.setExpression(new JRDesignExpression(detailExpression));

        detail.addElement(detailElement);
        column.setDetailCell(detail);
        return column;
    }
}
