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

   public static List<SalesVO> readDataFromCSV() throws IOException {
        List<SalesVO> inputList = new ArrayList<SalesVO>();
        String filePath = "D://sshukla//technical//corejava//src//com//streams//data//SalesRecord100.csv";
        //var filePath = System.getProperty("user.dir") + "/resources/SalesRecord100.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        }



/*        try{
            File inputF = new File(path);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {

        }*/

        return inputList;
    }
    private static Function<String, SalesVO> mapToItem = (line) -> {
        String[] p = line.split(",");// a CSV has comma separated lines
        SalesVO item = new SalesVO();
        item.setRegion(p[0]);
        item.setCountry(p[1]);
        item.setItemType(p[2]);
        item.setSalesChannel(p[3]);
        item.setOrderPriority(p[4]);
        item.setOrderDate(p[5]);
        item.setOrderID(Integer.valueOf(p[6]));
        item.setShipDate(p[7]);
        item.setUnitsSold(Integer.valueOf(p[8]));
        item.setUnitPrice(Double.valueOf(p[9]));
        item.setUnitCost(Double.valueOf(p[10]));
        item.setTotalRevenue(Double.valueOf(p[11]));
        item.setTotalCost(Double.valueOf(p[12]));
        item.setTotalProfit(Double.valueOf(p[13]));
        return item;
    };
}
