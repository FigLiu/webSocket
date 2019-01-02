package cn.okuribito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableWebSocket
@ComponentScan(basePackages = "cn.okuribito.*")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
