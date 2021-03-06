import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import Home from './screens/Home'
import Login from './screens/Login'
import Register from './screens/Register'

const MainStack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <MainStack.Navigator screenOptions={{title:"E-Health",headerShown:false}}>
        <MainStack.Screen name="Login" component={Login} />
        <MainStack.Screen name="Home" component={Home} />
        <MainStack.Screen name="Register" component={Register} />
      </MainStack.Navigator>
    </NavigationContainer>
)}
