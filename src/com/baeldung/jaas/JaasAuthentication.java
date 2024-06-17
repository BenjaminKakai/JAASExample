package com.baeldung.jaas;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;

public class JaasAuthentication {

    public static void main(String[] args) {
        try {
            LoginContext loginContext = new LoginContext("jaasApplication", new ConsoleCallbackHandler());
            loginContext.login();
            Subject subject = loginContext.getSubject();
            PrivilegedAction<Void> privilegedAction = new ResourceAction();
            Subject.doAsPrivileged(subject, privilegedAction, null);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
