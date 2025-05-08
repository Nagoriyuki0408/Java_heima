package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//"ID", "姓名", "年龄", "职位"
public class Employee
{
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private int id;
    private String name;
    private int age;
    private String position;

}
