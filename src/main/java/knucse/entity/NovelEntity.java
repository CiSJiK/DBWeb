package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity(name = "novel")
public class NovelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nnum;

    @Column
    private String nname;
}
