import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/perfil-info")
public class PerfilInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nome = (String) session.getAttribute("nome");
        String email = (String) session.getAttribute("email");
        // Adicione aqui outras informações do usuário, se necessário
        // Por exemplo:
        String dataNascimento = (String) session.getAttribute("dataNascimento");
        String genero = (String) session.getAttribute("genero");
        String nacionalidade = (String) session.getAttribute("nacionalidade");

        // Criar um objeto JSON com as informações do usuário
        String userInfo = "{\"nome\":\"" + nome + "\",\"email\":\"" + email + "\",\"dataNascimento\":\"" + dataNascimento + "\",\"genero\":\"" + genero + "\",\"nacionalidade\":\"" + nacionalidade + "\"}";

        // Definir o tipo de conteúdo da resposta como JSON
        response.setContentType("application/json");
        // Escrever o JSON na resposta
        response.getWriter().write(userInfo);
    }
}
