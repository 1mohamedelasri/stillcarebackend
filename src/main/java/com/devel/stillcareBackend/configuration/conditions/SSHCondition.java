package com.devel.stillcareBackend.configuration.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SSHCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return null != env
                && "true".equals(env.getProperty("config.ssh"));
    }
}