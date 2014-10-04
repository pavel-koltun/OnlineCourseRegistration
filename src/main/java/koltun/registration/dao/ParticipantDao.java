package koltun.registration.dao;

import koltun.registration.domain.Participant;

import java.util.Collection;

public interface ParticipantDao {
    boolean insertParticipant(Participant participant);
    void changeConfirmation(Integer id);
    void deleteParticipant(Integer id);
    void updateParticipant(Participant participant);
    Participant findParticipant(Integer id);
    Collection findAllParticipants();
}