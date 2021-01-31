package com.devel.stillcareBackend.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.util.Properties;


@Component
public class SSHconfig implements ServletContextInitializer {
    Logger log = LoggerFactory.getLogger(SSHconfig.class);


    public SSHconfig() {
        try {
            Properties p = new Properties();
            p.load(getClass().getResourceAsStream("/application.properties"));
            if(p.getProperty("ssh.forward.enabled")!=null){
                log.info("ssh forward is opend.");
                log.info("ssh init ……");
                Session session = new JSch().getSession(p.getProperty("ssh.forward.username"),p.getProperty("ssh.forward.host"),Integer.valueOf(p.getProperty("ssh.forward.port")));
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(p.getProperty("ssh.forward.password"));
                session.connect();
                session.setPortForwardingL(p.getProperty("ssh.forward.from_host"),Integer.valueOf(p.getProperty("ssh.forward.from_port")) ,p.getProperty("ssh.forward.to_host") ,Integer.valueOf(p.getProperty("ssh.forward.to_port")) );
            }else{
                log.info("ssh forward is closed.");
            }
        } catch (IOException e) {
            log.error("ssh IOException failed.", e);
        } catch (JSchException e) {
            log.error("ssh JSchException failed.", e);
        } catch (Exception e) {
            log.error("ssh settings is failed. skip!", e);
        }
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}