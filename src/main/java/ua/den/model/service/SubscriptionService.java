package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.den.model.entity.Subscription;
import ua.den.model.exceprions.RowAlreadyExistsException;
import ua.den.model.repository.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void addNewSubscription(Subscription subscription) throws RowAlreadyExistsException {
        List<Subscription> subscriptions =
                subscriptionRepository.findAllByUserLogin(subscription.getUser().getLogin());

        boolean isExists = subscriptions.stream()
                .anyMatch(subscr ->
                        subscr.getUser().getLogin().equals(subscription.getUser().getLogin())
                                && subscr.getCar().equals(subscription.getCar()));

        if (isExists) {
            throw new RowAlreadyExistsException();
        } else {
            subscriptionRepository.save(subscription);
        }
    }

    public void removeSubscription(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

    public List<Subscription> getSubscribersByCarId(Long carId) {
        return subscriptionRepository.findByCarId(carId);
    }

    public List<Subscription> getSubscriptionsByUser(String login) {
        return subscriptionRepository.findAllByUserLogin(login);
    }
}
