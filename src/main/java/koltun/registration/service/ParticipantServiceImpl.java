package koltun.registration.service;

import koltun.registration.dao.ParticipantDao;
import koltun.registration.domain.Participant;

import java.util.Collection;

public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantDao participantDao;

    private ParticipantServiceImpl() {}

    private static class ParticipantServiceImplHolder {
        public static final ParticipantServiceImpl PARTICIPANT_SERVICE_IMPL = new ParticipantServiceImpl();
    }

    public static ParticipantServiceImpl getInstance() {
        return ParticipantServiceImplHolder.PARTICIPANT_SERVICE_IMPL;
    }

    public void setParticipantDao(ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    public ParticipantDao getParticipantDao() {
        return participantDao;
    }

    public boolean insertParticipant(String firstName, String lastName, String phone, String email) {
        Participant participant = new Participant(firstName, lastName, phone, email);
        return participantDao.insertParticipant(participant);
    }

    public void confirmParticipant(Integer id) {
        participantDao.changeConfirmation(id);
    }

    public void deleteParticipant(Integer id) {
        participantDao.deleteParticipant(id);
    }

    public void updateParticipant(Participant participant) {
        participantDao.updateParticipant(participant);
    }

    public Participant findParticipant(Integer id) {
        return participantDao.findParticipant(id);
    }

    public Collection findAllParticipants() {
        return participantDao.findAllParticipants();
    }
}
