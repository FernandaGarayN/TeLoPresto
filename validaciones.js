function valida(){
    var formularioOk = true

    var marca = $("#marca").val()
    var largoMarca = marca.length
        if(largoMarca < 4 || largoMarca > 10){
            formularioOk = false
            $("#msgmarca").show()
        }

        var modelo = $("#modelo").val()
        var largoModelo = modelo.length
            if(largoModelo < 4 || largoModelo > 10){
                formularioOk = false
                $("#msgmodelo").show()
            }
}
function confir(){
    alert("Seguro deseas eliminar este vehículo?");
    
}