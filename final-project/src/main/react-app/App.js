/*
npm install react-native-elements
npm install @rneui/themed @rneui/base
npm install @rneui/base@edge @rneui/themed@edge

npm install react-native-vector-icons

npm install react-native-safe-area-context

@react-navigation/stack 

*/
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Weather from "./jonghwan/apis/WeatherAPI";
// import { Button } from 'react-native-elements';

// const today = new Date(); 
// const month = today.getMonth() + 1; 
// const date = today.getDate();
// const ToDayDate = month + '월' + date + '일';

export default function App() {
  return (

    <View style={styles.container}>
      <View style={styles.buttonContainer}>
        <Button title="ToDayDate" type={ ToDayDate } />
      </View>
      <Text>
        ㅅㄷ
      </Text>
      <StatusBar style="auto" />
      <Weather style={styles.weather}/>
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
  // weather: {
  //   border: '1px solid black',
  //   width: '80%',
  //   height: '25%',
  //   position: "absolute",
  //   top: '10%'
  // }
  buttonContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    width: '100%',
    paddingHorizontal: 20,
  },
// >>>>>>> 3fa17b41500bdc5292d95ebe6c79474075a714fe
});
