package com.devel.stillcareBackend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecretKey {

    @Value("${ssh.forward.password}")
    private String SSHConfigKey;

    public String getSSHConfigKey() {
        return SSHConfigKey;
    }

    public void setSSHConfigKey(String SSHConfigKey) {
        this.SSHConfigKey = SSHConfigKey;
    }
}