package koltun.registration.servlets.listeners;

import koltun.registration.dao.ParticipantDaoImpl;
import koltun.registration.service.HibernateService;
import koltun.registration.service.ParticipantServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Initializing context");
        ParticipantServiceImpl.getInstance().setParticipantDao(new ParticipantDaoImpl());
        HibernateService.getSessionFactory();
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
