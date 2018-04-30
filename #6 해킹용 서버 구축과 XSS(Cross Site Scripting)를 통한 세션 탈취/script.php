<?php
    $con = mysqli_connect("localhost", "root", "test", "ayudante");

    $userSession= $_GET["s"];

    $statement = mysqli_prepare($con, "INSERT INTO SCRIPTING VALUES (?)");
    mysqli_stmt_bind_param($statement, "s", $userSession);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>