package collection;

import data.Employee;
import data.GetData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SummaryCollectionTest {

    @Test
    public void testMap() throws IOException {
        var noRecords = Records.personfewrecords;
        //List<Employee> empList = GetData.getRecords(noRecords.toString());
        Map<Integer,Employee> empMap = GetData.getEmployeeMap();
        var name = "";
        var id = 0;
        for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
            if(entry.getValue().getEmpId()==158568) {
                name = entry.getValue().getFirstname();
                id = entry.getKey();
                System.out.println("id  :"+id +"  name "+name+"  Email  :"+entry.getValue().getEmail());
            }
        }
        assertEquals(158568,id);
        assertEquals("Eusebio Salo",name);
    }


}