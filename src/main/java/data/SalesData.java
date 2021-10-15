package data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SalesData {
    private String region;
    private String Country;
    private String ItemType;
    private String salesChannel;
    private String orderPriority;
    private String orderDate;
    private Integer orderID;
    private String shipDate;
    private Double unitsSold;
    private Double unitPrice;
    private Double unitCost;
    private Double totalRevenue;
    private Double totalCost;
    private Double totalProfit;

}
