package my.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author liu peng bo
 * @date 2022/5/11 下午3:18
 */
public class ApplicationEventDemo {
    public static void main(String[] args) {
        //GenericApplicationContext ac = new GenericApplicationContext();
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext();
        ac.register(ApplicationEventDemo.class);
        //基于接口
        ac.addApplicationListener(event -> System.out.println("基于接口接收事件:" + event));
        ac.refresh();
        ac.close();
    }

    @EventListener
    public void eventListener(ApplicationEvent event){
        System.out.println("@EventListener接收事件:"+event);
    }
}
