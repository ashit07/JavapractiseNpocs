package randoms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.google.common.collect.Table.Cell;

public class SimpleExcelReadExample {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    //
    // An excel file name. You can create a file name with a full path
    // information.
    //
    String filename = "C:\\Users\\ashijune\\Desktop\\Temp\\data.xls";

    //
    // Create an ArrayList to store the data read from excel sheet.
    //
    List sheetData = new ArrayList();

    FileInputStream fis = null;
    try {
      //
      // Create a FileInputStream that will be use to read the excel file.
      //
      fis = new FileInputStream(filename);

      //
      // Create an excel workbook from the file system.
      //
      // HSSFWorkbook workbook = new HSSFWorkbook(fis);
      Workbook wb = WorkbookFactory.create(fis); // Or foo.xlsx
      Sheet sheet = wb.getSheetAt(0);
      // Row r = s.getRow(0);
      //
      // Get the first sheet on the workbook.
      //
      // HSSFSheet sheet = workbook.getSheetAt(0);

      //
      // When we have a sheet object in hand we can iterator on each
      // sheet's rows and on each row's cells. We store the data read
      // on an ArrayList so that we can printed the content of the excel
      // to the console.
      //
      Iterator rows = sheet.rowIterator();
      while (rows.hasNext()) {
        Row row = (Row) rows.next();
        Iterator cells = row.cellIterator();

        List data = new ArrayList();
        while (cells.hasNext()) {
          Cell cell = (Cell) cells.next();
          data.add(cell);
        }

        sheetData.add(data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        fis.close();
      }
    }

    showExelData(sheetData);
  }

  private static void showExelData(List sheetData) {
    //
    // Iterates the data and print it out to the console.
    //
    for (int i = 0; i < sheetData.size(); i++) {
      List list = (List) sheetData.get(i);
      for (int j = 0; j < list.size(); j++) {
        Cell cell = (Cell) list.get(j);
        System.out.print(cell.getRichStringCellValue().getString());
        if (j < list.size() - 1) {
          System.out.print(", ");
        }
      }
      System.out.println("");
    }
  }
}
