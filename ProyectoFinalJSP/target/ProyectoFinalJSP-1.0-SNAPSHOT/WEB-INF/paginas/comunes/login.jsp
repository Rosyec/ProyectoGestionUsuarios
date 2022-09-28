<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div class="container text-center">
            <div class="row justify-content-center">
                <div class="col-4" style="margin-top:10em">
                    <main class="form-signin">
                        <form method="post" action="${pageContext.request.contextPath}/ServletLogin?accion=login">         
                            <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" class="bi bi-windows" viewBox="0 0 16 16">
                            <path d="M6.555 1.375 0 2.237v5.45h6.555V1.375zM0 13.795l6.555.933V8.313H0v5.482zm7.278-5.4.026 6.378L16 16V8.395H7.278zM16 0 7.33 1.244v6.414H16V0z"/>
                            </svg>
                            <h1 class="h3 mb-3 mt-3 fw-normal"> Iniciar Sesión</h1>
                            <div class="form-floating">
                                <input type="email" class="form-control" id="floatingInput" name="email" placeholder="name@example.com" required>
                                <label for="floatingInput">Correo electronico</label>
                            </div>
                            <div class="form-floating">
                                <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required>
                                <label for="floatingPassword">Contraseña</label>
                            </div>

                            <div class="checkbox mb-3 mt-3">
                                <label>
                                    <input type="checkbox" value="remember-me"> Recuerdame
                                </label>
                            </div>
                            <button class="w-100 btn btn-lg btn-dark" type="submit" type="button" data-bs-toggle="collapse" data-bs-target="#mensaje" aria-expanded="false" aria-controls="collapseExample">Ingresar</button>
                            <c:if test="${error}">                                                             
                                <div class="card card-body mt-3 alert-danger">
                                    <h5 class="card-title">Error</h5>
                                    <p class="card-text">${error_message}</p>                                   
                                </div>
                            </c:if>

                            <p class="mt-5 mb-3 text-muted">© Derechos reservados 2022</p>
                        </form>
                    </main>
                </div>               
            </div>
        </div>     
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
