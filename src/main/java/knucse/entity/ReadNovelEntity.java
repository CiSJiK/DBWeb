package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter @Setter @Entity(name="read_novel")
public class ReadNovelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nnum;

    @Column
    private int cid;
    @Column
    private String ctext;
    @Column
    private String uid;
}
