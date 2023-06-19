package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter @Entity(name="novelList") @Immutable
public class NovelListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nnum;

    @Column
    private String nname;

}
