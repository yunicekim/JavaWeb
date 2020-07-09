/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yunic
 */
public class AOYKMemberAdminController extends HttpServlet {

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
        
        //set url
        String url = "/AOYKDisplayMembers.jsp";
        //get action
        String action = request.getParameter("action");
        if(action == null){
            action = "displayMembers";
        }
        
        if(action.equals("displayMembers")){
            //get all members from db
            ArrayList<Member> members = MemberDB.selectMembers();
            
            //set the list to the request
            request.setAttribute("members", members);
        }
        else if(action.equals("addMember")){
            //set url to the Display member page
            url = "/AOYKAddMember.jsp";
            
        }
        else if(action.equals("saveMember")){
            //call saveMember method to save the entered inputs
            url = saveMember(request, response);

            //get all members from db
            ArrayList<Member> members = MemberDB.selectMembers();
            
            //set the list to the request
            request.setAttribute("members", members);
        }
        else if(action.equals("editMember")){
            //set member object
            Member member = new Member();
            String email = request.getParameter("email");
            
            //get a member with email
            member = MemberDB.selectMember(email);
            
            //set the member object to the jsp
            url = "/AOYKEditMember.jsp";
            
            //set the list to the request
            request.setAttribute("member", member);      
        }
        else if(action.equals("removeMember")){
            //set member object
            Member member = new Member();
            String email = request.getParameter("email");
            
            //get a member with email
            member = MemberDB.selectMember(email);
            
            //set the member object to the jsp
            url = "/AOYKRemoveMember.jsp";
            
            //set the list to the request
            request.setAttribute("member", member);      
        }
        else if(action.equals("deleteMember")){
            //set member object
            String email = request.getParameter("email");
            Member member = new Member();
            member.setEmailAddress(email);
            
            //delete the object using email
            MemberDB.delete(member);
            
            //get all members from db
            ArrayList<Member> members = MemberDB.selectMembers();
            
            //set the list to the request
            request.setAttribute("members", members);            
        }
        
        //forward the result to the browser
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
        //doPost(request, response);
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

    private String saveMember(HttpServletRequest request, HttpServletResponse response) {
        //set member object with all inputs
        Member member = new Member();
        String url = "/AOYKDisplayMembers.jsp";
        String errors = "";
        //get session to hold new inputs as a member object
        //HttpSession session = request.getSession();
        
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phone");;
        String programName = request.getParameter("dropProgram");
        int yearLevel = Integer.parseInt(request.getParameter("dropYearLevel"));
        
        member.setEmailAddress(email);
        member.setFullName(fullName);
        member.setPhoneNumber(phoneNumber);
        member.setProgramName(programName);
        member.setYearLevel(yearLevel);

        //if the email is already exist
        if(MemberDB.selectMember(email) != null){
            //validate email and name
            if(!member.isValid()){
                errors += "Cannot update record. ";
                errors += "Please provide a valid name.";
                
                url = "/AOYKEditMember.jsp";
                request.setAttribute("member", member);
                request.setAttribute("errors", errors);                 }
            else{
                MemberDB.update(member);
            }
        }
        else{
            //validate email and name
            if(!member.isValid()){
                errors = "Cannot insert a new record. " + errors;
                errors += "Please provide a valid name and/or email";
                
                url = "/AOYKAddMember.jsp";
                request.setAttribute("member", member);
                request.setAttribute("errors", errors);                
            }
            else{
                //insert the new member object to the db            
                MemberDB.insert(member);                
            }
        }
         return url;
    }

}
