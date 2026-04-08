package bilpoint;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void addStudent(Student student) {
        String query = "INSERT INTO Users (user_id, role, name, email, password) VALUES (?, 'STUDENT', ?, ?, ?)";
        
        try {
            Connection conn = DatabaseManager.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, student.getID());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getMail());
            pstmt.setString(4, student.getPassword()); 
            
            pstmt.executeUpdate();
            System.out.println(student.getName() + "added successfully to the database!");
            
        } catch (Exception e) {
            System.out.println("Error happened during data transportation");
            e.printStackTrace();
        }
    }
}