<%@page import="com.miniproject.db.QuestionsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.miniproject.model.Result"%>
<%@page import="com.miniproject.db.ResultDAO"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title>OES | Results</title>

    <link href="css/style.css" rel="stylesheet">
    
     <style>
		html {
  		position: relative;
  		min-height: 100%;
  	}

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
                        <a class="nav-link" href="TeacherHome.jsp">Home <span class="sr-only">(current)</span></a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="StudentRepository.jsp">Student Management</a>
                      </li>
                      
                      <li class="nav-item">
                        <a class="nav-link" href="QuestionRepository.jsp">Question Management</a>
                      </li>
                      
                      <li class="nav-item active">
                        <a class="nav-link" href="ExamResults.jsp">View Results</a>
                      </li>
                      
                    </ul>
                    <span class="navbar-text">
                      <a class="nav-link" href="TeacherLogoutServlet">Logout</a>
                    </span>
                  </div>

            </nav>
            <!-- NAVIGATION BAR ENDS HERE -->
        </header>   

        <!-- HEADER ENDS HERE -->
        
        <!-- MAIN TAG STARTS HERE -->

        <main role="main" class="container">
        <center><h3><pre><font color="Black">Examination Result of All Users</font></h3></pre></center>
        <div class="jumbotron">
                <table class="table table-bordered table-hover">
                        <thead class="thead-dark">
                            <tr tr class="table-dark">
                                 
                                 
                                 <th>STUDENT NAME</th>
                                 <th>MARKS OBTAINED</th>
                                 <th>TOTAL MARKS</th>
                                
                                </tr>
                            </thead>
                        <tr>
                            <%
                              
                            
                                ArrayList<Result> resultList = ResultDAO.getResult();
                                  for(Result r : resultList)
                                  {   
                                  
                              
                              %>
                            
                          <tr>
                          
                              <td><%=r.getName() %></td>
                              <td><%=r.getMarks()%></td>
                              <td><%=r.getTotal()%></td>
                              
                              
                          </tr>
                          <%
                          }
                          %>
                          
                        
                        
                    </table>
            <center>
                
                <input type="button" value="Back" class="btn btn btn-danger"  onclick="location.href='TeacherHome.jsp'">
            </center>
               
        </div>
                    
            
            
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
			
			response.sendRedirect("TeacherLogin.jsp");
		}
	%>
    </body>
</html>
