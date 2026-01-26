import { Image } from 'expo-image';
import { Platform, StyleSheet,View ,Button} from 'react-native';

import { HelloWave } from '@/components/hello-wave';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';

export default function HomeScreen() {
  return (
    <View style={styles.contenedorPadre}>

      <View style={styles.contenedorCabecera}>
              <Button title='X'></Button>
              <Button title='Y'></Button>
              <Button title='Z'></Button>
        
      </View>

      <View style={styles.contenedorMain}>
        <View style={styles.contenedorMainSup}>


          <View style={styles.contenedorMainSupBotones}>
              <Button title='boton1'></Button>
              <Button title='boton2'></Button>
          </View>
          <View style={styles.contenedorMainSupOperaciones}>
              <Button title='Operacion 1'></Button>
              <Button title='Operacion 2'></Button>
              <Button title='Operacion 3'></Button>


          </View>

        
          
        
        </View>
        <View style={styles.contenedorMainInf}>
              <Button title='accion1'></Button>
              <Button title='accion2'></Button>

        
        </View>
        
      </View>

      <View style={styles.contenedorFooter}>

        <Button title='boton final'></Button>
        
      </View>

    </View>

  );
}

const styles = StyleSheet.create({
    contenedorPadre:{
    flex:1,
    backgroundColor:'gray',
    flexDirection:'column',

  },
  contenedorCabecera:{
    flex:1,
    backgroundColor:'red',
    flexDirection:'row',
    justifyContent:'flex-end',
    alignItems:'center'
  },
    contenedorMain:{
    flex:6,
    backgroundColor:'black',
    flexDirection:'column',
  },
    contenedorFooter:{
    flex:1,
    backgroundColor:'yellow',
    flexDirection:'row',
    justifyContent:'flex-start',
    alignItems:'center'
  },
    contenedorMainSup:{
    flex:4,
    backgroundColor:'gray',
    flexDirection:'row',
  },
      contenedorMainInf:{
    flex:1,
    backgroundColor:'white',
    flexDirection:'row',
    justifyContent:'center',
    alignItems:'flex-end'
  },
    contenedorMainSupBotones:{
    flex:1,
    backgroundColor:'purple',
    flexDirection:'column',
    justifyContent:'space-around',
  },
    contenedorMainSupOperaciones:{
    flex:1,
    backgroundColor:'brown',
    flexDirection:'column',
    justifyContent:'center',
    alignItems:'flex-start'
  }

});
