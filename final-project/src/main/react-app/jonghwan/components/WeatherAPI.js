import {useEffect, useState} from "react";
import {Alert, Button, ImageBackground, StyleSheet, Text, View} from "react-native";
import axios from "axios";
import { TouchableOpacity } from 'react-native';
// import {Tab} from "react-native-elements";
// import {createBottomTabNavigator} from "@react-navigation/bottom-tabs";
import {useNavigation} from "@react-navigation/native";


const Weather = () =>{
    const [isLoading , setIsLoading] = useState(true);
    const [currentWeather, setCurrentWeather] = useState('');
    const [temp, setTemp] = useState('');
    const [summary, setSummary] = useState('');
    const [min, setMin] = useState('');
    const [error, setError] = useState(false);


    // const Tab = createBottomTabNavigator();
    const API_KEY = "5c109176cb7f758390478b3cbdcc8d63";
    const latitude = 38;
    const longitude = 127;

    const navigation = useNavigation();



    useEffect(() => {
        let mounted = true;
        const getWeather = async (latitude, longitude) => {
            try {
                const resWeather = await axios.get(
                    `https://api.openweathermap.org/data/3.0/onecall?lat=${latitude}&lon=${longitude}&exclude=hourly,minutely&appid=${API_KEY}&units=metric`
                ).then(response => {
                    // console.log("-")
                    // console.log(response.data.daily[0].temp.day)
                    // console.log("--")
                    if(mounted) {
                        let summary = response.data.daily[0].weather[0].description;
                        let main = response.data.daily[0].weather[0].main;
                        let temp = response.data.daily[0].temp.day;
                        // let minTemp =resWeather.data.min;

                        setCurrentWeather(main);
                        setTemp(temp);
                        setSummary(summary);
                        // setMin(minTemp);
                        setIsLoading(false);

                    }
                });


            } catch (error) {
                Alert.alert("날씨 정보를 읽어올 수 없습니다.")
                setError(true);
                setIsLoading(false);
            }

        };

        getWeather(latitude, longitude);

        return()=>{
            mounted = false
        }

    }, []);

    return (
            <TouchableOpacity style={styles.container} onPress={() => navigation.navigate("Home")}>
                <ImageBackground style={styles.picture}  imageStyle={styles.imgWrapper} source={currentWeather === "Snow" ? require('../../assets/snow.jpeg') : require('../../assets/snow.jpeg')}>
                    {isLoading || error
                        ? (<Text> Waiting.. </Text>)
                        : (
                            <>
                                <Text> {summary} </Text>
                                <View style={styles.weather}>
                                    <>
                                        <Text> {currentWeather} </Text>
                                        <Text style={styles.tempNum}> {Math.round(temp)} </Text>
                                        {/*<Text style={styles.tempNum}> {min} </Text>*/}
                                        <Text style={styles.temp}>°C |°F</Text>
                                        {/*<Text>{temp1}</Text>*/}
                                    </>
                                </View>
                            </>

                        )
                    }
                </ImageBackground>
            </TouchableOpacity>
    );
};

export default Weather;


const styles = StyleSheet.create({
    container: {
        alignItems:'center',
        justifyContent: 'center',
        width: '100%',
        height: 300,
        position: 'absolute',
        top: '15%',
        borderRadius: 30
    },
    picture:{
        alignItems:'center',
        justifyContent: 'center',
        width: '90%',
        height: 300,
        position: 'absolute',
        borderRadius: 30
    },
    tempNum: {
        fontSize: 50,
        fontWeight: 'bold'
    },
    temp: {
        fontSize: 20,
        fontWeight: 'bold'
    },
    imgWrapper: {
        width:'100%',
        height:'100%',
        borderRadius: 30

    }

})

