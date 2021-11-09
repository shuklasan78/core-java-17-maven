package data;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor
public class SalesVO {

    private  String region = "" ;
    private  String country = "";
    private  String itemType = "";
    private  String salesChannel = "";
    private  String orderPriority = "";
    private  String orderDate = null;
    private  Integer orderID = 0;
    private  String shipDate = null ;
    private  Integer unitsSold = 0;
    private  Double unitPrice = 0.0;
    private  Double unitCost =  0.0;
    private  Double totalRevenue = 0.0;
    private  Double totalCost = 0.0;
    private  Double totalProfit = 0.0;
}
