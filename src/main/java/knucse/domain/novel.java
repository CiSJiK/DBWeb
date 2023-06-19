package knucse.domain;
import jakarta.persistence.*;
@Entity
public class novel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nnum;
    private String nname;
    private String ncon;

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

    public String getNcon() {
        return ncon;
    }

    public void setNcon(String ncon) {
        this.ncon = ncon;
    }
}
