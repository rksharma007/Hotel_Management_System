import ui.services.AdminLoginUI;
import ui.ui_layer.LoginUser;

public class Main{
    public static void main(String[] args) {
//        DriverClass d = new DriverClass();
//        Connection connection = d.connect();
//
//        String sql= "SELECT * FROM Admin;";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs =statement.executeQuery(sql);
//            ResultSetMetaData resultSetMetaData =rs.getMetaData();
//            int colCount = resultSetMetaData.getColumnCount();
////            System.out.println(colCount);
//            int col = 0;
//            while(rs.next()){
//                while (++col <= colCount)
//                {
//                    System.out.println(rs.getString((int)col)+" ");
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        LoginUser newAdmin = new AdminLoginUI();
        newAdmin.loginRequester();
//        System.out.println("Working!");
    }
}