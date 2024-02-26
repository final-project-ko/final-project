import React from 'react';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import { Ionicons } from '@expo/vector-icons';

// 각 항목에 대한 컴포넌트를 import 해주세요.
import Item1 from './Item1';
import Item2 from './Item2';
// ...


const TopTabNavigator = () => {
  return (
    <Tab.Navigator
      tabBarOptions={{
        scrollEnabled: true,
        tabStyle: { width: 100 },
      }}
    >
      <Tab.Screen 
        name="Item1" 
        component={Item1} 
        options={{
          tabBarLabel: '항목 1',
          tabBarIcon: ({ color, size }) => (
            <Ionicons name="home" color={color} size={size} />
          ),
        }}
      />
      <Tab.Screen 
        name="Item2" 
        component={Item2} 
        options={{
          tabBarLabel: '항목 2',
          tabBarIcon: ({ color, size }) => (
            <Ionicons name="settings" color={color} size={size} />
          ),
        }}
      />
      {/* 추가적인 항목들 */}
    </Tab.Navigator>
  );
};

export default TopTabNavigator;
