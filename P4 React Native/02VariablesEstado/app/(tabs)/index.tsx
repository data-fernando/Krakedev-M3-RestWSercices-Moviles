import { Image } from 'expo-image';
import { Platform, StyleSheet, Text, Button, Alert } from 'react-native';

import { HelloWave } from '@/components/hello-wave';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';
// para refrescar
import { useState } from 'react';

export default function HomeScreen() {

  //usar esto en valores que cambian al interactuar
  //una funcion manamos el valor inicial, la referencia y la funcion para cambiar la referencia
  const [contadorEstado, setContadorEstado] = useState(0);


  const incrementar = () => {
    setContadorEstado(contadorEstado + 1);
    console.log("contador estado: " + contadorEstado)
  }

  const decrementar = () => {
    setContadorEstado(contadorEstado - 1);
    console.log("contador estado: " + contadorEstado)
  }

  const decrementarVidas = () => {
    verificarGameOver();
    if (vidas != 0) {
      setVidas(vidas - 1);

    }
    console.log("contador estado: " + contadorEstado)
  }

  const [vidas, setVidas] = useState(5);

  const verificarGameOver = () => {
    if (vidas == 0) {
      let mensaje = "PERDIO EL JUEGO" + vidas + " vidas"
      Alert.alert("Game OVER", mensaje)
    }

  }

  const premiar = () => {
    setVidas(vidas + 3);
    console.log("premiado " + vidas)
  }



  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: '#A1CEDC', dark: '#1D3D47' }}
      headerImage={
        <Image
          source={require('@/assets/images/partial-react-logo.png')}
          style={styles.reactLogo}
        />
      }>
      <ThemedView style={styles.titleContainer}>
        <ThemedText type="title">Variables de estado</ThemedText>
        <HelloWave />
      </ThemedView>
      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle">Contador</ThemedText>
        <ThemedText>
          {/* <Text> Valor contador {contador}</Text> */}
          <Text> Valor contador estado {contadorEstado}</Text>
          <Button title='incrementar' onPress={incrementar} />
          <Button title='decrementar' onPress={decrementar} />

        </ThemedText>
      </ThemedView>  

        <ThemedView style={styles.titleContainer}>
          <ThemedText type="title">Reto 21 Contador</ThemedText>
          <HelloWave />


        </ThemedView>

        <ThemedView>
          <Text> Vidas: {vidas}</Text>
          <Button title='quitar 1 vida' onPress={decrementarVidas} />
          <Button title='premiar' onPress={premiar} />


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
  reactLogo: {
    height: 178,
    width: 290,
    bottom: 0,
    left: 0,
    position: 'absolute',
  },
});
