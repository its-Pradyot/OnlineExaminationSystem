
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title>OES | Instruction Page</title>

    <link href="css/style.css" rel="stylesheet">
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
                      <li class="nav-item ">
                        <a class="nav-link" href="StudentProfile.jsp">Home <span class="sr-only">(current)</span></a>
                      </li>
                      <li class="nav-item active">
                        <a class="nav-link" href="ExamInstructions.jsp">View Exam Instructions</a>
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
        <div class="jumbotron">
            <div class="content-wrapper">
                <div class="container">
                    <div class="row pad-botm">
                        <div class="col-md-12">
                            <h4 class="header-line">Exam Instructions</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="panel panel-default">     
                                <div class="panel-body">
                                    <ul>
                                        <li>Exam contains Multiple Choice Questions.</li>
                                        <li>Each Question Carry 1 Mark</li>
                                        <li>There is no negative marking</li>
                                        <li>You can finish the exam at any time.</li>
                                        <li>Read the question carefully before answering.</li>
                                        <li>You can change your answers before submitting.</li>
                                        <li>If you face any isse then contact your teacher</li>
                                        <li>Good luck for the test.</li>
                                        <br>
                                                
                                    </ul>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                    
            
            <center><a class="btn btn-lg btn-primary" href="Exam.jsp" role="button">Start Exam</a></center>
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
			
			response.sendRedirect("StudentLogin.jsp");
		}
		%>
    </body>
</html>
