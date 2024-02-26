import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Ionicons } from '@expo/vector-icons';
import MainScreen from './MainScreen';
import SettingScreen from './SettingScreen';
import SettingScreen2 from './SettingScreen2';


const MainStack = createNativeStackNavigator();
const BottomTab = createBottomTabNavigator();

const MainStackNavigation = () => {
  return (
    <MainStack.Navigator initialRouteName="MainScreen">
      <MainStack.Screen name="MainScreen" component={MainScreen} />
    </MainStack.Navigator>
  );
};

const BottomNavigator = () => {
  return (
    <BottomTab.Navigator
      screenOptions={{
        tabBarStyle: {
          position: 'absolute',
          left: 0,
          right: 0,
          bottom: 0,
        },
      }}
    >
      <BottomTab.Screen 
        name="Main" 
        component={MainStackNavigation} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />
      <BottomTab.Screen 
        name="Setting" 
        component={SettingScreen} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="settings" color={color} size={size} />
          ),
        }}
      />
      <BottomTab.Screen 
        name="Setting2" 
        component={SettingScreen2} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="settings-outline" color={color} size={size} />
          ),
        }}
      />
    </BottomTab.Navigator>
  );
};

export default BottomNavigator;
