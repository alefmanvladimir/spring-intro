package telran.spting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
@Component
public class Sender {

    private Map<String, SenderService> services;
    private List<SenderService> listServices;
    @Autowired
    public Sender(List<SenderService> listServices){
        this.listServices = listServices;
        services = new HashMap<>();

    }

    public Map<String, SenderService> getServices() {
        return services;
    }

    @PostConstruct
    void init(){
        int size = listServices.size();
        for(int i=0; i<size; i++){
            services.put(listServices.get(i).getType(), listServices.get(i));
        }

    }
}
