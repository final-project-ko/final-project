import React from 'react';
import { View, StyleSheet } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import Weather from './../../jonghwan/components/WeatherAPI';
import SwipeButtons from './SwipeableButton';

const Stack = createStackNavigator();

const MainScreen = () => {
  return (
    <View style={styles.container} >
      <Weather/>
      <View style={styles.separator} />
        <SwipeButtons message="오늘은?" backgroundSource={require('../../assets/SwipeBar_3loop.gif')} />
        <View style={styles.separator} />
        <SwipeButtons message="밀어서 더 읽기" backgroundSource={require('../../assets/SwipeBar_4loop.gif')} />


    </View>
  );
};

export default MainScreen;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#323236',
  },
  separator: {
    marginTop: 30,
  },
});
