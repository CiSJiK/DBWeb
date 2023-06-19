package knucse.domain;

import lombok.Data;
public class Context {
    @Data
    public static class Create {
        private int nnum;
        private int uid;
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
        private int uid;
        private int ctext;
        private String cdate;
    }
}
