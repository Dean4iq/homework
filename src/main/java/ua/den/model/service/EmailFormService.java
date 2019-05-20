package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ua.den.model.entity.Car;
import ua.den.model.entity.Subscription;
import ua.den.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailFormService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SubscriptionService subscriptionService;

    public void sendNotificationForCar(Car car) {
        List<Subscription> subscriptions = subscriptionService.getSubscriporsByCarId(car.getId());

        List<User> userList = subscriptions.stream().map(Subscription::getUser).collect(Collectors.toList());
        String subject = car.getCarModel().getModel() + ' ' + car.getCarModel().getSerialNumber();

        sendMessages(userList, subject, car.toString());
    }

    private void sendMessages(List<User> users, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setText(text);
        simpleMailMessage.setSubject(subject);

        for (User user : users) {
            simpleMailMessage.setTo(user.getEmail());

            mailSender.send(simpleMailMessage);
        }
    }
}
