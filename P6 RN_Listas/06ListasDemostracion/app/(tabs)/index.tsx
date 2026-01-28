import { FlatList, StyleSheet, View, Text, Button, TextInput, ScrollView, Modal, TouchableOpacity } from 'react-native';
import { useState } from 'react';
import { Alert } from 'react-native';

export default function HomeScreen() {


  const [esNuevo, setEsNuevo] = useState(true);
  //variable 
  const [indiceSelecionado, setIndiceSelecionado] = useState(-1);



  // let personas = [
  //   { nombre: "Fernando", apellido: "Ponce", id: "97864" },
  //   { nombre: "Gabriel", apellido: "Lara", id: "8798" },
  //   { nombre: "Bjor", apellido: "Lux", id: "16289" }
  // ];

  ///forma actual de los productos
  const [productos, setProductos] = useState([
    { nombre: "galletas", categoria: "Alimento", precio: 1, precioVenta: 1.2, id: "97864" },
    { nombre: "TV", categoria: "Entretenimiento", precio: 200, precioVenta: 240, id: "8798" },
    { nombre: "Toalla", categoria: "Limpieza", precio: 8, precioVenta: 9.6, id: "16289" }
  ]);

  const [nombreUS, setNombre] = useState("ingrese el nombre ")
  const [categoriaUS, setValorCategoria] = useState("ingrese la categoria")
  const [precioUS, setPrecio] = useState("ingrese un precio")  //numericos
  const [precioVentaUS, setPrecioVenta] = useState("precio venta auto calculado")  //numericos
  const [idCajaUS, setId] = useState("ingrese el id")

  const [numerodeElemento, setNumeroElementos] = useState(productos.length);

  const existeProducto = () => {
    for (let i = 0; i < productos.length; i++) {
      if (productos[i].id == idCajaUS) {
        return true
        break;
      }
    }
    return false
  }

  const guardar = () => {

    //validar que no sean campos vacios
    if (nombreUS.length < 3 || categoriaUS.length < 3 || idCajaUS.length < 3) {
      Alert.alert("ERROR al guardar", "Todos los campos deben tener al menos 3 caracteres");
      return;
    }
    if (precioUS === "" || isNaN(Number(precioUS))) {
      Alert.alert("ERROR al guardar", "El precio debe ser un número válido"); return;
    }

    if (esNuevo) {
      ///verifca que no se repita el id
      if (existeProducto()) {
        Alert.alert("INFO, ya existe producto con id " + idCajaUS)
      } else {
        const nuevoProducto = {
          nombre: nombreUS,
          categoria: categoriaUS,
          precio: Number(precioUS),
          precioVenta: Number(precioUS) * 1.2,
          id: idCajaUS
        };
        setProductos([...productos, nuevoProducto]); // 👈 crea copia y actualiza
      }

    } else {
      // 1. Crear una copia del arreglo
      const copia = [...productos];
      // 2. Tomar el objeto original en la posición seleccionada
      let productoOriginal = copia[indiceSelecionado];
      // 3. Crear una copia del objeto original
      let productoActualizado = { ...productoOriginal };
      // 4. Modificar las propiedades necesarias
      productoActualizado.nombre = nombreUS;
      productoActualizado.categoria = categoriaUS;
      productoActualizado.precio = Number(precioUS);
      productoActualizado.precioVenta = Number(precioUS) * 1.2;
      // 5. Reemplazar en el arreglo
      copia[indiceSelecionado] = productoActualizado;
      // 6. Actualizar el estado
      setProductos(copia);
    }

    limpiar();
  };


  const limpiar = () => {
    setNombre("")
    setValorCategoria("")
    setPrecio("")
    setPrecioVenta("")
    setId("")
    setIndiceSelecionado(-1);
    setEsNuevo(true);
  }

  const eliminarProducto = () => {
    if (productoAEliminar !== null) {
      const copia = [...productos];
      copia.splice(productoAEliminar.index, 1);
      setProductos(copia);
      setNumeroElementos(copia.length);
      setModalVisible(false);
      setProductoAEliminar(null);
    }
  };

  // RETO 27 
  //REEMPLAZAR Boton por modal
  const [modalVisible, setModalVisible] = useState(false);
  // un nuevo use state para usar el modal para la confirmacion
  const [productoAEliminar, setProductoAEliminar] = useState<any>(null);





  //componente personalizado de cada elemento del FlatList
  //esto se llama destructuracion de objetos
  const CompPropioProductos = ({ nombre, categoria, precio, id, precioVenta, index }: any) => {
    return (
      <View style={styles.card}>
        <View>
          {/* Mostrar el índice enumerado (posición en la lista) */}
          <Text style={styles.index}>#{index + 1}</Text>
          {/* Si quieres también mostrar el id, puedes ponerlo aparte */}
          {/* <Text style={styles.index}>ID: {id}</Text> */}
        </View>

        <View style={styles.contenedorDatos}>
          <Text style={styles.nombre}>{nombre}</Text>
          <Text style={styles.precio}>({categoria})</Text>
          <Text style={styles.precio}>USD {precio}</Text>
        </View>

        <View style={styles.contenedorbotones}>
          {/* boton editar */}
          {/* <Button
            title="E"
            color="green"
            onPress={() => {
              console.log("datos :" + nombre + " " + categoria + " " + precio + " " + id+" "+ precioVenta);

              setNombre(nombre);
              setValorCategoria(categoria);
              setPrecio(String(precio)); // convertir a string para TextInput
              setPrecioVenta(String(precio*1.2)); 
              setId(String(id));         // usar id en lugar de index

              setEsNuevo(false); // 👈 ahora sí se guarda en estado 
              setIndiceSelecionado(index); //👈 aquí guardas el índice si lo necesitas
            }}
          /> */}

          <TouchableOpacity style={styles.btnEditar} onPress={() => {
            setNombre(nombre);
            setValorCategoria(categoria);
            setPrecio(String(precio));
            setPrecioVenta(String(precio * 1.2));
            setId(String(id));
            setEsNuevo(false);
            setIndiceSelecionado(index);
          }}
          >
            <Text style={styles.txtBtn}>Ed</Text>
          </TouchableOpacity>




          {/* boton eliminar */}

          {/* <Button title="X"
            color="red"
            onPress={() => {


              setIndiceSelecionado(index);
              let arreglo_eliminado = [...productos];
              Alert.alert("eliminado: " + arreglo_eliminado[index].id + " " + arreglo_eliminado[index].nombre)

              arreglo_eliminado.splice(index, 1)
              setProductos(arreglo_eliminado)
              console.log("despues de eliminar >>" + productos)
              setNumeroElementos(productos.length)
            }
            }
          /> */}

          <TouchableOpacity style={styles.btnEliminar} onPress={() => {
            setProductoAEliminar({ index, id, nombre });
            setModalVisible(true);
          }} >
            <Text style={styles.txtBtn}>D</Text>
          </TouchableOpacity>


        </View>
      </View>
    );
  };




  return (
    <View style={styles.container}>


      <View style={styles.head}>

        <ScrollView>
          <View style={styles.formularioDatos}>

            <TextInput
              value={idCajaUS}
              style={styles.cajaTexto}
              editable={esNuevo} ///para que no se edote el primary key
              onChangeText={(txt) => {
                setId(txt)
                console.log("valor caja:>>" + idCajaUS)
              }}
            />
            <TextInput
              value={nombreUS}
              style={styles.cajaTexto}
              selectTextOnFocus={true}
              onChangeText={(txt) => {
                setNombre(txt)
                console.log("valor nombre:>>" + nombreUS)
              }}
            />

            <TextInput
              value={categoriaUS}
              style={styles.cajaTexto}
              selectTextOnFocus={true}
              onChangeText={(txt) => {
                setValorCategoria(txt)
                console.log("valor categoria:>>" + categoriaUS)
              }}
            />

            <TextInput
              value={precioUS}
              style={styles.cajaTexto}
              selectTextOnFocus={true}
              keyboardType="numeric" //cuando se espera un numero 
              onChangeText={(txt) => {
                setPrecio(txt)
                console.log("valor precio:>>" + precioUS)
              }}
            />

            <TextInput
              value={precioVentaUS}
              editable={false}
              style={styles.cajaTexto}
              keyboardType="numeric" //cuando se espera un numero 
              onChangeText={(txt) => {
                setPrecioVenta(txt)
                console.log("valor precio Venta:>>" + precioVentaUS)
              }}
            />





          </View>

          <View style={styles.confirmacionForm}>

            <Button
              title='Guardar'
              onPress={guardar}
            />
            <Button
              title='Nuevo'
              onPress={limpiar}
            />

          </View>

        </ScrollView>





      </View>


      <View style={styles.main}>

        {/* <Text style={styles.title}>Lista de Personas</Text> */}
        <Text style={styles.title}>Lista de Productos ({numerodeElemento})</Text>



        <FlatList
          data={productos}
          renderItem={({ item, index }) => (
            <CompPropioProductos
              nombre={item.nombre}
              categoria={item.categoria}
              precio={item.precio}
              precioVenta={item.precio * 1.2}
              id={item.id}
              index={index}
            />
          )}
          keyExtractor={(obj) => obj.id}
        />

        {/* Modal de confirmación */}
        {/* Modal de confirmación */}
        <Modal transparent={true} visible={modalVisible} animationType="slide">
          <View style={styles.modalOverlay}>
            <View style={styles.modalBox}>
              <Text style={styles.modalText}>
                ¿Desea eliminar el producto {productoAEliminar?.id} - {productoAEliminar?.nombre}?
              </Text>
              <View style={styles.modalBotones}>
                <Button title="Cancelar" onPress={() => setModalVisible(false)} />
                <Button title="Eliminar" color="red" onPress={eliminarProducto} />
              </View>
            </View>
          </View>
        </Modal>




        {/* <Text style={styles.title}>Lista de Personas</Text>
      <FlatList
        data={personas}
        renderItem={({ item, index }) => (
          <View style={styles.card}>
            <Text style={styles.index}>#{index + 1}</Text>
            <Text style={styles.nombre}>{item.nombre}</Text>
            <Text style={styles.apellido}>{item.apellido}</Text>
          </View>
        )}
        keyExtractor={(obj) => obj.id}
      /> */}


      </View>

      <View style={styles.footer}>

        <Text> creado por : Fernando Ponce</Text>


      </View>


    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#1e1e2f",
    padding: 20,
    paddingTop: 0
  },
  head: {
    flex: 6,
    flexDirection: 'row',
    backgroundColor: "#1e1e2f",
    padding: 20,
    paddingTop: 40
  },
  main: {
    flex: 6,
    backgroundColor: "#1e1e2f",
    padding: 5
  },
  footer: {
    flex: 1,
    backgroundColor: "#1e1e2f",
    padding: 20,
    paddingTop: 40
  }
  ,
  title: {
    fontSize: 22,
    fontWeight: "bold",
    color: "#fff",
    marginBottom: 5,
    textAlign: "center",
  },
  subtitle: {
    fontSize: 14,
    fontWeight: "bold",
    color: "#fff",
    marginBottom: 15,
    textAlign: "center",
  },
  card: {
    backgroundColor: "#2e2e3e",
    padding: 15,
    marginBottom: 10,
    borderRadius: 8,
    flexDirection: "row",
    alignItems: "center",
    shadowColor: "#000",
    shadowOpacity: 0.2,
    shadowOffset: { width: 0, height: 2 },
    shadowRadius: 4,
    elevation: 3,
  },
  index: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: "center",
    alignItems: "center",
    fontSize: 16,
    fontWeight: "bold",
    color: "#ffcc00",
    marginRight: 10,
  },
  nombre: {
    fontSize: 18,
    fontWeight: "600",
    color: "#fff",
    marginRight: 8,
  },
  // apellido: {
  //   fontSize: 18,
  //   color: "#bbb",
  // },
contenedorbotones: {
  flexDirection: 'column',
  justifyContent: 'space-between', // 👈 reparte espacio
  alignItems: 'center',
},
  precio: {
    fontSize: 18,
    color: "#bbb",
  },
  contenedorDatos: {
    flex: 6,
    flexDirection: "column",
    justifyContent: "flex-start",
    alignItems: 'center'
  },
  formularioDatos: {
    flex: 4,
    flexDirection: "column",
    justifyContent: "flex-start",
    alignItems: 'stretch'
  },
  confirmacionForm: {
    flex: 2,
    flexDirection: "row",
    justifyContent: "center",
    alignItems: 'stretch'
  },
  cajaTexto: {
    borderColor: "white",
    borderCurve: 'circular',
    borderWidth: 1,
    paddingHorizontal: 20,
    paddingVertical: 20,
    color: "white"
  },
  letraTxt: {
    color: 'white'
  }, modalOverlay: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "rgba(0,0,0,0.5)"
  },

  //reto 27 adiciones

  modalBox: {
    backgroundColor: "white",
    padding: 20,
    borderRadius: 10,
    width: "80%",
    alignItems: "center",
  },
  modalText: {
    fontSize: 18,
    marginBottom: 20,
    textAlign: "center",
    color: "#333",
    fontWeight: "500",
  },
  modalBotones: {
    flexDirection: "row",
    justifyContent: "space-around",
    width: "100%",
  },

  btnEliminar: {
    backgroundColor: "red",
    padding: 10,
    borderRadius: 5,
    alignItems: "center",
    justifyContent: "center",
    minWidth: 80,
  },
  btnEditar: {
    backgroundColor: "green",
    padding: 10,
    borderRadius: 5,
    alignItems: "center",
    justifyContent: "center",
    minWidth: 80,
  },
  txtBtn: {
    color: "white",
    fontWeight: "bold",
    textAlign: "center",
  }


   

});
