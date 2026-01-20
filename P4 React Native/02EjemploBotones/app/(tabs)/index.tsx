import { Image } from 'expo-image';
import { Platform, StyleSheet ,Button, Alert} from 'react-native';

import { HelloWave } from '@/components/hello-wave';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';

export default function HomeScreen() {

  const finalizar=()=>{
    Alert.alert("Mensaje Fin","U SESION HA FINALIZADO")
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
        <ThemedText type="title">Reto 20 Botones!</ThemedText>
        <HelloWave />
      </ThemedView>
      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle" >Boton: Finalizar</ThemedText>
        <ThemedText>
              <Button title='Finalizar' onPress={finalizar} ></Button>
        </ThemedText>
      </ThemedView>

            <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle" >Boton: iniciar</ThemedText>
        <ThemedText>
              <Button title='Iniciar' onPress={()=>{
    Alert.alert("Mensaje Inicio","U SESION HA Iniciado")
  }}></Button>
        </ThemedText>
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
