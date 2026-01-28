import { Platform, StyleSheet, TextInput ,Button,Text} from 'react-native';

import { HelloWave } from '@/components/hello-wave';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';
import { useState } from 'react';

export default function HomeScreen() {

  const [valorCaja,setValorCaja]=useState("ingrese un valor")
  const [valorCaja2,setValorCaja2]=useState("ingrese otro valor")
  const [valorCaja3,setValorCaja3]=useState("")
  // const [valorCaja3,setValorCaja3]=useState(0)
    const [valorMoneda,setValorMoneda]=useState("")

  const suma=(a:number,b:number)=>a+b;
  const resta=(a:number,b:number)=>a-b;
  const multiplicacion=(a:number,b:number)=>a*b;
  const division=(a:number,b:number)=>a/b;

  const operar=(fn:Function)=>{
    let resultadoOperacion=fn(Number(valorCaja),Number(valorCaja2))
    return resultadoOperacion

  }

  const convertir=(fn:Function)=>{
    let valor=fn(Number(valorCaja));
    return valor

  }

  const aMxpesos=(a:number)=>a*17;
  const aCopesos=(a:number)=>a*4000;
  const aEuros=(a:number)=>a*0.92;

  return (
    <ParallaxScrollView 
    headerBackgroundColor={{ light: '#A1CEDC', dark: '#1D3D47' }} headerImage={<></>}>  
    <ThemedView style={styles.titleContainer}>
        <ThemedText type="title">Reto 23</ThemedText>
        <HelloWave />
      </ThemedView>
      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle">Demostracion</ThemedText>


        {/* <TextInput 
          value={valorCaja2} 
          style={styles.cajaTexto} 
          onChangeText={(txt)=>{
            setValorCaja2(txt)
            console.log("valor:>>"+valorCaja2)
          }}
        /> */}

        {/* <Button 
          title='Saludar' 
          onPress={()=>{
            let nombrecompleto=valorCaja+" "+valorCaja2
            setValorCaja3(nombrecompleto)
          }} 
        /> */}

        {/* <Button 
          title='sumar' 
          onPress={()=>{
            let operacion=operar(suma)
            setValorCaja3(operacion)
          }} 
        />

        <Button 
          title='restar' 
          onPress={()=>{
            let operacion=operar(resta)
            setValorCaja3(operacion)
          }} 
        />

        <Button 
          title='multiplicacion' 
          onPress={()=>{
            let operacion=operar(multiplicacion)
            setValorCaja3(operacion)
          }} 
        />

        <Button 
          title='division' 
          onPress={()=>{
            let operacion=operar(division)
            setValorCaja3(operacion)
          }} 
        /> */}

        <Button 
          title='convertir a P Colombianos' 
          onPress={()=>{
            let operacion=convertir(aCopesos)
            setValorMoneda("Pesos Colombianos")
            setValorCaja3(operacion)
          }} 
          
        /> 

        
        <Button 
          title='convertir a P Mexicanos' 
          onPress={()=>{
            let operacion=convertir(aMxpesos)
            setValorMoneda("Pesos Mexicanos")

            setValorCaja3(operacion)
          }} 
          
        /> 

        
        <Button 
          title='convertir a Euros' 
          onPress={()=>{
            let operacion=convertir(aEuros)
            setValorMoneda("Pesos Euros")

            setValorCaja3(operacion)
          }} 
          
        /> 

        

        
      </ThemedView>
      <ThemedView style={styles.stepContainer}></ThemedView>
      <ThemedView style={styles.stepContainer}>


        {/* <ThemedText type="subtitle">Resultado {valorCaja3}</ThemedText> */}

        <ThemedText type="subtitle">conversion {valorCaja3+" "+ valorMoneda}</ThemedText>
      </ThemedView>
    </ParallaxScrollView>
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
  cajaTexto:{
    borderColor:"white",
    borderCurve:'circular',
    borderWidth:1,
    paddingHorizontal:20,
    paddingVertical:20,
    color:"white"
  }
});
