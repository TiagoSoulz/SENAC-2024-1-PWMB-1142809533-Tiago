/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        String crm = request.getParameter("crm");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String dataNascimento = request.getParameter("data_nascimento");
        String especializacao = request.getParameter("especializacao");
        String sexo = request.getParameter("sexo");
        String estadoCivil = request.getParameter("estado_civil");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/medico", "root", "p@$$w0rd");
            String sql = "INSERT INTO medico (nome, crm, endereco, telefone, data_nascimento, especializacao, sexo, estado_civil, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, crm);
            stmt.setString(3, endereco);
            stmt.setString(4, telefone);
            stmt.setString(5, dataNascimento);
            stmt.setString(6, especializacao);
            stmt.setString(7, sexo);
            stmt.setString(8, estadoCivil);
            stmt.setString(9, email);
            stmt.setString(10, senha);
            stmt.executeUpdate();
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>Médico registrado com sucesso!</h2>");
            response.getWriter().println("<p>Deseja fazer o login?</p>");
            response.getWriter().println("<a href='login.html'><button>Ir para Login</button></a>");
            response.getWriter().println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().println("Erro ao cadastrar médico: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                response.getWriter().println("Erro ao cadastrar médico: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
