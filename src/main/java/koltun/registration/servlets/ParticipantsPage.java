package koltun.registration.servlets;

import koltun.registration.domain.Participant;
import koltun.registration.service.ParticipantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/participants")
public class ParticipantsPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("participants", ParticipantServiceImpl.getInstance().findAllParticipants());
        request.getRequestDispatcher("/pages/participants.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("delete") != null && !request.getParameter("delete").equals("")) {
            Integer id = null;

            try {
                id = Integer.parseInt(request.getParameter("delete"));
            } catch (NumberFormatException e) {
                System.err.println("Invalid id");

            }

            if (id != null) {
                ParticipantServiceImpl.getInstance().deleteParticipant(id);
            }
        } else if (request.getParameter("confirm") != null &&  !request.getParameter("confirm").equals("")) {
            Integer id = null;

            try {
                id = Integer.parseInt(request.getParameter("confirm"));
            } catch (NumberFormatException e) {
                System.err.println("Invalid id");

            }

            if (id != null) {
                ParticipantServiceImpl.getInstance().confirmParticipant(id);
            }
        }

        request.setAttribute("participants", ParticipantServiceImpl.getInstance().findAllParticipants());
        request.getRequestDispatcher("/pages/participants.jsp").forward(request, response);
    }
}