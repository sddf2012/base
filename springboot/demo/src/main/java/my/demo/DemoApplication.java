package my.demo;

import jakarta.annotation.PostConstruct;
import my.demo.service.socket.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

/**
 * @author liu peng bo
 * @date 2022/6/18 12:42
 */
@EntityScan("my.demo.domain.entity")
@MapperScan("my.demo.mapper")
@SpringBootApplication
public class DemoApplication {
    /*@Autowired
    private NettyServer nettyServer;*/

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
        NettyServer ns = ac.getBean(NettyServer.class);
        ns.start();
    }

    /*
    不能这样写，否则8080端口调不通
    @PostConstruct
    public void start() throws InterruptedException {
        nettyServer.start();
    }*/
}
