package telran.spting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import telran.spting.service.Sender;
import telran.spting.service.SenderService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SpringIntroApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringIntroApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        Sender sender = ctx.getBean(Sender.class);
        Map<String, SenderService> senderServices = sender.getServices();

        System.out.println("Enter exit for stopping application");
        while(true){
            System.out.println("Enter sender type");
            String line = scanner.nextLine();
            if(line.equals("exit")){
                ctx.close();
                break;
            }

            SenderService service = senderServices.get(line);
            if(service==null){
                System.out.printf("service %s is not implemented yet\n", line);
                continue;
            }
            System.out.println("Enter message");
            line = scanner.nextLine();
            service.send(line);
        }
    }
    @PostConstruct
    void init(){
        System.out.println("Application context created");
    }
    @PreDestroy
    void preDestroy(){
        System.out.println("Bye");
    }

}
