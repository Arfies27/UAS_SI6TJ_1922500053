<?php
    include 'koneksi.php';
    $query = "SELECT * from lecturer";
    $result = $con->query($query);

    //fetch all
    $data_dosen = $result->fetch_all(MYSQLI_ASSOC);

    echo json_encode($data_dosen);
?>