import { Image } from 'expo-image';
import { Platform, StyleSheet ,TextInput,Button,Text,View} from 'react-native';

import { HelloWave } from '@/components/hello-wave';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';
import { useState } from 'react';

export default function HomeScreen() {

  const [valorPeso,setValorPeso]=useState("")
  const [valorAltura,setValorAltura]=useState("")
  const [resultadoIMC,setValorIMC]=useState(0) /// setear con 0 valores numericos
  const [ mensajeIMC,setMensajeIMC]=useState("")

  const calculoImca=(peso:number,altura:number)=>{
      
      setValorIMC(peso/(altura*altura))
      return resultadoIMC
  }
const interpretarIMC = (imc: number): string => {
  if (imc < 18.5) {
    return "Bajo peso";
  } else if (imc < 24.9) {
    return "Normal";
  } else if (imc < 29.9) {
    return "Sobrepeso";
  } else {
    return "Obesidad";
  }
};





  return (
        <View style={styles.contenedor}>
          
        <ThemedText type="title">Reto 25 Calculadora imc</ThemedText>



        <Text style={styles.letraTxt}>Ingrese peso</Text>
        <TextInput 
          value={valorPeso} 
          style={styles.cajaTexto} 
          onChangeText={(txt)=>{
            setValorPeso(txt)
            console.log("valor:>>"+valorPeso)
          }}
        />
        <Text style={styles.letraTxt}>Ingrese altura</Text>
        <TextInput 
          value={valorAltura} 
          style={styles.cajaTexto} 
          onChangeText={(txt)=>{
            setValorAltura(txt)
            console.log("valor:>>"+valorAltura)
          }}
        />
        <Button title='calcularIMC' onPress={()=>{
          let valor=calculoImca(Number(valorPeso),Number(valorAltura))
          setMensajeIMC(interpretarIMC(valor))
        }}></Button>

        <Text style={styles.letraTxt}>Resultado e interpretacion:</Text>

        <Text style={styles.letraTxt} >{"Su valor es "+resultadoIMC.toFixed(2)+" con interpretacion "+mensajeIMC}</Text>

       </View> 

  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  reactLogo: {
    height: 178,
    width: 290,
    bottom: 0,
    left: 0,
    position: 'absolute',
  },  cajaTexto:{
    borderColor:"white",
    borderCurve:'circular',
    borderWidth:1,
    paddingHorizontal:20,
    paddingVertical:20,
    color:"white"
  },
  contenedor:{
    flexDirection:"column",
    paddingTop:50
  },
  letraTxt:{
    color:'white'
  }
});
