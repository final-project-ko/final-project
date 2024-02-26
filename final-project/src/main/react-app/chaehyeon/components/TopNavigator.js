import React from 'react';
import { Ionicons } from '@expo/vector-icons';
import AScreen from './AScreen';
import BScreen from './BScreen';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';

const Tab = createMaterialTopTabNavigator();

const TopNavigator = () => {
  return (
    <Tab.Navigator>
      <Tab.Screen 
        name="AScreen" 
        component={AScreen} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />
      <Tab.Screen 
        name="BScreen" 
        component={BScreen} 
        options={{
          tabBarIcon: ({color, size}) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />

    </Tab.Navigator>
  );
}

export default TopNavigator;

