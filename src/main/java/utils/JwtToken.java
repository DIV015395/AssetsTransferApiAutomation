package utils;
import java.util.ResourceBundle;

public class JwtToken
{
    ResourceBundle resourceBundle = ResourceBundle.getBundle("jwt");
    public String getItJwtToken() {
        return itJwtToken;
    }
    public String getDoctorJwtToken() {
        return doctorJwtToken;
    }
    private String itJwtToken = resourceBundle.getString("itJwtToken");
    private String doctorJwtToken = resourceBundle.getString("doctorJwtToken");

    public String getInvailidJwtToken() {
        return invailidJwtToken;
    }
    private String invailidJwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsImlhdCI6MTY0ODgyMDI3MCwiZXhwIjoxNjQ4ODI3NDcwfQ.AhArOvQTaJ7ohbPiyGiGTK5pFMWqjbZ5Kj9q2hXEhXU";

}
