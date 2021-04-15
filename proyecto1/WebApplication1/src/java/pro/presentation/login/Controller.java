
package pro.presentation.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pro.presentation.login.Model;


import pro.logic.usuario;
@WebServlet(name = "Controller", urlPatterns = {"/presentation/login", "/presentation/logout"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            

            case "/presentation/login":
                viewUrl = this.login(request);
                System.out.print("picha me mamo");
                break;
            case "/presentation/logout":
                viewUrl = this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String login(HttpServletRequest request) {

        this.updateModel(request);
        return this.loginAction(request);

    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getUsuario().setId(request.getParameter("usernameText"));
        model.getUsuario().setPassword(request.getParameter("passwordText"));
    }
    
    public String loginAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        pro.logic.Model domainModel = pro.logic.Model.instance();
        HttpSession session = request.getSession(true);

        try {
            usuario real = domainModel.recuperar( model.getUsuario().getId());
            
            //Persona cl = domainModel.PersonaFind(real);
            session.setAttribute("usuario", real);
            String viewUrl;
            //session.setAttribute("cliente", cl);
           
            return viewUrl = "/index.jsp";
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld", "Usuario o clave incorrectos");
            errores.put("claveFld", "Usuario o clave incorrectos");
            return "/index.jsp";
        }
    }

    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/login/Login.jsp";
    }

}
