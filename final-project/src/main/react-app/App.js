/*
ui 디자인용 라이브러리 임포트
npm install react-native-elements
npm install react-native-vector-icons
npm install react-native-safe-area-context
@react-navigation/stack
*/

import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import Weather from "./jonghwan/apis/WeatherAPI";
import VideoBackground from "./jonghwan/apis/VideoBackground";
// import MainScreen from './chaehyeon/pages/MainScreen';

export default function App() {

  return (
      <View style={styles.container}>
        {/*<VideoBackground/>*/}
        <Weather style={styles.weather} />
        {/*<MainScreen />*/}
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
  },
});