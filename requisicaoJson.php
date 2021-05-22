<?php
    
    //Lista que irá ser recebida pelo java
    $lista = array("Email"=>"will@gmail.com","Senha"=>"12345");
    
    //Transformando a lista em json
    echo json_encode($lista);

?>