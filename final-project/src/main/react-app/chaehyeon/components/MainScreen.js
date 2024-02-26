import React from 'react';
import { View, Button, Text, StyleSheet } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import Weather from './../../jonghwan/components/WeatherAPI';
import Home from './../../jonghwan/apis/Home';
const Stack = createStackNavigator();

const MainScreen = () => {
  return(
  
  <View style ={styles.container}>
    <Weather style={styles.weather} />
    </View>

  //   <View style ={styles.container}>
  //   <Stack.Navigator  initialRouteName="Weather">
  //     <Stack.Screen  options={{headerShown: false}}  name="Weather" component={Weather}/>
  //     <Stack.Screen options={{headerShown: false}}  name="Home" component={Home} />
  //   </Stack.Navigator>
  // </View>

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
    borderWidth: 1,
    borderColor: 'black',
    width: '80%',
    height: '25%',
    position: "absolute",
    top: '10%'
  }
});