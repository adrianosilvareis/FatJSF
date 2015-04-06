$(document).ready(function(){
    $("#glosa").hide();
    $("nav a").click(function(event){
       event.preventDefault() ;
       var botao = $(this).text();
       if(botao === "Intranet"){
            var server = window.location.href.split(":8084")[0];
            window.location = server+":1989/wordpress";
       }else if(botao === "Glosa"){
           $("#inconsistencia").hide('slow');
           $("#glosa").show('slow');
       }else if(botao === "Inconsistencia"){
           $("#glosa").hide('slow');
           $("#inconsistencia").show('slow');
       }
    });
});
