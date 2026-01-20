function normal() {
    let arreglo = ["manzana", "sandia", "platano", "fresa"];
    arreglo.push("kiwi");

    arreglo.forEach(element => {
        console.log(element);
    });

    return arreglo;
}

function normalDestructuracion() {
    const [elemento1, elemento2] = normal();
    console.log("recuperacion destructuracion:\n",elemento1, elemento2);
}

normalDestructuracion();
