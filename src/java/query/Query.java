package query;

/**
 *
 * @author TuanAnh
 */
public class Query {

    public static String INSERT_STUDENT = "INSERT INTO Student_HE151369(firstName, lastName, DOB, gender, address, telephone, email, specializedId, campusId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static String SELECT_LIST_STUDENT_REGISTER = "select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is null";
    public static String SELECT_LIST_STUDENT_ACCEPT = "select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null";
    public static String UPDATE_STUDENT = "UPDATE Student_HE151369 SET firstName = ?, lastName = ?, DOB = ?, gender = ?, address = ?, telephone = ?, email = ?, specializedId = ? WHERE id = ?";
    public static String INSERT_ACADEMIC_STUDENT = "INSERT INTO Academic_Student_HE151369 (rollNumber, memberCode, mode, enrollDate, studentId) VALUES (?, ?, ?, ?, ?)";
    public static String DELETE_STUDENT = "DELETE FROM Student_HE151369 WHERE id = ?";
    public static String DELETE_ACADEMIC_STUDENT = "DELETE FROM Academic_Student_HE151369 WHERE studentId = ?";
    public static String SELECT_IMAGE_STUDENT="SELECT * FROM Image_Student_HE151369 WHERE studentId=?";
}
