import React from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Ionicons } from '@expo/vector-icons';
import MainScreen from './MainScreen';
import SettingScreen3 from './SettingScreen3';
import TopNavigator from './TopNavigator';
import SettingScreen2 from './SettingScreen2';
import { StyleSheet } from 'react-native';

const BottomTab = createBottomTabNavigator();

const BottomNavigator = () => {
  return (
    <BottomTab.Navigator
      initialRouteName='MainScreen'
      tabBarOptions={{
        activeTintColor: '#fff', // 활성화된 아이콘 색상 변경
      }}
    >
      <BottomTab.Screen 
        name="MainScreen" 
        component={MainScreen} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
          tabBarStyle: { backgroundColor: '#000', height:60} // SettingScreen2의 탭에 배경색 변경
        }}
      />
      <BottomTab.Screen 
        name="SettingScreen" 
        component={TopNavigator} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />
      <BottomTab.Screen 
        name="SettingScreen2" 
        component={SettingScreen2} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />
      <BottomTab.Screen 
        name="SettingScreen3" 
        component={SettingScreen3} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />
    </BottomTab.Navigator>
  );
};

export default BottomNavigator;

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#000',
  },
});
