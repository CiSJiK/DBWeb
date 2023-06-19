package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter @Entity(name="feedbackList") @Immutable
public class FeedbackListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    @Column
    private String fname;

    @Column
    private int nnum;
}
