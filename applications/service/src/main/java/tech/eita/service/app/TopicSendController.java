package tech.eita.service.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TopicSendController {

    private static final String TOPIC_QUEUE = "italo-topic";

    JmsTemplate jmsTemplate;

    @Autowired
    public TopicSendController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/topic")
    public void sendTopic(@RequestParam(value = "message") String message) {
        log.info("Sending message: {}", message);
        jmsTemplate.convertAndSend(TOPIC_QUEUE, new User(message));
    }
}
