package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity(name = "context")
public class ContextEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Column
    private int nnum;

    @Column
    private int uid;

    @Column
    private String ctext;

    @Column
    private String cdate;
}
