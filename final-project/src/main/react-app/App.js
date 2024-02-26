/*
ui 디자인용 라이브러리 임포트
npm install react-native-elements
npm install react-native-vector-icons
npm install react-native-safe-area-context
@react-navigation/stack
*/

import React from 'react';
import {StatusBar, StyleSheet, Text, View} from 'react-native';
import {NavigationContainer} from "@react-navigation/native";
import {createStackNavigator} from "@react-navigation/stack";
import WeatherAPI from "./jonghwan/components/WeatherAPI";
import Home from "./jonghwan/apis/Home";
import Fivedays from "./jonghwan/apis/fivedays";
// import MainScreen from './chaehyeon/pages/MainScreen';

export default function App() {

  const Stack = createStackNavigator();
  return (
      <>
        <StatusBar barStyle="default"/>
        <NavigationContainer>
          <Stack.Navigator  initialRouteName="Weather">
            <Stack.Screen  options={{headerShown: false}}  name="Weather" component={WeatherAPI}/>
            <Stack.Screen options={{headerShown: false}}  name="Home" component={Home} />
          </Stack.Navigator>
        </NavigationContainer>
      </>

      // <View style={styles.container}>
      //   {/*<VideoBackground/>*/}
      //   <Weather style={styles.weather} />
      //   {/*<DetailWeather/>*/}
      //   {/*<MainScreen />*/}
      // </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },


  buttonContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    width: '100%',
    paddingHorizontal: 20,
  },


});

