import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { Button } from 'react-native-elements';
import Swiper from 'react-native-web-swiper';

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  slideContainer: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  slide1: {
    backgroundColor: 'rgba(20,20,200,0.3)',
  },
  slide2: {
    backgroundColor: 'rgba(20,200,20,0.3)',
  },
  slide3: {
    backgroundColor: 'rgba(200,20,20,0.3)',
  },
});

export default function Screen() {

  const navigation = useNavigation();

    return (
      <View style={styles.container}>
        <Swiper>
          <View style={[styles.slideContainer,styles.slide1]}>
            <Text>Slide 1</Text>
            <Button
            title="Go back to Home"
            onPress={() => navigation.navigate('BottomNavigator')}
          />
          </View>
          <View style={[styles.slideContainer,styles.slide2]}>
            <Text>Slide 2</Text>
            <Button
            title="Go back to Home"
            onPress={() => navigation.navigate('BottomNavigator')}
          />
          </View>
          <View style={[styles.slideContainer,styles.slide3]}>
            <Text>Slide 3</Text>
            <Button
            title="Go back to Home"
            onPress={() => navigation.navigate('BottomNavigator')}
          />
          </View>
        </Swiper>
      </View>
    );
  }