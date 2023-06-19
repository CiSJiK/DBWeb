package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity(name = "feedback")
public class FeedbackEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    @Column
    private String fname;

    @Column
    private String fcon;
}
