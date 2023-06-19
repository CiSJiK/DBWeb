package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter @Entity(name="readNovel") @Immutable
public class ReadNovelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nnum;

    @Column
    private int cid;

    @Column
    private String ctext;

    @Column
    private String cdate;
    @Column
    private String uid;
}
