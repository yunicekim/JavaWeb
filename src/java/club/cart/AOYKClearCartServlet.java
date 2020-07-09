/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Document   : AOYKClearCartServlet
 * Purpose : clear stored items in the Cart and restore the items to the loan list
 * Author     : Abdel & Yunice
 * Revision History 
 * Created on : 13-Mar-2020
 */
public class AOYKClearCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get a ServletContext
        ServletContext sc = this.getServletContext();
        //get loanitems from the ServletContext
        ArrayList<Book> loanitems = (ArrayList<Book>)sc.getAttribute("loanitems");
        
        //Get a cart session
        HttpSession session = request.getSession();
        ECart cart = (ECart)session.getAttribute("cart");
        
        //Get loanitems from the cart
        ArrayList<Book> cartItems = cart.getItems();
        
        //Add back the quantity reserved from each cart item to the loan items QOH
        String code ="";
        int quantity = 0;
        for(Book cartItem : cartItems){
            code = cartItem.getCode();
            quantity = cartItem.getQuantity();
            ELoan.addToQOH(loanitems, code, quantity);
        }        
        
        cartItems.clear();
        
        session.setAttribute("cart", cart);
        sc.setAttribute("loanitems", loanitems);
        
        //Forward the control to AOYKEcart.jsp
        String url = "/AOYKECart.jsp";
        sc.getRequestDispatcher(url)
                .forward(request, response);
        

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

}
