function recuperarNumber(idComponente){
    //asi de tipea en JS
    let componente= /**@type{HTMLInputElement} */(document.getElementById(idComponente))
    let valorComp=componente.value;

    //siempre lo recupera como string
    return Number(valorComp)

}