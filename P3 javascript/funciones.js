
///ARRow function
const sumar=(a,b)=>(a+b);


//funcion que recivbe funciones Programacion funcional
function operar(fun){

    valor1=recuperarNumber("valor1")
    valor2=recuperarNumber("valor2")

    console.log("valor 1: "+valor1+" "+"valor 2: "+valor2)
    let resultado=fun(valor1,valor2)
    console.log("la resultado de operacion es "+resultado)

}
///ARRow function
restar=(a,b)=>(a-b);

multiplicar=(a,b)=>(a*b);

dividir=(a,b)=>(a/b);