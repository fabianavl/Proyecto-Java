<%@ page contentType="text/html" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Informacion Registro</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <!--Navegacion-->
    <nav class="navbar navbar-expand-lg bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/">
                <img src="./assets/codoacodo 1.svg" alt="logo de codo a codo">
                <span class="text-light">Codo a Codo</span> 
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link text-light active" aria-current="page" href="./index.html">Volver</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-secondary" href="#">Inscripciones 2023</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-secondary" href="#">Codo a codo 4.0</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <section>
    <h2>Info del Alumno inscripto DNI ${a.getDni()}</h2>
    <p>Nombre: ${a.getNombre()}</p>
    <p>Apellido: ${a.getApellido()}</p>
    <p>Curso: ${a.getTituloCurso()}</p>
    </section>

</body>
</html>