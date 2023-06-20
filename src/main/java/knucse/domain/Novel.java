package knucse.domain;
import jakarta.persistence.*;
@Entity
public class Novel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nnum;
    private String nname;

    public int getNnum() {
        return nnum;
    }

    public void setNnum(int nnum) {
        this.nnum = nnum;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }
}
