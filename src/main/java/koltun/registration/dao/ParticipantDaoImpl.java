package koltun.registration.dao;

import koltun.registration.domain.Participant;
import koltun.registration.service.HibernateService;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

public class ParticipantDaoImpl implements ParticipantDao {

    @Override
    public boolean insertParticipant(Participant participant) {

        Session session = HibernateService.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(participant);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Exception during inserting participant. Rollback.");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public void updateParticipant(Participant participant) {
        Session session = HibernateService.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.saveOrUpdate(participant);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("Error during update participant");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void changeConfirmation(Integer id) {
        Session session = HibernateService.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Participant participant = findParticipant(id);
            if (participant == null)
                return;
            participant.setConfirmed(!participant.getConfirmed());
            updateParticipant(participant);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Error during confirmation.");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteParticipant(Integer id) {
        Session session = HibernateService.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Participant participant = new Participant();
            participant.setId(id);
            session.delete(participant);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Error during deleting participant");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Participant findParticipant(Integer id) {
        Session session = HibernateService.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            return (Participant) session.get(Participant.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("Error during searching participant");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public Collection findAllParticipants() {
        Session session = HibernateService.getSessionFactory().openSession();

        List participants = null;

        try {
            session.beginTransaction();
            participants = session.createQuery("from Participant").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Error during getting all participants.");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return participants;
    }
}
