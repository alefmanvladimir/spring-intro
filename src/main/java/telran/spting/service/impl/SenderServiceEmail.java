package telran.spting.service.impl;

import org.springframework.stereotype.Service;
import telran.spting.service.SenderService;

@Service("email")
public class SenderServiceEmail implements SenderService {
    @Override
    public void send(String message) {
        System.out.println("email message: " + message);
    }

    @Override
    public String getType() {
        return "email";
    }
}
