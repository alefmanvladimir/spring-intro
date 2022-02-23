package telran.spting.service.impl;

import org.springframework.stereotype.Service;
import telran.spting.service.SenderService;

@Service("sms")
public class SenderServiceSms implements SenderService {
    @Override
    public void send(String message) {
        System.out.println("sms message: " + message);
    }

    @Override
    public String getType() {
        return "sms";
    }
}
