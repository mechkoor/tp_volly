<?php
if($_SERVER["REQUEST_METHOD"] == "POST"){
 include_once("../racine.php");
 include_once RACINE.'/service/EtudiantService.php';
 laod();
}
function laod(){
 extract($_POST);
 $es = new EtudiantService();
 echo json_encode($es->findAllApi());
}
