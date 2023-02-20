<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Client Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: gold">
                    <div>
                        <a href="<%=request.getContextPath()%>/list" class="navbar-brand"> Client Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="http://www.github.com/mrmoisesnoah" class="nav-link">Created by Moisés Noah</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Edit Client
                                </c:if>
                                <c:if test="${user == null}">
                                    Add New Client
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Name</label> <input type="text" maxlength="50" placeholder="John Doe" value="<c:out value='${user.name}' />" class="form-control" name="name" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>CPF</label> <input type="text" maxlength="11" placeholder="Insert numbers only" value="<c:out value='${user.cpf}' />" class="form-control" name="cpf" required="required">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Date of Birth</label> <input type="date" value="<c:out value='${user.dateOfBirth}' />" class="form-control" name="dateOfBirth" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="email" placeholder="john@email.com" value="<c:out value='${user.email}' />" class="form-control" name="email" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Phone Number</label> <input type="text" placeholder="(99)99999-9999" value="<c:out value='${user.email}' />" class="form-control" name="phone">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Country</label> <input type="text" maxlength="20" placeholder="Brazil" value="<c:out value='${user.country}' />" class="form-control" name="country">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>