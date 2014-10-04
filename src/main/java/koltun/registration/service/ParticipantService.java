package koltun.registration.service;

import koltun.registration.domain.Participant;

import java.util.Collection;

public interface ParticipantService {
    boolean insertParticipant(String firstName, String lastName, String phone, String email);
    void confirmParticipant(Integer id);
    void deleteParticipant(Integer id);
    void updateParticipant(Participant participant);
    Participant findParticipant(Integer id);
    Collection findAllParticipants();
}
