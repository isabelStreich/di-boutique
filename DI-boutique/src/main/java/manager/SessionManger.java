/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author istreich
 */
public class SessionManger {
    public static HttpSession recuperer(HttpServletRequest request, boolean creerSession) {
        HttpSession session = null;
        if (creerSession) {
            session = request.getSession(true);
        } else {
            session = request.getSession(false);
        }
        return session;
    }

    public static boolean add(HttpServletRequest request, boolean creerSession, String key, Object value) {
        boolean retour = false;
        HttpSession session = recuperer(request, creerSession);
        if (creerSession || (!creerSession && session != null)) {
            session.setAttribute(key, value);
            retour = true;
        } 
        return retour;
    }

    public static Object getByKey(HttpServletRequest request, boolean creerSession, String key) {
        Object retour = null;

        HttpSession session = recuperer(request, creerSession);
        if (creerSession || (!creerSession && session != null)) {
            retour = session.getAttribute(key);
        } 
        return retour;
    }

    /**
     * 
     * @param request
     * @param creerSession
     * @param key 
     */
    public static void removeByKey(HttpServletRequest request, boolean creerSession, String key) {
        HttpSession session = recuperer(request, creerSession);
        if (creerSession || (!creerSession && session != null)) {
            session.removeAttribute(key);
        }       
    }

    public static void destroy(HttpServletRequest request, boolean creerSession) {
        HttpSession session = recuperer(request, creerSession);
        if (creerSession || (!creerSession && session != null)) {
            session.invalidate();
        }
    }
}
