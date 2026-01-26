import { Image } from 'expo-image';
import { Platform, StyleSheet ,View,Text,Button} from 'react-native';

import { HelloWave } from '@/components/hello-wave';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';

export default function HomeScreen() {
  return (
        <ThemedView style={styles.contenedor}>

        <View style={styles.contenedor2}>
            
        </View> 
        <View style={styles.contenedor3}>
            <View style={styles.contenedor3_1}>
            </View> 
            <View style={styles.contenedor3_2}>
                 <View style={styles.contenedor3_2_1}>
                </View> 
                 <View style={styles.contenedor3_2_2}>
                    <Button title='boton1'></Button>
                    <Button title='boton2'></Button>
                    <Button title='boton3'></Button>



                </View>
            </View> 

        </View> 
      </ThemedView>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
    padding:40
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
  contenedor:{
    flex:1,
    backgroundColor:'gray',
    flexDirection:'column',
    paddingTop:40
  },//debe estar dentro de un padre flex
    contenedor2:{
    flex:1,
    backgroundColor:'blue',
    flexDirection:'column'
  },//debe estar dentro de un padre flex
    contenedor3:{
    flex:2,
    backgroundColor:'red',
    flexDirection:'column',
    paddingLeft:20  //para apreciar el rojo del contenedor padre
  },
      contenedor3_1:{
    flex:2,
    backgroundColor:'yellow',
    flexDirection:'column'
  },
        contenedor3_2:{
    flex:2,
    backgroundColor:'green',
    flexDirection:'row',
    paddingLeft:10 //para apreciar el rojo del contenedor padre
  },
          contenedor3_2_1:{
    flex:1,
    backgroundColor:'pink',
    flexDirection:'column'
  },
    contenedor3_2_2:{
    flex:2,
    backgroundColor:'purple',
    flexDirection:'column',
    justifyContent:'space-around',
    alignItems:'stretch'
  }
});
