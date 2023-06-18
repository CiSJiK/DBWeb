package knucse.domain;
import jakarta.persistence.*;
@Entity
public class comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private String ctext;
    private int nnum;
    private String uid;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }

    public int getNnum() {
        return nnum;
    }

    public void setNnum(int nnum) {
        this.nnum = nnum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
