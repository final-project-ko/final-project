import { StyleSheet, View } from "react-native";

import Weather from '../../jonghwan/apis/WeatherAPI';


const MainScreen = () =>{
    return(
        <View style ={styles.container}>
          <Weather style={styles.weather} />
          </View>
    )
}

export default MainScreen;


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
