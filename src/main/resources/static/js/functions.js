


function validarCampos(){
    if( $('#iduser').val()=="" || $('#idpassword').val()==""){
        Swal.fire({
            icon: 'info',
            title: 'Oops...',
            text: 'Parece que no has ingresado tus credenciales!',
            footer: '<h5>Revisa tus datos</h5>'
          });

    }else{
        ValidarMenu();
    }
}


async function ValidarMenu(){

    const user = $('#iduser').val();
    const passworduser = $('#idpassword').val();
    const request = await fetch('api/loggin/'+user,{
        method:'GET',
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        }

    });

    request.json().then((data) => {
        // do something with the data sent in the request
        if(passworduser==data.password){
            $('body').append('hello');
            console.log(data.nombre);
            console.log(data);
            $(location).attr('href',"http://localhost:8080/panelp.html");
        }else{
            alert("Error");
        }

        console.log(passworduser+" "+user+"contra " + data.nombre + data.password );
        
        
      });




}