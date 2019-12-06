package listeners;

import DAO.UtilitaireDecompte;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerCompteUtilisateur implements HttpSessionListener {

    ServletContext ctx = null;
    static int total = 0, current = 0;

    public void sessionCreated(HttpSessionEvent e) {
        UtilitaireDecompte.updateDecompte();
        total = UtilitaireDecompte.obtenirDecompte();
        current++;
        ctx = e.getSession().getServletContext();
        ctx.setAttribute("totalusers", total);
        ctx.setAttribute("currentusers", current);

    }

    public void sessionDestroyed(HttpSessionEvent e) {
        current--;
        ctx.setAttribute("currentusers", current);
    }
}
