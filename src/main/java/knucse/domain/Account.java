package knucse.domain;
import jakarta.persistence.*;


@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uid;

    private String upw;

    public String getUpw() {
        return upw;
    }

    public void setUpw(String upw) {
        this.upw = upw;
    }


    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
}
