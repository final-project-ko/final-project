import React from 'react';
import AScreen from './AScreen';
import BScreen from './BScreen';
import DScreen from './DScreen';
import EScreen from './EScreen';
import FScreen from './FScreen';
import GScreen from './GScreen';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import CScreen from './CScreen';


const Tab = createMaterialTopTabNavigator();

const TopNavigator = () => {
  return (
    <Tab.Navigator
      screenOptions={{
        tabBarScrollEnabled: true
      }}
    >
      <Tab.Screen 
        name="AScreen" 
        component={AScreen} 
      />
            <Tab.Screen 
        name="CScreen" 
        component={CScreen} 
      />
      <Tab.Screen 
        name="BScreen" 
        component={BScreen} 
      />
            <Tab.Screen 
        name="DScreen" 
        component={DScreen} 
      />
                  <Tab.Screen 
        name="EScreen" 
        component={EScreen} 
      />
                        <Tab.Screen 
        name="FScreen" 
        component={FScreen} 
      />
                              <Tab.Screen 
        name="GScreen" 
        component={GScreen} 
      />

    </Tab.Navigator>
  );
}

export default TopNavigator;

