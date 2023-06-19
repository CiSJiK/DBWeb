package knucse.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

public class View {
    @Getter
    @Entity
    @Immutable
    class NovelList{
        @Id
        private int nnum;
        private String nname;
    }
    @Getter
    @Entity
    @Immutable
    class NovelDoneList{
        @Id
        private int nnum;
        private String nname;
    }
}

class Procedure{
    @Getter
    @Entity
    @Immutable
    class FeedbackList{
        @Id
        private int fid;
        private String fname;
        private boolean isSelected;
    }
}
