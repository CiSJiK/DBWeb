package knucse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter @Entity(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unum = 0;
    @Column(unique = true)
    private String uid;
    @Column
    private String upw;
}
