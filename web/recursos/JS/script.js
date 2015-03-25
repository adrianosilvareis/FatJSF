$(document).ready(function(){
    $('#conteudo').hide();
    $('#ranking').hide();
    $('nav a').click(function(event){
        event.preventDefault();
        var botao = $(this).text();
        if(botao === "Descricao"){
            $('#ranking').hide('slow');
            $('#conteudo').show('slow');
        }else if(botao === "Ranking"){
            $('#conteudo').hide('slow');
            $('#ranking').show('slow');
        }
    });
});

