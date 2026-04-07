package bilpoint;

public class test {
    public static void main(String[] args) {
        Student yeniOgrenci = new Student("Mehmet Eyüp Örnek", "eyup.ornek@ug.bilkent.edu.tr", "123456", "CS");
        UserDAO dao = new UserDAO();
        dao.addStudent(yeniOgrenci);
    }
}
