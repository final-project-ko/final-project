import React from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Ionicons } from '@expo/vector-icons';
import MainScreen from './MainScreen';
import SettingScreen3 from './SettingScreen3';
import TopNavigator from './TopNavigator';
import SettingScreen2 from './SettingScreen2';


const BottomTab = createBottomTabNavigator();

const BottomNavigator = () => {
  return (
    <BottomTab.Navigator initialRouteName='MainScreen'>

      <BottomTab.Screen 
        name="MainScreen" 
        component={MainScreen} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
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
