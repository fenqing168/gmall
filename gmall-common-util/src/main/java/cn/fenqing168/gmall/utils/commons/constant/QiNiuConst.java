package cn.fenqing168.gmall.utils.commons.constant;

/**
 * @author fenqing
 */
public interface QiNiuConst {

    String ACCESS_KEY = "u5hYl0PC9hfW1L3mnf142LFT5nZYoZ3OwlM-GBe4";

    String SECRET_KEY = "OjTV_03YEtDaQHwcHQNgYU91zTOzXCpOG5WG0Wz_";

    enum Bucket {
        /**
         * 空间名
         */
        FENQING("fenqing", "http://file.fenqing168.cn/");

        Bucket(String name, String domain) {
            this.name = name;
            this.domain = domain;
        }

        private String name;

        private String domain;

        public String getDomain() {
            return domain;
        }

        public String getName() {
            return name;
        }
    }

}
