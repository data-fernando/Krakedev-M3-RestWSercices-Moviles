import { Link } from 'expo-router';
import { StyleSheet ,Text} from 'react-native';

import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
// import { } from "module";

export default function ModalScreen() {
  return (
    <ThemedView style={styles.container}>
      <Text>Hola papu</Text> 
      <ThemedText type="title">Holla mundo</ThemedText>
      <ThemedText type="title">This is a modal</ThemedText>
      <Link href="/" dismissTo style={styles.link}>
        <ThemedText type="link">Go to home screen</ThemedText>
      </Link>
    </ThemedView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 20,
  },
  link: {
    marginTop: 15,
    paddingVertical: 15,
  },
});
