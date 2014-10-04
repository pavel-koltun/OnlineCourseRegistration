package koltun.registration.servlets;

import koltun.registration.dao.ParticipantDao;
import koltun.registration.domain.Participant;
import koltun.registration.service.ParticipantService;
import koltun.registration.service.ParticipantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //Unicode support

        boolean insertedSuccessfully  = ParticipantServiceImpl.getInstance().insertParticipant(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("phone"),
                request.getParameter("email"));


        if (insertedSuccessfully) {
            request.getRequestDispatcher("/pages/registrationSuccess.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
        }
    }
}
