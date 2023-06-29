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

function validarLogin(){
    var email = $("#email").val()
    var password = $("#password").val()

    if(email == null || email.length == 0){
        alert("Debe ingresar un email")
        return false;
    }

    if(password == null || password.length == 0){
        alert("Debe ingresar un password")
        return false;
    }

    return true;
}
function validarReserva (){
    var nombre = $("#nombre").val()
    var apellido = $("#apellido").val()
    var email = $("#email").val()
    var telefono = $("#telefono").val()
    var vehiculo = $("#vehiculo").val()
    var fechainicio = $("#fechainicio").val()
    var fechafin = $("#fechafin").val()
    var gps = $("#gps").val()
    var silla = $("#silla").val()
    var seguro = $("#seguro").val()

    if(email == null || email.length == 0){
        alert("Debe ingresar un email")
        $('#confirmarModal').modal('hide');
        return false;
    }
    if(nombre == null || nombre.length == 0){
        alert("Debe ingresar un nombre")
        return false;
    }
    if(apellido == null || apellido.length == 0){
        alert("Debe ingresar un apellido")
        return false;
    }
     if(telefono == null || telefono.length == 0){
        alert("Debe ingresar un telefono")
        return false;
    } 
    if(vehiculo == null || vehiculo.length == 0){
        alert("Debe ingresar un vehiculo")
        return false;
    } 
    
    if(fechainicio == null || fechainicio.length == 0){
        alert("Debe ingresar un fechainicio")
        return false;
    } 
    
    if(fechafin == null || fechafin.length == 0){
        alert("Debe ingresar un fechafin")
        return false;
    } 
    
    $('#confirmarModal').modal('show');
    return true 
}

// Objeto para almacenar la información
var informacionEspecifica = [];

// Función para crear nueva información
function crearInformacion(nuevaInformacion) {
  informacionEspecifica.push(nuevaInformacion);
}

// Función para modificar información existente
function modificarInformacion(indice, nuevaInformacion) {
  informacionEspecifica[indice] = nuevaInformacion;
}

// Función para eliminar información existente
function eliminarInformacion(indice) {
  informacionEspecifica.splice(indice, 1);
}

// Función para mostrar la información
function mostrarInformacion() {
  informacionEspecifica.forEach((informacion, indice) => {
    console.log(`Información ${indice + 1}: ${informacion}`);
  });
}

// Ejemplo de uso
crearInformacion("Información 1");
crearInformacion("Información 2");
mostrarInformacion();

modificarInformacion(0, "Nueva información 1");
eliminarInformacion(1);
mostrarInformacion();

// Objeto para almacenar la información
var informacionEspecifica = [];

// Función para crear nueva información
function crearInformacion(nuevaInformacion) {
  informacionEspecifica.push(nuevaInformacion);
}

// Función para modificar información existente
function modificarInformacion(indice, nuevaInformacion) {
  if (indice >= 0 && indice < informacionEspecifica.length) {
    informacionEspecifica[indice] = nuevaInformacion;
  } else {
    console.log("Índice inválido. No se pudo modificar la información.");
  }
}

// Función para eliminar información existente
function eliminarInformacion(indice) {
  if (indice >= 0 && indice < informacionEspecifica.length) {
    informacionEspecifica.splice(indice, 1);
  } else {
    console.log("Índice inválido. No se pudo eliminar la información.");
  }
}

// Función para mostrar la información
function mostrarInformacion() {
  if (informacionEspecifica.length > 0) {
    console.log("Información específica:");
    informacionEspecifica.forEach((informacion, indice) => {
      console.log(`Información ${indice + 1}: ${informacion}`);
    });
  } else {
    console.log("No hay información específica para mostrar.");
  }
}


// Ejemplo de uso
crearInformacion("Información 1");
crearInformacion("Información 2");
mostrarInformacion();

modificarInformacion(0, "Nueva información 1");
modificarInformacion(2, "Nueva información 2"); // Índice inválido
eliminarInformacion(1);
eliminarInformacion(2); // Índice inválido
mostrarInformacion();