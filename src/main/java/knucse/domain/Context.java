package knucse.domain;

import lombok.Data;
public class Context {
    @Data
    public static class Create {
        private int nnum;
        private String uid;
        private String ctext;
    }
    @Data
    public static class Update{
        private String ctext;
    }
    @Data
    public static class Simple {
        private int cid;
        private int nnum;
        private String uid;
        private String ctext;
        private String cdate;
    }
}
