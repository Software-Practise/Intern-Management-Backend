package com.example.events;


import com.example.model.Application;
import com.example.services.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListener extends AbstractMongoEventListener<Application> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public ApplicationListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Application> event) {
        if (event.getSource().getAppId() < 1) {
            event.getSource().setAppId(sequenceGenerator.generateSequence(Application.SEQUENCE_NAME));
        }
    }


}
