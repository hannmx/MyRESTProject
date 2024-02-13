package org.hannmx.MyRESTProject.services;

import org.hannmx.MyRESTProject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }
    @Autowired
    private DataProcessingService dataProcessingService;

    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }
}
