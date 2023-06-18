package knucse.domain;

import lombok.Data;
public class Context {
    @Data
    public static class Create {
        private int nnum;
        private int unum;
        private String ctext;
    }
    @Data
    public static class Update{
        private String ctext;
    }
    @Data
    public static class Simple {
        private int nnum;
        private int unum;
        private String ctext;
    }
}
