import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Weather from "./apis/WeatherAPI";

export default function App() {




  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      <Weather style={styles.weather}/>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  weather: {
    border: '1px solid black',
    width: '80%',
    height: '25%',
    position: "absolute",
    top: '10%'
  }
});




