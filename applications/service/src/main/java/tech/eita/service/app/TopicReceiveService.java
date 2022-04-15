package tech.eita.service.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TopicReceiveService {

    private static final String TOPIC_NAME = "italo-topic";

    private static final String SUBSCRIPTION_NAME = "italo-subscription";

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
            subscription = SUBSCRIPTION_NAME)
    public void receiveMessage(User user) {

        log.info("Received message from topic: {}", user.getName());

    }
}