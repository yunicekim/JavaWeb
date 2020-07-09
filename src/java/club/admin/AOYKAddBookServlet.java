/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
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
 * Document   : AOYKAddBooksServlet
 * Purpose : add new book to the books.txt after validating all inputs
 * Author     : Yunice & Abdel
 * Revision History 
 * Created on : 14-Feb-2020
 */
public class AOYKAddBookServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "save";  // default action
        }
        
        String url = "/AOYKAddBook.jsp";

        int quantity = 0;
        int unCheckCount = 0;//checks all inputs are correct

        String bookCode = request.getParameter("code");
        String descriptionString = request.getParameter("description");
        String quantityString = request.getParameter("quantity");
        //make a new book class to hold all values from jsp
        Book book = new Book();

        //declare book array list to get whole list of book from the books.txt
        ArrayList<Book> books = new ArrayList<Book>();

        // validate the parameters
        String message = "";
        if (bookCode == null || bookCode.isEmpty() ) {
            message = "Book code is required.";
            unCheckCount++;                
        }
        else{
            book.setCode(bookCode);
        }
        
        if(descriptionString == null || descriptionString.isEmpty()){
            message += "<br>Description must have at least 3 characters.";
        }
        else{
            if(descriptionString.length() <3 ){
                message += "<br>Description must have at least 3 characters.";
                unCheckCount++;
            }
            else{
                book.setDescription(descriptionString);
            }
        }
        
        if (quantityString != null && !quantityString.isEmpty()){
            quantity = Integer.parseInt(quantityString);
            if(quantity <= 0){
                message += "<br>Quantity must be a positive number.";
                unCheckCount++;
            }
            else{
                book.setQuantity(quantity);
            }
        }
        else{
            message += "<br>Quantity must be a positive number.";
            unCheckCount++;
        }

        //if all inputs are correct
        if( unCheckCount == 0 ) {
            message = "";

            //set all inputed values to the book object
//            book.setCode(bookCode);
//            book.setDescription(descriptionString);
//            book.setQuantity(quantity);

            //get a relative file name and insert a record 
            ServletContext context = getServletContext();
            String path =
                context.getRealPath("/WEB-INF/books.txt");
            BookIO.insert(book, path);

            //get all book list from the books.txt
            books = BookIO.getBooks(path);                
            //Forward the control to AOYKDisplayBooks.jsp page.
            url = "/AOYKDisplayBooks";
        }

        //set all result on the request to forward them to the next view
        request.setAttribute("book", book);
        request.setAttribute("message", message);
        request.setAttribute("bookList", books);       

        getServletContext()
                .getRequestDispatcher(url)
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
