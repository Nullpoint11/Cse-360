package application;

public class Order {

    private String studentid;
    private String orderstatus;

    Order(String studentid){
        this.studentid = studentid;
        orderstatus = "Accepted";
    }

    public void changeStatus(String newstatus){
        orderstatus = newstatus;
    }

    public String getStatus(){
        return orderstatus;
    }

    public String getStudentid(){
        return studentid;
    }

    public void setOrderStatus(String status){
        orderstatus = status;
    }
}
