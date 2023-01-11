$("document").ready(
    ()=>{

        cargarDatos();
        //$("#table-casa").DataTable();

    }

)

async  function cargarDatos(){
    const request  = await  fetch("/api/casa", {
        Method: "GET",
        "Content-Type": "application/json",
        Accept: "application/json"
    });

    let requestJSON = await request.json();

    console.log(requestJSON);
    for (let casa in requestJSON){
        $("#table-casa").append(crearFila(requestJSON[casa]))
    }


}

function crearFila(casa){
    return `<tr>
                <td>${casa["codigoCasa"]}</td>
                <td>${casa["numeroCasa"]}</td>
                <td>$${casa["costoMantenimiento"]}</td>
                <td>
                    <button type="button" class="btn btn-secondary" onclick="obtenerInformacion(${casa["codigoCasa"]})">Información</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="listarServicios(${casa["codigoCasa"]})">Servicios</button>
                </td>
           </tr>`
}


async function listarServicios(id){
    //consumir api

    const request = await fetch("/api/servicio/casa/"+id, {
        Method: "GET",
        "Content-Type": "application/json",
        Accept: "application/json"
    })
    let response = await request.json();

    console.log(response)
    $("#services-body").empty()

    for (let servicio in response){
        $("#services-body").append(crearFilaServicio(response[servicio]))
    }
    $("#service-block").show();

}
async function obtenerInformacion(id){
    const request = await fetch("/api/casa/"+id, {
        Method: "GET",
        "Content-Type": "application/json",
        Accept: "application/json"
    })
    let casa = await request.json();
    console.log(casa)
    $("#casa-body").empty()
    let html = `<tr>
                    <td>Codigo Casa</td>
                    <td>${casa["codigoCasa"]}</td>
                </tr>
                <tr>
                    <td>Número casa</td>
                    <td>${casa["numeroCasa"]}</td>
                </tr>
                <tr>
                    <td>Costo Mantenimiento</td>
                    <td>$${casa["costoMantenimiento"]}</td>
                </tr>
                <tr>
                    <td>Propietario</td>
                    <td>${casa["propietario"]["nombrePersona"]}</td>
                </tr>
                 <tr>
                    <td>Correo de propietario</td>
                    <td>${casa["propietario"]["correo"]}</td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td>${casa["pais"]["nombrePais"]}, ${casa["departamento"]["nombreDepartamento"]}, 
                     ${casa["municipio"]["nombreMunicipio"]}</td>
                </tr>`
                ;
    $("#casa-body").append(html)
    $("#casa-block").show()

}

function crearFilaServicio(servicio){
    return `<tr>
                <td>${servicio["codigoServicio"]}</td>
                <td>${servicio["nombreServicio"]}</td>
                <td>$ ${servicio["tarifa"]}</td>
                <td>${servicio["fechaSuspencion"]}</td>
                <td>${servicio["proveedor"]["nombreProveedor"]}</td>
                <td>
                    <button type="button" class="btn btn-secondary" onclick="obtenerInformacionfactura(${servicio["codigoServicio"]})">Facturas</button>
                </td>
           </tr>`
}
async function obtenerInformacionfactura(id){
    $("#service-block").hide();
    const request = await fetch("/api/factura/servicio/"+id, {
        Method: "GET",
        "Content-Type": "application/json",
        Accept: "application/json"
    });
    let response = await request.json();
    console.log(response)
    $("#factura-body").empty()
    for (let factura in response){
        $("#factura-body").append(crearFilaFactura(response[factura]))
    }
    $("#factura-block").show();
}

function crearFilaFactura(factura){
    return `<tr>
                <td>${factura["idFactura"]}</td>
                <td>${factura["fechaExpidacion"]}</td>
                <td>$ ${factura["total"]}</td>
                <td>
                    <button type="button" class="btn btn-secondary" onclick="sendMail(${factura["idFactura"]})">Enviar correo</button>
                </td>
           </tr>`
}


async function sendMail(id){
    const request = await fetch("/api/email/factura/"+ id, {
        Method: "GET",
        "Content-Type": "application/json",
        Accept: "application/json"
    })
    let response =await request;

    console.log(response)
    if(response["status"]==200){
        Swal.fire({
            icon: "success",
            text: "Correo enviado de manera exitosa",

        })
    }else{
        Swal.fire({
            icon: "error",
            text: "No se ha podido enviar el correo, vuelve a intentarlo",

        })
    }
}
function closeDiv(id){
    $(id).hide();
}


