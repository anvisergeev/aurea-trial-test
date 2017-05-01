package com.aurea.trial.service.impl;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.aurea.trial.domain.model.Repository;
import com.aurea.trial.repository.RepositoryModelRepository;
import com.aurea.trial.service.MqService;
import com.aurea.trial.service.RepositoryVerificationService;

/**
 * Implementation of the service for messaging delivery.
 *
 * @author aSergeev
 *
 */
@Service
public class MqServiceImpl implements MqService {

    public enum RepositoryVerificationMessageProperty {
        REPOSITORY_ID("repositoryId");

        private String value;

        private RepositoryVerificationMessageProperty(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private RepositoryModelRepository repositoryModelRepository;

    @Autowired
    private RepositoryVerificationService repositoryVerificationService;

    @Override
    public void startRepositoryVerification(Repository repository) {
        this.jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setLong(RepositoryVerificationMessageProperty.REPOSITORY_ID.value(),
                        repository.getId());
                return message;
            }
        });
    }

    @JmsListener(destination = "repositorybox")
    @Override
    public void repositoryVerification(Map<String, Object> message) {
        Long repositoryId =
                (Long) message.get(RepositoryVerificationMessageProperty.REPOSITORY_ID.value());

        Repository repository = repositoryModelRepository.findOne(repositoryId);

        repositoryVerificationService.verifyRepository(repository);
    }

    private void unusedMethod(String userParameter, String unusedParameter) {
        int unusedLocalVariable = 0;
        int usedLocalVariable = 10;
        unusedParameter = unusedParameter;
        unusedLocalVariable = usedLocalVariable;
    }

}
