package com.baeldung.poi.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.read.biff.BiffException;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.baeldung.poi.excel.ExcelPOIHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class ExcelIntegrationTest {

    private ExcelPOIHelper excelPOIHelper;
    private static String FILE_NAME = "bearing.xlsx";
    private String fileLocation;

    @Before
    public void generateExcelFile() throws IOException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + FILE_NAME;

        excelPOIHelper = new ExcelPOIHelper();
//        excelPOIHelper.writeExcel();

    }

    @Test
    public void whenParsingPOIExcelFile_thenCorrect() throws IOException {
        Map<Integer, List<String>> data = excelPOIHelper.readExcel(fileLocation);

        assertEquals("Name", data.get(0)
                .get(0));
        assertEquals("Age", data.get(0)
                .get(1));

        assertEquals("John Smith", data.get(1)
                .get(0));
        assertEquals("20", data.get(1)
                .get(1));
    }


    @Test
    public void parserProductTest() throws IOException {
        Map<Integer, List<String>> data = excelPOIHelper.readExcel(fileLocation);


        Set<Map.Entry<Integer, List<String>>> items = data.entrySet();

        for (Map.Entry<Integer, List<String>> item : items
        ) {
            System.out.print(item.getKey() + " ");

            System.out.println(item.getValue());

        }


    }

//    @After
//    public void cleanup(){
//        File testFile = new File(fileLocation);
//        if (testFile.exists()) {
//           testFile.delete();
//        }
//    }
}