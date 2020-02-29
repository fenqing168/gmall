package cn.fenqing168.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author fenqing
 */
@SpringBootApplication
@EnableDubbo
@MapperScan("cn.fenqing168.gmall.modules.*.mapper")
public class GmallMumberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallMumberServiceApplication.class, args);
    }

}
