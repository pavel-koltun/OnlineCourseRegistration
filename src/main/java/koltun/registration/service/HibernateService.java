package koltun.registration.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateService {
    private HibernateService() {}

    private static class SessionFactoryHolder {
        public static final SessionFactory SESSION_FACTORY = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                ServiceRegistry serviceRegistry =
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties())
                                .build();

                return configuration.buildSessionFactory(serviceRegistry);
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed. " + ex.getMessage());
                throw new ExceptionInInitializerError(ex);
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return SessionFactoryHolder.SESSION_FACTORY;
    }
}
