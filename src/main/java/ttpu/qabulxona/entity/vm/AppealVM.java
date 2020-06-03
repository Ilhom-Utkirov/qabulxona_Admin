package ttpu.qabulxona.entity.vm;

import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */

public class AppealVM {
    private Integer id;
    private String surname;
    private String name;
    private String phoneNumber;
    private String studentId;
    private String appaelText;
    private String appealType;
    private String StudentEmail;
    private String dateCreated;
    private String filenames;
    private URL[] urls;

public AppealVM(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAppaelText() {
        return appaelText;
    }

    public void setAppaelText(String appaelText) {
        this.appaelText = appaelText;
    }

    public String getAppealType() {
        return appealType;
    }

    public void setAppealType(String appealType) {
        this.appealType = appealType;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    public URL[] getUrls() {
        return urls;
    }

    public void setUrls(URL[] urls) {

        this.urls = urls;
    }
}
