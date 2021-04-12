package org.example.workbook.sheetwriters;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.example.workbook.sheetwriters.data.Model1;
import org.example.workbook.sheetwriters.data.Model2;
import org.example.workbook.sheetwriters.data.Response;
import org.example.workbook.sheetwriters.workbook.Sheet;
import org.example.workbook.sheetwriters.workbook.Workbook;
import org.example.workbook.sheetwriters.writers.Writers;
import org.junit.Before;
import org.junit.Test;

public class ResponseConverterTest {

    private Response response;
    private ResponseConverter converter;

    @Before
    public void setUp() {
        converter = new ResponseConverter(new Writers());

        Model2 model2A = new Model2("AFirst", 24);
        Model2 model2B = new Model2("BSecond", 99);

        Model1 model1 = new Model1("PRIMARY");
        model1.setChildren(asList(model2A, model2B));

        response = new Response(model1);
    }

    @Test
    public void creates_workbook_with_two_sheets() {
        Workbook result = converter.toWorkbook(response);

        assertEquals(2, result.getSheets().size());
    }

    @Test
    public void returns_expected_sheet_for_model1() {
        Workbook result = converter.toWorkbook(response);

        Sheet model1Sheet = result.getSheets().get(0);

        assertEquals(
            "PRIMARY: has 2 children",
            model1Sheet.toString()
        );
    }

    @Test
    public void returns_expected_sheets_with_info_about_two_model1_instances() {
        Model1 anotherModel = new Model1("SECONDDDD");
        response.addModel(anotherModel);

        Workbook result = converter.toWorkbook(response);

        Sheet model1Sheet = result.getSheets().get(0);
        assertEquals(
            "PRIMARY: has 2 children\n" +
                     "SECONDDDD: has 0 children",
            model1Sheet.toString()
        );
    }

    @Test
    public void returns_expected_sheet_with_info_about_model1_two_children_model2_instances() {
        Workbook result = converter.toWorkbook(response);

        Sheet model2Sheet = result.getSheets().get(1);
        assertEquals(
            "ExternalModel2: AFirst (24)\n" +
                     "ExternalModel2: BSecond (99)",
            model2Sheet.toString()
        );
    }


}
