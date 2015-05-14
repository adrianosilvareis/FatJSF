$(document).ready(function(){
    $("#glosa").hide();
    $("#particular").hide();
    $("nav a").click(function(event){
       event.preventDefault() ;
       var botao = $(this).text();
       if(botao === "Intranet"){
            var server = window.location.href.split(":8080")[0];
            window.location = server+":1989/wordpress";
       }else if(botao === "Glosa"){
           $("#inconsistencia").hide('slow');
           $("#particular").hide('slow');
           $("#glosa").show('slow');
       }else if(botao === "Inconsistencia"){
           $("#glosa").hide('slow');
           $("#particular").hide('slow');
           $("#inconsistencia").show('slow');
       }else if(botao === "OS Não Paga"){
           $("#glosa").hide('slow');
           $("#inconsistencia").hide('slow');
           $("#particular").show('slow');
       }
    });
});
