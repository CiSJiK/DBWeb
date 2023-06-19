package knucse.domain;
import jakarta.persistence.*;

@Entity
public class feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private String fname;
    private String fcon;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFcon() {
        return fcon;
    }

    public void setFcon(String fcon) {
        this.fcon = fcon;
    }
}