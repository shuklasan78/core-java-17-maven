package data;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessSalesRecords {
    public static void main(String[] args) {
        ProcessSalesRecords o1 = new ProcessSalesRecords();

        System.out.println(readSalesDataFromCSV("").size());
    }

    public static List<SalesData> readSalesDataFromCSV(String filename) {
        String fileName = filename;
        if(filename.isEmpty()) {
            fileName = "/Users/sandeepkumarshukla/Applications/Technical/core-java-17-maven/src/main/resources/salesfivemillionssalesrecords.csv";
        } else {
            fileName = "/Users/sandeepkumarshukla/Applications/Technical/core-java-17-maven/src/main/resources/"+fileName+".csv";

        }
        List<SalesData> salesDataList = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = line.replaceFirst(",", " , ");
            while (line != null) {
                    String[] attributes = line.split(",");

                    SalesData salesData = createSalesData(attributes);
                    if(null!=salesData) {
                        salesDataList.add(salesData);
                    }
                    line = br.readLine();
            }
        } catch (IOException ioe) { ioe.printStackTrace(); }
        return salesDataList;
    }


      static SalesData createSalesData(String[] meatadata) {

            if(!meatadata[0].trim().equals("Region")) {
                  String region = meatadata[0];
                  String country = meatadata[1];
                  String itemType = meatadata[2];
                  String salesChannel = meatadata[3];
                  String orderPriority = meatadata[4];
                  String orderDate = meatadata[5];
                  Integer orderID = Integer.valueOf(meatadata[6]);
                  String shipDate = meatadata[7];
                  Double unitsSold = Double.valueOf(meatadata[8]);
                  Double unitPrice = Double.valueOf(meatadata[9]);
                  Double unitCost = Double.valueOf(meatadata[10]);
                  Double totalRevenue = Double.valueOf(meatadata[11]);
                  Double totalCost = Double.valueOf(meatadata[12]);
                  Double totalProfit = Double.valueOf(meatadata[13]);
            SalesData salesData = new SalesData(region,
                    country,
                    itemType,
                    salesChannel,
                    orderPriority,
                    orderDate,
                    orderID,
                    shipDate,
                    unitsSold,
                    unitPrice,
                    unitCost,
                    totalRevenue,
                    totalCost,totalProfit);
            return salesData;
            }
            else {
                return null;
            }


        }
}
