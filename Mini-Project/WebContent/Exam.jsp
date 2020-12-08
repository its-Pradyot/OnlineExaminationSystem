<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.miniproject.db.QuestionsDAO"%>
 <%@page import="com.miniproject.model.Question"%>

<%@ page import="java.util.*" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title>OES | Java Test</title>

    <link href="css/style.css" rel="stylesheet">
    
    <style>
		html {
  		position: relative;
  		min-height: 100%;

	</style>
  </head>

    <body>
    	<!-- HEADER STARTS HERE -->
        <header>
        	<!-- NAVIGATION BAR STARTS HERE -->
            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4 indigo">
            <a class="navbar-brand" href="#">Online Examination Portal </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <!-- SESSION CHECKING -->
            
            <%
				if(session.getAttribute("username")!=null && session.getAttribute("username")!=""){
		
			%>
            
            
           
            
            <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                      <li class="nav-item">
                        <a class="nav-link" href="StudentProfile.jsp">Home </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="ExamInstructions.jsp">View Exam Instructions<span class="sr-only">(current)</span></a>
                      </li>
                      
                    </ul>
                     <span class="navbar-text">
                      <a class="nav-link" href="StudentLogOutServlet">Logout</a>
                    </span>
                  </div>

            </nav>
            <!-- NAVIGATION BAR ENDS HERE -->
        </header>   

        <!-- HEADER ENDS HERE -->
        
        <!-- MAIN TAG STARTS HERE -->

        <main role="main" class="container">
        <center><h2>Java Programming Test</h2></center>
        
         <form action="ResultServlet" method="post">
        <div class="jumbotron">
               
                	
                        <div class="row">
                           <div class="col-md-12">
                               <div class="alert alert-default">
                                   <%
                                         int i = 1;
                                         
                                              int radioname = 0;
                                              ArrayList<Question> questionList = QuestionsDAO.getAllQuestions();
                                             for(Question q : questionList)
                                            {   
                                              
                                         
                                        %>
                                        
                                        <div class="form-group">
                                               <label><%=i%>.&nbsp;&nbsp;<%=q.getQuestion() %></label>
                                       </div>
                   
                                       <div class="radio">
                                           <input type="radio" value="a" name="<%=radioname%>">&nbsp;<%=q.getOption1()%>
                                       </div>
                   
                                       <div class="radio">
                                           <input type="radio" value="b" name="<%=radioname%>">&nbsp;<%=q.getOption2()%>
                                       </div>
                   
                                       <div class="radio">
                                           <input type="radio" value="c" name="<%=radioname%>">&nbsp;<%=q.getOption3()%>
                                       </div>
                   
                                       <div class="radio">
                                           <input type="radio" value="d" name="<%=radioname%>">&nbsp;<%=q.getOption4()%>
                                       </div>
                                       <br>
                                       <br>
                                                   
                                                   
                                               
                                        <%
                                                 radioname++;
                                                i++;
                                                 }
                                         %>
                                         
                                         
                                       
                               </div>
                           </div>
                       </div>
                   
           
               <center><input type="submit" value="Submit Exam" class="btn btn-lg btn-success"> </center>
               
        </div>
                    
            
            
        </form>
        </div>
        </main>
        
         <!-- MAIN TAG ENDS HERE -->
			
		<!-- FOOTER STARTS HERE -->

        <footer class="footer">
        <div class="container">
            <center><span class="text-muted">&copy; Pradyot Itkurkar</span></center>
        </div>
        </footer>

         <!-- BOOTSTRAP CORE AND JS CDN PLACED HERE TO REDUCE LOAD TIME -->
        
        

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
        <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    	<%
		}
			else{
			out.println("<p>Please login to access your profile</p>");
			response.sendRedirect("StudentLogin.jsp");
		}
		%>	
    </body>
</html>
